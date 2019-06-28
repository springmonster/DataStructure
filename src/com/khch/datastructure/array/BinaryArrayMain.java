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

        System.out.println("------------------------");
        BinaryArray binaryArray1 = new BinaryArray();
        binaryArray1.insert(30);
        binaryArray1.insert(20);
        binaryArray1.insert(10);
        binaryArray1.insert(0);
        binaryArray1.display();

        BinaryArray binaryArray2 = new BinaryArray();
        binaryArray2.insert(35);
        binaryArray2.insert(25);
        binaryArray2.insert(15);
        binaryArray2.insert(5);
        binaryArray2.insert(60);
        binaryArray2.insert(3);
        binaryArray2.insert(9);
        binaryArray2.display();

        binaryArray.merge(binaryArray1, binaryArray2);
        binaryArray.display();
    }
}
