package com.khch.datastructure.stackqueue;

public class QueueXMain {
    public static void main(String[] args) {
        QueueX queueX = new QueueX(5);

        queueX.insert(1);
        queueX.insert(2);
        queueX.insert(3);
        queueX.insert(4);


        System.out.println(queueX.remove());
        System.out.println(queueX.remove());
        System.out.println(queueX.remove());
    }
}
