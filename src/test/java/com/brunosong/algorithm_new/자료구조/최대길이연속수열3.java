package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 최대길이연속수열3 {

    @Test
    void test() {
//        제한사항:
//        • nums의 길이는 300,000을 넘지 않습니다.
//        • nums[i]의 값은 -1,000,000,000에서 1,000,000,000까지이며, 중복된 값도 있습니다.

        int[] nums = {8, 1, 9, 3, 10, 2, 4, 0, 2, 3};

        Assertions.assertThat(solution(nums)).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0})).isEqualTo(10);
        Assertions.assertThat(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3})).isEqualTo(1);
        Assertions.assertThat(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1})).isEqualTo(7);
        Assertions.assertThat(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7})).isEqualTo(3);

        solution(nums);
        // 정답맞춤
    }


    public int solution(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i] - 1)) continue;
            int cnt = 0;
            int num = nums[i];
            while (numSet.contains(num)) {
                num++;
                cnt++;
            }

            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
