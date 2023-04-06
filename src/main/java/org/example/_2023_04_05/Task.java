package org.example._2023_04_05;

public class Task {
    /**
     * int a;
     * 00010010
     */

    public int getOne(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }

    /**
     * 123 -- 321
     * -123 -- -321
     * 120 -- 21
     */

    public int getReverse(int x) {
        int sign = 1;
        if (x < 0) {
            x *= -1;
            sign = -1;
        }

        int result = 0;
        int max = Integer.MAX_VALUE;

        while (x > 0) {
            int mod = x % 10;
            if (max / 10 > result || max / 10 == result && max % 10 >= mod) {
                result = result * 10 + mod;
            } else return 0;
            x = x / 10;
        }
        return result * sign;
    }

    /**
     * [1 0 3]
     * [4 2 3 0]
     * [0 1 2 3 4 6]
     */

    public int getMiss(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int sum2 = 0;
        for (int i : nums) {
            sum2 = sum2 + i;
        }
        return sum - sum2;
    }
}