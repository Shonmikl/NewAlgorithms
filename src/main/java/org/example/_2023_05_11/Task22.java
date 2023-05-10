package org.example._2023_05_11;

public class Task22 {
    /**
     * String a1 = "vMtOew"
     * String a2 = "nsOM"
     * [M,O]
     */
//    private static void twoC(String a, String b) {
//        int a1 = 0;
//        int b1 = b.length()-1;
//
//        for (int i = 0; i < a.length(); i++) {
//            if(a.charAt(i))
//        }
//    }

    /**
     * [1 3 4 9 11 26]
     */

    private static int makeAna(String a, String b) {
        int minDel = 0;

        int[] aFreq = new int[26];
        int[] bFreq = new int[26];

        for (int i = 0; i < a.length(); i++) {
            int charToInt = a.charAt(i);
            int position = charToInt - 'a';
            aFreq[position]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int charToInt = b.charAt(i);
            int position = charToInt - 'a';
            bFreq[position]++;
        }

        for (int i = 0; i < 26; i++) {
            int difference = Math.abs(aFreq[i] - bFreq[i]);
            minDel += difference;
        }
        return minDel;
    }

    public static void main(String[] args) {
        String a1 = "vmtoew";
        String a2 = "nsom";
        System.out.println(makeAna(a1, a2));
    }


    /**
     * String a1 = w_o_rld
     * String a2 = w_eap_o_n
     */
}
