package com.brunosong.algorithm_new.백준.집합과맵;

import java.util.HashSet;
import java.util.Scanner;

public class 숫자카드 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nCnt = sc.nextInt();
        sc.nextLine();

        String N = sc.nextLine();

        int mCnt = sc.nextInt();
        sc.nextLine();

        String M = sc.nextLine();

        HashSet<Integer> set = new HashSet<>();

        String[] nStrArr = N.split(" ");
        for (int i = 0; i < nStrArr.length; i++) {
            set.add(Integer.parseInt(nStrArr[i]));
        }

        StringBuilder sb = new StringBuilder();
        String[] mStrArr = M.split(" ");
        for (int i = 0; i < mCnt; i++) {
            if (set.contains(Integer.parseInt(mStrArr[i]))) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
