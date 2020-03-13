package com.interview.string;

/**
 * java1.6和java1.6之后有区别
 */
public class InternDifference {
    public static void main(String[] args) {
        String s1 = "a";
        s1.intern();
        String s2 = "a";
        System.out.println(s1 == s2);

        String s3 = "b" + "c";
        s3.intern();
        String s4 = "bc";
        System.out.println(s3 == s4);
    }
}
