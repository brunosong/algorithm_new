package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 중복순열 {

    int n = 3;
    int m = 2;

    @Test
    void test() {

        int[] dis = new int[m];

        printNumbers(0,dis);
    }

    public void printNumbers(int level, int[] dis) {

        if (level == m) {
            System.out.println(Arrays.toString(dis));
        } else {
            for (int i = 1; i <= n; i++) {
                dis[level] = i;
                printNumbers(level+1, dis);
            }
        }

    }

}
