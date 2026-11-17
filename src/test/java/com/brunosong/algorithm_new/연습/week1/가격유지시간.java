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
 * [문제] 가격유지시간 (11-17, 스택)
 * 비슷한 원래 문제: 프로그래머스 "주식가격". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=가격유지시간
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 1초마다 기록한 가격이 배열 prices로 주어집니다. 각 시점마다, 그 뒤로 가격이 처음으로 더 낮아질 때까지 몇 초 동안
 * 떨어지지 않았는지 return 해 주세요. 끝까지 안 떨어지면 마지막 시점까지의 시간입니다.
 *
 * [제한사항]
 * - prices의 길이는 2 이상 100,000 이하입니다.
 * - 각 가격은 1 이상 10,000 이하입니다.
 *
 * [입출력 예]
 *   prices             result
 *   [5, 3, 4, 4, 1]    [1, 3, 2, 1, 0]
 *   [2, 2, 2]          [2, 1, 0]
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 0초의 5는 1초에 3으로 떨어지니 1초, 1초의 3은 4초에 1로 떨어지니 3초 동안 유지됐습니다.
 */
public class 가격유지시간 {

    public int[] solution(int[] prices) {
//        // 여기에 풀이를 작성합니다.
//        Stack<Integer> stack = new Stack<>();
//        for (int p : prices) {
//            stack.add(p);
//        }
//
//        // 첫번째꺼 뽑음 무조건 0
//        int[] temp = new int[prices.length];
//        temp[temp.length-1] = 0;
//
//        Integer first = stack.pop();
//        int idx = prices.length-2;
//        int result = 0;
//        while (!stack.isEmpty()) {
//            Integer current = stack.pop();
//            if (current <= first) {
//                result++;
//            } else {
//                result = 1;
//            }
//            temp[idx--] = result;
//            first = current;
//        }
//
//        return temp;

            int n = prices.length;
            int[] ans = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                    int j = st.pop(); ans[j] = i - j;
                }
                st.push(i);
            }
            while (!st.isEmpty()) { int j = st.pop(); ans[j] = n - 1 - j; }
            return ans;

    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertArrayEquals(new int[]{1, 3, 2, 1, 0}, solution(new int[]{5, 3, 4, 4, 1})); }
    @Test void 예제2() { assertArrayEquals(new int[]{2, 1, 0}, solution(new int[]{2, 2, 2})); }
    @Test @Timeout(1) void 큰입력_계속오름() {
        int n = 100_000; int[] p = new int[n]; int[] e = new int[n];
        for (int i = 0; i < n; i++) { p[i] = 1 + i / 10; e[i] = n - 1 - i; }
        assertArrayEquals(e, solution(p));
    }
    @Test @Timeout(1) void 큰입력_계속내림() {
        int n = 100_000; int[] p = new int[n]; int[] e = new int[n];
        for (int i = 0; i < n; i++) { p[i] = n - i; e[i] = (i == n - 1) ? 0 : 1; }
        assertArrayEquals(e, solution(p));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{5, 1, 5, 5, 3, 5, 3, 2}, new int[]{1, 6, 2, 1, 3, 1, 1, 0}),
                Arguments.of(new int[]{3, 5, 1, 4, 1, 4, 3, 2}, new int[]{2, 1, 5, 1, 3, 1, 1, 0}),
                Arguments.of(new int[]{4, 1, 5, 2, 4, 2, 2, 1, 3}, new int[]{1, 7, 1, 4, 1, 2, 1, 1, 0}),
                Arguments.of(new int[]{2, 1, 5, 5, 5, 1, 3, 4}, new int[]{1, 6, 3, 2, 1, 2, 1, 0}),
                Arguments.of(new int[]{5, 5, 2, 5, 2}, new int[]{2, 1, 2, 1, 0}),
                Arguments.of(new int[]{5, 4, 4, 3}, new int[]{1, 2, 1, 0}),
                Arguments.of(new int[]{2, 4, 1, 2, 5, 4, 2, 4, 5}, new int[]{2, 1, 6, 5, 1, 1, 2, 1, 0}),
                Arguments.of(new int[]{1, 2, 4, 5, 2, 3, 5, 5}, new int[]{7, 6, 2, 1, 3, 2, 1, 0}),
                Arguments.of(new int[]{5, 4, 2, 1}, new int[]{1, 1, 1, 0}),
                Arguments.of(new int[]{3, 1, 3, 3, 3, 4, 4, 5, 3}, new int[]{1, 7, 6, 5, 4, 3, 2, 1, 0}),
                Arguments.of(new int[]{4, 5, 1, 4, 3, 5, 4, 3, 1}, new int[]{2, 1, 6, 1, 4, 1, 1, 1, 0}),
                Arguments.of(new int[]{1, 3, 5}, new int[]{2, 1, 0}),
                Arguments.of(new int[]{4, 5}, new int[]{1, 0}),
                Arguments.of(new int[]{3, 4}, new int[]{1, 0}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 0}),
                Arguments.of(new int[]{1, 1, 3}, new int[]{2, 1, 0}),
                Arguments.of(new int[]{1, 3, 5, 5, 1, 2}, new int[]{5, 3, 2, 1, 1, 0}),
                Arguments.of(new int[]{4, 2, 3}, new int[]{1, 1, 0}),
                Arguments.of(new int[]{1, 3, 1, 3, 3, 5, 1}, new int[]{6, 1, 4, 3, 2, 1, 0}),
                Arguments.of(new int[]{3, 3, 5}, new int[]{2, 1, 0}),
                Arguments.of(new int[]{5, 2, 4, 2, 1, 3, 4}, new int[]{1, 3, 1, 1, 2, 1, 0}),
                Arguments.of(new int[]{3, 2, 1, 4, 2, 2, 2, 3, 2}, new int[]{1, 1, 6, 1, 4, 3, 2, 1, 0}),
                Arguments.of(new int[]{5, 2, 3, 1, 5, 4, 3, 1}, new int[]{1, 2, 1, 4, 1, 1, 1, 0}),
                Arguments.of(new int[]{1, 4, 4, 4}, new int[]{3, 2, 1, 0}),
                Arguments.of(new int[]{2, 5, 1, 4, 2, 5, 5, 4}, new int[]{2, 1, 5, 1, 3, 2, 1, 0})
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] prices, int[] expected) {
        assertArrayEquals(expected, solution(prices));
    }
}
