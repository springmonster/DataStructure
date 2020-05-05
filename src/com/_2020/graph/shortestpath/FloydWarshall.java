package com._2020.graph.shortestpath;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 通过第1，2，3。。。N条边来查看
 * e[i][j] > e[i][k] + e[k][j]
 */
public class FloydWarshall {
    private static int[][] array;
    private static int nums;
    private static final int MAX_VALUE = 9999;

    public static void main(String[] args) throws FileNotFoundException {
        initGraph();
        display(nums);
        System.out.println("Result as below:");
        floydWallshall(nums);
        display(nums);
    }

    private static void initGraph() throws FileNotFoundException {
        File file = new File("shortestpath");
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
    }

    private static void floydWallshall(int nums) {
        for (int k = 1; k <= nums; k++) {
            for (int i = 1; i <= nums; i++) {
                for (int j = 1; j <= nums; j++) {
                    if (array[i][j] > array[i][k] + array[k][j]) {
                        array[i][j] = array[i][k] + array[k][j];
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
}
