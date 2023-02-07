package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;
/* loaded from: classes.dex */
public interface Pool<V> extends ResourceReleaser<V>, MemoryTrimmable {
    /* renamed from: get */
    V mo137get(int i);

    @Override // com.facebook.common.references.ResourceReleaser
    void release(V v);
}
