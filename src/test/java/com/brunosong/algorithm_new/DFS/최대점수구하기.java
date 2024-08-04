package com.brunosong.algorithm_new.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최대점수구하기 {

    int n = 5;
    int timeLimit = 20;

    int answer = Integer.MIN_VALUE;

    @Test
    void test() {


        int[][] arr = {
                    {10, 5},
                    {25, 12},
                    {15, 8},
                    {6 ,3},
                    {7 ,4}
                };

        getMaxScore(0,0,0,arr);
        Assertions.assertThat(answer).isEqualTo(41);
    }

    void getMaxScore(int level, int timeSum, int scoreSum, int[][] arr) {

        if(timeSum > timeLimit) return;

        if(level == n) {
            answer = Math.max(scoreSum,answer);
        } else {
            getMaxScore(level+1, arr[level][1] + timeSum, arr[level][0] + scoreSum, arr);
            getMaxScore(level+1, timeSum, scoreSum, arr);
        }
    }

}
