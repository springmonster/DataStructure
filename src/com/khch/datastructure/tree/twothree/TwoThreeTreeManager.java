package com.khch.datastructure.tree.twothree;

public class TwoThreeTreeManager {
    public static void main(String[] args) throws Exception {
        TwoThreeTree twoThreeTree = new TwoThreeTree();
        twoThreeTree.insert(18);
        twoThreeTree.insert(4);
        twoThreeTree.insert(0);
        twoThreeTree.insert(17);
        twoThreeTree.insert(2);
        twoThreeTree.insert(7);
        twoThreeTree.insert(23);
        twoThreeTree.insert(12);
        twoThreeTree.insert(15);
        twoThreeTree.insert(11);

        twoThreeTree.display();

        twoThreeTree = new TwoThreeTree();
        twoThreeTree.insert(0);
        twoThreeTree.insert(2);
        twoThreeTree.insert(4);
        twoThreeTree.insert(7);
        twoThreeTree.insert(11);
        twoThreeTree.insert(12);
        twoThreeTree.insert(15);
        twoThreeTree.insert(17);
        twoThreeTree.insert(18);
        twoThreeTree.insert(23);

        twoThreeTree.display();
    }
}
