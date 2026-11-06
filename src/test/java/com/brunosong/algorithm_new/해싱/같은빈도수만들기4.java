package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 같은빈도수만들기4 {
    @Test
    void test() {
        Assertions.assertThat(solution("aaabc")).isEqualTo(new int[]{0, 2, 2, 3, 3});
        Assertions.assertThat(solution("aabb")).isEqualTo(new int[]{0, 0, 2, 2, 2});
        Assertions.assertThat(solution("abcde")).isEqualTo(new int[]{0, 0, 0, 0, 0});
        Assertions.assertThat(solution("abcdeabc")).isEqualTo(new int[]{0, 0, 0, 1, 1});
        Assertions.assertThat(solution("abbccddee")).isEqualTo(new int[]{1, 0, 0, 0, 0});

    }


    public int[] solution(String s) {
        int[] answer = new int[5];

        int max = 0;

        Map<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = hash.getOrDefault(c, 0) + 1;
            hash.put(c, cnt);

            max = Math.max(max, cnt);
        }

        char[] chars = new char[]{'a','b','c','d','e'};
        for (int i = 0; i < chars.length; i++) {
            Integer i1 = hash.getOrDefault(chars[i],0);
            answer[i] = max - i1;
        }

        return answer;
    }
}
