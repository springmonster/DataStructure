package com.khch.datastructure.stackqueue;

public class StackXCharacterReverse {
    static String value = "Hello World!";

    public static void main(String[] args) {
        StackX stackX = new StackX(value.length());

        for (int i = 0; i < value.length(); i++) {
            stackX.push((int) value.charAt(i));
        }

        while (!stackX.isEmpty()) {
            System.out.print((char) stackX.pop());
        }
    }
}
