package org.example._2023_03_29;

public class Distinct {
    private static void getSingle(int[] arr) {
        int xor = 0;
        for (int x : arr) {
            xor = xor ^ x;
        }
        System.out.println(xor);
    }
    //0 0 0 0 0 0 0 0
    //0 0 0 0 0 1 1 1
    //0 0 0 0 0 1 1 1 || 0^7 = 7

    //0 0 0 0 0 1 1 1
    //0 0 0 0 0 0 1 1
    //0 0 0 0 0 1 0 0 || 7^3 = 4

    //0 0 0 0 0 1 0 0
    //0 0 0 0 1 0 0 0
    //0 0 0 0 1 1 0 0 4^8 = 12

    //0 0 0 0 1 1 0 0
    //0 0 0 0 0 0 1 0
    //0 0 0 0 1 1 1 0 12^2 = 14

    //0 0 0 0 1 1 1 0
    //0 0 0 0 0 0 0 1


    //0 0 0 0 0 0 1 0
    //0 0 0 0 0 0 0 1

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 2, 5, 2, 8, 7, 3};
        getSingle(arr);
    }
}