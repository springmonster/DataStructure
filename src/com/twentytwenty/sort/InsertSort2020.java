package com.twentytwenty.sort;

class InsertSort2020 {
    private static int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];

            int j = i - 1;
            while (j >= 0 && value < array[j]) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = value;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}