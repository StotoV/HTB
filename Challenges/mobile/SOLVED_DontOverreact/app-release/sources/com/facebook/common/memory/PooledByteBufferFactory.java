package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public interface PooledByteBufferFactory {
    /* renamed from: newByteBuffer */
    PooledByteBuffer mo139newByteBuffer(int i);

    /* renamed from: newByteBuffer */
    PooledByteBuffer mo140newByteBuffer(InputStream inputStream) throws IOException;

    /* renamed from: newByteBuffer */
    PooledByteBuffer mo141newByteBuffer(InputStream inputStream, int i) throws IOException;

    /* renamed from: newByteBuffer */
    PooledByteBuffer mo142newByteBuffer(byte[] bArr);

    /* renamed from: newOutputStream */
    PooledByteBufferOutputStream mo143newOutputStream();

    /* renamed from: newOutputStream */
    PooledByteBufferOutputStream mo144newOutputStream(int i);
}
