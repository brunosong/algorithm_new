package com.brunosong.algorithm_new.retry.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class 동전교환 {

    static int min = Integer.MAX_VALUE;

    @Test
    void test() {
        int[] arr = {1,2,5};
        int n = 15;

        //Arrays.sort(arr, Collections.reverseOrder());
        solution(arr, n);

        System.out.println(min);
    }

    int solution(int[] arr, int n) {
        int answer = 0;

        DFS(0, 0, arr, n);
        return answer;
    }

    void DFS(int level, int sum, int[] arr, int n) {

        if (sum > n) return;
        if (level > min) return;

        if (n == sum) {
            min = Math.min(min,level);
        } else {
            for (int i = 0; i < arr.length; i++) {
                DFS(level+1, sum + arr[i], arr, n);
            }
        }

    }
}
