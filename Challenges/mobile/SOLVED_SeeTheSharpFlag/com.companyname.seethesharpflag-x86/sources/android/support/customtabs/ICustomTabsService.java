package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import java.util.List;
/* loaded from: classes.dex */
public interface ICustomTabsService extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements ICustomTabsService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String commandName, Bundle args) throws RemoteException {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List<Bundle> otherLikelyBundles) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback callback) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
            return 0;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) throws RemoteException {
            return false;
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long flags) throws RemoteException {
            return false;
        }
    }

    Bundle extraCommand(String commandName, Bundle args) throws RemoteException;

    boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List<Bundle> otherLikelyBundles) throws RemoteException;

    boolean newSession(ICustomTabsCallback callback) throws RemoteException;

    boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) throws RemoteException;

    int postMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException;

    boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) throws RemoteException;

    boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) throws RemoteException;

    boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) throws RemoteException;

    boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) throws RemoteException;

    boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) throws RemoteException;

    boolean warmup(long flags) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements ICustomTabsService {
        private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsService";
        static final int TRANSACTION_extraCommand = 5;
        static final int TRANSACTION_mayLaunchUrl = 4;
        static final int TRANSACTION_newSession = 3;
        static final int TRANSACTION_newSessionWithExtras = 10;
        static final int TRANSACTION_postMessage = 8;
        static final int TRANSACTION_receiveFile = 12;
        static final int TRANSACTION_requestPostMessageChannel = 7;
        static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
        static final int TRANSACTION_updateVisuals = 6;
        static final int TRANSACTION_validateRelationship = 9;
        static final int TRANSACTION_warmup = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICustomTabsService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICustomTabsService)) {
                return (ICustomTabsService) queryLocalInterface;
            }
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            Bundle bundle = null;
            Bundle bundle2 = null;
            Bundle bundle3 = null;
            Bundle bundle4 = null;
            Bundle bundle5 = null;
            Bundle bundle6 = null;
            Uri uri = null;
            Bundle bundle7 = null;
            Bundle bundle8 = null;
            switch (code) {
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    boolean warmup = warmup(data.readLong());
                    reply.writeNoException();
                    reply.writeInt(warmup ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    boolean newSession = newSession(ICustomTabsCallback.Stub.asInterface(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(newSession ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    Uri uri2 = data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    boolean mayLaunchUrl = mayLaunchUrl(asInterface, uri2, bundle, data.createTypedArrayList(Bundle.CREATOR));
                    reply.writeNoException();
                    reply.writeInt(mayLaunchUrl ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        bundle8 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    Bundle extraCommand = extraCommand(readString, bundle8);
                    reply.writeNoException();
                    if (extraCommand != null) {
                        reply.writeInt(1);
                        extraCommand.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface2 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        bundle7 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    boolean updateVisuals = updateVisuals(asInterface2, bundle7);
                    reply.writeNoException();
                    reply.writeInt(updateVisuals ? 1 : 0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface3 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    boolean requestPostMessageChannel = requestPostMessageChannel(asInterface3, uri);
                    reply.writeNoException();
                    reply.writeInt(requestPostMessageChannel ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface4 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    int postMessage = postMessage(asInterface4, readString2, bundle6);
                    reply.writeNoException();
                    reply.writeInt(postMessage);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface5 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    int readInt = data.readInt();
                    Uri uri3 = data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    boolean validateRelationship = validateRelationship(asInterface5, readInt, uri3, bundle5);
                    reply.writeNoException();
                    reply.writeInt(validateRelationship ? 1 : 0);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface6 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    boolean newSessionWithExtras = newSessionWithExtras(asInterface6, bundle4);
                    reply.writeNoException();
                    reply.writeInt(newSessionWithExtras ? 1 : 0);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface7 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    Uri uri4 = data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    boolean requestPostMessageChannelWithExtras = requestPostMessageChannelWithExtras(asInterface7, uri4, bundle3);
                    reply.writeNoException();
                    reply.writeInt(requestPostMessageChannelWithExtras ? 1 : 0);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    ICustomTabsCallback asInterface8 = ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    Uri uri5 = data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null;
                    int readInt2 = data.readInt();
                    if (data.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    boolean receiveFile = receiveFile(asInterface8, uri5, readInt2, bundle2);
                    reply.writeNoException();
                    reply.writeInt(receiveFile ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements ICustomTabsService {
            public static ICustomTabsService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean warmup(long flags) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(flags);
                    boolean z = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().warmup(flags);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean newSession(ICustomTabsCallback callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newSession(callback);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = true;
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newSessionWithExtras(callback, extras);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List<Bundle> otherLikelyBundles) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = true;
                    if (url != null) {
                        obtain.writeInt(1);
                        url.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(otherLikelyBundles);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().mayLaunchUrl(callback, url, extras, otherLikelyBundles);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public Bundle extraCommand(String commandName, Bundle args) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(commandName);
                    if (args != null) {
                        obtain.writeInt(1);
                        args.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().extraCommand(commandName, args);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateVisuals(callback, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = true;
                    if (postMessageOrigin != null) {
                        obtain.writeInt(1);
                        postMessageOrigin.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestPostMessageChannel(callback, postMessageOrigin);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = true;
                    if (postMessageOrigin != null) {
                        obtain.writeInt(1);
                        postMessageOrigin.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestPostMessageChannelWithExtras(callback, postMessageOrigin, extras);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public int postMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    obtain.writeString(message);
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().postMessage(callback, message, extras);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    obtain.writeInt(relation);
                    boolean z = true;
                    if (origin != null) {
                        obtain.writeInt(1);
                        origin.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().validateRelationship(callback, relation, origin, extras);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.customtabs.ICustomTabsService
            public boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    boolean z = true;
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(purpose);
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().receiveFile(callback, uri, purpose, extras);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ICustomTabsService impl) {
            if (Proxy.sDefaultImpl == null) {
                if (impl == null) {
                    return false;
                }
                Proxy.sDefaultImpl = impl;
                return true;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static ICustomTabsService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
