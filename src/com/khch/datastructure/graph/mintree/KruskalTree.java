package com.khch.datastructure.graph.mintree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalTree {
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
        List<KrusKalNode> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (adjacencyArray[i][j] != 0 && adjacencyArray[i][j] != MAX) {
                    KrusKalNode krusKalNode = new KrusKalNode();
                    krusKalNode.begin = i;
                    krusKalNode.end = j;
                    krusKalNode.weight = adjacencyArray[i][j];
                    list.add(krusKalNode);
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o.weight));
        for (KrusKalNode node : list) {
            System.out.println(String.format("Begin is %d End is %d Weight is %d", node.begin, node.end, node.weight));
        }
        System.out.println("------------------------------ Final Result is ------------------------------");
        int[] parent = new int[9];

        for (int i = 0, count = list.size(); i < count; i++) {
            int m = findParent(parent, list.get(i).begin);
            int n = findParent(parent, list.get(i).end);
            if (m != n) {
                parent[n] = m;
                System.out.println(String.format("Begin is %d End is %d Weight is %d", list.get(i).begin, list.get(i).end, list.get(i).weight));
            }
        }
    }

    private static int findParent(int[] parent, int vertex) {
        while (parent[vertex] > 0) {
            vertex = parent[vertex];
        }
        return vertex;
    }
}

class KrusKalNode {
    int begin;
    int end;
    int weight;
}