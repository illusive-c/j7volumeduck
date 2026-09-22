package com.desaysv.ivi.vdb.client.bind;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class VDThreadConfig {
    public int corePoolSize;
    public long keepAliveTime;
    public int maximumPoolSize;
    public TimeUnit timeUnit;
    public BlockingQueue<Runnable> workQueue;

    public VDThreadConfig(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this.corePoolSize = i2;
        this.maximumPoolSize = i3;
        this.keepAliveTime = j2;
        this.timeUnit = timeUnit;
        this.workQueue = blockingQueue;
    }
}
