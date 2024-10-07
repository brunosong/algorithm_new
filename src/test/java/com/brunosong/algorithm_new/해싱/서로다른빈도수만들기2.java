package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

public class 서로다른빈도수만들기2 {

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

        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        // 같은 값이 있는지 체크하기 위해 Set을 만든다.
        Set<Integer> set = new HashSet<>();
        for (char c : map.keySet()) {
            // 같은 값이 존재하는지 확인
            while (set.contains(map.get(c))) {
                // 값이 존재하면 다른 값이 될때까지 계속해서 줄여준다.
                map.put(c, map.get(c) - 1);
                answer++;
            }
            // 만약 값이 0이 되어버리면 셋에 넣지 않는다.
            if (map.get(c) == 0) continue;
            set.add(map.get(c));
        }

        return answer;
    }

}
