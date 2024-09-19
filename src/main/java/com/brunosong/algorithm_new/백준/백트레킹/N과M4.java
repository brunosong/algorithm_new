package com.brunosong.algorithm_new.백준.백트레킹;

import java.util.Scanner;

public class N과M4 {

    static int N,M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();

        String[] s = nums.split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int[] arr = new int[M];
        dfs(1,0, arr);
        System.out.println(sb);
    }

    public static void dfs(int start, int depth, int[] arr) {
        if (depth == M) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= N; i++) {
                arr[depth] = i;
                dfs(i, depth + 1,arr);
            }
        }
    }

}
