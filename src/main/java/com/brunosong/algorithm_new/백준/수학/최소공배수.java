package com.brunosong.algorithm_new.백준.수학;

import java.util.Scanner;

public class 최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        long a = Integer.parseInt(nums[0]);
        long b = Integer.parseInt(nums[1]);

        System.out.println((a * b) / gcd(a,b));
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
