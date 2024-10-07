package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class 한번사용한최초문자 {
    @Test
    void test() {
        Assertions.assertThat(solution("statitsics")).isEqualTo(3);
        Assertions.assertThat(solution("aabb")).isEqualTo(-1);
        Assertions.assertThat(solution("stringshowtime")).isEqualTo(3);
        Assertions.assertThat(solution("abcdeabcdfg")).isEqualTo(5);

    }


    public int solution(String s) {
        int answer = -1;
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
//
//        if (!map.containsValue(1)) {
//            return -1;
//        }

//        int max = Integer.MAX_VALUE;
//        for (char c : map.keySet()) {
//            if (map.get(c) == 1) {
//                max = Math.min(s.indexOf(c), max);
//            }
//        }

        // 한번 더 맵을 탐색할 필요없이 바로 검색
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return s.indexOf(charArray[i]) + 1;
            }
        }

        return answer;
    }


}
