package com.brunosong.algorithm_new.retry.DFS;

import org.junit.jupiter.api.Test;

public class 바둑이 {

    static int max = Integer.MIN_VALUE;

    @Test
    void test() {
        int n = 259;
        int[] arr = { 81 ,58 ,42 ,33 ,61 };

        // n에 가까운 가장 무거운 무게를 출력한다 DFS 사용
        solution(n,arr);

        System.out.println(max);
    }

    int solution(int n, int[] arr) {
        int answer = 0;

        DFS(0,0,arr, n);

        return answer;
    }

    void DFS(int level, int sum, int[] arr, int limit) {

        if (sum > limit) return;

        if (level == arr.length) {
            max = Math.max(max, sum);
        } else {
            DFS(level+1, arr[level] + sum, arr, limit);
            DFS(level+1, sum, arr, limit);
        }
    }

}
