package com.interview.gc;

public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization finalization = new Finalization();
        System.out.println(finalization);
        finalization = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(finalization);
        System.out.println(Finalization.finalization);
    }
}
