
package com.khch.datastructure.hash;

/**
 * 开放寻址法
 * 1. 线性探测
 * 2. 二次探测
 * 3. 再次哈希
 * <p>
 * 这里不考虑扩容也不考虑循环
 */
public class HashOpenAddress {
    private static final int NUMBER = 11;
    private static HashItem[] array = new HashItem[11];

    void clearArray() {
        array = new HashItem[11];
    }

    void putLinear(int key, String value) {
        int hashCode = key % NUMBER;

        while (array[hashCode] != null && array[hashCode].key != key) {
            hashCode = (hashCode + 1) % NUMBER;
        }
        array[hashCode] = new HashItem(key, value);
    }

    String getLinearValue(int key) {
        int hashCode = key % NUMBER;
        while (array[hashCode].key != key) {
            hashCode = (hashCode + 1) % NUMBER;
        }
        return array[hashCode].getValue();
    }

    void putSecond(int key, String value) {
        int hashCode = key % NUMBER;

        int count = 0;
        while (array[hashCode] != null && array[hashCode].key != key) {
            hashCode = (int) ((hashCode + Math.pow(2, count)) % NUMBER);
            count = count + 1;
        }
        array[hashCode] = new HashItem(key, value);
    }

    String getSecond(int key) {
        int hashCode = key % NUMBER;

        int count = 0;
        while (array[hashCode].key != key) {
            hashCode = (int) ((hashCode + Math.pow(2, count)) % NUMBER);
            count = count + 1;
        }
        return array[hashCode].getValue();
    }

    void putHashAgain(int key, String value) {
        int hashCode = key % NUMBER;

        while (array[hashCode] != null && array[hashCode].key != key) {
            hashCode = key % 5;
        }
        array[hashCode] = new HashItem(key, value);
    }

    String getHashAgain(int key) {
        int hashCode = key % NUMBER;

        while (array[hashCode].key != key) {
            hashCode = key % 5;
        }
        return array[hashCode].getValue();
    }
}
