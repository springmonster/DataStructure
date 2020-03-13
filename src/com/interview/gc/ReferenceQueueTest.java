package com.interview.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ReferenceQueueTest {
    private static ReferenceQueue<NormalObject> referenceQueue = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<NormalObject> reference;
        while ((reference = (Reference<NormalObject>) referenceQueue.poll()) != null) {
            System.out.println("reference name " + ((NormalObjectWearReference) reference).name);
            System.out.println("reference get " + reference.get());
        }
    }

    public static void main(String[] args) {
        List<WeakReference<NormalObject>> weakReferenceList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            weakReferenceList.add(new NormalObjectWearReference(new NormalObject("weak object " + i), referenceQueue));
            System.out.println("Created weak:  " + weakReferenceList.get(i));
        }
        System.out.println("first time");
        checkQueue();
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("second time");
        checkQueue();
    }
}
