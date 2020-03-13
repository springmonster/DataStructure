package com.interview.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class NormalObjectWearReference extends WeakReference<NormalObject> {
    public String name;

    public NormalObjectWearReference(NormalObject normalObject, ReferenceQueue referenceQueue) {
        super(normalObject, referenceQueue);
        this.name = normalObject.name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Normal Object Finalizing " + this.name);
    }
}
