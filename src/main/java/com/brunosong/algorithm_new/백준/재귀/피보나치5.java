package com.brunosong.algorithm_new.백준.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long a = 0;
        long b = 1;

        for (int i = 3; i <= N+1; i++) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }

        System.out.println(b);
    }
}
