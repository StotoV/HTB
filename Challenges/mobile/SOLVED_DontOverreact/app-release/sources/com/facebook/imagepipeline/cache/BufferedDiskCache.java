package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class BufferedDiskCache {
    private static final Class<?> TAG = BufferedDiskCache.class;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    public boolean containsSync(CacheKey cacheKey) {
        return this.mStagingArea.containsKey(cacheKey) || this.mFileCache.hasKeySync(cacheKey);
    }

    public Task<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return Task.forResult(true);
        }
        return containsAsync(cacheKey);
    }

    private Task<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            return Task.call(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                /* renamed from: call */
                public Boolean mo117call() throws Exception {
                    return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage != null) {
                return foundPinnedImage(cacheKey, encodedImage);
            }
            Task<EncodedImage> async = getAsync(cacheKey, atomicBoolean);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return async;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.v(TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaMiss();
        try {
            return this.mFileCache.hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    private Task<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            return Task.call(new Callable<EncodedImage>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                @Nullable
                /* renamed from: call */
                public EncodedImage mo118call() throws Exception {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("BufferedDiskCache#getAsync");
                        }
                        if (atomicBoolean.get()) {
                            throw new CancellationException();
                        }
                        EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                        if (encodedImage != null) {
                            FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.getUriString());
                            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                        } else {
                            FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.getUriString());
                            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
                            try {
                                PooledByteBuffer readFromDiskCache = BufferedDiskCache.this.readFromDiskCache(cacheKey);
                                if (readFromDiskCache == null) {
                                    return null;
                                }
                                CloseableReference of = CloseableReference.of(readFromDiskCache);
                                try {
                                    encodedImage = new EncodedImage(of);
                                } finally {
                                    CloseableReference.closeSafely(of);
                                }
                            } catch (Exception unused) {
                                if (FrescoSystrace.isTracing()) {
                                    FrescoSystrace.endSection();
                                }
                                return null;
                            }
                        }
                        if (!Thread.interrupted()) {
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return encodedImage;
                        }
                        FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                        if (encodedImage != null) {
                            encodedImage.close();
                        }
                        throw new InterruptedException();
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            Preconditions.checkNotNull(cacheKey);
            Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
            this.mStagingArea.put(cacheKey, encodedImage);
            final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            try {
                this.mWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.beginSection("BufferedDiskCache#putAsync");
                            }
                            BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                        } finally {
                            BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                            EncodedImage.closeSafely(cloneOrNull);
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                        }
                    }
                });
            } catch (Exception e) {
                FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
                this.mStagingArea.remove(cacheKey, encodedImage);
                EncodedImage.closeSafely(cloneOrNull);
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Task<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            return Task.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.4
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    try {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("BufferedDiskCache#remove");
                        }
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                        BufferedDiskCache.this.mFileCache.remove(cacheKey);
                    } finally {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
            return Task.forError(e);
        }
    }

    public Task<Void> clearAll() {
        this.mStagingArea.clearAll();
        try {
            return Task.call(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.5
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    BufferedDiskCache.this.mStagingArea.clearAll();
                    BufferedDiskCache.this.mFileCache.clearAll();
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e);
        }
    }

    public long getSize() {
        return this.mFileCache.getSize();
    }

    private Task<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.v(TAG, "Found image for %s in staging area", cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return Task.forResult(encodedImage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        try {
            Class<?> cls = TAG;
            FLog.v(cls, "Disk cache read for %s", cacheKey.getUriString());
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.v(cls, "Disk cache miss for %s", cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.v(cls, "Found entry in disk cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            InputStream openStream = resource.openStream();
            PooledByteBuffer mo141newByteBuffer = this.mPooledByteBufferFactory.mo141newByteBuffer(openStream, (int) resource.size());
            openStream.close();
            FLog.v(cls, "Successful read from disk cache for %s", cacheKey.getUriString());
            return mo141newByteBuffer;
        } catch (IOException e) {
            FLog.w(TAG, e, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        Class<?> cls = TAG;
        FLog.v(cls, "About to write to disk-cache for key %s", cacheKey.getUriString());
        try {
            this.mFileCache.insert(cacheKey, new WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.6
                @Override // com.facebook.cache.common.WriterCallback
                public void write(OutputStream outputStream) throws IOException {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            FLog.v(cls, "Successful disk-cache write for key %s", cacheKey.getUriString());
        } catch (IOException e) {
            FLog.w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }
}
