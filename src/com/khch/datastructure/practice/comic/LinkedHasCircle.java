package com.khch.datastructure.practice.comic;

/**
 * 快慢指针
 */
public class LinkedHasCircle {
    public static void main(String[] args) {
        LhcNode lhcNode0 = new LhcNode(5);
        LhcNode lhcNode1 = new LhcNode(3);
        LhcNode lhcNode2 = new LhcNode(7);
        LhcNode lhcNode3 = new LhcNode(2);
        LhcNode lhcNode4 = new LhcNode(6);
        LhcNode lhcNode5 = new LhcNode(8);
        LhcNode lhcNode6 = new LhcNode(1);
        lhcNode0.next = lhcNode1;
        lhcNode1.next = lhcNode2;
        lhcNode2.next = lhcNode3;
        lhcNode3.next = lhcNode4;
        lhcNode4.next = lhcNode5;
        lhcNode5.next = lhcNode6;
        lhcNode6.next = lhcNode3;

        System.out.println(hasCircle(lhcNode0));
        System.out.println(String.format("环的长度为%d", circleLength(lhcNode0)));
        System.out.println(String.format("入环的值为%d", findInsertCircleNodeValue(lhcNode0)));
    }

    private static boolean hasCircle(LhcNode lhcNode) {
        LhcNode head1 = lhcNode;
        LhcNode head2 = lhcNode;
        while (head2 != null) {
            if (head2.next == null || head2.next.next == null) {
                break;
            }
            head2 = head2.next.next;
            head1 = head1.next;
            System.out.print(String.format("2指针是%d", head2.getValue()));
            System.out.print(String.format(" 1指针是%d", head1.getValue()));
            System.out.println();
            if (head2 == head1) {
                return true;
            }
        }
        return false;
    }

    private static int circleLength(LhcNode lhcNode) {
        int length = 0;
        boolean isFirstMeet = true;
        LhcNode head1 = lhcNode;
        LhcNode head2 = lhcNode;
        while (head2 != null) {
            if (head2.next == null || head2.next.next == null) {
                break;
            }
            head2 = head2.next.next;
            head1 = head1.next;
            System.out.print(String.format("2指针是%d", head2.getValue()));
            System.out.print(String.format(" 1指针是%d", head1.getValue()));
            System.out.println();
            length++;
            if (head2 == head1) {
                if (!isFirstMeet) {
                    return length;
                } else {
                    isFirstMeet = false;
                    length = 0;
                }
            }
        }
        return -1;
    }

    private static int findInsertCircleNodeValue(LhcNode lhcNode) {
        LhcNode head1 = lhcNode;
        LhcNode head2 = lhcNode;
        while (head2 != null) {
            if (head2.next == null || head2.next.next == null) {
                break;
            }
            head2 = head2.next.next;
            head1 = head1.next;
            System.out.print(String.format("2指针是%d", head2.getValue()));
            System.out.print(String.format(" 1指针是%d", head1.getValue()));
            System.out.println();
            if (head2 == head1) {
                head1 = lhcNode;
                break;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1.getValue();
    }
}

class LhcNode {
    private int value;
    LhcNode next;

    public int getValue() {
        return value;
    }

    LhcNode(int value) {
        this.value = value;
    }
}
