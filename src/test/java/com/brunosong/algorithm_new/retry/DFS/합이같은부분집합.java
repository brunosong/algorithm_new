package com.brunosong.algorithm_new.retry.DFS;

import com.brunosong.algorithm_new.재귀.경로탐색_DFS;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 합이같은부분집합 {

    static String answer = "NO";

    @Test
    void test() {

        int[] arr = {1,3,5,6,7,10};

        solution(arr);

        System.out.println(answer);

    }

    public String solution(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        DFS(0, 0, sum, arr);
        return answer;
    }

    public void DFS(int level, int sum, int total, int[] arr) {

        if (sum > total / 2) return;

        if (level == arr.length) {
            if (total / 2 == sum) {
                answer = "YES";
            }
        } else {
            DFS(level+1, arr[level] + sum, total , arr);
            DFS(level+1, sum, total , arr);
        }

    }
}
