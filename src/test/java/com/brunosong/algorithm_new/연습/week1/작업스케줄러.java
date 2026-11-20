package com.brunosong.algorithm_new.연습.week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 작업스케줄러 (11-19, 힙)
 * 비슷한 원래 문제: 프로그래머스 "디스크 컨트롤러". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=작업스케줄러
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 작업 요청이 jobs[i] = [요청 시각, 소요 시간]으로 주어집니다. 처리기는 한 번에 한 작업만 하고, 시작한 작업은 끝까지 합니다.
 * 처리기가 비어 있을 때 이미 요청된 작업이 있으면 그중 소요 시간이 가장 짧은 것부터 합니다.
 * 소요 시간이 같으면 요청 시각이 빠른 것, 그것도 같으면 번호가 작은 것을 먼저 합니다. 요청된 작업이 없으면 다음 요청까지 기다립니다.
 * 각 작업의 (끝난 시각 - 요청 시각)의 평균을 소수점 아래를 버린 정수로 return 해 주세요.
 *
 * [제한사항]
 * - jobs의 길이는 1 이상 500 이하입니다.
 * - 요청 시각은 0 이상 1,000 이하, 소요 시간은 1 이상 1,000 이하입니다.
 *
 * [입출력 예]
 *   jobs                        result
 *   [[0,4],[2,1],[3,2]]         3
 *   [[0,1],[5,2]]               1
 *   [[1,3],[1,1],[1,2]]         3
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 0초에 0번(4초)을 시작해 4초에 끝납니다. 그때 1번(1초), 2번(2초)이 기다리고 있어 1번, 2번 순서로 합니다.
 * 걸린 시간은 4, 3, 4이고 평균 11 / 3을 버리면 3입니다.
 */
public class 작업스케줄러 {

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, (a,b) -> a[0] - b[0]); //요청시각순
        PriorityQueue<int[]> wait = new PriorityQueue<>((a,b) -> {
            return a[1] != b[1] ? a[1] - b[1] : a[0] - b[0];  // 짧은 것 먼저
        });

        int done = 0, result = 0, time = 0, i = 0;
        while (done < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= time) wait.add(jobs[i++]);
            if (wait.isEmpty()) {
                time = jobs[i][0];
                continue;
            }
            int[] job = wait.poll();
            time += job[1];
            result += time - job[0];
            done++;
        }

        return result / jobs.length;
    }

//    public int solution(int[][] jobs) {
//        // 여기에 풀이를 작성합니다.
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
//            if (a[0] == b[0]) {
//                return a[1] - b[1];
//            }
//            return a[0] - b[0];
//        });
//
//        for (int i = 0; i < jobs.length; i++) {
//            queue.add(new int[]{jobs[i][0], jobs[i][1]});
//        }
//
//        int endTime = 0;
//
//        int result = 0;
//        for (int time = 0; time < 1000; time++) {
//            if (queue.isEmpty()) break;
//            while (!queue.isEmpty() && queue.peek()[0] == time) {
//                int[] poll = queue.poll();
//                // 요청시간
//                int requestTime = poll[0];
//                int processTime = poll[1];
//
//                if (endTime <= requestTime) {
//                    endTime = requestTime;
//                }
//
//                endTime += processTime;
//
//                result += endTime - requestTime;
//            }
//        }
//
//        return result / jobs.length;
//    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(3, solution(new int[][]{{0, 4}, {2, 1}, {3, 2}})); }
    @Test void 예제2_쉬는시간() { assertEquals(1, solution(new int[][]{{0, 1}, {5, 2}})); }
    @Test void 예제3_동시요청() { assertEquals(3, solution(new int[][]{{1, 3}, {1, 1}, {1, 2}})); }
    @Test void 하나() { assertEquals(5, solution(new int[][]{{3, 5}})); }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {9, 6}}, 4),
                Arguments.of(new int[][]{{9, 6}, {2, 1}, {6, 2}, {2, 5}, {6, 1}}, 4),
                Arguments.of(new int[][]{{10, 1}, {0, 6}, {2, 1}, {3, 2}, {10, 5}}, 4),
                Arguments.of(new int[][]{{4, 1}, {5, 4}}, 2),
                Arguments.of(new int[][]{{9, 6}, {7, 6}}, 8),
                Arguments.of(new int[][]{{2, 3}, {1, 2}, {1, 1}, {10, 4}, {0, 1}}, 2),
                Arguments.of(new int[][]{{6, 2}, {5, 4}, {1, 1}}, 3),
                Arguments.of(new int[][]{{6, 3}, {6, 3}, {3, 1}}, 3),
                Arguments.of(new int[][]{{8, 3}, {7, 4}, {8, 6}, {3, 5}, {10, 5}, {0, 1}}, 7),
                Arguments.of(new int[][]{{2, 5}, {2, 2}}, 4),
                Arguments.of(new int[][]{{10, 4}, {1, 4}, {8, 3}, {0, 4}, {9, 3}}, 5),
                Arguments.of(new int[][]{{9, 1}, {1, 5}}, 3),
                Arguments.of(new int[][]{{10, 5}, {7, 3}, {5, 3}, {6, 1}, {3, 4}, {8, 5}}, 7),
                Arguments.of(new int[][]{{4, 3}}, 3),
                Arguments.of(new int[][]{{0, 3}, {9, 3}, {8, 3}, {8, 5}, {3, 5}}, 5),
                Arguments.of(new int[][]{{6, 6}, {2, 6}, {2, 1}}, 5),
                Arguments.of(new int[][]{{1, 5}, {5, 6}, {10, 5}, {7, 6}}, 8),
                Arguments.of(new int[][]{{10, 6}}, 6),
                Arguments.of(new int[][]{{4, 1}, {5, 1}}, 1),
                Arguments.of(new int[][]{{5, 6}, {3, 2}, {10, 4}, {7, 4}, {0, 1}}, 5),
                Arguments.of(new int[][]{{10, 4}, {5, 1}}, 2),
                Arguments.of(new int[][]{{7, 3}, {9, 2}}, 3),
                Arguments.of(new int[][]{{10, 4}, {2, 4}}, 4),
                Arguments.of(new int[][]{{6, 2}, {0, 5}, {3, 6}, {10, 2}, {2, 4}, {6, 2}}, 7),
                Arguments.of(new int[][]{{1, 1}, {10, 3}, {6, 6}, {2, 6}, {7, 4}, {3, 4}}, 8)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[][] jobs, int expected) {
        assertEquals(expected, solution(jobs));
    }
}
