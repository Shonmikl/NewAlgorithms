package org.example._2023_04_26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //todo есть ошибка
    private static List<List<Integer>> kings(int[][] queens, int[] king) {
       List<List<Integer>> result = new ArrayList<>();
       boolean[][] seen = new boolean[8][8];

       for (int[] q: queens) {
           seen[q[0]][q[1]] = true;
       }

       int[] direction = {-1, 0, 1};
       for (int dx : direction) {
           for (int dy : direction) {
               if(dx == 0 && dy == 0) {
                   continue;
               }

               int x = king[0];
               int y = king[1];

               while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                   x +=dx;
                   y +=dy;

                   if(seen[x][y]) {
                       result.add(Arrays.asList(x,y));
                       break;
                   }
               }
           }
       }
       return result;
    }

    public static void main(String[] args) {
        int[] k = {2,4};
        int[][] q = {{2,1}, {2,7}, {6,4}, {7,7}, {2,5}, {4,6}};
        int[][] q1 = {{2,7}};
        System.out.println(kings(q, k));
//        ListNode l1 = new ListNode(1);
//        ListNode l3 = new ListNode(3);
//        ListNode l5 = new ListNode(5);
//
//        l1.next = l3;
//        l3.next = l5;
//
//        ListNode l2 = new ListNode(2);
//        ListNode l4 = new ListNode(4);
//        ListNode l6 = new ListNode(6);
//
//        l2.next = l4;
//        l4.next = l6;
//
//        System.out.println(getSortedList(l1, l2));
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