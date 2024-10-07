package com.brunosong.algorithm_new.백준.조합론;

import java.util.Scanner;

public class 베라의패션 {

    public static int answer = 0;
    public static int T = 2;

    public static void main(String[] args) {

        //int N = 2;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[] dis = new int[T];
        int[] check = new int[N+1];

        DFS(N,0,dis,check);
        System.out.println(answer);
    }

    public static void DFS(int N, int level, int[] dis, int[] check) {

        if (level == 2) {
            answer++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    dis[level] = i;
                    DFS(N,level+1,dis,check);
                    check[i] = 0;
                }
            }
        }

    }



}
