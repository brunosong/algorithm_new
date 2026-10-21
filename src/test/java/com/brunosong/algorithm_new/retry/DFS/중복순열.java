package com.brunosong.algorithm_new.retry.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 중복순열 {

    @Test
    void test() {
        int n = 3;
        int m = 2;

        solution(n,m);
    }

    public void solution(int n, int m) {

        DFS(0,n,m,new int[m]);

    }

    public void DFS(int level, int n, int m, int[] ch) {
        if (level == m) {
            System.out.println(Arrays.toString(ch));
        } else {
            for (int i = 1; i <= n; i++) {
                ch[level] = i;
                DFS(level + 1, n, m, ch);
            }
        }
    }
}
