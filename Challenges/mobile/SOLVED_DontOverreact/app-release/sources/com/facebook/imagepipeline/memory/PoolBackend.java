package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;
/* loaded from: classes.dex */
interface PoolBackend<T> {
    @Nullable
    /* renamed from: get */
    T mo130get(int i);

    int getSize(T t);

    @Nullable
    T pop();

    void put(T t);
}
