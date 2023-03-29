package org.example._2023_03_29;

import java.util.ArrayList;

public class Dynamic {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9, 4, 5, 8, 9, 4, 5, 8, 9, 4, 5, 8, 9, 4, 4, 5, 8, 9, 4, 4, 5, 8, 9, 4, 5, 8, 9, 4, 5, 8, 4, 5, 8};
        int[] prices = {1, 6, 4, 7, 6, 4, 5, 8, 9, 4, 5, 8, 9, 4, 5, 8, 9, 4, 5, 8, 4, 5, 8, 4, 5, 8, 9, 4, 5, 8, 9, 4, 5, 8, 4, 5, 8};

        int maxWeight = 50;

        int count = weights.length;
        //int maxWeight = 13;

        int[][] A;

        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxWeight + 1];
        }

        //k - наш набор
        for (int k = 0; k <= count; k++) {
            //s - размер рюкзака
            for (int s = 0; s <= maxWeight; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= weights[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        trace(A, weights, count, maxWeight, result);

        System.out.println("Оптимальное содержимое: ");
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void trace(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }

        if (A[k - 1][s] == A[k][s]) {
            trace(A, weight, k - 1, s, result);
        } else {
            trace(A, weight, k - 1, s - weight[k - 1], result);
            result.add(k);
        }
    }
}