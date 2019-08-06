package com.khch.datastructure.practice.leetcode;

public class Stone771 {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

//        String J = "z";
//        String S = "ZZ";

        int result = new Solution771().numJewelsInStones(J, S);
        System.out.println(result);
    }
}

class Solution771 {

    public int numJewelsInStones(String J, String S) {
        char[] array = new char[127];
        for (int i = 0; i < S.length(); i++) {
            array[S.charAt(i)] += 1;
        }
        int result = 0;
        for (int j = 0; j < J.length(); j++) {
            if (array[J.charAt(j)] != 0) {
                result += array[J.charAt(j)];
            }
        }
        return result;
    }
}
