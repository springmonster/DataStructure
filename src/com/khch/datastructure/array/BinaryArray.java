package com.khch.datastructure.array;

public class BinaryArray {
    int capacity = 100;
    int[] array;
    int elementCount;

    public BinaryArray() {
        array = new int[capacity];
        elementCount = 0;
    }

    /**
     * 采用二分查找
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        int low = 0;
        int high = elementCount - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                return true;
            } else {
                if (array[mid] > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
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
        int low = 0;
        int high = elementCount - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for (int i = elementCount - 1; i >= low; i--) {
            array[i + 1] = array[i];
        }
        array[low] = value;
        elementCount++;
        return true;

//        if (elementCount >= capacity) {
//            return false;
//        } else {
//            int j = elementCount;
//            for (int i = 0; i < elementCount; i++) {
//                if (array[i] > value) {
//                    j = i;
//                    break;
//                }
//            }
//            for (int k = elementCount - 1; k >= j; k--) {
//                array[k + 1] = array[k];
//            }
//            array[j] = value;
//            elementCount++;
//            return true;
//        }
    }

    /**
     * 只删除匹配的第一个数据
     *
     * @param value
     */
    public void delete(int value) {
        int low = 0;
        int high = elementCount - 1;
        int index = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                index = mid;
                break;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for (int i = index; i < elementCount; i++) {
            array[i] = array[i + 1];
        }
        elementCount--;
        //        int j = elementCount;
//        for (int i = 0; i < elementCount; i++) {
//            if (array[i] == value) {
//                j = i;
//                break;
//            }
//        }
//        if (j != elementCount) {
//            for (int k = j; k < elementCount; k++) {
//                array[k] = array[k + 1];
//            }
//            elementCount--;
//        }
    }

    public void display() {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void merge(BinaryArray a, BinaryArray b) {
        int length = a.array.length + b.array.length;

        this.array = new int[length];
        this.elementCount = 0;

        int aIndex = 0;
        int bIndex = 0;
        int index = 0;

        while (true) {
            if (aIndex >= a.elementCount) {
                index = a.elementCount;
                break;
            }
            if (bIndex >= b.elementCount) {
                index = b.elementCount;
                break;
            }
            if (a.array[aIndex] < b.array[bIndex]) {
                this.array[index++] = a.array[aIndex++];
            } else {
                this.array[index++] = b.array[bIndex++];
            }
            this.elementCount++;
        }


        if (index < a.elementCount) {
            for (int j = index; j < a.elementCount; j++) {
                this.array[elementCount] = a.array[j];
                this.elementCount++;
            }
        }

        if (index < b.elementCount) {
            for (int j = index; j < b.elementCount; j++) {
                this.array[elementCount] = b.array[j];
                this.elementCount++;
            }
        }
    }
}
