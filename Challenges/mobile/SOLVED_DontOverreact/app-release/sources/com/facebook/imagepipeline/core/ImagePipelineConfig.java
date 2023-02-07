package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ImagePipelineConfig {
    private static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    private final Bitmap.Config mBitmapConfig;
    private final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
    private final CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
    private final CacheKeyFactory mCacheKeyFactory;
    @Nullable
    private final CallerContextVerifier mCallerContextVerifier;
    private final CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
    private final Context mContext;
    private final boolean mDiskCacheEnabled;
    private final boolean mDownsampleEnabled;
    private final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
    private final ExecutorSupplier mExecutorSupplier;
    private final FileCacheFactory mFileCacheFactory;
    private final int mHttpNetworkTimeout;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    @Nullable
    private final ImageDecoder mImageDecoder;
    @Nullable
    private final ImageDecoderConfig mImageDecoderConfig;
    private final ImagePipelineExperiments mImagePipelineExperiments;
    @Nullable
    private final ImageTranscoderFactory mImageTranscoderFactory;
    @Nullable
    private final Integer mImageTranscoderType;
    private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private final DiskCacheConfig mMainDiskCacheConfig;
    private final int mMemoryChunkType;
    private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private final NetworkFetcher mNetworkFetcher;
    @Nullable
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final PoolFactory mPoolFactory;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final Set<RequestListener> mRequestListeners;
    private final boolean mResizeAndRotateEnabledForNetwork;
    private final DiskCacheConfig mSmallImageDiskCacheConfig;

    private ImagePipelineConfig(Builder builder) {
        CacheKeyFactory cacheKeyFactory;
        ImageCacheStatsTracker imageCacheStatsTracker;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        PoolFactory poolFactory;
        WebpBitmapFactory loadWebpBitmapFactoryIfExists;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        ImagePipelineExperiments build = builder.mExperimentsBuilder.build();
        this.mImagePipelineExperiments = build;
        this.mBitmapMemoryCacheParamsSupplier = builder.mBitmapMemoryCacheParamsSupplier == null ? new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) builder.mContext.getSystemService("activity")) : builder.mBitmapMemoryCacheParamsSupplier;
        this.mBitmapMemoryCacheTrimStrategy = builder.mBitmapMemoryCacheTrimStrategy == null ? new BitmapMemoryCacheTrimStrategy() : builder.mBitmapMemoryCacheTrimStrategy;
        this.mBitmapConfig = builder.mBitmapConfig == null ? Bitmap.Config.ARGB_8888 : builder.mBitmapConfig;
        if (builder.mCacheKeyFactory == null) {
            cacheKeyFactory = DefaultCacheKeyFactory.getInstance();
        } else {
            cacheKeyFactory = builder.mCacheKeyFactory;
        }
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mContext = (Context) Preconditions.checkNotNull(builder.mContext);
        this.mFileCacheFactory = builder.mFileCacheFactory == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : builder.mFileCacheFactory;
        this.mDownsampleEnabled = builder.mDownsampleEnabled;
        this.mEncodedMemoryCacheParamsSupplier = builder.mEncodedMemoryCacheParamsSupplier == null ? new DefaultEncodedMemoryCacheParamsSupplier() : builder.mEncodedMemoryCacheParamsSupplier;
        if (builder.mImageCacheStatsTracker == null) {
            imageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
        } else {
            imageCacheStatsTracker = builder.mImageCacheStatsTracker;
        }
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
        this.mImageDecoder = builder.mImageDecoder;
        this.mImageTranscoderFactory = getImageTranscoderFactory(builder);
        this.mImageTranscoderType = builder.mImageTranscoderType;
        this.mIsPrefetchEnabledSupplier = builder.mIsPrefetchEnabledSupplier == null ? new Supplier<Boolean>() { // from class: com.facebook.imagepipeline.core.ImagePipelineConfig.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            /* renamed from: get */
            public Boolean mo126get() {
                return true;
            }
        } : builder.mIsPrefetchEnabledSupplier;
        DiskCacheConfig defaultMainDiskCacheConfig = builder.mMainDiskCacheConfig == null ? getDefaultMainDiskCacheConfig(builder.mContext) : builder.mMainDiskCacheConfig;
        this.mMainDiskCacheConfig = defaultMainDiskCacheConfig;
        if (builder.mMemoryTrimmableRegistry == null) {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        } else {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        }
        this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
        this.mMemoryChunkType = getMemoryChunkType(builder, build);
        int i = builder.mHttpConnectionTimeout < 0 ? HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT : builder.mHttpConnectionTimeout;
        this.mHttpNetworkTimeout = i;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
        }
        this.mNetworkFetcher = builder.mNetworkFetcher == null ? new HttpUrlConnectionNetworkFetcher(i) : builder.mNetworkFetcher;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.mPlatformBitmapFactory = builder.mPlatformBitmapFactory;
        if (builder.mPoolFactory == null) {
            poolFactory = new PoolFactory(PoolConfig.newBuilder().build());
        } else {
            poolFactory = builder.mPoolFactory;
        }
        this.mPoolFactory = poolFactory;
        this.mProgressiveJpegConfig = builder.mProgressiveJpegConfig == null ? new SimpleProgressiveJpegConfig() : builder.mProgressiveJpegConfig;
        this.mRequestListeners = builder.mRequestListeners == null ? new HashSet<>() : builder.mRequestListeners;
        this.mResizeAndRotateEnabledForNetwork = builder.mResizeAndRotateEnabledForNetwork;
        this.mSmallImageDiskCacheConfig = builder.mSmallImageDiskCacheConfig != null ? builder.mSmallImageDiskCacheConfig : defaultMainDiskCacheConfig;
        this.mImageDecoderConfig = builder.mImageDecoderConfig;
        this.mExecutorSupplier = builder.mExecutorSupplier == null ? new DefaultExecutorSupplier(poolFactory.getFlexByteArrayPoolMaxNumThreads()) : builder.mExecutorSupplier;
        this.mDiskCacheEnabled = builder.mDiskCacheEnabled;
        this.mCallerContextVerifier = builder.mCallerContextVerifier;
        this.mCloseableReferenceLeakTracker = builder.mCloseableReferenceLeakTracker;
        WebpBitmapFactory webpBitmapFactory = build.getWebpBitmapFactory();
        if (webpBitmapFactory != null) {
            setWebpBitmapFactory(webpBitmapFactory, build, new HoneycombBitmapCreator(getPoolFactory()));
        } else if (build.isWebpSupportEnabled() && WebpSupportStatus.sIsWebpSupportRequired && (loadWebpBitmapFactoryIfExists = WebpSupportStatus.loadWebpBitmapFactoryIfExists()) != null) {
            setWebpBitmapFactory(loadWebpBitmapFactoryIfExists, build, new HoneycombBitmapCreator(getPoolFactory()));
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private static void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
        WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
        WebpBitmapFactory.WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
        if (webpErrorLogger != null) {
            webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
        }
        if (bitmapCreator != null) {
            webpBitmapFactory.setBitmapCreator(bitmapCreator);
        }
    }

    private static DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
            }
            return DiskCacheConfig.newBuilder(context).build();
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    static void resetDefaultRequestConfig() {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.mBitmapMemoryCacheParamsSupplier;
    }

    public CountingMemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.mBitmapMemoryCacheTrimStrategy;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    public Context getContext() {
        return this.mContext;
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return sDefaultImageRequestConfig;
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.mFileCacheFactory;
    }

    public boolean isDownsampleEnabled() {
        return this.mDownsampleEnabled;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled;
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.mEncodedMemoryCacheParamsSupplier;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mExecutorSupplier;
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.mImageCacheStatsTracker;
    }

    @Nullable
    public ImageDecoder getImageDecoder() {
        return this.mImageDecoder;
    }

    @Nullable
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.mImageTranscoderFactory;
    }

    @Nullable
    public Integer getImageTranscoderType() {
        return this.mImageTranscoderType;
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.mIsPrefetchEnabledSupplier;
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mMainDiskCacheConfig;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public int getMemoryChunkType() {
        return this.mMemoryChunkType;
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.mNetworkFetcher;
    }

    @Nullable
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mPlatformBitmapFactory;
    }

    public PoolFactory getPoolFactory() {
        return this.mPoolFactory;
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.mProgressiveJpegConfig;
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.mRequestListeners);
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.mResizeAndRotateEnabledForNetwork;
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.mSmallImageDiskCacheConfig;
    }

    @Nullable
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.mImageDecoderConfig;
    }

    @Nullable
    public CallerContextVerifier getCallerContextVerifier() {
        return this.mCallerContextVerifier;
    }

    public ImagePipelineExperiments getExperiments() {
        return this.mImagePipelineExperiments;
    }

    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.mCloseableReferenceLeakTracker;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    @Nullable
    private static ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
        if (builder.mImageTranscoderFactory != null && builder.mImageTranscoderType != null) {
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        }
        if (builder.mImageTranscoderFactory == null) {
            return null;
        }
        return builder.mImageTranscoderFactory;
    }

    private static int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
        if (builder.mMemoryChunkType != null) {
            return builder.mMemoryChunkType.intValue();
        }
        return imagePipelineExperiments.isNativeCodeDisabled() ? 1 : 0;
    }

    /* loaded from: classes.dex */
    public static class DefaultImageRequestConfig {
        private boolean mProgressiveRenderingEnabled;

        private DefaultImageRequestConfig() {
            this.mProgressiveRenderingEnabled = false;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            this.mProgressiveRenderingEnabled = z;
        }

        public boolean isProgressiveRenderingEnabled() {
            return this.mProgressiveRenderingEnabled;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Bitmap.Config mBitmapConfig;
        private Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
        private CountingMemoryCache.CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
        private CacheKeyFactory mCacheKeyFactory;
        private CallerContextVerifier mCallerContextVerifier;
        private CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
        private final Context mContext;
        private boolean mDiskCacheEnabled;
        private boolean mDownsampleEnabled;
        private Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
        private ExecutorSupplier mExecutorSupplier;
        private final ImagePipelineExperiments.Builder mExperimentsBuilder;
        private FileCacheFactory mFileCacheFactory;
        private int mHttpConnectionTimeout;
        private ImageCacheStatsTracker mImageCacheStatsTracker;
        private ImageDecoder mImageDecoder;
        private ImageDecoderConfig mImageDecoderConfig;
        private ImageTranscoderFactory mImageTranscoderFactory;
        @Nullable
        private Integer mImageTranscoderType;
        private Supplier<Boolean> mIsPrefetchEnabledSupplier;
        private DiskCacheConfig mMainDiskCacheConfig;
        @Nullable
        private Integer mMemoryChunkType;
        private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        private NetworkFetcher mNetworkFetcher;
        private PlatformBitmapFactory mPlatformBitmapFactory;
        private PoolFactory mPoolFactory;
        private ProgressiveJpegConfig mProgressiveJpegConfig;
        private Set<RequestListener> mRequestListeners;
        private boolean mResizeAndRotateEnabledForNetwork;
        private DiskCacheConfig mSmallImageDiskCacheConfig;

        private Builder(Context context) {
            this.mDownsampleEnabled = false;
            this.mImageTranscoderType = null;
            this.mMemoryChunkType = null;
            this.mResizeAndRotateEnabledForNetwork = true;
            this.mHttpConnectionTimeout = -1;
            this.mExperimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.mDiskCacheEnabled = true;
            this.mCloseableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
            this.mContext = (Context) Preconditions.checkNotNull(context);
        }

        public Builder setBitmapsConfig(Bitmap.Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mBitmapMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(CountingMemoryCache.CacheTrimStrategy cacheTrimStrategy) {
            this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.mCacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder setHttpConnectionTimeout(int i) {
            this.mHttpConnectionTimeout = i;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.mFileCacheFactory = fileCacheFactory;
            return this;
        }

        public boolean isDownsampleEnabled() {
            return this.mDownsampleEnabled;
        }

        public Builder setDownsampleEnabled(boolean z) {
            this.mDownsampleEnabled = z;
            return this;
        }

        public boolean isDiskCacheEnabled() {
            return this.mDiskCacheEnabled;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            this.mDiskCacheEnabled = z;
            return this;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            this.mEncodedMemoryCacheParamsSupplier = (Supplier) Preconditions.checkNotNull(supplier);
            return this;
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.mExecutorSupplier = executorSupplier;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.mImageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.mImageDecoder = imageDecoder;
            return this;
        }

        @Nullable
        public Integer getImageTranscoderType() {
            return this.mImageTranscoderType;
        }

        public Builder setImageTranscoderType(int i) {
            this.mImageTranscoderType = Integer.valueOf(i);
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.mImageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            this.mIsPrefetchEnabledSupplier = supplier;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mMainDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        @Nullable
        public Integer getMemoryChunkType() {
            return this.mMemoryChunkType;
        }

        public Builder setMemoryChunkType(int i) {
            this.mMemoryChunkType = Integer.valueOf(i);
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.mNetworkFetcher = networkFetcher;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.mPlatformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            this.mPoolFactory = poolFactory;
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.mProgressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            this.mRequestListeners = set;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z) {
            this.mResizeAndRotateEnabledForNetwork = z;
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mSmallImageDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.mImageDecoderConfig = imageDecoderConfig;
            return this;
        }

        public Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            this.mCallerContextVerifier = callerContextVerifier;
            return this;
        }

        public Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            this.mCloseableReferenceLeakTracker = closeableReferenceLeakTracker;
            return this;
        }

        public ImagePipelineExperiments.Builder experiment() {
            return this.mExperimentsBuilder;
        }

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this);
        }
    }
}
