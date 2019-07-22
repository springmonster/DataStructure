package com.khch.datastructure.hash;

/**
 * 采用数组+链表的形式
 * 链表采用头部插入
 */
public class HashLinkedList {

    private static final int NUMBER = 11;
    private static HashItem[] array = new HashItem[11];

    void put(int key, String value) {
        int hashCode = key % NUMBER;

        if (array[hashCode] != null && array[hashCode].key != key) {
            HashItem hashItem = new HashItem(key, value);
            hashItem.setNext(array[hashCode].getNext());
            array[hashCode].setNext(hashItem);
        } else {
            HashItem hashItem = new HashItem(key, value);
            array[hashCode] = hashItem;
        }
    }

    String get(int key) {
        int hashCode = key % NUMBER;

        HashItem hashItem = array[hashCode];

        while (hashItem.key != key) {
            hashItem = hashItem.getNext();
        }

        return hashItem.getValue();
    }
}
