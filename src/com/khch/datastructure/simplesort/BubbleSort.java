package com.khch.datastructure.simplesort;

public class BubbleSort {
    private static int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        bubbleSort();
        display();
    }

    private static void bubbleSort() {
//        for (int out = innerArray.length; out > 1; out--) {
//            for (int in = 0; in < out - 1; in++) {
//                if (innerArray[in] > innerArray[in + 1]) {
//                    int temp = innerArray[in];
//                    innerArray[in] = innerArray[in + 1];
//                    innerArray[in + 1] = temp;
//                }
//            }
//        }

        for (int out = array.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    int temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
            }
        }
    }

    private static void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
