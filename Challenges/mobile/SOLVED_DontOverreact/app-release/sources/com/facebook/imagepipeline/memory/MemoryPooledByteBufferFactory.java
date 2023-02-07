package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    private final MemoryChunkPool mPool;
    private final PooledByteStreams mPooledByteStreams;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.mPool = memoryChunkPool;
        this.mPooledByteStreams = pooledByteStreams;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    /* renamed from: newByteBuffer  reason: collision with other method in class */
    public MemoryPooledByteBuffer mo139newByteBuffer(int i) {
        Preconditions.checkArgument(i > 0);
        CloseableReference of = CloseableReference.of(this.mPool.mo137get(i), this.mPool);
        try {
            return new MemoryPooledByteBuffer(of, i);
        } finally {
            of.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    /* renamed from: newByteBuffer  reason: collision with other method in class */
    public MemoryPooledByteBuffer mo140newByteBuffer(InputStream inputStream) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    /* renamed from: newByteBuffer  reason: collision with other method in class */
    public MemoryPooledByteBuffer mo142newByteBuffer(byte[] bArr) {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return memoryPooledByteBufferOutputStream.mo145toByteBuffer();
            } catch (IOException e) {
                throw Throwables.propagate(e);
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    /* renamed from: newByteBuffer  reason: collision with other method in class */
    public MemoryPooledByteBuffer mo141newByteBuffer(InputStream inputStream, int i) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, i);
        try {
            return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    MemoryPooledByteBuffer newByteBuf(InputStream inputStream, MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream) throws IOException {
        this.mPooledByteStreams.copy(inputStream, memoryPooledByteBufferOutputStream);
        return memoryPooledByteBufferOutputStream.mo145toByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    /* renamed from: newOutputStream  reason: collision with other method in class */
    public MemoryPooledByteBufferOutputStream mo143newOutputStream() {
        return new MemoryPooledByteBufferOutputStream(this.mPool);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    /* renamed from: newOutputStream  reason: collision with other method in class */
    public MemoryPooledByteBufferOutputStream mo144newOutputStream(int i) {
        return new MemoryPooledByteBufferOutputStream(this.mPool, i);
    }
}
