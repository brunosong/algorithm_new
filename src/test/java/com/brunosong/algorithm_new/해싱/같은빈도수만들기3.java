package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 같은빈도수만들기3 {
    @Test
    void test() {

        Assertions.assertThat(solution("aaabc"))
                .isEqualTo(new int[]{0, 2, 2, 3, 3});

        Assertions.assertThat(solution("aabb"))
                .isEqualTo(new int[]{0, 0, 2, 2, 2});

        Assertions.assertThat(solution("abcde"))
                .isEqualTo(new int[]{0, 0, 0, 0, 0});

        Assertions.assertThat(solution("abcdeabc"))
                .isEqualTo(new int[]{0, 0, 0, 1, 1});

        Assertions.assertThat(solution("abbccddee"))
                .           isEqualTo(new int[]{1, 0, 0, 0, 0});

    }

    public int[] solution(String s) {
        int[] answer = new int[5];

        // 해싱
        int max = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = hashMap.getOrDefault(c, 0) + 1;
            hashMap.put(c, cnt);

            max = Math.max(cnt, max);
        }

        char[] temp = new char[]{'a','b','c','d','e'};
        for (int i = 0; i < temp.length; i++) {
            Integer num = hashMap.getOrDefault(temp[i], 0);
            answer[i] = max - num;
        }

        return answer;
    }
}
