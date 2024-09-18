package com.brunosong.algorithm_new.백준.집합과맵;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 문자열_집합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nm = sc.nextLine();

        String[] s = nm.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            strSet.add(str);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String str = sc.nextLine();
            if (strSet.contains(str)) cnt++;
        }

        System.out.println(cnt);
    }
}
