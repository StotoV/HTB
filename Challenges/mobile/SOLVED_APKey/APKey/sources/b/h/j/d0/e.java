package b.h.j.d0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
/* loaded from: classes.dex */
public final class e {
    public final c a;

    /* loaded from: classes.dex */
    public static final class a implements c {
        public final InputContentInfo a;

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // b.h.j.d0.e.c
        public ClipDescription a() {
            return this.a.getDescription();
        }

        @Override // b.h.j.d0.e.c
        public void b() {
            this.a.requestPermission();
        }

        @Override // b.h.j.d0.e.c
        public Uri c() {
            return this.a.getLinkUri();
        }

        @Override // b.h.j.d0.e.c
        public Object d() {
            return this.a;
        }

        @Override // b.h.j.d0.e.c
        public Uri e() {
            return this.a.getContentUri();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements c {
        public final Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final ClipDescription f480b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f481c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.f480b = clipDescription;
            this.f481c = uri2;
        }

        @Override // b.h.j.d0.e.c
        public ClipDescription a() {
            return this.f480b;
        }

        @Override // b.h.j.d0.e.c
        public void b() {
        }

        @Override // b.h.j.d0.e.c
        public Uri c() {
            return this.f481c;
        }

        @Override // b.h.j.d0.e.c
        public Object d() {
            return null;
        }

        @Override // b.h.j.d0.e.c
        public Uri e() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        ClipDescription a();

        void b();

        Uri c();

        Object d();

        Uri e();
    }

    public e(c cVar) {
        this.a = cVar;
    }
}
