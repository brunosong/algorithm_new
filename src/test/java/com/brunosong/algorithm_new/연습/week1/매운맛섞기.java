package com.brunosong.algorithm_new.연습.week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 매운맛섞기 (11-19, 힙)
 * 비슷한 원래 문제: 프로그래머스 "더 맵게". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=매운맛섞기
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 음식들의 매운 정도가 배열 scoville로 주어집니다. 모든 음식의 매운 정도를 K 이상으로 만들려고 합니다.
 * 한 번 섞을 때는 가장 덜 매운 음식(a)과 두 번째로 덜 매운 음식(b)을 꺼내 a + b x 2 짜리 음식 하나로 만들어 넣습니다.
 * 모두 K 이상이 될 때까지 섞어야 하는 최소 횟수를 return 해 주세요. 불가능하면 -1입니다.
 *
 * [제한사항]
 * - scoville의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 원소는 0 이상 1,000,000 이하, K는 0 이상 1,000,000,000 이하입니다.
 *
 * [입출력 예]
 *   scoville     K    result
 *   [1, 1, 1]    4    2
 *   [10, 12]     7    0
 *   [1, 2]       10   -1
 *   [3, 4, 5]    10   2
 */
public class 매운맛섞기 {

    public int solution(@NonNull int[] scoville, int K) {
        // 여기에 풀이를 작성합니다.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : scoville) {
            queue.add(j);
        }

        if (!queue.isEmpty() && queue.peek() >= K) return 0;

        int cnt = 1;
        while (!queue.isEmpty()) {

            if (queue.size() == 1 && queue.peek() < K) {
                return -1;
            }

            if (queue.peek() <= K) {
                int a = queue.poll();
                int b = queue.poll();

                int total = a + b * 2;
                queue.add(total);

                if (!queue.isEmpty() && queue.peek() >= K) {
                    break;
                }

            }
            cnt++;
        }

        return cnt;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(2, solution(new int[]{1, 1, 1}, 4)); }
    @Test void 예제2() { assertEquals(0, solution(new int[]{10, 12}, 7)); }
    @Test void 예제3() { assertEquals(-1, solution(new int[]{1, 2}, 10)); }
    @Test void 예제4() { assertEquals(2, solution(new int[]{3, 4, 5}, 10)); }
    @Test void 하나인데부족() { assertEquals(-1, solution(new int[]{3}, 5)); }
    @Test @Timeout(3) void 큰입력() {
        int n = 1_000_000; int[] a = new int[n]; Arrays.fill(a, 1_000_000); a[0] = 0;
        assertEquals(1, solution(a, 1_000_000));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{4}, 3, 0),
                Arguments.of(new int[]{6}, 35, -1),
                Arguments.of(new int[]{4, 4}, 29, -1),
                Arguments.of(new int[]{7, 2, 1, 6}, 2, 1),
                Arguments.of(new int[]{0, 5, 4, 10, 7, 0, 6}, 3, 2),
                Arguments.of(new int[]{10, 2, 6, 1, 3, 4, 3}, 6, 3),
                Arguments.of(new int[]{1, 6, 7, 3, 8}, 4, 1),
                Arguments.of(new int[]{3, 9}, 25, -1),
                Arguments.of(new int[]{10, 5}, 26, -1),
                Arguments.of(new int[]{10, 8, 7, 10, 9, 10, 8}, 30, 5),
                Arguments.of(new int[]{0, 5, 2, 0, 9, 4, 8}, 1, 2),
                Arguments.of(new int[]{9}, 2, 0),
                Arguments.of(new int[]{9}, 10, -1),
                Arguments.of(new int[]{9, 3, 5, 2, 1, 2}, 25, 5),
                Arguments.of(new int[]{6, 5, 8}, 6, 1),
                Arguments.of(new int[]{6}, 3, 0),
                Arguments.of(new int[]{1, 6}, 20, -1),
                Arguments.of(new int[]{4, 0, 4, 10, 1}, 31, 4),
                Arguments.of(new int[]{7, 3, 2}, 14, 2),
                Arguments.of(new int[]{9, 3, 10, 2, 8, 5}, 32, 5),
                Arguments.of(new int[]{1, 7, 4}, 31, -1),
                Arguments.of(new int[]{7, 9, 10, 5, 5}, 29, 4),
                Arguments.of(new int[]{7}, 0, 0),
                Arguments.of(new int[]{7, 1, 6, 9, 4, 2, 2}, 32, 6),
                Arguments.of(new int[]{10}, 20, -1)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] scoville, int K, int expected) {
        assertEquals(expected, solution(scoville, K));
    }
}
