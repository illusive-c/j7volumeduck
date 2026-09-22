package com.desaysv.ivi.vdb.client.listener;

import com.desaysv.ivi.vdb.client.bind.VDServiceDef;

/* loaded from: classes.dex */
public interface VDBindListener {
    void onVDConnected(VDServiceDef.ServiceType serviceType);

    void onVDDisconnected(VDServiceDef.ServiceType serviceType);
}
