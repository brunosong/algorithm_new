package com.brunosong.algorithm_new.연습.week2;

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
 * [문제] 전력망나누기 (11-27, DFS, BFS)
 * 비슷한 원래 문제: 프로그래머스 "전력망을 둘로 나누기". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=전력망나누기
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 송전탑 n개(1번 ~ n번)가 전선 n-1개로 트리 모양으로 이어져 있습니다. wires[i]는 [a, b]로, a번과 b번이 전선으로 이어져 있다는 뜻입니다.
 * 전선 하나를 끊으면 송전탑이 두 묶음으로 나뉩니다. 두 묶음의 송전탑 수 차이가 가장 작아지도록 끊을 때, 그 차이를 return 해 주세요.
 *
 * [제한사항]
 * - n은 2 이상 100 이하입니다.
 * - wires의 길이는 n-1이고, 모든 송전탑이 하나로 이어져 있습니다.
 *
 * [입출력 예]
 *   입력                                                   result
 *   6, {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}}            0
 *   5, {{1, 2}, {1, 3}, {1, 4}, {1, 5}}                    3
 *   7, {{1, 2}, {2, 3}, {2, 4}, {4, 5}, {4, 6}, {6, 7}}    1
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 3번과 4번 사이를 끊으면 3개, 3개로 나뉘어 차이가 0입니다. 입출력 예 #2는 어느 전선을 끊어도 1개, 4개라서 3입니다.
 */
public class 전력망나누기 {

    public int solution(int n, int[][] wires) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            int left = wires[i][0];
            int right = wires[i][1];

            list.get(left).add(right);
            list.get(right).add(left);
        }

        int best = n;
        for (int[] cut : wires) {
            int count = count(1, list, new boolean[n + 1], cut);
            int other = n - count;
            int diff = Math.abs(count - other);
            best = Math.min(best, diff);
        }

        return best;
    }

    public int count(int num, List<List<Integer>> list, boolean[] b, int[] cut) {
        int cnt = 1;
        b[num] = true;
        for (int nextLine : list.get(num)) {
            if (b[nextLine]) continue;
            if ((num == cut[0] && nextLine == cut[1]) || (num == cut[1] && nextLine == cut[0])) continue;
            cnt += count(nextLine, list, b, cut);
        }

        return cnt;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(0, solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}})); }
    @Test void 예제2() { assertEquals(3, solution(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}})); }
    @Test void 예제3() { assertEquals(1, solution(7, new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}, {4, 6}, {6, 7}})); }
    @Test void 두개() { assertEquals(0, solution(2, new int[][]{{1, 2}})); }
    @Test @Timeout(2) void 큰입력_일자() {
        int[][] w = new int[99][]; for (int i = 0; i < 99; i++) w[i] = new int[]{i + 1, i + 2};
        assertEquals(0, solution(100, w));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(7, new int[][]{{7, 1}, {2, 6}, {5, 4}, {2, 3}, {4, 2}, {7, 3}}, 1),
                Arguments.of(2, new int[][]{{2, 1}}, 0),
                Arguments.of(5, new int[][]{{2, 1}, {4, 1}, {5, 2}, {3, 5}}, 1),
                Arguments.of(5, new int[][]{{1, 2}, {4, 1}, {2, 3}, {3, 5}}, 1),
                Arguments.of(10, new int[][]{{10, 8}, {8, 6}, {9, 1}, {3, 2}, {3, 8}, {1, 8}, {2, 4}, {2, 7}, {2, 5}}, 0),
                Arguments.of(13, new int[][]{{11, 12}, {6, 5}, {9, 7}, {10, 1}, {7, 13}, {8, 7}, {4, 2}, {4, 3}, {10, 6}, {1, 3}, {3, 7}, {11, 1}}, 1),
                Arguments.of(15, new int[][]{{9, 12}, {8, 11}, {4, 6}, {7, 8}, {15, 5}, {11, 1}, {7, 6}, {8, 13}, {2, 15}, {6, 5}, {6, 12}, {14, 12}, {10, 4}, {10, 3}}, 5),
                Arguments.of(15, new int[][]{{11, 15}, {12, 15}, {2, 14}, {12, 13}, {6, 12}, {15, 9}, {5, 12}, {7, 4}, {1, 14}, {13, 3}, {13, 8}, {1, 13}, {7, 13}, {10, 4}}, 3),
                Arguments.of(14, new int[][]{{1, 10}, {3, 9}, {11, 8}, {14, 2}, {5, 11}, {6, 9}, {3, 7}, {11, 3}, {4, 2}, {2, 3}, {9, 12}, {1, 3}, {13, 11}}, 6),
                Arguments.of(7, new int[][]{{3, 5}, {2, 1}, {2, 6}, {3, 2}, {7, 2}, {3, 4}}, 1),
                Arguments.of(11, new int[][]{{7, 9}, {3, 1}, {4, 6}, {2, 5}, {2, 1}, {4, 2}, {7, 2}, {4, 10}, {11, 5}, {8, 5}}, 5),
                Arguments.of(4, new int[][]{{1, 4}, {1, 3}, {2, 4}}, 0),
                Arguments.of(5, new int[][]{{4, 3}, {5, 4}, {1, 4}, {4, 2}}, 3),
                Arguments.of(8, new int[][]{{6, 5}, {3, 7}, {4, 7}, {1, 7}, {6, 8}, {2, 6}, {4, 8}}, 0),
                Arguments.of(15, new int[][]{{10, 7}, {13, 9}, {5, 8}, {15, 5}, {5, 4}, {14, 1}, {2, 8}, {6, 5}, {11, 15}, {9, 7}, {13, 8}, {14, 8}, {14, 3}, {12, 8}}, 5),
                Arguments.of(4, new int[][]{{1, 4}, {4, 3}, {2, 3}}, 0),
                Arguments.of(5, new int[][]{{4, 2}, {2, 3}, {5, 2}, {3, 1}}, 1),
                Arguments.of(8, new int[][]{{3, 7}, {8, 4}, {2, 1}, {3, 1}, {7, 5}, {8, 3}, {6, 4}}, 2),
                Arguments.of(8, new int[][]{{8, 1}, {4, 2}, {2, 8}, {4, 6}, {7, 4}, {5, 7}, {5, 3}}, 2),
                Arguments.of(15, new int[][]{{6, 1}, {9, 2}, {6, 5}, {3, 9}, {11, 3}, {15, 13}, {6, 9}, {1, 14}, {12, 13}, {14, 12}, {5, 7}, {10, 4}, {6, 8}, {4, 1}}, 1),
                Arguments.of(12, new int[][]{{3, 12}, {1, 2}, {11, 8}, {6, 3}, {9, 7}, {10, 11}, {7, 5}, {6, 9}, {11, 3}, {11, 4}, {2, 4}}, 0),
                Arguments.of(10, new int[][]{{5, 9}, {8, 5}, {8, 6}, {4, 10}, {5, 7}, {4, 2}, {10, 1}, {2, 5}, {2, 3}}, 0),
                Arguments.of(15, new int[][]{{2, 10}, {9, 3}, {6, 4}, {6, 10}, {8, 10}, {5, 6}, {13, 7}, {10, 3}, {11, 13}, {12, 4}, {15, 5}, {10, 13}, {1, 3}, {14, 4}}, 3),
                Arguments.of(8, new int[][]{{5, 3}, {3, 7}, {1, 4}, {2, 5}, {6, 5}, {8, 7}, {3, 1}}, 2),
                Arguments.of(9, new int[][]{{3, 8}, {3, 2}, {1, 5}, {5, 6}, {9, 4}, {7, 3}, {1, 2}, {4, 5}}, 1)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int n, int[][] wires, int expected) {
        assertEquals(expected, solution(n, wires));
    }
}
