package com.brunosong.algorithm_new.retry.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 조합구하기 {

    @Test
    void test() {
        DFS(0, 1, 2, 4, new int[2]);
    }

    void DFS(int level, int s, int m, int n, int[] comb) {

        if (level == m) {
            System.out.println(Arrays.toString(comb));
        } else {
            for (int i = s; i <= n; i++) {
                comb[level] = i;
                DFS(level+1, i+1, m,n, comb);
            }
        }

    }
}
