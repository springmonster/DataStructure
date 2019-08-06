package com.khch.datastructure.practice.leetcode;

import java.util.Stack;

public class Stack150 {
    public static void main(String[] args) {
//        String[] input = new String[]{"2", "1", "+", "3", "*"};
//        String[] input = new String[]{"4", "13", "5", "/", "+"};
        String[] input = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution150().evalRPN(input));
    }
}

class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String value = tokens[i];
            if ("+".equalsIgnoreCase(value) ||
                    "-".equalsIgnoreCase(value) ||
                    "*".equalsIgnoreCase(value) ||
                    "/".equalsIgnoreCase(value)) {
                int second = stack.pop();
                int first = stack.pop();
                int temp = 0;
                if ("+".equalsIgnoreCase(value)) {
                    temp = first + second;
                } else if ("-".equalsIgnoreCase(value)) {
                    temp = first - second;
                } else if ("*".equalsIgnoreCase(value)) {
                    temp = first * second;
                } else if ("/".equalsIgnoreCase(value)) {
                    temp = first / second;
                }
                stack.push(temp);
            } else {
                stack.push(Integer.valueOf(value));
            }
        }
        return stack.pop();
    }
}