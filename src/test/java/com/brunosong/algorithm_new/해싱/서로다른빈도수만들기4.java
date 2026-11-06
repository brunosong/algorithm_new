package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 서로다른빈도수만들기4 {

    @Test
    void test() {

        Assertions.assertThat(solution("aaabbbcc")).isEqualTo(2);
        Assertions.assertThat(solution("aaabbc")).isEqualTo(0);
        Assertions.assertThat(solution("aebbbbc")).isEqualTo(2);
        Assertions.assertThat(solution("aaabbbcccde")).isEqualTo(5);
        Assertions.assertThat(solution("aaabbbcccdddeeeeeff")).isEqualTo(8);

    }

    int solution(String s) {
        int answer = 0;

        Map<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = hash.getOrDefault(c, 0) + 1;
            hash.put(c, cnt);
        }

        Set<Integer> set = new HashSet<>();
        for (Character key : hash.keySet()) {
            while (set.contains(hash.get(key))){
                hash.put(key, hash.get(key) - 1);
                answer++;
            }
            if (hash.get(key) == 0) continue;
            set.add(hash.get(key));
        }

        return answer;
    }
}
