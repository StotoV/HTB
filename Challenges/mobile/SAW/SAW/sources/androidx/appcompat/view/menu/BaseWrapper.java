package androidx.appcompat.view.menu;
/* loaded from: classes.dex */
class BaseWrapper<T> {
    final T mWrappedObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseWrapper(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = t;
    }

    /* renamed from: getWrappedObject */
    public T mo19getWrappedObject() {
        return this.mWrappedObject;
    }
}
