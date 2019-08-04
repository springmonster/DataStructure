package com.khch.datastructure.tree.twothree;

/**
 * 2-3树的节点
 * 2节点，value有一个，子节点两个
 * 3节点，value有两个，子节点三个
 * 假设value的默认值为-1
 */
class TTNode {

    // 如果是2结点，那么占据values[0]和children[0],children[1]
    // 如果是3结点，那么占据values[0],values[1],children[0],children[1],children[2],
    int[] values = {-1, -1};
    TTNode[] children = new TTNode[3];
    TTNode parentNode;

    boolean isTwoNode() {
        return values[1] == -1;
    }
}
