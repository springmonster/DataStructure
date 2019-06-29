package com.khch.datastructure.leetcode;

/**
 * 这道题的解法并没有达到要求的log(m+n)
 */
public class MiddleNumber4 {
    public static void main(String[] args) {
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution4().findMedianSortedArrays(nums1, nums2));
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        int n1Index = 0;
        int n2Index = 0;
        int arrayIndex = 0;

        while (n1Index < nums1.length && n2Index < nums2.length) {
            if (nums1[n1Index] < nums2[n2Index]) {
                array[arrayIndex++] = nums1[n1Index++];
            } else {
                array[arrayIndex++] = nums2[n2Index++];
            }
        }

        if (n1Index < nums1.length) {
            for (int i = n1Index; i < nums1.length; i++) {
                array[arrayIndex++] = nums1[i];
            }
        }

        if (n2Index < nums2.length) {
            for (int i = n2Index; i < nums2.length; i++) {
                array[arrayIndex++] = nums2[i];
            }
        }

        if (array.length % 2 == 0) {
            return (double) (array[(array.length - 1) / 2] + array[array.length / 2]) / 2;
        } else {
            return (double) array[array.length / 2];
        }
    }
}
