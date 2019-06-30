package com.khch.datastructure.stackqueue;

public class StackXMain {
    public static void main(String[] args) {
        StackX stackX = new StackX(5);
        stackX.push(9);
        stackX.push(8);
        stackX.push(7);
        stackX.push(6);
        stackX.push(5);

        System.out.println(stackX.pop());
        System.out.println(stackX.pop());
        System.out.println(stackX.pop());
        System.out.println(stackX.pop());
        System.out.println(stackX.peek());
        System.out.println(stackX.pop());
    }
}
