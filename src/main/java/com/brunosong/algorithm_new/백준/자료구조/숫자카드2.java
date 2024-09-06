package com.brunosong.algorithm_new.백준.자료구조;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class 숫자카드2 {

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String nArrStr = sc.nextLine();
        int[] nArr = Stream.of(nArrStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int n : nArr) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        int M = sc.nextInt();
        sc.nextLine();
        String mArrStr = sc.nextLine();

        int[] mArr = Stream.of(mArrStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        for (int m : mArr) {
            sb.append(map.getOrDefault(m,0) + " ");
        }

        System.out.println(sb);

    }

}
