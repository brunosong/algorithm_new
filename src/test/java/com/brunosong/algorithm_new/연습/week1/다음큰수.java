package com.brunosong.algorithm_new.연습.week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 다음큰수 (11-18, 스택)
 * 비슷한 원래 문제: 백준 17298 "오큰수". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=다음큰수
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 정수 배열 a가 주어집니다. 각 원소마다, 그 오른쪽에 있으면서 그 원소보다 큰 수 가운데 가장 왼쪽에 있는 수를 구합니다.
 * 그런 수가 없으면 -1입니다. 결과를 배열로 return 해 주세요.
 *
 * [제한사항]
 * - a의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 원소는 1 이상 1,000,000 이하입니다.
 *
 * [입출력 예]
 *   a                  result
 *   [2, 1, 4, 3, 5]    [4, 4, 5, 5, -1]
 *   [5, 4, 3]          [-1, -1, -1]
 *   [1, 1, 2]          [2, 2, -1]
 */
public class 다음큰수 {

    public int[] solution(int[] a) {

        int[] result = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result, -1);

        for (int i = 0; i < result.length; i++) {
            while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
                result[stack.pop()] = a[i];
            }
            stack.push(i);
        }


//        int[] result = new int[a.length];
//        // 여기에 풀이를 작성합니다.
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i+1; j < a.length; j++) {
//                if (a[i] < a[j]) {
//                    result[i] = a[j];
//                    break;
//                }
//                if (a.length-1 == j) {
//                    result[i] = -1;
//                }
//            }
//        }
//        result[result.length-1] = -1;
        return result;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertArrayEquals(new int[]{4, 4, 5, 5, -1}, solution(new int[]{2, 1, 4, 3, 5})); }
    @Test void 예제2() { assertArrayEquals(new int[]{-1, -1, -1}, solution(new int[]{5, 4, 3})); }
    @Test void 예제3() { assertArrayEquals(new int[]{2, 2, -1}, solution(new int[]{1, 1, 2})); }
    @Test @Timeout(2) void 큰입력() {
        int n = 1_000_000; int[] a = new int[n]; int[] e = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        for (int i = 0; i < n; i++) e[i] = (i == n - 1) ? -1 : i + 2;
        assertArrayEquals(e, solution(a));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 2, 6}, new int[]{2, 4, 6, 6, -1}),
                Arguments.of(new int[]{6, 3, 2, 1, 6, 1, 5, 2}, new int[]{-1, 6, 6, 6, -1, 5, -1, -1}),
                Arguments.of(new int[]{5}, new int[]{-1}),
                Arguments.of(new int[]{5, 2, 5, 4, 6, 4, 1}, new int[]{6, 5, 6, 6, -1, -1, -1}),
                Arguments.of(new int[]{3, 6, 2, 4, 5, 2, 5, 1, 6}, new int[]{6, -1, 4, 5, 6, 5, 6, 6, -1}),
                Arguments.of(new int[]{1, 3, 5, 4, 6}, new int[]{3, 5, 6, 6, -1}),
                Arguments.of(new int[]{3, 4, 3, 1, 4, 4, 2, 2, 2}, new int[]{4, -1, 4, 4, -1, -1, -1, -1, -1}),
                Arguments.of(new int[]{1, 3, 4}, new int[]{3, 4, -1}),
                Arguments.of(new int[]{6, 2}, new int[]{-1, -1}),
                Arguments.of(new int[]{1, 5, 4, 6, 3, 6, 5, 4}, new int[]{5, 6, 6, -1, 6, -1, -1, -1}),
                Arguments.of(new int[]{1, 6, 1}, new int[]{6, -1, -1}),
                Arguments.of(new int[]{3, 1, 3, 5, 2, 6}, new int[]{5, 3, 5, 6, 6, -1}),
                Arguments.of(new int[]{5, 1, 2, 4, 4, 1, 2}, new int[]{-1, 2, 4, -1, -1, 2, -1}),
                Arguments.of(new int[]{5, 2, 2, 6, 1}, new int[]{6, 6, 6, -1, -1}),
                Arguments.of(new int[]{6, 1, 6, 6, 3, 4, 6, 1, 3}, new int[]{-1, 6, -1, -1, 4, 6, -1, 3, -1}),
                Arguments.of(new int[]{2, 6}, new int[]{6, -1}),
                Arguments.of(new int[]{2, 5, 6, 4, 4, 1, 1, 4}, new int[]{5, 6, -1, -1, -1, 4, 4, -1}),
                Arguments.of(new int[]{5, 4, 5, 3, 2, 4, 3, 4}, new int[]{-1, 5, -1, 4, 4, -1, 4, -1}),
                Arguments.of(new int[]{5, 2, 5, 5, 1}, new int[]{-1, 5, -1, -1, -1}),
                Arguments.of(new int[]{1, 6, 2, 6, 1}, new int[]{6, -1, 6, -1, -1}),
                Arguments.of(new int[]{1}, new int[]{-1}),
                Arguments.of(new int[]{3, 3, 3, 6, 6, 2}, new int[]{6, 6, 6, -1, -1, -1}),
                Arguments.of(new int[]{4, 2}, new int[]{-1, -1}),
                Arguments.of(new int[]{4, 4, 4, 4, 3, 3}, new int[]{-1, -1, -1, -1, -1, -1}),
                Arguments.of(new int[]{5, 4, 5}, new int[]{-1, 5, -1})
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] a, int[] expected) {
        assertArrayEquals(expected, solution(a));
    }
}
