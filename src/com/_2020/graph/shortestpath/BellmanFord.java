package com._2020.graph.shortestpath;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class BellmanFord {
    private static int[][] array;
    // 一维数组记录源点到其他点的最短距离
    private static int[] dis;

    private static int[] u;
    private static int[] v;
    private static int[] w;

    private static int nodeNums;
    private static int valueNums;
    private static final int MAX_VALUE = 9999;
    // 每次寻找的最小值
    private static int min;
    // 每次寻找的最小值的下标
    private static int index;

    public static void main(String[] args) throws FileNotFoundException {
        initGraph();
        display();
        System.out.println("\nResult as below:");
        bellmanford();
        displayResult();
    }

    private static void initGraph() throws FileNotFoundException {
        File file = new File("bellmanford");
        Scanner scanner = new Scanner(file);

        nodeNums = scanner.nextInt();
        valueNums = scanner.nextInt();

        dis = new int[nodeNums + 1];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = MAX_VALUE;
        }
        dis[0] = dis[1] = 0;

        u = new int[valueNums];
        v = new int[valueNums];
        w = new int[valueNums];

        int i = 0;

        while (scanner.hasNextLine()) {
            int firstNum = scanner.nextInt();
            int secondNum = scanner.nextInt();
            int weight = scanner.nextInt();
            System.out.println(firstNum);
            System.out.println(secondNum);
            System.out.println(weight);

            u[i] = firstNum;
            v[i] = secondNum;
            w[i] = weight;
            i++;
        }
    }

    private static void bellmanford() {
        for (int i = 0; i < nodeNums; i++) {
            for (int j = 0; j < nodeNums; j++) {
                if (dis[v[j]] > dis[u[j]] + w[j]) {
                    dis[v[j]] = dis[u[j]] + w[j];
                }
            }
        }
    }

    private static void display() {
        System.out.println("u is ");
        for (int i = 0; i < u.length; i++) {
            System.out.print(u[i] + " ");
        }
        System.out.println("\nv is ");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("\nw is ");
        for (int i = 0; i < w.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println("\ndis is ");
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i] + " ");
        }
    }

    private static void displayResult() {
        for (int di : dis) {
            System.out.print(di + " ");
        }
    }
}
