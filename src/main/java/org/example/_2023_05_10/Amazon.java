package org.example._2023_05_10;

import java.util.Arrays;

public class Amazon {
    private static final int[][] A =
                   {{1, 4, 7, 11, 15, 16},
                    {2, 5, 8, 12, 19, 21},
                    {3, 6, 9, 16, 22, 24},
                    {10, 13, 14, 17, 24, 28},
                    {18, 21, 23, 26, 30, 36}};

    private static final int[][] B =
                    {{1, 2, 3, 4},
                    { 5, 6, 7, 8},
                    { 9, 10, 11, 12},
                    {13, 14, 15, 16}};
    private static final int K = 55;

    private static boolean isKexist(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (arr[i][j] == k) {
                System.out.println(i + " : " + j);
                return true;
            }
            if (arr[i][j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private static void rotate(int[][] matrix) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N/2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate90(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
//        System.out.println(isKexist(A, K));
        rotate90(B);
//        rotate(B);
    }
}
