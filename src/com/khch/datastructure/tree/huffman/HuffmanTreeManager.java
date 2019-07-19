package com.khch.datastructure.tree.huffman;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanTreeManager {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        map.put("a", 5);
        map.put("b", 29);
        map.put("c", 7);
        map.put("d", 8);
        map.put("e", 14);
        map.put("f", 23);
        map.put("g", 3);
        map.put("h", 11);

        LinkedList<HuffmanNode> list = createList(map);

        insertSortList(list);

        display(list);

        HuffmanNode root = adjustArray(list);

        displayTree(root);

        String input = "abcdefgh";

        String result = encodeString(root, input, map);

        System.out.println(String.format("Result is %s", result));
    }

    private static LinkedList<HuffmanNode> createList(Map<String, Integer> map) {

        LinkedList<HuffmanNode> array = new LinkedList();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.value = entry.getKey();
            huffmanNode.weight = entry.getValue();

            array.add(huffmanNode);
        }

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
            System.out.print(String.format("value is %s and weight is %d \n", item.value, item.weight));
        }
    }

    private static HuffmanNode adjustArray(LinkedList<HuffmanNode> list) {
        while (list.size() >= 2) {
            HuffmanNode first = list.get(0);
            HuffmanNode second = list.get(1);

            list.remove(0);
            list.remove(0);

            HuffmanNode newNode = new HuffmanNode();
            newNode.leftChild = first;
            newNode.rightChild = second;
            newNode.weight = first.weight + second.weight;

            first.parent = newNode;
            first.isLeft = true;

            second.parent = newNode;
            second.isLeft = false;

            list.addFirst(newNode);

            insertSortList(list);
        }

        return list.get(0);
    }

    private static void displayTree(HuffmanNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        displayTree(node.leftChild);
        displayTree(node.rightChild);
    }

    private static String encodeString(HuffmanNode root, String input, Map<String, Integer> map) {
        System.out.println();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            HuffmanNode currentNode = root;
            findValue(String.valueOf(input.charAt(i)), map, stringBuilder, currentNode);
        }
        return stringBuilder.toString();
    }

    private static void findValue(String input, Map<String, Integer> map, StringBuilder stringBuilder, HuffmanNode currentNode) {
        if (currentNode == null) {
            return;
        }
        if (map.get(input) == currentNode.weight) {
            StringBuilder eachStringBuilder = new StringBuilder();
            while (currentNode.parent != null) {
                if (currentNode.isLeft) {
                    eachStringBuilder.insert(0, 0);
                } else {
                    eachStringBuilder.insert(0, 1);
                }
                currentNode = currentNode.parent;
            }
            System.out.println(String.format("each node encode is %s", eachStringBuilder.toString()));
            stringBuilder.append(eachStringBuilder.toString());
        } else {
            findValue(input, map, stringBuilder, currentNode.leftChild);
            findValue(input, map, stringBuilder, currentNode.rightChild);
        }
    }
}
