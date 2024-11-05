package com.brunosong.algorithm_new.백준.수학;

import java.math.BigInteger;
import java.util.Scanner;

public class 꼬마정민 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] nums = str.split(" ");

        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < nums.length; i++) {
            sum = sum.add(new BigInteger(nums[i]));
        }

        System.out.println(sum);
    }
}
