package com.khch.datastructure.advancedsort;

/**
 * 快速排序的优化
 * 1. 再选取哨兵上，可以采取3个数取中或者9个数取中，3个数取中就是数组的头，中，尾
 * 2. 可以不用每次比较完哨兵之后都进行swap，最后当low和high相等时再把哨兵的值进行set
 * 3. 数据量较小时直接使用插入排序
 * 4. 尾递归优化？
 */
public class QuickSort {
    private static int[] array = new int[]{54, 26, 93, 17, 77, 31, 60, 55, 20, 20};

    public static void main(String[] args) {
        quickSort(0, array.length - 1);
        display();
    }

    private static void quickSort(int low, int high) {
        if (low < high) {
            int mid = findMid(low, high);
            quickSort(low, mid - 1);
            quickSort(mid + 1, high);
        }
    }

    private static int findMid(int low, int high) {
        int index = low;
        int value = array[index];
        while (low < high) {
            while (value <= array[high] && low < high) {
                high--;
            }
            swap(index, high);
            index = high;
            while (value >= array[low] && low < high) {
                low++;
            }
            swap(index, low);
            index = low;
        }
        return low;
    }

    private static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void display() {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
