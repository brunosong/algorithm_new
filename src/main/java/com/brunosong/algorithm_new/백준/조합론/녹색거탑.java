package com.brunosong.algorithm_new.백준.조합론;

import java.util.Scanner;

public class 녹색거탑 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        double pow = Math.pow(2, N);

        System.out.println((int)pow);
    }

}
