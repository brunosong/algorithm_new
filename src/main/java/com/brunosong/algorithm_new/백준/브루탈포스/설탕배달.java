package com.brunosong.algorithm_new.백준.브루탈포스;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= N / 5; i++) {
            int cnt = 0;
            int tmp = N - (5 * i);
            cnt += i;

            if ((tmp % 3) == 0) {
                cnt += tmp / 3;
                tmp = tmp % 3;
            }
            if (tmp == 0) {
                answer = Math.min(cnt, answer);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}
