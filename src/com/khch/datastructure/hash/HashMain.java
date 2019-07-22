package com.khch.datastructure.hash;

public class HashMain {

    public static void main(String[] args) {
        HashOpenAddress hashOpenAddress = new HashOpenAddress();

        hashOpenAddress.putLinear(1, "a");
        hashOpenAddress.putLinear(12, "b");
        System.out.println(hashOpenAddress.getLinearValue(1));
        System.out.println(hashOpenAddress.getLinearValue(12));

        hashOpenAddress.clearArray();

        hashOpenAddress.putSecond(1, "a");
        hashOpenAddress.putSecond(12, "b");
        hashOpenAddress.putSecond(23, "c");
        System.out.println(hashOpenAddress.getSecond(1));
        System.out.println(hashOpenAddress.getSecond(12));
        System.out.println(hashOpenAddress.getSecond(23));

        hashOpenAddress.clearArray();

        hashOpenAddress.putHashAgain(1, "a");
        hashOpenAddress.putHashAgain(12, "b");
        hashOpenAddress.putHashAgain(23, "c");
        System.out.println(hashOpenAddress.getHashAgain(1));
        System.out.println(hashOpenAddress.getHashAgain(12));
        System.out.println(hashOpenAddress.getHashAgain(23));

        HashLinkedList hashLinkedList = new HashLinkedList();
        hashLinkedList.put(1, "a");
        hashLinkedList.put(12, "b");
        hashLinkedList.put(23, "c");
        System.out.println(hashLinkedList.get(1));
        System.out.println(hashLinkedList.get(12));
        System.out.println(hashLinkedList.get(23));
    }
}
