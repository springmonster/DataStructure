package com.khch.datastructure.leetcode;

public class BinarySearch704 {
    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 3, 5, 9, 12};
        int result = new Solution704().search(array, 9);
        System.out.println(result);
    }
}

class Solution704 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
