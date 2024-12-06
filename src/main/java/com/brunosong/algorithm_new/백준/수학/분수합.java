package com.brunosong.algorithm_new.백준.수학;

import java.util.Scanner;

public class 분수합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums1 = sc.nextLine().split(" ");
        String[] nums2 = sc.nextLine().split(" ");

        int a1 = Integer.parseInt(nums1[0]);
        int b1 = Integer.parseInt(nums1[1]);

        int a2 = Integer.parseInt(nums2[0]);
        int b2 = Integer.parseInt(nums2[1]);

        //분모의 최소 공배수를 구해야한다
        int commonDenominator = lcm(b1,b2);

        //분자를 변환한다
        int newNumerator = (a1 * (commonDenominator / b1)) + (a2 * (commonDenominator / b2));
        int newDenominator = commonDenominator;

        //기약분수를 구한다.
        int gcd = gcd(newNumerator, newDenominator);

        System.out.println(newNumerator / gcd + " " + newDenominator / gcd);

    }

    //최소 공배수 구하기 (분수를 더하기 위해서는 분모의 최송 공배수를 구해야한다)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }


    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
