package com.brunosong.algorithm_new.백준.조합론;

import java.util.Arrays;
import java.util.Scanner;

public class 로또 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = 6;
        String[] lotto = new String[s];

        while (true) {
            String kAndS = sc.nextLine();
            if (kAndS.equals("0")) break;

            String[] nums = kAndS.split(" ");
            int numCnt = Integer.parseInt(nums[0]);

            String[] numStr = Arrays.stream(nums).skip(1)
                                    .toArray(String[]::new);

            generateLotto(0, s, numStr, lotto, 0);
            System.out.println();
        }

    }

    public static void generateLotto(int level, int s, String[] nums, String[] lotto, int startIdx) {
        if (level == s) {
            System.out.println(String.join(" ", lotto));
        } else {
            for (int i = startIdx; i < nums.length; i++) {
                lotto[level] = nums[i];
                generateLotto(level+1, s, nums, lotto, i+1);
            }
        }
    }
}
