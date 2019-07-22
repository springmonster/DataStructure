package com.khch.datastructure.hash;

public class HashItem {
    int key;
    private String value;
    private HashItem next;

    HashItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setNext(HashItem next) {
        this.next = next;
    }

    public HashItem getNext() {
        return next;
    }
}
