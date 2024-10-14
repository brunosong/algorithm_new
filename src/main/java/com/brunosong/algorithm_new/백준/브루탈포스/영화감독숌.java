package com.brunosong.algorithm_new.백준.브루탈포스;

import java.util.Scanner;

public class 영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int num = 666;
        while (cnt != N) {
            if (String.valueOf(num).indexOf("666") != -1) {
                cnt++;
            }
            num++;
        }
        System.out.println(num - 1);
    }
}
