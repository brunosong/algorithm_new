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
 * [문제] 인쇄대기열 (11-17, 큐)
 * 비슷한 원래 문제: 프로그래머스 "프로세스". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=인쇄대기열
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 프린터 대기열에 문서가 순서대로 있고, priorities[i]는 i번 문서의 중요도(1 ~ 9)입니다. 프린터는 이렇게 동작합니다.
 * 1. 대기열 맨 앞 문서를 꺼냅니다.
 * 2. 남은 대기열에 그 문서보다 중요도가 높은 문서가 하나라도 있으면, 꺼낸 문서를 대기열 맨 뒤에 다시 넣습니다.
 * 3. 없으면 그 문서를 인쇄합니다.
 * location번 문서가 몇 번째로 인쇄되는지 return 해 주세요.
 *
 * [제한사항]
 * - priorities의 길이는 1 이상 100 이하입니다.
 * - location은 0 이상 (길이 - 1) 이하입니다.
 *
 * [입출력 예]
 *   priorities            location   result
 *   [1, 3, 2, 3]          0          4
 *   [5, 5, 5]             1          2
 *   [1, 1, 9, 1, 1, 1]    5          4
 */
public class 인쇄대기열 {

    public int solution(int[] priorities, int location) {
        // 여기에 풀이를 작성합니다.
        int max = Arrays.stream(priorities).max().getAsInt();
        int[] cnt = new int[10];
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
//            if (a[1] == b[1]) {
//                return a[0] - b[0];
//            }
//            return b[1] - a[1];
//        });

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (max != poll[1]) {
                queue.offer(poll);
                continue;
            } else {

                if (poll[0] == location) {
                    return count + 1;
                }

                int[] nextCnt = queue.stream().max(Comparator.comparingInt(a -> a[1])).get();
                max = nextCnt[1];

                count++;
            }
        }

        return 0;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(4, solution(new int[]{1, 3, 2, 3}, 0)); }
    @Test void 예제2() { assertEquals(2, solution(new int[]{5, 5, 5}, 1)); }
    @Test void 예제3() { assertEquals(4, solution(new int[]{1, 1, 9, 1, 1, 1}, 5)); }
    @Test void 맨앞이최고() { assertEquals(1, solution(new int[]{9, 1, 1, 1}, 0)); }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 1, 3, 1, 3, 1}, 3, 2),
                Arguments.of(new int[]{1, 3, 3}, 0, 3),
                Arguments.of(new int[]{2, 4, 2, 3, 7, 7}, 0, 5),
                Arguments.of(new int[]{2, 2, 1, 1, 3, 1, 3}, 1, 4),
                Arguments.of(new int[]{5, 3, 5, 5, 9, 1, 7}, 1, 6),
                Arguments.of(new int[]{9, 7, 4, 7, 2, 2}, 1, 2),
                Arguments.of(new int[]{1, 3, 3, 2, 2, 2, 1}, 1, 1),
                Arguments.of(new int[]{1, 2, 2, 3}, 2, 3),
                Arguments.of(new int[]{3, 1, 1, 3, 2, 2}, 2, 6),
                Arguments.of(new int[]{5, 2}, 1, 2),
                Arguments.of(new int[]{2, 3, 3, 2}, 2, 2),
                Arguments.of(new int[]{2, 2, 4, 2, 2, 4}, 0, 3),
                Arguments.of(new int[]{7, 3, 9, 7, 3, 2, 3, 8}, 1, 7),
                Arguments.of(new int[]{1, 3, 2, 2, 2, 1}, 2, 2),
                Arguments.of(new int[]{6, 1, 6, 9}, 3, 1),
                Arguments.of(new int[]{3, 1, 3, 3}, 0, 1),
                Arguments.of(new int[]{6, 3, 9, 3, 8}, 0, 3),
                Arguments.of(new int[]{4, 8, 6, 3, 6, 5, 3}, 2, 2),
                Arguments.of(new int[]{1, 1, 1, 3, 1, 3, 2, 1}, 5, 2),
                Arguments.of(new int[]{2, 5}, 0, 2),
                Arguments.of(new int[]{4, 7, 4, 4, 1, 9, 5, 6}, 5, 1),
                Arguments.of(new int[]{1, 2, 3, 3}, 1, 3),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 1, 1, 1}, 6, 7),
                Arguments.of(new int[]{7, 8, 8, 9, 8, 4}, 2, 4),
                Arguments.of(new int[]{4, 1, 3}, 1, 3)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] priorities, int location, int expected) {
        assertEquals(expected, solution(priorities, location));
    }
}
