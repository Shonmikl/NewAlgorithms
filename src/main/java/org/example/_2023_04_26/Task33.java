package org.example._2023_04_26;

public class Task33 {
    /**
     * 1 --> 3 --> 5
     * 2 --> 4 --> 6
     */

    private static ListNode getSortedList(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        if(l1 != null) {
            currentNode.next = l1;
        }
        if(l2 != null) {
            currentNode.next = l2;
        }

        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(5);

        l1.next = l3;
        l3.next = l5;

        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l6 = new ListNode(6);

        l2.next = l4;
        l4.next = l6;

        System.out.println(getSortedList(l1, l2));
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}