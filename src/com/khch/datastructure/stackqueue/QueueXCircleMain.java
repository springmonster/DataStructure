package com.khch.datastructure.stackqueue;

public class QueueXCircleMain {
    public static void main(String[] args) {
        QueueXCircle queueXCircle = new QueueXCircle(4);

        System.out.println(queueXCircle.head);
        System.out.println(queueXCircle.tail);
        System.out.println("----------------");

        queueXCircle.insert(1);
        queueXCircle.insert(2);
        queueXCircle.insert(3);

        System.out.println(queueXCircle.head);
        System.out.println(queueXCircle.tail);
        System.out.println("----------------");

        queueXCircle.remove();
        queueXCircle.remove();
        queueXCircle.remove();

        System.out.println(queueXCircle.head);
        System.out.println(queueXCircle.tail);
        System.out.println("----------------");

        queueXCircle.insert(1);
        queueXCircle.insert(2);
        queueXCircle.insert(3);

        System.out.println(queueXCircle.head);
        System.out.println(queueXCircle.tail);
        System.out.println("----------------");
    }
}
