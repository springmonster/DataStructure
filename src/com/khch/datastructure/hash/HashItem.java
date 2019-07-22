package com.khch.datastructure.hash;

public class HashItem {
    int key;
    private String value;

    HashItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
