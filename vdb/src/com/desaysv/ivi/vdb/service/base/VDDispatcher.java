package com.desaysv.ivi.vdb.service.base;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class VDDispatcher {
    private ArrayList<EventRange> mEventSet;
    private VDService mService;

    private class EventRange {
        private int mEventMaxId;
        private int mEventMinId;

        public EventRange(int i2, int i3) {
            this.mEventMinId = i2;
            this.mEventMaxId = i3;
        }

        public int getMaxId() {
            return this.mEventMaxId;
        }

        public int getMinId() {
            return this.mEventMinId;
        }
    }

    protected VDDispatcher(VDService vDService) {
        this.mService = vDService;
    }

    public void addEventRange(int i2, int i3) {
        EventRange eventRange = new EventRange(i2, i3);
        if (this.mEventSet == null) {
            this.mEventSet = new ArrayList<>();
        }
        this.mEventSet.add(eventRange);
    }

    public boolean isInsideEvent(VDEvent vDEvent) {
        ArrayList<EventRange> arrayList = this.mEventSet;
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        Iterator<EventRange> it = this.mEventSet.iterator();
        while (it.hasNext()) {
            EventRange next = it.next();
            if (vDEvent.getId() >= next.getMinId() && vDEvent.getId() <= next.getMaxId()) {
                return true;
            }
        }
        return false;
    }

    public abstract Bundle onGet(VDEvent vDEvent);

    public abstract void onSet(VDEvent vDEvent);

    public void publish(VDEvent vDEvent) {
        this.mService.publish(vDEvent);
    }
}
