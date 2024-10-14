package com.brunosong.algorithm_new.백준.브루탈포스;

import java.util.Arrays;
import java.util.Scanner;

public class 연립방정식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        sc.close();

        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);
        int d = Integer.parseInt(nums[3]);
        int e = Integer.parseInt(nums[4]);
        int f = Integer.parseInt(nums[5]);

        int[] answer = new int[2];

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999 ; y++) {
                if ((a * x) + (b * y) == c && (d * x) + (e * y) == f) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
