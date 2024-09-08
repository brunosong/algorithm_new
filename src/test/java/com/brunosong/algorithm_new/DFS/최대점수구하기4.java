package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

public class 최대점수구하기4 {

    public int maxScore = Integer.MIN_VALUE;

    @Test
    void test() {

        int n = 5, m = 20;

        int[][] arr = {
                {10, 5},
                {25, 12},
                {15, 8},
                {6 ,3},
                {7 ,4}
        };

        findMaxScore(0,0,0,arr, n, m);

        System.out.println(maxScore);
    }

    void findMaxScore(int level, int score, int time, int[][] arr, int n, int m) {

        if (time > m) return;

        if (level == n) {
            maxScore = Math.max(score,maxScore);
        } else {
            findMaxScore(level+1, score + arr[level][0], time + arr[level][1], arr, n, m);
            findMaxScore(level+1, score, time, arr, n, m);
        }
    }
}
