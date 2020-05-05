package com._2020.tree.priority;

import java.util.PriorityQueue;

/**
 * @see java.util.PriorityQueue
 * @see java.util.concurrent.PriorityBlockingQueue
 */
public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(6);
        priorityQueue.add(5);
        priorityQueue.add(4);

        while (!priorityQueue.isEmpty()) {
            System.out.print(" " + priorityQueue.poll());
        }
    }
}
