package com.brunosong.algorithm_new.백준.정렬;

import java.util.Scanner;
import java.util.stream.Stream;

public class 커트라인 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String cnt = sc.nextLine();
        String scores = sc.nextLine();

        int N = Integer.parseInt(cnt.split(" ")[0]);
        int k = Integer.parseInt(cnt.split(" ")[1]);

        int[] arr = new int[N];
        Integer[] s = Stream.of(scores.split(" "))
                .map(Integer::parseInt)
                .sorted((i1,i2) -> i2 - i1)
                .toArray(Integer[]::new);

        System.out.println(s[k-1]);
    }
}
