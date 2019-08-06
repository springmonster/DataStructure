package com.khch.datastructure.practice.leetcode;

import java.util.Stack;

public class Stack20 {
    public static void main(String[] args) {
        String input = "()[]{}";
//        String input = "(]";
//        String input = "]";
//        String input = "([)]";
//        String input = "(";
//        String input = "([]";
        System.out.println(new Solution20().isValid(input));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        boolean isValid = true;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == '{' || value == '[' || value == '(') {
                stack.push(value);
            } else {
                if (stack.size() != 0) {
                    char result = (char) stack.pop();
                    if (result == '{' && value == '}' ||
                            result == '[' && value == ']' ||
                            result == '(' && value == ')') {
                        // match
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        if (stack.size() != 0) {
            isValid = false;
        }
        return isValid;
    }
}