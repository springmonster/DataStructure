package com.khch.datastructure.graph.shortestpath;

public class Dijkstra {
    public static void main(String[] args) {
        int LENGTH = 7;
        int INF = Integer.MAX_VALUE;
        int[][] matrix = new int[][]{
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF}, // <---选取初始顶点
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};

        int[] vertexArray = new int[LENGTH];
        int[] resultArray = new int[LENGTH];
        int[] previousParentArray = new int[LENGTH];

        int currentVertex = 3;
        vertexArray[currentVertex] = 1;
        for (int i = 0; i < LENGTH; i++) {
            resultArray[i] = matrix[currentVertex][i];
        }

        for (int i = 0; i < LENGTH; i++) {
            int minValue = INF;
            for (int j = 0; j < LENGTH; j++) {
                if (vertexArray[j] != 1 && resultArray[j] < minValue) {
                    minValue = resultArray[j];
                    currentVertex = j;
                }
            }
            if (vertexArray[currentVertex] != 1 && minValue != INF) {
                vertexArray[currentVertex] = 1;

                for (int k = 0; k < LENGTH; k++) {
                    if (vertexArray[k] != 1 && resultArray[k] > minValue + matrix[currentVertex][k] && matrix[currentVertex][k] != INF) {
                        resultArray[k] = minValue + matrix[currentVertex][k];
                        previousParentArray[k] = currentVertex;
                    }
                }
            }
        }

        for (int i = 0; i < LENGTH; i++) {
            System.out.print(String.format("%d ", resultArray[i]));
        }
        System.out.println("前驱节点为");
        for (int i = 0; i < LENGTH; i++) {
            System.out.print(String.format("%d ", previousParentArray[i]));
        }
    }
}
