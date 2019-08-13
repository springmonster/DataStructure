package com.khch.datastructure.graph.shortestpath;

/*
 *    0  1  2  3
 * 0  0  2  6  4
 * 1  M  0  3  M
 * 2  7  M  0  1
 * 3  5  M 12  0
 */
public class FloydWarshall {

    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE;
        int[][] adjacencyArray = new int[][]{
                {0, 2, 6, 4},
                {MAX, 0, 3, MAX},
                {7, MAX, 0, 1},
                {5, MAX, 12, 0},
        };

        // array[i][j] > array[i][1] + array[1][j]
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (adjacencyArray[i][j] > adjacencyArray[i][k] + adjacencyArray[k][j]
                            && adjacencyArray[i][k] != MAX && adjacencyArray[k][j] != MAX) {
                        adjacencyArray[i][j] = adjacencyArray[i][k] + adjacencyArray[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(adjacencyArray[i][j] + " ");
            }
        }
    }
}
