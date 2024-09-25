package com.brunosong.algorithm_new.백준.정렬;

import java.util.Scanner;

public class 소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int[] arr = new int[10];

        String[] nums = num.split("");
        for (int i = 0; i < nums.length; i++) {
            int val = Integer.parseInt(nums[i]);
            arr[val]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i);
                }
            }
        }

        System.out.println(sb);
    }
}
