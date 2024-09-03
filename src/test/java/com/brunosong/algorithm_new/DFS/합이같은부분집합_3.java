package com.brunosong.algorithm_new.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class 합이같은부분집합_3 {

    int target = 0;
    int total = 0;

    String answer = "NO";

    @Test
    void test() {
        // {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이
        // 16으로 같은 경우가 존재하는 것 찾기
        int[] arr = {1 ,3 ,5 ,6 ,7 ,10};
        Assertions.assertThat(solution(arr)).isEqualTo("YES");
    }

    public String solution(int[] arr) {
        answer = "NO";

        total = IntStream.of(arr).sum();
        target = total / 2;

        findSubset(0,0,arr,arr.length);


        return answer;
    }


    public void findSubset(int level, int sum, int[] arr, int n) {
        if (sum > target) return;

        if (level == n) {
            if (sum == target) {
                answer = "YES";
            }
        } else {
            findSubset(level+1, sum + arr[level], arr, n);
            findSubset(level+1, sum, arr, n);
        }
    }





}
