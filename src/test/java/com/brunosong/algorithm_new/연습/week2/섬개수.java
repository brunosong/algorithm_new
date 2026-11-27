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
 * [문제] 섬개수 (11-27, DFS, BFS)
 * 비슷한 원래 문제: LeetCode 200 "Number of Islands". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=섬개수
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 지도 grid가 문자열 배열로 주어집니다. '1'은 땅, '0'은 바다입니다. 상하좌우로 붙어 있는 땅은 같은 섬입니다.
 * [섬의 개수, 가장 큰 섬의 칸 수]를 return 해 주세요. 땅이 없으면 [0, 0]입니다.
 *
 * [제한사항]
 * - grid의 행 수와 열 수는 1 이상 100 이하입니다.
 * - 모든 행의 길이는 같습니다.
 * - 섬 하나가 10,000칸까지 클 수 있습니다. 재귀로 풀면 호출 깊이를 생각해 봅니다.
 *
 * [입출력 예]
 *   입력                           result
 *   {"11000", "11011", "00010"}    {2, 4}
 *   {"101", "010", "101"}          {5, 1}
 *   {"000"}                        {0, 0}
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 왼쪽 위 4칸짜리 섬과 오른쪽 3칸짜리 섬이 있습니다. 입출력 예 #2는 대각선은 붙은 것으로 보지 않아 1칸짜리 섬이 5개입니다.
 */
public class 섬개수 {

    int[] driveRow = {-1,0,1,0};
    int[] driveCol = {0,1,0,-1};

    public int[] solution(String[] grid) {

        boolean check = false;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i].contains("0")) {
                check = true;
                break;
            }
        }

        if (!check) {
            return new int[]{1, grid.length * grid[0].length()};
        }

        // 여기에 풀이를 작성합니다.
        char[][] gridChar = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            gridChar[i] = grid[i].toCharArray();
        }

        int cnt = 0;
        int max = 0;
        for (int i = 0; i < gridChar.length; i++) {
            for (int j = 0; j < gridChar[i].length; j++) {
                if (gridChar[i][j] == '1') {
                    cnt++;
                    max = Math.max(bfs(i,j,gridChar), max);
                }
            }
        }
        return new int[]{cnt, max};
    }

    public int bfs(int row, int col, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = '0';

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nextRow = driveRow[i] + current[0];
                int nextCol = driveCol[i] + current[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length &&
                        grid[nextRow][nextCol] == '1') {
                    grid[nextRow][nextCol] = '0';
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return cnt;
    }




    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertArrayEquals(new int[]{2, 4}, solution(new String[]{"11000", "11011", "00010"})); }
    @Test void 예제2() { assertArrayEquals(new int[]{5, 1}, solution(new String[]{"101", "010", "101"})); }
    @Test void 예제3() { assertArrayEquals(new int[]{0, 0}, solution(new String[]{"000"})); }
    @Test void 한칸땅() { assertArrayEquals(new int[]{1, 1}, solution(new String[]{"1"})); }
    @Test @Timeout(2) void 큰입력_다땅() {
        String[] g = new String[100]; Arrays.fill(g, "1".repeat(100));
        assertArrayEquals(new int[]{1, 10000}, solution(g));
    }
    @Test @Timeout(2) void 큰입력_바둑판() {
        String[] g = new String[100];
        for (int i = 0; i < 100; i++) g[i] = (i % 2 == 0 ? "10" : "01").repeat(50);
        assertArrayEquals(new int[]{5000, 1}, solution(g));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new String[]{"011", "000"}, new int[]{1, 2}),
                Arguments.of(new String[]{"111", "111", "001", "110", "001", "010", "100", "001"}, new int[]{6, 7}),
                Arguments.of(new String[]{"101"}, new int[]{2, 1}),
                Arguments.of(new String[]{"01000", "00101", "11010"}, new int[]{5, 2}),
                Arguments.of(new String[]{"111001", "101000"}, new int[]{2, 5}),
                Arguments.of(new String[]{"1110", "1011", "1010", "0010", "0011", "1110"}, new int[]{1, 14}),
                Arguments.of(new String[]{"0110"}, new int[]{1, 2}),
                Arguments.of(new String[]{"1", "0", "0", "1", "1"}, new int[]{2, 2}),
                Arguments.of(new String[]{"1111", "0011", "0000"}, new int[]{1, 6}),
                Arguments.of(new String[]{"010", "111"}, new int[]{1, 4}),
                Arguments.of(new String[]{"0000010", "0100000", "1001100"}, new int[]{4, 2}),
                Arguments.of(new String[]{"01100", "01000", "00010", "11011", "11001", "01111", "11010"}, new int[]{2, 15}),
                Arguments.of(new String[]{"0000", "1111", "0100", "1011", "0000", "1000", "0010", "1100"}, new int[]{6, 5}),
                Arguments.of(new String[]{"0011111", "0101001", "1111110", "1111111"}, new int[]{1, 21}),
                Arguments.of(new String[]{"1011101", "1111000", "0000110", "1011110", "0001001", "1000011"}, new int[]{6, 8}),
                Arguments.of(new String[]{"1100", "1101", "0010", "0010", "1000"}, new int[]{4, 4}),
                Arguments.of(new String[]{"01010", "00111", "01100"}, new int[]{2, 6}),
                Arguments.of(new String[]{"00100000", "00111000", "10100000", "00011000", "00000101", "10001100", "00000010"}, new int[]{7, 5}),
                Arguments.of(new String[]{"11110000"}, new int[]{1, 4}),
                Arguments.of(new String[]{"1", "0", "0"}, new int[]{1, 1}),
                Arguments.of(new String[]{"10000", "11010", "00101", "01000", "01111", "00101", "01011"}, new int[]{6, 9}),
                Arguments.of(new String[]{"10011", "00001", "10010", "10000", "10110"}, new int[]{5, 3}),
                Arguments.of(new String[]{"0"}, new int[]{0, 0}),
                Arguments.of(new String[]{"0", "1"}, new int[]{1, 1}),
                Arguments.of(new String[]{"11", "00", "00", "00", "10", "00", "10"}, new int[]{3, 2})
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(String[] grid, int[] expected) {
        assertArrayEquals(expected, solution(grid));
    }
}
