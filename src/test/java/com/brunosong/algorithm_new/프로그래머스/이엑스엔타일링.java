package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 이엑스엔타일링 {

    @Test
    void test() {
        // 이 문제는 DP를 이용해서 푼다. 피보나치

        int n = 4;

        solutionWithForLoop(n);

    }

    /* for 문 사용 */
    public int solutionWithForLoop(int n) {
        int answer = 0;
        int MOD = 1000000007;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[n]);

        return answer;
    }


    /* DFS 사용 */
    public int solution(int n) {

        int[] dis = new int[n + 1];
        dis[1] = 1;
        dis[2] = 2;

        return fifo(n, dis);
    }

    public int fifo(int n, int[] dis) {

        if(dis[n] != 0) return dis[n];

        dis[n] = (fifo(n - 1,dis) + fifo(n - 2,dis)) % 1000000007;
        return dis[n];

    }



}
