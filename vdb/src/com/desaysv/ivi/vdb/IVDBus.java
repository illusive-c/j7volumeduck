package com.desaysv.ivi.vdb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.desaysv.ivi.vdb.IVDBusCallback;
import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public interface IVDBus extends IInterface {

    public static abstract class Stub extends Binder implements IVDBus {
        private static final String DESCRIPTOR = "com.desaysv.ivi.vdb.IVDBus";
        static final int TRANSACTION_get = 1;
        static final int TRANSACTION_set = 2;
        static final int TRANSACTION_subscribe = 3;
        static final int TRANSACTION_subscribeCustomizedEvent = 4;
        static final int TRANSACTION_unsubscribeCustomizedEvent = 5;

        private static class Proxy implements IVDBus {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.desaysv.ivi.vdb.IVDBus
            public VDEvent get(VDEvent vDEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vDEvent != null) {
                        obtain.writeInt(1);
                        vDEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? VDEvent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.desaysv.ivi.vdb.IVDBus
            public void set(VDEvent vDEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vDEvent != null) {
                        obtain.writeInt(1);
                        vDEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.desaysv.ivi.vdb.IVDBus
            public void subscribe(int[] iArr, int i2, String str, IVDBusCallback iVDBusCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iVDBusCallback != null ? iVDBusCallback.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.desaysv.ivi.vdb.IVDBus
            public void subscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vDEvent != null) {
                        obtain.writeInt(1);
                        vDEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iVDBusNotify != null ? iVDBusNotify.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.desaysv.ivi.vdb.IVDBus
            public void unsubscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vDEvent != null) {
                        obtain.writeInt(1);
                        vDEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iVDBusNotify != null ? iVDBusNotify.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVDBus asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IVDBus)) ? new Proxy(iBinder) : (IVDBus) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                VDEvent vDEvent = get(parcel.readInt() != 0 ? VDEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (vDEvent != null) {
                    parcel2.writeInt(1);
                    vDEvent.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                set(parcel.readInt() != 0 ? VDEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                subscribe(parcel.createIntArray(), parcel.readInt(), parcel.readString(), IVDBusCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                subscribeCustomizedEvent(parcel.readInt() != 0 ? VDEvent.CREATOR.createFromParcel(parcel) : null, IVDBusNotify.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            unsubscribeCustomizedEvent(parcel.readInt() != 0 ? VDEvent.CREATOR.createFromParcel(parcel) : null, IVDBusNotify.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    VDEvent get(VDEvent vDEvent) throws RemoteException;

    void set(VDEvent vDEvent) throws RemoteException;

    void subscribe(int[] iArr, int i2, String str, IVDBusCallback iVDBusCallback) throws RemoteException;

    void subscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) throws RemoteException;

    void unsubscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) throws RemoteException;
}
