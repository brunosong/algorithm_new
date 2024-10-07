package com.brunosong.algorithm_new.백준.투포인터;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class 두수의합 {
    public static void main(String[] args) {
//        9
//        5 12 7 10 9 1 2 3 11
//        13
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] nums = sc.nextLine().split(" ");
        int x = sc.nextInt();
        sc.nextLine();

        int[] array = Stream.of(nums).mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(array);

        int p1 = 0;
        int p2 = array.length-1;
        int cnt = 0;

        while (p1 < p2) {
            int sum = array[p1] + array[p2];
            if (sum == x) {
                cnt++;
                p1++;
                p2--;
            } else if (sum > x) {
                p2--;
            } else {
                p1++;
            }
        }

        System.out.println(cnt);

    }
}
