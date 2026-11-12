package com.brunosong.algorithm_new.연습.week0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 겹치는주문코드 (11-12, 해시)
 * 비슷한 원래 문제: 프로그래머스 "전화번호 목록". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=겹치는주문코드
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 매장 키오스크는 주문 코드를 한 글자씩 입력받다가, 지금까지 입력한 글자가 어떤 코드와 똑같아지면 바로 그 주문을 접수합니다.
 * 그래서 어떤 코드가 다른 코드의 앞부분(접두어)이면, 긴 코드는 끝까지 입력할 수 없습니다.
 * 모든 코드를 끝까지 입력할 수 있으면 true, 아니면 false를 return 하도록 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * - codes의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 코드는 숫자로만 된 1 ~ 20글자이고, 같은 코드는 두 번 나오지 않습니다.
 *
 * [입출력 예]
 *   codes                       result
 *   ["301","7724","30155"]      false
 *   ["12","34","56"]            true
 *   ["5556","9","555"]          false
 *
 * [입출력 예 설명]
 * 입출력 예 #1: "301"이 "30155"의 앞부분이라, 30155를 입력하다가 301에서 접수됩니다.
 */
public class 겹치는주문코드 {

    public boolean solution(String[] codes) {
        // 여기에 풀이를 작성합니다.
//        Set<String> set = new HashSet<>(Arrays.asList(codes));
//        for (int i = 0; i < codes.length; i++) {
//            for (int j = 0; j < codes[i].length(); j++) {
//                String c = codes[i].substring(0,j);
//                if (set.contains(c)) {
//                    return false;
//                }
//            }
//        }
        String[] c = codes.clone();
        Arrays.sort(c);

        for (int i = 0; i < c.length - 1; i++) {
            if (c[i+1].startsWith(c[i])) return false;
        }

        return true;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertFalse(solution(new String[]{"301","7724","30155"})); }
    @Test void 예제2() { assertTrue(solution(new String[]{"12","34","56"})); }
    @Test void 예제3() { assertFalse(solution(new String[]{"5556","9","555"})); }
    @Test void 하나() { assertTrue(solution(new String[]{"1"})); }
    @Test @Timeout(3) void 큰입력_겹침없음() {
        int n = 1_000_000; String[] c = new String[n];
        for (int i = 0; i < n; i++) c[i] = String.valueOf(1_000_000 + i);
        assertTrue(solution(c));
    }
    @Test @Timeout(3) void 큰입력_맨끝에겹침() {
        int n = 1_000_000; String[] c = new String[n];
        for (int i = 0; i < n - 1; i++) c[i] = String.valueOf(1_000_000 + i);
        c[n - 1] = "1000000123";
        assertFalse(solution(c));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new String[]{"211"}, true),
                Arguments.of(new String[]{"2", "2113", "132"}, false),
                Arguments.of(new String[]{"333"}, true),
                Arguments.of(new String[]{"13", "332"}, true),
                Arguments.of(new String[]{"2", "22", "1311", "112", "1"}, false),
                Arguments.of(new String[]{"332", "212", "3323", "1"}, false),
                Arguments.of(new String[]{"223", "1231", "2"}, false),
                Arguments.of(new String[]{"2", "1", "3"}, true),
                Arguments.of(new String[]{"3"}, true),
                Arguments.of(new String[]{"33", "3313", "23"}, false),
                Arguments.of(new String[]{"2112", "222", "3", "12"}, true),
                Arguments.of(new String[]{"1", "33", "122"}, false),
                Arguments.of(new String[]{"122", "3", "3112", "123"}, false),
                Arguments.of(new String[]{"2", "21"}, false),
                Arguments.of(new String[]{"3", "121", "2222", "1"}, false),
                Arguments.of(new String[]{"113", "3", "33", "121", "112"}, false),
                Arguments.of(new String[]{"3131", "32", "1221", "2"}, true),
                Arguments.of(new String[]{"1", "331", "13"}, false),
                Arguments.of(new String[]{"131", "32"}, true),
                Arguments.of(new String[]{"33", "3"}, false),
                Arguments.of(new String[]{"232", "1231", "323"}, true),
                Arguments.of(new String[]{"121", "32", "1", "11", "23"}, false),
                Arguments.of(new String[]{"1", "3322"}, true),
                Arguments.of(new String[]{"222", "213", "1"}, true),
                Arguments.of(new String[]{"23"}, true)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(String[] codes, boolean expected) {
        assertEquals(expected, solution(codes));
    }
}
