package com.twentytwenty.sort;

class SelectionSort2020 {
    private static int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length - i; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}