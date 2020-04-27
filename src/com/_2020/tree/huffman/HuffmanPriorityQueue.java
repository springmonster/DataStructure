package com._2020.tree.huffman;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue priorityQueueMin = new PriorityQueue();
        priorityQueueMin.add(10);
        priorityQueueMin.add(9);
        priorityQueueMin.add(8);
        priorityQueueMin.add(7);

        Object[] objects = priorityQueueMin.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        System.out.println();

        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueueMax.add(7);
        priorityQueueMax.add(8);
        priorityQueueMax.add(9);
        priorityQueueMax.add(10);

        Object[] objects1 = priorityQueueMax.toArray();
        for (int i = 0; i < objects1.length; i++) {
            System.out.println(objects1[i]);
        }
    }
}
