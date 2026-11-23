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
 * [문제] 최소회의실 (11-20, 힙)
 * 비슷한 원래 문제: 백준 19598 "최소 회의실 개수", LeetCode 253. 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=최소회의실
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 회의 목록 meetings[i] = [시작 시각, 끝 시각]이 주어집니다. 한 회의실에서는 회의가 겹치면 안 됩니다.
 * 어떤 회의가 끝나는 시각에 다른 회의가 바로 시작하는 것은 같은 회의실에서 할 수 있습니다.
 * 모든 회의를 하는 데 필요한 회의실의 최소 개수를 return 해 주세요.
 *
 * [제한사항]
 * - meetings의 길이는 1 이상 100,000 이하입니다.
 * - 0 이상 시작 시각 < 끝 시각 이하 1,000,000,000 입니다.
 *
 * [입출력 예]
 *   meetings                          result
 *   [[1,4],[2,5],[7,9],[4,7]]         2
 *   [[1,2],[2,3],[3,4]]               1
 *   [[1,10],[2,9],[3,8]]              3
 */
public class 최소회의실 {

    public int solution(int[][] meetings) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : meetings) {
            list.add(new int[]{arr[0], 0}); // IN
            list.add(new int[]{arr[1], 1}); // OUT
        }

        Collections.sort(list, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int max = 0;
        int cnt = 0;
        for (int[] arr : list) {
            if (arr[1] == 0) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt--;
            }
        }

        return max;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(2, solution(new int[][]{{1, 4}, {2, 5}, {7, 9}, {4, 7}})); }
    @Test void 예제2_딱붙음() { assertEquals(1, solution(new int[][]{{1, 2}, {2, 3}, {3, 4}})); }
    @Test void 예제3_다겹침() { assertEquals(3, solution(new int[][]{{1, 10}, {2, 9}, {3, 8}})); }
    @Test @Timeout(2) void 큰입력_둘씩겹침() {
        int n = 100_000; int[][] m = new int[n][];
        for (int i = 0; i < n; i++) m[i] = new int[]{i, i + 2};
        assertEquals(2, solution(m));
    }
    @Test @Timeout(2) void 큰입력_전부겹침() {
        int n = 100_000; int[][] m = new int[n][];
        for (int i = 0; i < n; i++) m[i] = new int[]{0, 1};
        assertEquals(n, solution(m));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[][]{{9, 13}, {6, 11}, {1, 2}, {9, 15}}, 3),
                Arguments.of(new int[][]{{8, 12}, {8, 10}, {5, 9}, {3, 6}, {2, 5}, {3, 9}, {7, 8}}, 4),
                Arguments.of(new int[][]{{2, 5}, {9, 12}, {9, 10}, {8, 14}}, 3),
                Arguments.of(new int[][]{{0, 5}, {4, 8}, {5, 7}, {7, 10}}, 2),
                Arguments.of(new int[][]{{6, 8}, {10, 12}, {6, 10}, {10, 14}, {4, 9}, {1, 6}}, 3),
                Arguments.of(new int[][]{{3, 7}, {3, 8}, {0, 1}, {2, 3}, {6, 9}, {9, 15}, {10, 16}}, 3),
                Arguments.of(new int[][]{{10, 14}, {1, 4}}, 1),
                Arguments.of(new int[][]{{6, 8}, {7, 13}, {3, 8}, {7, 11}}, 4),
                Arguments.of(new int[][]{{8, 14}, {8, 13}}, 2),
                Arguments.of(new int[][]{{6, 9}, {1, 5}, {2, 5}, {10, 15}, {5, 8}, {1, 3}, {4, 6}}, 3),
                Arguments.of(new int[][]{{7, 9}, {6, 11}, {5, 11}}, 3),
                Arguments.of(new int[][]{{5, 6}, {9, 11}, {0, 5}, {10, 15}, {5, 6}, {1, 3}, {3, 5}}, 2),
                Arguments.of(new int[][]{{4, 8}, {3, 6}, {6, 7}, {7, 10}}, 2),
                Arguments.of(new int[][]{{9, 15}, {10, 12}, {6, 10}, {5, 7}, {7, 10}}, 3),
                Arguments.of(new int[][]{{0, 5}, {4, 9}, {6, 8}, {6, 9}}, 3),
                Arguments.of(new int[][]{{1, 6}, {9, 13}, {9, 10}, {4, 10}}, 3),
                Arguments.of(new int[][]{{1, 2}, {6, 10}}, 1),
                Arguments.of(new int[][]{{3, 4}, {8, 10}, {6, 7}, {1, 2}}, 1),
                Arguments.of(new int[][]{{9, 10}, {6, 9}, {3, 9}}, 2),
                Arguments.of(new int[][]{{0, 4}, {5, 8}, {9, 12}, {10, 15}, {4, 7}, {2, 7}}, 3),
                Arguments.of(new int[][]{{5, 6}, {0, 5}, {8, 13}, {10, 11}, {5, 10}, {9, 11}, {10, 12}}, 4),
                Arguments.of(new int[][]{{1, 7}, {1, 6}, {1, 3}, {3, 5}}, 3),
                Arguments.of(new int[][]{{4, 10}, {7, 10}, {4, 5}, {10, 16}}, 2),
                Arguments.of(new int[][]{{1, 6}, {5, 7}, {1, 5}, {1, 7}, {4, 5}}, 4),
                Arguments.of(new int[][]{{9, 15}, {5, 10}, {4, 8}, {1, 4}, {9, 11}, {9, 12}, {10, 13}}, 4)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[][] meetings, int expected) {
        assertEquals(expected, solution(meetings));
    }
}
