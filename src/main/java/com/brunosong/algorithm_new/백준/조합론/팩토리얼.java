package com.brunosong.algorithm_new.백준.조합론;

import java.net.ServerSocket;
import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int sum = 1;
        for (int i = 2; i <= N; i++) {
            sum = sum * i;
        }

        System.out.println(sum);
    }
}
