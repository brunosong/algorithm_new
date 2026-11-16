package com.brunosong.algorithm_new.연습.week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.lang.NonNull;

import java.util.*;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 배포묶음 (11-16, 큐)
 * 비슷한 원래 문제: 프로그래머스 "기능개발". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=배포묶음
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 기능 여러 개를 순서대로 배포해야 합니다. progresses[i]는 i번 기능의 현재 진도(%)이고, 하루마다 speeds[i]씩 오릅니다.
 * 100%가 된 기능도 앞 기능이 아직 안 끝났으면 기다렸다가, 앞 기능이 배포되는 날 같이 배포됩니다.
 * 배포는 하루에 한 번, 하루가 끝날 때 합니다. 배포할 때마다 몇 개가 나가는지 순서대로 return 해 주세요.
 *
 * [제한사항]
 * - 기능 수는 1 이상 100 이하입니다.
 * - progresses의 원소는 0 이상 100 미만, speeds의 원소는 1 이상 100 이하입니다.
 *
 * [입출력 예]
 *   progresses         speeds            result
 *   [80, 50, 95]       [10, 25, 1]       [2, 1]
 *   [40, 90, 90, 10]   [20, 5, 10, 30]   [4]
 *   [99, 1, 99]        [1, 1, 1]         [1, 2]
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 끝나는 날이 2, 2, 5일이라 2일째에 두 개, 5일째에 한 개가 나갑니다.
 */
public class 배포묶음 {

    public int[] solution(@NonNull int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        // 여기에 풀이를 작성합니다.
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            int day = 0;
            while (progress < 100) {
                progress += speed;
                day++;
            }

            queue.add(day);
        }

        List<Integer> result = new ArrayList<>();

        int max = queue.peek();

        for (int day = 0; day < progresses.length; day++) {
            int cnt = 0;
            while (!queue.isEmpty() && max >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            result.add(cnt);

            if (queue.isEmpty()) {
                break;
            }

            max = Math.max(queue.peek(), max);
        }


        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertArrayEquals(new int[]{2, 1}, solution(new int[]{80, 50, 95}, new int[]{10, 25, 1})); }
    @Test void 예제2() { assertArrayEquals(new int[]{4}, solution(new int[]{40, 90, 90, 10}, new int[]{20, 5, 10, 30})); }
    @Test void 예제3() { assertArrayEquals(new int[]{1, 2}, solution(new int[]{99, 1, 99}, new int[]{1, 1, 1})); }
    @Test void 하나() { assertArrayEquals(new int[]{1}, solution(new int[]{0}, new int[]{1})); }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{28}, new int[]{25}, new int[]{1}),
                Arguments.of(new int[]{73, 95, 16, 95, 38, 52, 0}, new int[]{18, 12, 22, 7, 11, 17, 16}, new int[]{2, 2, 2, 1}),
                Arguments.of(new int[]{19, 62, 39}, new int[]{15, 25, 25}, new int[]{3}),
                Arguments.of(new int[]{71, 71}, new int[]{3, 22}, new int[]{2}),
                Arguments.of(new int[]{16}, new int[]{21}, new int[]{1}),
                Arguments.of(new int[]{1, 81, 82, 98, 31, 71}, new int[]{22, 19, 26, 8, 12, 27}, new int[]{4, 2}),
                Arguments.of(new int[]{39, 37, 61, 23, 36}, new int[]{15, 29, 16, 26, 12}, new int[]{4, 1}),
                Arguments.of(new int[]{10, 84, 99, 57, 63, 39}, new int[]{1, 27, 12, 18, 12, 16}, new int[]{6}),
                Arguments.of(new int[]{26, 92, 11}, new int[]{15, 20, 12}, new int[]{2, 1}),
                Arguments.of(new int[]{72, 95, 7, 60, 31, 47}, new int[]{10, 9, 27, 8, 26, 17}, new int[]{2, 1, 3}),
                Arguments.of(new int[]{84, 68, 66, 19, 58, 19, 29}, new int[]{29, 14, 19, 20, 26, 25, 1}, new int[]{1, 2, 3, 1}),
                Arguments.of(new int[]{23, 29, 34, 63}, new int[]{15, 11, 26, 29}, new int[]{1, 3}),
                Arguments.of(new int[]{29, 19, 87, 81, 21, 0}, new int[]{23, 6, 26, 21, 20, 12}, new int[]{1, 5}),
                Arguments.of(new int[]{23, 98}, new int[]{6, 16}, new int[]{2}),
                Arguments.of(new int[]{73, 18, 72}, new int[]{23, 10, 19}, new int[]{1, 2}),
                Arguments.of(new int[]{37, 39, 27, 48, 94, 98}, new int[]{26, 1, 27, 24, 4, 25}, new int[]{1, 5}),
                Arguments.of(new int[]{64}, new int[]{8}, new int[]{1}),
                Arguments.of(new int[]{57, 18, 91, 12}, new int[]{7, 5, 10, 28}, new int[]{1, 3}),
                Arguments.of(new int[]{21}, new int[]{22}, new int[]{1}),
                Arguments.of(new int[]{46, 69, 84, 47, 22, 32, 71}, new int[]{7, 19, 29, 23, 8, 1, 12}, new int[]{4, 1, 2}),
                Arguments.of(new int[]{18, 95}, new int[]{12, 20}, new int[]{2}),
                Arguments.of(new int[]{51, 73, 45, 93, 83}, new int[]{22, 23, 21, 27, 28}, new int[]{5}),
                Arguments.of(new int[]{65, 88, 1}, new int[]{4, 19, 21}, new int[]{3}),
                Arguments.of(new int[]{98, 76}, new int[]{5, 15}, new int[]{1, 1}),
                Arguments.of(new int[]{14, 54, 43, 44}, new int[]{30, 28, 2, 8}, new int[]{2, 2})
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] progresses, int[] speeds, int[] expected) {
        assertArrayEquals(expected, solution(progresses, speeds));
    }
}
