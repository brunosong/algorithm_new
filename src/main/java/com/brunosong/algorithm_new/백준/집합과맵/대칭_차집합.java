package com.brunosong.algorithm_new.백준.집합과맵;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 대칭_차집합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        int aCnt = Integer.parseInt(N.split(" ")[0]);
        int bCnt = Integer.parseInt(N.split(" ")[1]);

        String A = sc.nextLine();
        String B = sc.nextLine();

        Set<Integer> aSet = new HashSet<>();
        for (int i = 0; i < aCnt; i++) {
             aSet.add(Integer.parseInt(A.split(" ")[i]));
        }

        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < bCnt; i++) {
            bSet.add(Integer.parseInt(B.split(" ")[i]));
        }

        int cnt = 0;


    }
}
