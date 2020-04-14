package com._2020.leetcode.swordoffer;

import java.util.LinkedList;

public class Solution104 {

    public static void main(String[] args) {
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            int value1 = maxDepth(root.left);
//            int value2 = maxDepth(root.right);
//            return Math.max(value1, value2) + 1;
//        }

        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pop();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return maxDepth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
