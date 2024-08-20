package com.brunosong.algorithm_new.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최대점수구하기2 {

    public int max = 0;

    @Test
    void test() {

        int questionCnt = 5;
        int timeLimit = 20;

        int[][] arr = {
                {10, 5},
                {25, 12},
                {15, 8},
                {6 ,3},
                {7 ,4}
        };

        findMaxScore(0,0,0,arr,questionCnt,timeLimit);
        System.out.println(max);
    }


    public void findMaxScore(int level, int score, int time, int[][] arr, int questionCnt, int timeLimit) {

        if (time > timeLimit) return;

        if (level == questionCnt) {
            max = Math.max(max,score);
        } else {
            findMaxScore(level+1, score + arr[level][0], time + arr[level][1], arr,questionCnt, timeLimit);
            findMaxScore(level+1, score, time, arr,questionCnt, timeLimit);
        }


    }

}
