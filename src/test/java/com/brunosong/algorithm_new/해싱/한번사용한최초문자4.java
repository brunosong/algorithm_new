package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 한번사용한최초문자4 {

    @Test
    void test() {

        Assertions.assertThat(solution("statitsics")).isEqualTo(3);
        Assertions.assertThat(solution("aabb")).isEqualTo(-1);
        Assertions.assertThat(solution("stringshowtime")).isEqualTo(3);
        Assertions.assertThat(solution("abcdeabcdfg")).isEqualTo(5);

    }

    int solution(String s) {
        int answer = -1;

        Map<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }

        return answer;
    }
}
