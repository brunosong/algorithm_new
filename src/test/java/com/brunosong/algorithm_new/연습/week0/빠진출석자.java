package com.brunosong.algorithm_new.연습.week0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 빠진출석자 (11-12, 해시)
 * 비슷한 원래 문제: 프로그래머스 "완주하지 못한 선수". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=빠진출석자
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 동아리 모임에 명단(roster)에 있는 사람이 모두 오기로 했는데, 출석 체크(attended)를 해 보니 딱 한 명이 빠졌습니다.
 * 명단에는 같은 이름이 여러 번 나올 수 있습니다(동명이인).
 * 출석하지 않은 한 사람의 이름을 return 하도록 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * - roster의 길이는 1 이상 100,000 이하입니다.
 * - attended의 길이는 roster의 길이보다 1 작습니다.
 * - 이름은 알파벳 소문자 1 ~ 20글자입니다.
 *
 * [입출력 예]
 *   roster                  attended          result
 *   ["kim","lee","park"]    ["park","kim"]    "lee"
 *   ["choi","choi","han"]   ["han","choi"]    "choi"
 *
 * [입출력 예 설명]
 * 입출력 예 #2: choi가 명단에 두 명인데 출석은 한 명만 했으므로 choi 한 명이 빠졌습니다.
 */
public class 빠진출석자 {

    public String solution(String[] roster, String[] attended) {
        // 여기에 풀이를 작성합니다.
        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < roster.length; i++) {
            hash.put(roster[i], hash.getOrDefault(roster[i],0) + 1);
        }

        for (int i = 0; i < attended.length; i++) {
            String name = attended[i];
            hash.put(name, hash.get(name) - 1);
        }

        for (String key : hash.keySet()) {
            if (hash.get(key) > 0) return key;
        }

        return "";
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals("lee", solution(new String[]{"kim","lee","park"}, new String[]{"park","kim"})); }
    @Test void 예제2() { assertEquals("choi", solution(new String[]{"choi","choi","han"}, new String[]{"han","choi"})); }
    @Test void 한명() { assertEquals("a", solution(new String[]{"a"}, new String[]{})); }
    @Test @Timeout(2) void 큰입력() {
        int n = 100_000;
        String[] roster = new String[n]; String[] attended = new String[n - 1];
        for (int i = 0, j = 0; i < n; i++) { roster[i] = "p" + i; if (i != 77_777) attended[j++] = "p" + i; }
        assertEquals("p77777", solution(roster, attended));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new String[]{"park", "han", "choi"}, new String[]{"park", "choi"}, "han"),
                Arguments.of(new String[]{"choi", "kim", "han"}, new String[]{"choi", "kim"}, "han"),
                Arguments.of(new String[]{"kim", "park"}, new String[]{"kim"}, "park"),
                Arguments.of(new String[]{"park", "lee", "lee", "kim", "kim", "kim"}, new String[]{"kim", "park", "lee", "lee", "kim"}, "kim"),
                Arguments.of(new String[]{"lee", "kim", "park", "lee", "lee", "kim", "lee"}, new String[]{"park", "kim", "lee", "lee", "kim", "lee"}, "lee"),
                Arguments.of(new String[]{"lee", "kim"}, new String[]{"lee"}, "kim"),
                Arguments.of(new String[]{"choi", "lee", "park", "lee", "jung", "kim", "han"}, new String[]{"choi", "jung", "park", "lee", "lee", "kim"}, "han"),
                Arguments.of(new String[]{"lee", "lee", "jung"}, new String[]{"lee", "lee"}, "jung"),
                Arguments.of(new String[]{"kim", "kim", "park", "lee", "kim", "kim"}, new String[]{"lee", "park", "kim", "kim", "kim"}, "kim"),
                Arguments.of(new String[]{"lee", "lee", "kim", "choi", "jung", "han", "lee"}, new String[]{"lee", "choi", "lee", "jung", "han", "kim"}, "lee"),
                Arguments.of(new String[]{"jung"}, new String[]{}, "jung"),
                Arguments.of(new String[]{"han"}, new String[]{}, "han"),
                Arguments.of(new String[]{"kim", "lee", "lee", "choi", "han"}, new String[]{"kim", "han", "choi", "lee"}, "lee"),
                Arguments.of(new String[]{"park", "park", "lee"}, new String[]{"park", "park"}, "lee"),
                Arguments.of(new String[]{"kim", "han", "park", "jung", "kim"}, new String[]{"kim", "kim", "han", "park"}, "jung"),
                Arguments.of(new String[]{"yoon", "park", "lee", "choi", "jung", "han", "lee", "han"}, new String[]{"lee", "park", "choi", "lee", "han", "jung", "han"}, "yoon"),
                Arguments.of(new String[]{"jung", "park", "jung", "jung", "choi", "kim", "han", "choi"}, new String[]{"choi", "jung", "kim", "park", "choi", "jung", "jung"}, "han"),
                Arguments.of(new String[]{"kim", "kim", "kim", "lee", "kim", "lee", "kim"}, new String[]{"lee", "kim", "kim", "kim", "kim", "lee"}, "kim"),
                Arguments.of(new String[]{"lee", "choi"}, new String[]{"choi"}, "lee"),
                Arguments.of(new String[]{"lee", "kim", "han", "park"}, new String[]{"park", "han", "kim"}, "lee"),
                Arguments.of(new String[]{"lee", "han", "park", "kim", "jung", "lee", "jung", "han"}, new String[]{"han", "park", "han", "jung", "lee", "kim", "jung"}, "lee"),
                Arguments.of(new String[]{"lee", "park", "han"}, new String[]{"lee", "park"}, "han"),
                Arguments.of(new String[]{"choi", "choi", "lee", "lee", "park"}, new String[]{"lee", "choi", "park", "lee"}, "choi"),
                Arguments.of(new String[]{"park", "kim", "choi"}, new String[]{"park", "kim"}, "choi"),
                Arguments.of(new String[]{"kim", "kim"}, new String[]{"kim"}, "kim")
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(String[] roster, String[] attended, String expected) {
        assertEquals(expected, solution(roster, attended));
    }
}
