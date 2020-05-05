package com._2020.graph.shortestpath;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class Dijkstra {
    private static int[][] array;
    // 一维数组记录源点到其他点的最短距离
    private static int[] dis;
    // 记录哪些点已经被访问过
    private static int[] book;
    private static int nums;
    private static final int MAX_VALUE = 9999;
    // 每次寻找的最小值
    private static int min;
    // 每次寻找的最小值的下标
    private static int index;

    public static void main(String[] args) throws FileNotFoundException {
        initGraph();
        display(nums);
        System.out.println("Result as below:");
        dijkstra(nums);
        displayResult();
    }

    private static void initGraph() throws FileNotFoundException {
        File file = new File("dijkstra");
        Scanner scanner = new Scanner(file);

        nums = scanner.nextInt();

        array = new int[nums + 1][nums + 1];
        for (int i = 1; i <= nums; i++) {
            for (int j = 1; j <= nums; j++) {
                if (i != j) {
                    array[i][j] = MAX_VALUE;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        while (scanner.hasNextLine()) {
            int firstNum = scanner.nextInt();
            int secondNum = scanner.nextInt();
            int weight = scanner.nextInt();
            System.out.println(firstNum);
            System.out.println(secondNum);
            System.out.println(weight);

            array[firstNum][secondNum] = weight;
        }

        dis = array[1];
        book = new int[nums + 1];
        book[0] = book[1] = 1;
    }

    private static void dijkstra(int nums) {
        for (int i = 1; i <= nums; i++) {
            // 首先找到最小的边，并且顶点未被访问过
            min = MAX_VALUE;
            for (int j = 1; j <= nums; j++) {
                if (book[j] != 1 && dis[j] < min) {
                    min = dis[j];
                    index = j;
                }
            }
            // 设置为访问过
            book[index] = 1;
            // 访问二维数组中的index的行，如果通过index这个当前选出的最小点，还能将距离进行缩短，那么就进行松弛
            for (int v = 1; v <= nums; v++) {
                if (array[index][v] != MAX_VALUE) {
                    if (dis[v] > dis[index] + array[index][v]) {
                        dis[v] = dis[index] + array[index][v];
                    }
                }
            }
        }
    }

    private static void display(int nums) {
        for (int i = 1; i <= nums; i++) {
            for (int j = 1; j <= nums; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void displayResult() {
        for (int di : dis) {
            System.out.print(di + " ");
        }
    }
}
