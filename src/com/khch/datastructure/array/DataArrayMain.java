package com.khch.datastructure.array;

public class DataArrayMain {
    public static void main(String[] args) {
        DataArray dataArray = new DataArray();

        dataArray.insert(5);
        dataArray.insert(4);
        dataArray.insert(6);
        dataArray.insert(3);
        dataArray.insert(7);
        dataArray.insert(2);
        dataArray.insert(8);
        dataArray.insert(1);
        dataArray.insert(9);
        dataArray.insert(0);
        dataArray.display();

        dataArray.insert(11);
        dataArray.display();

        dataArray.delete(6);
        dataArray.display();

        dataArray.insert(6);
        dataArray.display();

        int max = dataArray.getMax();
        System.out.println(String.format("max number is %d", max));

        dataArray.delete(11);
        dataArray.display();


        boolean isFind = dataArray.find(10);
        System.out.println(isFind);

        isFind = dataArray.find(100);
        System.out.println(isFind);

        dataArray.removeMax();
        dataArray.display();
    }
}
