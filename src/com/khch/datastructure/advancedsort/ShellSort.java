package com.khch.datastructure.advancedsort;

public class ShellSort {
    private static int[] array = new int[]{54, 26, 93, 17, 77, 31, 44, 55, 20};

    public static void main(String[] args) {
        shellSort();
        display();
    }

    private static void shellSort() {
        int step = array.length;
        while (step >= 1) {
            step = step / 2;
            /**
             * 这里的作用是每一组需要几次插入排序
             * 比如最开始step是4，那么需要进行4次分别插入排序才能完成
             */
            for (int stepCount = 0; stepCount < step; stepCount++) {
                /**
                 * 针对每次一进行插入排序
                 * 首先定位到第一个元素
                 */
                for (int i = stepCount + step; i < array.length; i = i + step) {
                    int index = i;
                    int tempVal = array[i];
                    while (index - step >= 0 && array[index - step] > tempVal) {
                        array[index] = array[index - step];
                        index = index - step;
                    }
                    if (index != i) {
                        array[index] = tempVal;
                    }
                }
            }
        }
    }

    private static void display() {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
