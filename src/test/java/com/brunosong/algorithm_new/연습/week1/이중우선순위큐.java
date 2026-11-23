package com.brunosong.algorithm_new.연습.week1;

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
 * [문제] 이중우선순위큐 (11-20, 힙)
 * 비슷한 원래 문제: 프로그래머스 "이중우선순위큐". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=이중우선순위큐
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 명령어 목록 operations를 차례로 실행합니다.
 * - "I 숫자": 큐에 숫자를 넣습니다.-
 * - "D 1": 큐에서 최댓값을 하나 지웁니다.
 * - "D -1": 큐에서 최솟값을 하나 지웁니다.
 * 빈 큐에서 지우라는 명령은 무시합니다. 끝났을 때 [최댓값, 최솟값]을, 비어 있으면 [0, 0]을 return 해 주세요.
 *
 * [제한사항]
 * - operations의 길이는 1 이상 1,000,000 이하입니다.
 * - 숫자는 int 범위입니다. 같은 숫자가 여러 번 들어올 수 있습니다.
 *
 * [입출력 예]
 *   operations                                  result
 *   ["I 5","I -3","I 10","D 1","I 7"]           [7, -3]
 *   ["I 1","D -1","D 1"]                        [0, 0]
 *   ["I 4","I 4","D 1"]                         [4, 4]
 */
public class 이중우선순위큐 {

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < operations.length; i++) {
            String[] strings = operations[i].split(" ");
            Integer value = Integer.valueOf(strings[1]);

            if (strings[0].equals("I")) {
                treeMap.put(value, treeMap.getOrDefault(value,0) + 1);
            } else {

                if (treeMap.isEmpty()) continue;

                Integer key = value == 1 ? treeMap.lastKey() : treeMap.firstKey();
                if (treeMap.get(key) == 1) treeMap.remove(key);
                else {
                    treeMap.put(key, treeMap.get(key) - 1);
                }
            }
        }

        return treeMap.isEmpty()
                ? new int[]{0, 0}
                : new int[]{treeMap.lastKey(), treeMap.firstKey()};
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertArrayEquals(new int[]{7, -3}, solution(new String[]{"I 5", "I -3", "I 10", "D 1", "I 7"})); }
    @Test void 예제2() { assertArrayEquals(new int[]{0, 0}, solution(new String[]{"I 1", "D -1", "D 1"})); }
    @Test void 예제3_중복() { assertArrayEquals(new int[]{4, 4}, solution(new String[]{"I 4", "I 4", "D 1"})); }
    @Test void 빈큐삭제무시() { assertArrayEquals(new int[]{2, 2}, solution(new String[]{"D 1", "I 2"})); }
    @Test @Timeout(3) void 큰입력() {
        int n = 1_000_000; String[] ops = new String[n];
        for (int i = 0; i < n / 2; i++) ops[i] = "I " + i;
        for (int i = n / 2; i < n; i++) ops[i] = (i % 2 == 0) ? "D 1" : "D -1";
        assertArrayEquals(new int[]{0, 0}, solution(ops));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new String[]{"I 4", "D 1", "I -5", "I -5", "I 3", "I -5", "D 1", "I -4"}, new int[]{-4, -5}),
                Arguments.of(new String[]{"I -3", "D 1", "I 1", "D -1", "I 4", "I 4"}, new int[]{4, 4}),
                Arguments.of(new String[]{"I 4", "D 1", "D 1", "I -1"}, new int[]{-1, -1}),
                Arguments.of(new String[]{"I 1", "I -1", "D -1", "I -3", "I 0", "D 1", "D -1"}, new int[]{0, 0}),
                Arguments.of(new String[]{"I 4"}, new int[]{4, 4}),
                Arguments.of(new String[]{"D -1"}, new int[]{0, 0}),
                Arguments.of(new String[]{"D 1", "D 1"}, new int[]{0, 0}),
                Arguments.of(new String[]{"D 1", "I 1", "I -5", "D -1", "I -4", "I -3", "D -1", "I -5"}, new int[]{1, -5}),
                Arguments.of(new String[]{"D 1", "D 1", "D -1", "I -3", "I 0", "D 1", "I 5", "I -5", "D 1", "I -1"}, new int[]{-1, -5}),
                Arguments.of(new String[]{"I -4", "D 1", "I -3", "D 1", "D 1", "D -1", "I -2", "I -5", "I 4"}, new int[]{4, -5}),
                Arguments.of(new String[]{"D -1", "D 1", "D -1", "D 1", "D -1", "I -1"}, new int[]{-1, -1}),
                Arguments.of(new String[]{"I 5", "D 1", "I -4", "D -1", "D 1", "D 1", "D 1", "D -1"}, new int[]{0, 0}),
                Arguments.of(new String[]{"I -4", "D 1", "D -1", "I -4", "D 1", "I -2", "I -1", "I 5", "D 1"}, new int[]{-1, -2}),
                Arguments.of(new String[]{"I 5", "D -1", "I 2"}, new int[]{2, 2}),
                Arguments.of(new String[]{"I 1", "I 2", "D 1", "I 0"}, new int[]{1, 0}),
                Arguments.of(new String[]{"D 1", "D -1", "I 1", "I -4", "I -5", "I 3", "I -5", "I -5"}, new int[]{3, -5}),
                Arguments.of(new String[]{"D 1"}, new int[]{0, 0}),
                Arguments.of(new String[]{"I -5", "I -1", "D -1", "I 1"}, new int[]{1, -1}),
                Arguments.of(new String[]{"D 1", "D 1", "I 0", "D 1", "I 2", "D -1", "I 3", "I -3", "I 1", "D 1"}, new int[]{1, -3}),
                Arguments.of(new String[]{"I -4", "I -1", "D 1", "I -5", "I 5", "I 4", "D -1"}, new int[]{5, -4}),
                Arguments.of(new String[]{"D 1", "D 1", "D -1", "D -1", "I 3", "I 1", "I -3", "D -1"}, new int[]{3, 1}),
                Arguments.of(new String[]{"I 1", "I -1", "D 1", "D -1", "D -1", "I 2", "I 0", "D 1", "I 4"}, new int[]{4, 0}),
                Arguments.of(new String[]{"I 4", "D -1", "I -3"}, new int[]{-3, -3}),
                Arguments.of(new String[]{"I 0", "I 3", "D -1", "D 1", "D -1", "I 3", "D -1"}, new int[]{0, 0}),
                Arguments.of(new String[]{"I 0", "I 0", "I 1", "I 4", "I 3", "D 1", "D -1", "I 0"}, new int[]{3, 0})
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(String[] operations, int[] expected) {
        assertArrayEquals(expected, solution(operations));
    }
}
