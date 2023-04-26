package org.example._2023_04_19;

import java.util.Arrays;

public class Task {
    /**
     * String s = "UUDDLLRR"
     * String s = "LRDDLRU";
     * +1 -1
     */

    private static boolean isAtPoint(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int counter = 0;

        for (char move : s.toCharArray()) {
            if ('U' == move || 'R' == move) {
                counter++;
            } else counter--;
        }
        return counter == 0;
    }

    /**
     * [-1, 2, 1, -4] k == 1
     */

    private static int threeSum(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int a = i + 1;
            int b = nums.length - 1;

            while (a < b) {
                int currentSum = nums[i] + nums[a] + nums[b];
                if (currentSum > target) {
                    b -= 1;
                } else {
                    a += 1;
                }

                if (Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
            }
        }
        return result;
    }

    /**
     * String a = "a#a#a" String b = "a"
     * String a = "ba###a" String b = "a"
     * String a = "##a#ab#" String b = "a"
     * String a = "##a#ab#" String b = "b"
     */

//    private static boolean isCompare(String a, String b) {
//
//    }

    public static void main(String[] args) {
//        String s = "UUDDL";
//        System.out.println(isAtPoint(s));

        int[] arr = {-1, 2, -1, -4};
        int k = -7;

        System.out.println(threeSum(arr, k));
    }

}
