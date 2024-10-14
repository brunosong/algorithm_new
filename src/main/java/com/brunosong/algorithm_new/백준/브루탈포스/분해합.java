package com.brunosong.algorithm_new.백준.브루탈포스;

import java.util.Scanner;

public class 분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int answer = 0;

        for (int i = 1; i < N; i++) {
            int sum = i;
            int nTmp = i;

            while (nTmp > 0) {
                sum += nTmp % 10;
                nTmp /= 10;
            }

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }
}
