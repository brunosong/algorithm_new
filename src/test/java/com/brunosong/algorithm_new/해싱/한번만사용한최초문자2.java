package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 한번만사용한최초문자2 {

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

        Assertions.assertThat(solution2("statitsics")).isEqualTo(3);
        Assertions.assertThat(solution2("aabb")).isEqualTo(-1);
        Assertions.assertThat(solution2("stringshowtime")).isEqualTo(3);
        Assertions.assertThat(solution2("abcdeabcdfg")).isEqualTo(5);

    }


    int solution(String str) {
        int answer = Integer.MAX_VALUE;

        Map<Character,Integer> map = new HashMap<>();
        char[] strArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            map.put(strArray[i], map.getOrDefault(strArray[i], 0) + 1);
        }

        if (!map.containsValue(1)) return -1;

        List<Character> collect = map.keySet().stream().filter(k -> map.get(k) == 1)
                .collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            Character character = collect.get(i);
            answer = Math.min(answer, str.indexOf(character));
        }

        return answer + 1;
    }


    int solution2(String str) {
        int answer = -1;

        Map<Character,Integer> map = new HashMap<>();
        char[] strArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            map.put(strArray[i], map.getOrDefault(strArray[i], 0) + 1);
        }

        char[] charArray = str.toCharArray();
        for (int x = 0; x <  charArray.length; x++) {
            if (map.get(charArray[x]) == 1) {
                return x + 1;
            }
        }

        return answer;
    }



}
