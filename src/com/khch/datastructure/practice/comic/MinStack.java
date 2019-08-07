package com.khch.datastructure.practice.comic;

import java.util.Stack;

public class MinStack {
    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> stack1 = new Stack<>();

    public static void main(String[] args) throws Exception {
        push(4);
        push(9);
        push(7);
        push(3);
        push(8);
        push(5);

//        display();

        poll();
        poll();
        poll();
        poll();
        poll();
        poll();

        System.out.println("end");
    }

    private static void push(int value) {
        stack.push(value);
        if (!stack1.isEmpty()) {
            int minValue = stack1.peek();
            if (value < minValue) {
                stack1.push(value);
            }
        } else {
            stack1.push(value);
        }
    }

    private static int poll() throws Exception {
        if (!stack.isEmpty()) {
            int result = stack.pop();
            if (result == stack1.peek()) {
                stack1.pop();
            }
            return result;
        } else {
            throw new Exception("没有更多数据了");
        }
    }

//    private static void display() {
//        while (!stack.isEmpty()) {
//            System.out.print(stack.peek() + " ");
//        }
//        System.out.println();
//        while (!stack1.isEmpty()) {
//            System.out.print(stack1.peek() + " ");
//        }
//    }
}
