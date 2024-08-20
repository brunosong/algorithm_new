package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 중복순열구하기2 {

    @Test
    void test() {

        int n = 3;
        int m = 2;

        int[] dis = new int[m];
        StringBuilder sb = new StringBuilder();

        printNum(0,n,m,sb,dis);
        System.out.println(sb.toString());
    }

    public void printNum(int level, int n, int m, StringBuilder sb, int[] dis) {

        if (level == m) {
            for (int i = 0; i < dis.length; i++) {
                sb.append(dis[i]).append(" ");
            }
            sb.append("\n");
        } else {

            for (int i = 1; i <= n; i++) {
                dis[level] = i;
                printNum(level+1, n, m, sb,dis);
            }
        }



    }


}
