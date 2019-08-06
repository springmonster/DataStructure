package com.khch.datastructure.tree.priority;

/**
 * 假设数组最大为10
 * 要构建最大堆，即值越大优先级越高
 */
public class TPriorityQueue {
    private int[] array = new int[10];
    private int count = 0;

    public TPriorityQueue() {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.MIN_VALUE;
        }
    }

    public void push(int value) {
        array[count] = value;
        count++;
        adjustArray();
    }

    /**
     * 要选取的为父亲节点
     * 例如1，2，3，4，5，6
     * 1--0
     * 2--1    3--2
     * 4--3 5--4  6--5
     * 则从大到小需要循环的index为（count-1）/2
     */
    private void adjustArray() {
        int index = (count - 1) / 2;
        for (int i = index; i >= 0; i--) {
            adjust(i);
        }
    }

    private void adjust(int index) {
        if (2 * index + 1 > count || 2 * index + 2 > count || index > count) {
            return;
        }
        // 如果父节点大于左孩子但是小于右孩子
        if (array[index] > array[2 * index + 1] && array[index] < array[2 * index + 2]) {
            int temp = array[2 * index + 2];
            array[2 * index + 2] = array[index];
            array[index] = temp;

            adjust(2 * index + 2);
        } else {
            // 如果父节点小于左孩子并且左孩子小于右孩子
            if (array[index] < array[2 * index + 1] && array[2 * index + 1] < array[2 * index + 2]) {
                int temp = array[2 * index + 2];
                array[2 * index + 2] = array[index];
                array[index] = temp;

                adjust(2 * index + 2);
            } else if (array[index] < array[2 * index + 1] && array[2 * index + 1] > array[2 * index + 2]) {
                // 如果父节点小于左孩子但是左孩子大于右孩子
                int temp = array[2 * index + 1];
                array[2 * index + 1] = array[index];
                array[index] = temp;

                adjust(2 * index + 1);
            }
        }
    }

    public void pull() {
        if (count == -1) {
            System.out.println("没有数据了");
            return;
        }
        int result = array[0];
        array[0] = array[count - 1];
        count--;
        adjustArray();
        System.out.println(String.format("出队的数为%d", result));
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
