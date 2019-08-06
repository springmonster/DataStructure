package com.khch.datastructure.tree.priority;

public class TPriorityQueueManager {
    public static void main(String[] args) {
        TPriorityQueue tPriorityQueue = new TPriorityQueue();
        tPriorityQueue.push(1);
        tPriorityQueue.display();
        tPriorityQueue.push(2);
        tPriorityQueue.display();
        tPriorityQueue.push(3);
        tPriorityQueue.display();
        tPriorityQueue.push(4);
        tPriorityQueue.display();
        tPriorityQueue.push(5);
        tPriorityQueue.display();
        tPriorityQueue.push(6);
        tPriorityQueue.display();

        tPriorityQueue.pull();
        tPriorityQueue.display();
        tPriorityQueue.pull();
        tPriorityQueue.display();
        tPriorityQueue.pull();
        tPriorityQueue.display();
        tPriorityQueue.pull();
        tPriorityQueue.display();
        tPriorityQueue.pull();
        tPriorityQueue.display();
        tPriorityQueue.pull();
        tPriorityQueue.display();
    }
}
