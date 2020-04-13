package com._2020.swordoffer;

public class Solution58 {
    static String s = "lrloseumgh";
    static int k = 6;

    public static void main(String[] args) {
        System.out.println(reverseLeftWords(s, k));
    }

    public static String reverseLeftWords(String s, int n) {
        String firstPart = s.substring(0, n);
        String secondPart = s.substring(n);
        return secondPart.concat(firstPart);
    }
}
