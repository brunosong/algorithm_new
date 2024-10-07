package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class 같은빈도수만들기2 {

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
        char[] chars = {'a','b','c','d','e'};

        TreeMap<Character,Integer> map = new TreeMap<>();
        char[] charArray = s.toCharArray();

        int max = 0;
        for (char c : charArray) {
            int cnt = map.getOrDefault(c,0) + 1;
            max = Math.max(cnt,max);
            map.put(c, cnt);
        }

        for (int i = 0; i < chars.length; i++) {
            answer[i] = max - map.getOrDefault(chars[i],0);
        }

        return answer;
    }
}
