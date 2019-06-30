package com.khch.datastructure.stackqueue;

public class StackXCharacterBracket {
    //    static String value = "{a([b{c(d)}]e)}";
    static String value = "{a([b{c(d)}}e)}";

    public static void main(String[] args) {
        StackX stackX = new StackX(value.length());

        for (int i = 0; i < value.length(); i++) {
            switch (value.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stackX.push(value.charAt(i));
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackX.isEmpty()) {
                        char right = value.charAt(i);
                        char left = (char) stackX.pop();
                        if (left == '{' && right == '}'
                                || left == '[' && right == ']'
                                || left == '(' && right == ')') {
                            System.out.println(String.format("Match is %c %c", left, right));
                        } else {
                            System.out.println("不匹配");
                            throw new IllegalArgumentException();
                        }
                    }
                    break;
                default:
                    System.out.println(String.format("This is letter %c", value.charAt(i)));
                    break;
            }
        }
    }
}
