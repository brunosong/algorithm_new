package com.brunosong.algorithm_new.백준.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 수정렬하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        Arrays.sort(arr);

        for (int x : arr) {
            System.out.println(x);
        }
    }
}
