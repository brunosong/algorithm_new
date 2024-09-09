package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class 음수가붙어있는부분수열 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5)).isEqualTo(5);
    }

    int solution(int[] nums, int m) {
        int answer = 0;

        HashMap<Integer,Integer> sumMap = new HashMap<>();

        int sum = 0;
        sumMap.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - m)) {
                int n = sum - m;
                answer += sumMap.get(n);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum,0) + 1);
        }

        return answer;
    }


}
