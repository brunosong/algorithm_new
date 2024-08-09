package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class 땅따먹기 {

    int answer = 0;

    @Test
    void test() {
        int[][] land = {
            {1,2,3,5},
            {5,6,7,8},
            {4,3,2,1}
        };

        int[][] dp = new int[land.length+1][land[0].length+1];

        for (int i=0; i<land.length; i++) {
            dp[i][0] = land[i][0];
            dp[i][1] = land[i][1];
            dp[i][2] = land[i][2];
            dp[i][3] = land[i][3];
        }

        for (int i=1; i<=land.length; i++) {
            dp[i][0] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][1] += Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][2] += Math.max(dp[i-1][1], Math.max(dp[i-1][0], dp[i-1][3]));
            dp[i][3] += Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][0]));
        }

        int answer = 0;
        for (int i=0; i<4; i++) {
            answer = Math.max(answer ,dp[land.length][i]);
        }

        System.out.println(answer);


        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }


        int total = 0;
        int beforeIdx = -1;
        for (int i = 0; i < land.length; i++) {
            int sum = 0;
            int topIdx = -1;
            for (int j = 0; j <land[i].length; j++) {
                if(j != beforeIdx) {
                    if(sum < land[i][j]) {
                        sum = land[i][j];
                        topIdx = j;
                    }
                }
            }
            beforeIdx = topIdx;
            total += sum;
        }

        System.out.println(total);

    }


    void findMaxSum(int level, int sum, int[][] land, int[][] checker) {

        if(level == land.length) {
            answer = Math.max(sum,answer);
        } else {
            for (int i = 0; i < land[level].length; i++) {
                if(checker[level][i] == 0) {
                    //자기꺼와 다음에 밟지 못하는것까지 체크한다.
                    checker[level][i] = 1;
                    if(level+1 < land.length) {
                        checker[level+1][i] = 1;
                    }
                    int i1 = land[level][i];
                    findMaxSum(level + 1, sum + i1 , land, checker);
                    if(level+1 < land.length) {
                        checker[level+1][i] = 0;
                    }

                    checker[level][i] = 0;
                }

            }
        }


    }


    int solution(int[][] land) {
        int answer = 0;

        return answer;
    }







}
