package com.khch.datastructure.graph.traversal;

import java.util.Stack;

/*

                 A
                /\
               B  F
              /|\ /\
             C-I G  \
             \ | /\  \
               D - H  \
               \    \ \
                \    \\
                  \  \\
                    \\\
                     E
 */
public class GraphDFSTraversal {
    public static void main(String[] args) {
        int[][] adjacencyArray = new int[][]{
                //a
                {0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                //b
                {1, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 1},
                //c
                {Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1},
                //d
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE, 1, 1, 1},
                //e
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
                //f
                {1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                //g
                {Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 1, 0, 1, Integer.MAX_VALUE},
                //h
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 1, Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE},
                //i
                {Integer.MAX_VALUE, 1, 1, 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
        };

        dfs(adjacencyArray, 9);
    }

    private static void dfs(int[][] adjacencyArray, int length) {
        boolean[] visited = new boolean[length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            boolean allVisited = true;
            int index = stack.peek();
            for (int i = 0; i < length; i++) {
                if (adjacencyArray[index][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    allVisited = false;
//                    System.out.println("push into stack is " + (char) (i + 65));
                    break;
                }
            }
            if (allVisited) {
                int result = stack.pop();
                System.out.println("result is " + (char) (result + 65));
            }
        }
    }
}
