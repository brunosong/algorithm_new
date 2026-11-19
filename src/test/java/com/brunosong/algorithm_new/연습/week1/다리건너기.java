package com.brunosong.algorithm_new.연습.week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 다리건너기 (11-18, 큐)
 * 비슷한 원래 문제: 프로그래머스 "다리를 지나는 트럭". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=다리건너기
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 트럭들이 정해진 순서대로 한 줄짜리 다리를 건넙니다. 다리에는 트럭이 최대 bridgeLength대까지 올라갈 수 있고,
 * 다리 위 트럭 무게의 합은 weight 이하여야 합니다. 트럭은 1초에 1칸 움직이고, 다리를 다 건너는 데 bridgeLength초가 걸립니다.
 * 1초에 트럭은 최대 한 대만 다리에 올라갈 수 있습니다. 모든 트럭이 다리를 다 건너는 데 걸리는 최소 시간을 return 해 주세요.
 *
 * [제한사항]
 * - bridgeLength, weight는 1 이상 10,000 이하입니다.
 * - trucks의 길이는 1 이상 10,000 이하이고, 각 무게는 1 이상 weight 이하입니다.
 *
 * [입출력 예]
 *   bridgeLength   weight   trucks           result
 *   3              10       [5, 5, 5]        7
 *   1              5        [5, 5]           3
 *   50             100      [10 x 10대]      60
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 1초, 2초에 첫째와 둘째가 올라가고, 셋째는 무게 때문에 기다렸다가 4초에 첫째가 내려간 뒤 올라가서 7초에 다 건넙니다.
 */
public class 다리건너기 {

    public int solution(int bridgeLength, int weight, int[] trucks) {
        // 여기에 풀이를 작성합니다.
        Queue<int[]> queue = new LinkedList<>();

        int time = 1;
        int size = 0;
        int idx = 0;
        while (true) {

            while (!queue.isEmpty() && time >= queue.peek()[0]) {
                int[] poll = queue.poll();
                size -= poll[1];
            }

            if (idx <= trucks.length - 1) {
                int truck = trucks[idx];
                if (size + truck <= weight) {
                    size += truck;
                    queue.add(new int[]{time + bridgeLength,truck});
                    idx++;
                }
            }

            if (idx >= trucks.length - 1 && queue.isEmpty()) {
                break;
            }

            time++;
        }

        return time;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(7, solution(3, 10, new int[]{5, 5, 5})); }
    @Test void 예제2() { assertEquals(3, solution(1, 5, new int[]{5, 5})); }
    @Test void 예제3() { int[] t = new int[10]; Arrays.fill(t, 10); assertEquals(60, solution(50, 100, t)); }
    @Test void 한대() { assertEquals(3, solution(2, 10, new int[]{7})); }
    @Test @Timeout(3) void 큰입력_한대씩만() {
        int[] t = new int[1000]; Arrays.fill(t, 1000);
        assertEquals(1_000_001, solution(1000, 1000, t));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(3, 14, new int[]{12}, 4),
                Arguments.of(3, 5, new int[]{2, 1, 3, 4, 5}, 13),
                Arguments.of(4, 9, new int[]{3, 7, 5, 1, 9, 3}, 22),
                Arguments.of(4, 5, new int[]{2, 3, 4, 5}, 14),
                Arguments.of(1, 11, new int[]{10, 7, 6, 4, 7}, 6),
                Arguments.of(3, 13, new int[]{2, 7, 7}, 8),
                Arguments.of(4, 8, new int[]{8}, 5),
                Arguments.of(3, 15, new int[]{4, 1, 11}, 7),
                Arguments.of(5, 4, new int[]{1}, 6),
                Arguments.of(3, 12, new int[]{11, 4, 12}, 10),
                Arguments.of(2, 1, new int[]{1, 1}, 5),
                Arguments.of(3, 12, new int[]{3, 7}, 5),
                Arguments.of(5, 3, new int[]{3, 2}, 11),
                Arguments.of(2, 6, new int[]{2, 2, 3, 2}, 6),
                Arguments.of(4, 2, new int[]{1, 1, 2, 1}, 14),
                Arguments.of(4, 4, new int[]{2, 2, 1, 3, 2, 4}, 18),
                Arguments.of(3, 4, new int[]{2, 4, 3, 3}, 13),
                Arguments.of(4, 5, new int[]{4, 5, 4}, 13),
                Arguments.of(5, 1, new int[]{1, 1, 1, 1}, 21),
                Arguments.of(4, 5, new int[]{2, 3, 4, 1, 4, 4}, 18),
                Arguments.of(5, 8, new int[]{3, 4, 2, 2, 2}, 13),
                Arguments.of(4, 7, new int[]{1}, 5),
                Arguments.of(5, 15, new int[]{1, 14, 15}, 12),
                Arguments.of(5, 15, new int[]{7, 3, 5}, 8),
                Arguments.of(3, 6, new int[]{3, 1, 1, 1}, 7)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int bridgeLength, int weight, int[] trucks, int expected) {
        assertEquals(expected, solution(bridgeLength, weight, trucks));
    }
}
