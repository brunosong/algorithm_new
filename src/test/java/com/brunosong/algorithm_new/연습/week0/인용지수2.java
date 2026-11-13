package com.brunosong.algorithm_new.연습.week0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 풀이에 필요한 import는 직접 추가합니다.

/*
 * [문제] 인용지수 (11-13, 정렬)
 * 비슷한 원래 문제: 프로그래머스 "H-Index". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=인용지수
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 어떤 연구자가 쓴 논문들의 인용 횟수가 배열 citations로 주어집니다.
 * "인용 횟수가 h번 이상인 논문이 h편 이상"이 되는 h 가운데 가장 큰 값을 인용 지수라고 합니다.
 * 인용 지수를 return 하도록 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * - citations의 길이는 1 이상 100,000 이하입니다.
 * - 각 원소는 0 이상 1,000,000 이하입니다.
 *
 * [입출력 예]
 *   citations          result
 *   [4, 4, 0, 2, 7]    3
 *   [0, 0]             0
 *   [10, 10, 10]       3
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 3번 이상 인용된 논문이 3편(4, 4, 7)이라 h = 3은 됩니다. 4번 이상 인용된 논문도 3편뿐이라 h = 4는 안 됩니다.
 */
public class 인용지수2 {

    public int solution(int[] citations) {
        // 여기에 풀이를 작성합니다.
        Arrays.sort(citations);

        int h = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h) {
                return h;
            }
            h--;
        }

        return 0;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(3, solution(new int[]{4, 4, 0, 2, 7})); }
    @Test void 예제2() { assertEquals(0, solution(new int[]{0, 0})); }
    @Test void 예제3() { assertEquals(3, solution(new int[]{10, 10, 10})); }
    @Test void 한편() { assertEquals(1, solution(new int[]{1})); }
    @Test @Timeout(2) void 큰입력() {
        int[] a = new int[100_000]; for (int i = 0; i < a.length; i++) a[i] = i;
        assertEquals(50_000, solution(a));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{1, 6, 6, 2}, 2),
                Arguments.of(new int[]{1, 0}, 1),
                Arguments.of(new int[]{10, 10, 0, 5, 7}, 4),
                Arguments.of(new int[]{7, 8, 7, 7, 0, 2, 3}, 4),
                Arguments.of(new int[]{10, 9, 9, 1, 7, 1, 2, 2, 2}, 4),
                Arguments.of(new int[]{2, 8, 0}, 2),
                Arguments.of(new int[]{2, 0, 8, 8}, 2),
                Arguments.of(new int[]{1, 4, 10, 0}, 2),
                Arguments.of(new int[]{6, 3}, 2),
                Arguments.of(new int[]{2, 3, 1, 2, 0}, 2),
                Arguments.of(new int[]{3}, 1),
                Arguments.of(new int[]{3, 1, 1, 10, 2, 5}, 3),
                Arguments.of(new int[]{8, 2, 1}, 2),
                Arguments.of(new int[]{0, 3, 4}, 2),
                Arguments.of(new int[]{8, 7}, 2),
                Arguments.of(new int[]{3, 6, 5, 6}, 3),
                Arguments.of(new int[]{3, 5}, 2),
                Arguments.of(new int[]{9, 4, 9, 1, 7, 6, 5, 0}, 5),
                Arguments.of(new int[]{3, 4, 1, 8}, 3),
                Arguments.of(new int[]{4, 6, 1, 3, 8}, 3),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{10, 3, 6, 3, 10, 1, 8}, 4),
                Arguments.of(new int[]{1, 10, 6, 3, 2, 8}, 3),
                Arguments.of(new int[]{4, 7, 10, 10, 1, 4, 7, 6, 0}, 5),
                Arguments.of(new int[]{4, 0, 3, 8, 2, 10, 5, 0, 2}, 4)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] citations, int expected) {
        assertEquals(expected, solution(citations));
    }
}
