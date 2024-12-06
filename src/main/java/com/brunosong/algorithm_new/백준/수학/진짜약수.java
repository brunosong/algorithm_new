package com.brunosong.algorithm_new.백준.수학;

import java.util.Arrays;
import java.util.Scanner;

public class 진짜약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(array);

        int N = array[0] * array[array.length-1];
        System.out.println(N);
    }
}
