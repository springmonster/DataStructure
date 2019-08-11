package com.khch.datastructure.graph.traversal;

import java.util.LinkedList;

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
public class GraphBFSTraversal {
    public static void main(String[] args) {
        GLinkedNode[] adjacencyTable = new GLinkedNode[9];

        GLinkedNode gLinkedNodeA = new GLinkedNode(0);
        GLinkedNode gLinkedNodeB = new GLinkedNode(1);
        GLinkedNode gLinkedNodeC = new GLinkedNode(2);
        GLinkedNode gLinkedNodeD = new GLinkedNode(3);
        GLinkedNode gLinkedNodeE = new GLinkedNode(4);
        GLinkedNode gLinkedNodeF = new GLinkedNode(5);
        GLinkedNode gLinkedNodeG = new GLinkedNode(6);
        GLinkedNode gLinkedNodeH = new GLinkedNode(7);
        GLinkedNode gLinkedNodeI = new GLinkedNode(8);

        adjacencyTable[0] = gLinkedNodeA;
        adjacencyTable[0].next = new GLinkedNode(1);
        adjacencyTable[0].next.next = new GLinkedNode(5);

        adjacencyTable[1] = gLinkedNodeB;
        adjacencyTable[1].next = new GLinkedNode(0);
        adjacencyTable[1].next.next = new GLinkedNode(2);
        adjacencyTable[1].next.next.next = new GLinkedNode(8);
        adjacencyTable[1].next.next.next.next = new GLinkedNode(6);

        adjacencyTable[2] = gLinkedNodeC;
        adjacencyTable[2].next = new GLinkedNode(3);
        adjacencyTable[2].next.next = new GLinkedNode(8);

        adjacencyTable[3] = gLinkedNodeD;
        adjacencyTable[3].next = new GLinkedNode(2);
        adjacencyTable[3].next.next = new GLinkedNode(8);
        adjacencyTable[3].next.next.next = new GLinkedNode(6);
        adjacencyTable[3].next.next.next.next = new GLinkedNode(7);
        adjacencyTable[3].next.next.next.next.next = new GLinkedNode(4);

        adjacencyTable[4] = gLinkedNodeE;
        adjacencyTable[4].next = new GLinkedNode(3);
        adjacencyTable[4].next.next = new GLinkedNode(7);
        adjacencyTable[4].next.next.next = new GLinkedNode(5);

        adjacencyTable[5] = gLinkedNodeF;
        adjacencyTable[5].next = new GLinkedNode(0);
        adjacencyTable[5].next.next = new GLinkedNode(6);
        adjacencyTable[5].next.next.next = new GLinkedNode(4);

        adjacencyTable[6] = gLinkedNodeG;
        adjacencyTable[6].next = new GLinkedNode(1);
        adjacencyTable[6].next.next = new GLinkedNode(5);
        adjacencyTable[6].next.next.next = new GLinkedNode(7);
        adjacencyTable[6].next.next.next.next = new GLinkedNode(3);

        adjacencyTable[7] = gLinkedNodeH;
        adjacencyTable[7].next = new GLinkedNode(3);
        adjacencyTable[7].next.next = new GLinkedNode(4);
        adjacencyTable[7].next.next.next = new GLinkedNode(6);

        adjacencyTable[8] = gLinkedNodeI;
        adjacencyTable[8].next = new GLinkedNode(1);
        adjacencyTable[8].next.next = new GLinkedNode(2);
        adjacencyTable[8].next.next.next = new GLinkedNode(3);

        bfs(adjacencyTable, 9);
    }

    private static void bfs(GLinkedNode[] adjacencyTable, int length) {
        boolean[] visited = new boolean[length];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.push(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            System.out.println("result is " + (char) (adjacencyTable[index].value + 65));
            while (adjacencyTable[index].next != null) {
                if (!visited[adjacencyTable[index].next.value]) {
                    queue.offer(adjacencyTable[index].next.value);
                    visited[adjacencyTable[index].next.value] = true;
                }
                adjacencyTable[index] = adjacencyTable[index].next;
            }
        }
    }
}

class GLinkedNode {
    GLinkedNode(int value) {
        this.value = value;
    }

    int value;
    GLinkedNode next;
}
