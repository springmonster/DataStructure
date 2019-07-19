package com.khch.datastructure.tree.huffman;

import java.util.ArrayList;
import java.util.List;

public class HuffmanTreeManager {

    public static void main(String[] args) {
        List<HuffmanNode> list = createList();

        insertSortList(list);

        display(list);
    }

    private static List<HuffmanNode> createList() {
        HuffmanNode hNode1 = new HuffmanNode();
        hNode1.value = 'a';
        hNode1.weight = 5;

        HuffmanNode hNode2 = new HuffmanNode();
        hNode2.value = 'b';
        hNode2.weight = 29;

        HuffmanNode hNode3 = new HuffmanNode();
        hNode3.value = 'c';
        hNode3.weight = 7;

        HuffmanNode hNode4 = new HuffmanNode();
        hNode4.value = 'd';
        hNode4.weight = 8;

        HuffmanNode hNode5 = new HuffmanNode();
        hNode5.value = 'e';
        hNode5.weight = 14;

        HuffmanNode hNode6 = new HuffmanNode();
        hNode6.value = 'f';
        hNode6.weight = 23;

        HuffmanNode hNode7 = new HuffmanNode();
        hNode7.value = 'g';
        hNode7.weight = 3;

        HuffmanNode hNode8 = new HuffmanNode();
        hNode8.value = 'h';
        hNode8.weight = 11;

        List<HuffmanNode> array = new ArrayList();

        array.add(hNode1);
        array.add(hNode2);
        array.add(hNode3);
        array.add(hNode4);
        array.add(hNode5);
        array.add(hNode6);
        array.add(hNode7);
        array.add(hNode8);

        return array;
    }

    private static void insertSortList(List<HuffmanNode> array) {
        // 采用插入排序
        for (int i = 1; i < array.size(); i++) {
            HuffmanNode tempNode = array.get(i);
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (tempNode.weight < array.get(j).weight) {
                    array.set(j + 1, array.get(j));
                    index = j;
                }
            }
            if (index != i) {
                array.set(index, tempNode);
            }
        }
    }

    private static void display(List<HuffmanNode> list) {
        System.out.println();
        for (HuffmanNode item : list) {
            System.out.print(String.format("value is %c and weight is %d \n", item.value, item.weight));
        }
    }

    private static void adjustArray(List<HuffmanNode> list) {

    }
}
