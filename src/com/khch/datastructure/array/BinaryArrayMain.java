package com.khch.datastructure.array;

public class BinaryArrayMain {
    public static void main(String[] args) {
        BinaryArray binaryArray = new BinaryArray();

        binaryArray.insert(10);
        binaryArray.insert(9);
        binaryArray.insert(8);
        binaryArray.insert(7);
        binaryArray.insert(6);
        binaryArray.insert(5);
        binaryArray.insert(4);
        binaryArray.insert(3);
        binaryArray.insert(2);
        binaryArray.insert(1);
        binaryArray.display();

        binaryArray.insert(11);
        binaryArray.display();

        binaryArray.insert(0);
        binaryArray.display();

        binaryArray.delete(6);
        binaryArray.display();

        binaryArray.insert(6);
        binaryArray.display();

        binaryArray.delete(11);
        binaryArray.display();

        boolean isFind = binaryArray.find(10);

        System.out.println(isFind);

        isFind = binaryArray.find(100);

        System.out.println(isFind);
    }
}
