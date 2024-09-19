package com.brunosong.algorithm_new.백준.약수_배수;

import java.util.Scanner;

public class 최소공배수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String nums = sc.nextLine();
            String[] s = nums.split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            sb.append((a * b) / gcd(a,b)).append("\n");
        }

        System.out.println(sb);
    }

    /* 최대 공약수 구하는 방법 */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
