package com.brunosong.algorithm_new.프로그래머스LV2;

public class 멀리뛰기 {
    static int n = 4;

    static int cnt = 0;


    static int[] move = {1,2};

    static int sum = 0;

    public static void main(String[] args) {
//        n	result
//        4	5
//        3	3
        //int n = 4;

        DFS(1);
        System.out.println(cnt);
    }


    public static void DFS(int v ) {

        if( v > n) return;

        if( v == n ) {
            cnt++; return;
        }

        for (int i = 0; i < move.length ; i++) {
            DFS( v + move[i]);
            //DFS( v -= move[i]);
        }
    }


}
