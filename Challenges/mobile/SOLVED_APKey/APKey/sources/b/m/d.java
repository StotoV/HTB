package b.m;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static a b(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return ON_START;
                }
                if (ordinal == 3) {
                    return ON_RESUME;
                }
                return null;
            }
            return ON_CREATE;
        }

        public b a() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return b.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return b.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return b.STARTED;
            }
            return b.CREATED;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED
    }

    public d() {
        new AtomicReference();
    }

    public abstract void a(f fVar);
}
