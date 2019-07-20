package com.khch.datastructure.tree.huffman;

import java.util.*;

public class HuffmanTreeManager {
    private static Map<String, String> huffmanMap = new HashMap<>();

    public static void main(String[] args) {
        // 构建原始的带权重的字符串哈希表
        Map<String, Integer> map = createOriginalStringMap();

        // 构建链表
        LinkedList<HuffmanNode> list = createList(map);

        // 排序链表，按照权重从小到大进行排列
        createSortedLinkedList(list);

        display(list);

        // 将权重链表转换为树
        HuffmanNode root = adjustLinkedListToTree(list);

        displayTree(root);

        // 进行哈夫曼编码 ----------------------------------------------
        String input = "abcdefg";

        encodeString(root, "");

        System.out.println("\n--- 进行哈夫曼编码 ---\n");
        displayTreeWithHuffmanCode(root);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            String charString = String.valueOf(input.charAt(i));
            stringBuilder.append(huffmanMap.get(charString));
        }

        System.out.println();
        System.out.println(String.format("原始字符串是%s，编码后是%s", input, stringBuilder.toString()));
        System.out.println("\n--- 进行哈夫曼编码 ---\n");
        // 进行哈夫曼编码 ----------------------------------------------

        // 进行哈夫曼解码 ----------------------------------------------
        decodeString(stringBuilder.toString(), root);
        // 进行哈夫曼解码 ----------------------------------------------
    }

    private static Map<String, Integer> createOriginalStringMap() {
        Map<String, Integer> map = new TreeMap<>();

        map.put("a", 5);
        map.put("b", 3);
        map.put("c", 7);
        map.put("d", 12);
        map.put("e", 1);
        map.put("f", 6);
        map.put("g", 9);

        return map;
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

    private static void createSortedLinkedList(List<HuffmanNode> array) {
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

    private static HuffmanNode adjustLinkedListToTree(LinkedList<HuffmanNode> list) {
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

            createSortedLinkedList(list);
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

    private static void encodeString(HuffmanNode node, String huffmanCode) {
        if (node.leftChild == null && node.rightChild == null) {
            node.huffmanCode = huffmanCode;
            huffmanMap.put(node.value, node.huffmanCode);
        } else {
            encodeString(node.leftChild, huffmanCode + "0");
            encodeString(node.rightChild, huffmanCode + "1");
        }
    }

    private static void displayTreeWithHuffmanCode(HuffmanNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.huffmanCode + " ");
        displayTreeWithHuffmanCode(node.leftChild);
        displayTreeWithHuffmanCode(node.rightChild);
    }

    private static void decodeString(String encodeString, HuffmanNode root) {
        System.out.println("\n--- 进行哈夫曼解码 ---\n");
        HuffmanNode current = root;

        for (int i = 0; i < encodeString.length(); i++) {
            if (String.valueOf(encodeString.charAt(i)).equalsIgnoreCase("0")) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current.leftChild == null && current.rightChild == null) {
                System.out.print(current.value + " ");
                current = root;
            }
        }
        System.out.println("\n--- 进行哈夫曼解码 ---\n");
    }
}
