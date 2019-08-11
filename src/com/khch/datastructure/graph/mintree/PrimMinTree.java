package com.khch.datastructure.graph.mintree;

public class PrimMinTree {
    private static int MAX = Integer.MAX_VALUE;

    private static int[][] adjacencyArray = new int[][]{
            {0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX},
            {10, 0, 18, MAX, MAX, MAX, 16, MAX, 12},
            {MAX, 18, 0, 22, MAX, MAX, MAX, MAX, 8},
            {MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21},
            {MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX},
            {11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX},
            {MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX},
            {MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX},
            {MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0}
    };

    public static void main(String[] args) {
        int[] lowestCost = new int[9];
        int[] adjacency = new int[9];

        for (int i = 0; i < 9; i++) {
            lowestCost[i] = adjacencyArray[0][i];
        }

        for (int i = 0; i < 9; i++) {
            int min = MAX;
            int k = 0;
            for (int j = 0; j < 9; j++) {
                if (lowestCost[j] != 0 && lowestCost[j] < min) {
                    min = lowestCost[j];
                    k = j;
                }
            }

            System.out.println(String.format("权值最小的顶点是%d->%d", adjacency[k], k));

            // 顶点完成了任务
            lowestCost[k] = 0;

            for (int x = 0; x < 9; x++) {
                if (lowestCost[x] != 0 && adjacencyArray[k][x] < lowestCost[x]) {
                    lowestCost[x] = adjacencyArray[k][x];
                    adjacency[x] = k;
                }
            }
        }
    }
}
