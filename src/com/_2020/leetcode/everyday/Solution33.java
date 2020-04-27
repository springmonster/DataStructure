package com._2020.leetcode.everyday;


/**
 * }
 */
public class Solution33 {
    //    static int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
    static int[] nums = new int[]{};

    public static void main(String[] args) {
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        return search(nums, low, high, target);
    }

    private static int search(int[] nums, int low, int high, int target) {
        int mid = (low + high) / 2;

        if (nums[low] == target) {
            return low;
        } else if (nums[high] == target) {
            return high;
        } else if (nums[mid] == target) {
            return mid;
        }

        if (low >= high) {
            return -1;
        }

        int result1 = search(nums, low, mid, target);
        int result2 = search(nums, mid + 1, high, target);
        if (result1 != -1) {
            return result1;
        }
        return result2;
//        if (nums[low] < target && target < nums[mid]) {
//            return search(nums, low, mid, target);
//        } else {
//            return search(nums, mid + 1, high, target);
//        }
    }
}
