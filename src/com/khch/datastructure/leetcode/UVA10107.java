package com.khch.datastructure.leetcode;

/**
 * 不断的输入整数，输出中值，如果中间有两个数，输出他们平均值的整数部分。
 * <p>
 * input
 * 1
 * 3
 * 4
 * 60
 * 70
 * 50
 * 2
 * <p>
 * output
 * 1
 * 2
 * 3
 * 3
 * 4
 * 27
 * 4
 */
public class UVA10107 {
    private static int[] array = new int[]{1, 3, 4, 60, 70, 50, 2};
    private static int[] resultArray = new int[array.length];

    public static void main(String[] args) {
        sortAndFind();
        display();
    }

    private static void sortAndFind() {
        UVAArray uvaArray = new UVAArray(array.length);

        for (int i = 0; i < array.length; i++) {
            uvaArray.insert(array[i]);
            if (uvaArray.elementCount % 2 == 1) {
                resultArray[i] = uvaArray.innerArray[(uvaArray.elementCount - 1) / 2];
            } else {
                int temp = uvaArray.elementCount / 2;
                int result = (uvaArray.innerArray[temp - 1] + uvaArray.innerArray[temp]) / 2;
                resultArray[i] = result;
            }
        }
    }

    private static void display() {
        for (int item :
                resultArray) {
            System.out.print(item + " ");
        }
    }
}

class UVAArray {
    int elementCount = 0;
    int[] innerArray;

    public UVAArray(int length) {
        innerArray = new int[length];
    }

    void insert(int value) {
        elementCount++;
        int index = elementCount - 1;
        int temp = value;
        while (index >= 1 && innerArray[index - 1] > value) {
            innerArray[index] = innerArray[index - 1];
            index--;
        }
        innerArray[index] = value;
    }
}
