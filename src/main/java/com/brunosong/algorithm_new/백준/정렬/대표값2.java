package com.brunosong.algorithm_new.백준.정렬;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 대표값2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        Arrays.sort(arr);
        int avg = (int)IntStream.of(arr).average().getAsDouble();

        System.out.println(avg);
        System.out.println(arr[2]);

    }
}
