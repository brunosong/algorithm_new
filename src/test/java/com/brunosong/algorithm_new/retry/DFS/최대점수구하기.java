package com.brunosong.algorithm_new.retry.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최대점수구하기 {

    static int max = Integer.MIN_VALUE;
    @Test
    void test() {

        int n = 20;

        int[][] arr = {
                {10, 5},
                {25, 12},
                {15, 8},
                {6 ,3},
                {7 ,4}
        };

        solution(arr, n);

        System.out.println(max);
    }

    public int solution(int[][] arr, int n) {
        int answer = 0;
        DFS(0,0,0,n,arr);
        return answer;
    }

    public void DFS(int level, int totalTime, int score, int limit, int[][] arr) {

        if (totalTime > limit) return;

        if (level == arr.length) {
            max = Math.max(max, score);
        } else {
            DFS(level + 1, arr[level][1] + totalTime, arr[level][0] + score, limit, arr);
            DFS(level + 1, totalTime, score, limit, arr);
        }




    }





}
