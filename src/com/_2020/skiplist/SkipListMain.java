package com._2020.skiplist;

public class SkipListMain {
    public static void main(String[] args) {
        SkipList list = new SkipList();
        System.out.println(list);
        list.put(2);
        list.put(1);
        list.put(3);
        list.put(1);//测试同一个key值
        list.put(4);
        list.put(6);
        list.put(5);
        System.out.println(list);
        System.out.println(list.getSize());
    }
}
