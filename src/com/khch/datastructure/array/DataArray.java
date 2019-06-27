package com.khch.datastructure.array;


/**
 * 1. 如果插入数据超出数组的容量，如何扩容？
 * 2. 如果插入数据有重复数据，如何保证删除策略？
 * - 2.1 是只删除匹配的第一个？
 * - 2.2 是删除所有的匹配？
 */
public class DataArray {
    int capacity = 100;
    int[] array;
    int elementCount;

    public DataArray() {
        array = new int[capacity];
        elementCount = 0;
    }

    public boolean find(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 无扩容，如果容量不够则不允许插入
     *
     * @param value
     * @return
     */
    public boolean insert(int value) {
        if (elementCount >= capacity) {
            return false;
        } else {
            array[elementCount] = value;
            elementCount++;
            return true;
        }
    }

    /**
     * 只删除匹配的第一个数据
     *
     * @param value
     */
    public void delete(int value) {
        int j = elementCount;
        for (int i = 0; i < elementCount; i++) {
            if (array[i] == value) {
                j = i;
                break;
            }
        }
        if (j != elementCount) {
            for (int k = j; k < elementCount; k++) {
                array[k] = array[k + 1];
            }
            elementCount--;
        }
    }

    public void display() {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int getMax() {
        if (elementCount == 0) {
            return -1;
        }
        int max = array[0];
        for (int i = 1; i < elementCount; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public void removeMax() {
        if (elementCount == 0) {
            return;
        }
        int max = array[0];
        int index = 0;
        for (int i = 1; i < elementCount; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        for (int j = index; j < elementCount; j++) {
            array[j] = array[j + 1];
        }
        elementCount--;
    }
}
