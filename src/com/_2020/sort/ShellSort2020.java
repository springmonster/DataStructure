package com._2020.sort;

public class ShellSort2020 {
    private static int[] array = new int[]{10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        int segment = array.length;
        while (segment >= 1) {
            segment = segment / 2;

            // 针对每一个段进行插入排序
            for (int i = 0; i < segment; i++) {
                insertionSort(i, segment);
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static void insertionSort(int startIndex, int segment) {
        for (int i = startIndex + segment; i < array.length; i = i + segment) {
            int segmentIndex = i;
            int value = array[segmentIndex];
            while ((segmentIndex - segment) >= 0 && value < array[segmentIndex - segment]) {
                array[segmentIndex] = array[segmentIndex - segment];
                segmentIndex = segmentIndex - segment;
            }
            if (segmentIndex != i) {
                array[segmentIndex] = value;
            }
        }
    }
}
