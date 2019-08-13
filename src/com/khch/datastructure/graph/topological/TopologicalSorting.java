package com.khch.datastructure.graph.topological;

import java.util.Stack;

/*
    5->0<-4
    |     |
    V     V
    2->3->1
 */
public class TopologicalSorting {
    public static void main(String[] args) {
        int[] inDegree = new int[]{2, 2, 1, 1, 0, 0};

        TopologicalNode[] topologicalNodes = new TopologicalNode[6];
        // 0
        topologicalNodes[0] = new TopologicalNode(0);
        // 1
        topologicalNodes[1] = new TopologicalNode(1);
        // 2
        topologicalNodes[2] = new TopologicalNode(2);
        topologicalNodes[2].next = new TopologicalNode(3);
        // 3
        topologicalNodes[3] = new TopologicalNode(3);
        topologicalNodes[3].next = new TopologicalNode(1);
        // 4
        topologicalNodes[4] = new TopologicalNode(4);
        topologicalNodes[4].next = new TopologicalNode(0);
        topologicalNodes[4].next.next = new TopologicalNode(1);
        // 5
        topologicalNodes[5] = new TopologicalNode(5);
        topologicalNodes[5].next = new TopologicalNode(0);
        topologicalNodes[5].next.next = new TopologicalNode(2);

        Stack<TopologicalNode> stack = new Stack<>();

        // 将入度为0的顶点入栈
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(topologicalNodes[i]);
            }
        }

        while (!stack.isEmpty()) {
            TopologicalNode node = stack.pop();
            System.out.print(node.value + " ");
            for (; node.next != null; node = node.next) {
                inDegree[node.next.value] = inDegree[node.next.value] - 1;
                if (inDegree[node.next.value] == 0) {
                    stack.push(topologicalNodes[node.next.value]);
                }
            }
        }
    }
}

class TopologicalNode {
    int value;
    TopologicalNode next;

    public TopologicalNode(int value) {
        this.value = value;
    }
}
