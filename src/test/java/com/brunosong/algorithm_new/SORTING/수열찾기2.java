package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 수열찾기2 {
    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{1, 10, 2, 3, 5, 6})).isEqualTo(new int[]{1, 3, 5});
        Assertions.assertThat(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})).isEqualTo(new int[]{1, 1, 3, 7});
        Assertions.assertThat(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})).isEqualTo(new int[]{2, 3, 5, 5, 7, 7});
    }

    int[] solution(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num,0) + 1);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (hash.get(nums[i]) == 0) continue;
            if (hash.get(nums[i]) > 0) {
                answer.add(nums[i]);
                hash.put(nums[i], hash.get(nums[i]) - 1);
                hash.put(nums[i] * 2, hash.get(nums[i] * 2) - 1);
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
