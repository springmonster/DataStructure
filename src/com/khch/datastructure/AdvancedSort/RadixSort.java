package com.khch.datastructure.AdvancedSort;

/**
 * 基数排序
 */
public class RadixSort {

    private static int[] array = new int[]{543, 261, 93569, 1007, 771, 361, 60, 55, 120};

    public static void main(String[] args) {
        radixSort();
        display();
    }

    private static void radixSort() {
        System.out.println(String.format("Max length is %d", getMaxLength()));

        int maxLength = getMaxLength();
        int numA = 10;
        int numB = 1;

        for (int i = 0; i < maxLength; i++, numA = numA * 10, numB = numB * 10) {
            // 0--9
            RadixItem[] temp = new RadixItem[10];
            // 这里按照每一位进行排列
            for (int i1 : array) {
                // 这里需要获取每一位的数
                int value = (i1 % numA) / numB;
                RadixItem radixItem = new RadixItem();
                radixItem.value = i1;
                if (temp[value] == null) {
                    temp[value] = radixItem;
                } else {
                    RadixItem preItem = temp[value];
                    RadixItem currentItem = temp[value].next;
                    while (currentItem != null) {
                        preItem = currentItem;
                        currentItem = currentItem.next;
                    }
                    preItem.next = radixItem;
                }
            }
            // 然后将排列之后的再写入原始数组
            int index = 0;
            for (RadixItem radixItem : temp) {
                if (radixItem != null) {
                    array[index++] = radixItem.value;
                    RadixItem tempItem = radixItem.next;
                    while (tempItem != null) {
                        array[index++] = tempItem.value;
                        tempItem = tempItem.next;
                    }
                }
            }
        }
    }

    private static int getMaxLength() {
        int maxNumber = getMaxNumber();
        int length = 1;
        while (maxNumber / 10 != 0) {
            maxNumber = maxNumber / 10;
            length += 1;
        }
        return length;
    }

    private static int getMaxNumber() {
        int max = Integer.MIN_VALUE;
        for (int i1 : array) {
            if (i1 > max) {
                max = i1;
            }
        }
        return max;
    }

    private static void display() {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

class RadixItem {
    int value;
    RadixItem next;
}
