package com.brunosong.algorithm_new.백준.집합과맵;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 대칭_차집합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();

        String A = sc.nextLine();
        Set<Integer> aSet = Stream.of(A.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        String B = sc.nextLine();
        Set<Integer> bSet = Stream.of(B.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        int cnt = 0;

        for (int a : aSet) {
            if (!bSet.contains(a)) {
                cnt++;
            }
        }

        bSet.removeAll(aSet);
        cnt += bSet.size();

        System.out.println(cnt);

    }
}
