package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

public class 최대점수구하기3 {

    public int questionCnt = 5;
    public int timeLimit = 20;
    int[][] arr = {
            {10, 5},
            {25, 12},
            {15, 8},
            {6 ,3},
            {7 ,4}
    };

    @Test
    void test() {
        findMaxScore(0,0,0);
    }

    public void findMaxScore(int level, int sum, int time) {

        if (time > timeLimit) return;

        if (level == questionCnt) {
            System.out.println(time + " , " + sum);

        } else {
            findMaxScore(level+1, sum + arr[level][0], time + arr[level][1]);
            findMaxScore(level+1, sum, time);
        }
    }



}
