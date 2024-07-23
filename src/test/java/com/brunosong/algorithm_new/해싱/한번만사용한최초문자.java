package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 한번만사용한최초문자 {

    @Test
    void test() {

        //        문자열에서 한번만 사용한 문자를 찾으려고 합니다.
        //        매개변수 s에 문자열이 주어지면 한번만 사용한 문자 중 문자열에서 가장 먼저 나타난 문자의
        //        인덱스 번호를 반환하는 프로그램을 작성하세요. 인덱스는 1부터 시작합니다. 한번만 사용한
        //        문자가 없을 경우 -1를 반환하세요.
        //        입출력 예:
        //        제한사항:
        //        • 문자열 s의 길이는 100을 넘지 않습니다.
        //        • 문자열은 소문자로만 이루어져 있습니다.
        //                입력예제 1 설명 :
        //                한번만 사용한 문자는 a, c이고, 문자열에서 먼저 나타난 것은 a이고 인덱스는 3입니다.
        //          s                   answer
        //        "statitsics"              3
        //        "aabb"                    -1
        //        "stringshowtime"          3
        //        "abcdeabcdfg"             5

        Assertions.assertThat(solution("statitsics")).isEqualTo(3);
        Assertions.assertThat(solution("aabb")).isEqualTo(-1);
        Assertions.assertThat(solution("stringshowtime")).isEqualTo(3);
        Assertions.assertThat(solution("abcdeabcdfg")).isEqualTo(5);

        Assertions.assertThat(solution_Basic("statitsics")).isEqualTo(3);
        Assertions.assertThat(solution_Basic("aabb")).isEqualTo(-1);
        Assertions.assertThat(solution_Basic("stringshowtime")).isEqualTo(3);
        Assertions.assertThat(solution_Basic("abcdeabcdfg")).isEqualTo(5);

    }


    int solution(String s) {
        /* 스트림을 써보기 위해서 해봤다. */
        Map<String, Integer> collect = Arrays.stream(s.split("")).collect(
            Collectors.groupingBy(
                    c -> c,
                    Collectors.summingInt(c -> c.length())
            )
        );

        if(!collect.containsValue(1)) return -1;

        // 빈도가 1 이상인 요소만 필터링
        List<Map.Entry<String, Integer>> oneList = collect.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .collect(Collectors.toList());

        int minIndex = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> m : oneList) {
            minIndex = Math.min(s.indexOf(m.getKey()), minIndex);
        }

        return minIndex + 1;
    }


    int solution_Basic(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i + 1;
        }

        return -1;
    }

}
