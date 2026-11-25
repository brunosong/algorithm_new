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
 * [문제] 구역합계 (11-25, DFS)
 * 비슷한 원래 문제: 프로그래머스 "무인도 여행" (레벨 2). 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=구역합계
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 지도 maps가 문자열 배열로 주어집니다. 'X'는 빈칸이고, '1'~'9' 숫자는 그 칸에 있는 사과 개수입니다.
 * 숫자 칸끼리 상하좌우로 붙어 있으면 같은 구역입니다. 구역마다 사과 개수를 모두 더한 값을
 * 작은 것부터 순서대로 담아 return 해 주세요. 숫자 칸이 하나도 없으면 [-1]입니다.
 *
 * [제한사항]
 * - maps의 행 수와 열 수는 1 이상 50 이하입니다.
 * - 모든 행의 길이는 같고, 'X'와 '1'~'9'로만 이루어져 있습니다.
 *
 * [입출력 예]
 *   maps                                   result
 *   { "X591X",
     * "X1X5X",
     * "X231X",
     * "1XXX1"}   {1, 1, 27}
 *   {"XXX", "XXX", "XXX"}                  {-1}-
 *   {"1X1", "X1X", "1X1"}                  {1, 1, 1, 1, 1}
 *
 * [입출력 예 설명]
 * 입출력 예 #1: 가운데 큰 구역은 5+9+1+1+5+2+3+1 = 27이고, 맨 아래 양쪽 끝 '1'은 각각 따로 떨어진 구역입니다.
 * 입출력 예 #3: 대각선은 붙은 것으로 보지 않아 1짜리 구역이 5개입니다.
 */
public class 구역합계 {

    private int sum = 0;

    private int[] driveCol = {0,1,0,-1};
    private int[] driveRow = {-1,0,1,0 };

    public int[] solution(String[] maps) {
        // 여기에 풀이를 작성합니다.
        String[][] maps2 = new String[maps.length][maps[0].split("").length];

        for (int i = 0; i < maps.length; i++) {
            String[] split = maps[i].split("");
            for (int j = 0; j < split.length; j++) {
                maps2[i][j] = split[j];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < maps2.length; i++) {
            for (int j = 0; j < maps2[i].length; j++) {
                if (!maps2[i][j].equals("X")) {
                    sum = 0;
                    dfs(i,j, maps2);
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);

        Integer[] array = list.stream().toArray(Integer[]::new);

        if (list.isEmpty()) return new int[]{-1};

        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();

    }

    public void dfs(int row, int col, String[][] maps) {

        if (maps[row][col].equals("X")) {
            return;
        } else {

            sum += Integer.parseInt(maps[row][col]);
            maps[row][col] = "X";

            for (int i = 0; i < 4; i++) {
                int nextCol = driveCol[i] + col;
                int nextRow = driveRow[i] + row;

                if (nextRow >= 0 && nextRow < maps.length && nextCol >= 0 &&
                        nextCol < maps[nextRow].length && !maps[nextRow][nextCol].equals("X")) {
                    dfs(nextRow, nextCol, maps);
                }
            }
        }

    }

    // ================= 솔루션 2 (더 깔끔한 방법) =================
    // 내 풀이와 같은 아이디어(들른 칸을 'X'로 바꿔서 방문 표시)를 쓰되,
    // 1) split("") 대신 toCharArray()로 char 2차원 배열을 만들고
    // 2) sum 필드 대신 dfs가 "이 구역의 합계"를 return 하도록 했습니다.
    //    → 필드를 0으로 초기화하는 걸 잊을 걱정이 없습니다.

    // 상, 우, 하, 좌로 한 칸 움직일 때 행/열이 얼마나 바뀌는지
    private int[] moveRow2 = {-1, 0, 1, 0};
    private int[] moveCol2 = {0, 1, 0, -1};

    public int[] solution2(String[] maps) {
        // 문자열 배열 → char 2차원 배열 (칸을 'X'로 바꿀 수 있게)
        char[][] grid = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            grid[i] = maps[i].toCharArray();
        }

        // 구역마다 사과 합계를 모아 둘 리스트
        List<Integer> sums = new ArrayList<>();

        // 지도를 왼쪽 위부터 한 칸씩 본다
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                // 빈칸이거나 이미 들른 칸('X'로 바꿔 둠)이면 건너뛴다
                if (grid[row][col] == 'X') {
                    continue;
                }

                // 새 구역을 찾았다 → 이어진 칸을 전부 돌고 합계를 받아 온다
                int sum = dfs2(grid, row, col);
                sums.add(sum);
            }
        }

        // 구역이 하나도 없으면 [-1]
        if (sums.isEmpty()) {
            return new int[]{-1};
        }

        // 작은 것부터 정렬해서 int 배열로 옮긴다
        Collections.sort(sums);
        int[] answer = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            answer[i] = sums.get(i);
        }
        return answer;
    }

    // (row, col)에서 시작해 이어진 숫자 칸을 전부 들르고, 그 사과 합계를 돌려준다
    private int dfs2(char[][] grid, int row, int col) {
        // 지금 칸의 사과 개수 ('7' 문자 → 7 숫자)
        int sum = grid[row][col] - '0';

        // 들렀다고 표시 (다시 세지 않게)
        grid[row][col] = 'X';

        // 상우하좌 네 방향을 하나씩 본다
        for (int dir = 0; dir < 4; dir++) {
            int nextRow = row + moveRow2[dir];
            int nextCol = col + moveCol2[dir];

            // 지도 밖이면 건너뛴다
            if (nextRow < 0 || nextRow >= grid.length) {
                continue;
            }
            if (nextCol < 0 || nextCol >= grid[nextRow].length) {
                continue;
            }
            // 빈칸이거나 이미 들른 칸이면 건너뛴다
            if (grid[nextRow][nextCol] == 'X') {
                continue;
            }

            // 옆 칸으로 가서, 거기서 모아 온 합계를 더한다
            sum = sum + dfs2(grid, nextRow, nextCol);
        }
        return sum;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertArrayEquals(new int[]{1, 1, 27}, solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})); }
    @Test void 예제2() { assertArrayEquals(new int[]{-1}, solution(new String[]{"XXX", "XXX", "XXX"})); }
    @Test void 예제3() { assertArrayEquals(new int[]{1, 1, 1, 1, 1}, solution(new String[]{"1X1", "X1X", "1X1"})); }
    @Test void 한칸() { assertArrayEquals(new int[]{7}, solution(new String[]{"7"})); }
    @Test @Timeout(2) void 큰입력_전부한구역() {
        String[] m = new String[50]; Arrays.fill(m, "9".repeat(50));
        assertArrayEquals(new int[]{22500}, solution(m));
    }
    @Test @Timeout(2) void 큰입력_체크무늬() {
        String[] m = new String[50];
        for (int i = 0; i < 50; i++) { StringBuilder sb = new StringBuilder(); for (int j = 0; j < 50; j++) sb.append((i + j) % 2 == 0 ? '9' : 'X'); m[i] = sb.toString(); }
        int[] e = new int[1250]; Arrays.fill(e, 9);
        assertArrayEquals(e, solution(m));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new String[]{"2XXXX91", "6X4XXX2"}, new int[]{4, 8, 12}),
                Arguments.of(new String[]{"88X25"}, new int[]{7, 16}),
                Arguments.of(new String[]{"188X956", "51X8559", "2199136", "187774X"}, new int[]{135}),
                Arguments.of(new String[]{"XXXXXXX", "7X6XXX6", "XXXXXXX", "3XXXX7X", "X3XX487"}, new int[]{3, 3, 6, 6, 7, 26}),
                Arguments.of(new String[]{"X335"}, new int[]{11}),
                Arguments.of(new String[]{"1X2X864", "X852X1X", "14XX87X"}, new int[]{1, 22, 34}),
                Arguments.of(new String[]{"69", "2X", "X9", "69"}, new int[]{17, 24}),
                Arguments.of(new String[]{"7XX", "5XX", "6XX", "3XX"}, new int[]{21}),
                Arguments.of(new String[]{"23", "44"}, new int[]{13}),
                Arguments.of(new String[]{"XXX65XX", "X4XX1XX", "XXX19X9"}, new int[]{4, 9, 22}),
                Arguments.of(new String[]{"X9X", "999", "XX5", "X88"}, new int[]{57}),
                Arguments.of(new String[]{"2X"}, new int[]{2}),
                Arguments.of(new String[]{"XX6XX", "XX875", "88331"}, new int[]{49}),
                Arguments.of(new String[]{"XX", "X2", "X5", "X3", "3X"}, new int[]{3, 10}),
                Arguments.of(new String[]{"XXX1", "XXX3"}, new int[]{4}),
                Arguments.of(new String[]{"26X", "1XX", "93X", "6X4"}, new int[]{4, 27}),
                Arguments.of(new String[]{"31", "X8", "XX", "X8", "XX", "XX"}, new int[]{8, 12}),
                Arguments.of(new String[]{"163X2XX", "X2424XX", "448XX1X"}, new int[]{1, 40}),
                Arguments.of(new String[]{"X4X", "X61", "XX9", "XXX", "2X7", "XX3"}, new int[]{2, 10, 20}),
                Arguments.of(new String[]{"8", "X", "6", "3", "7"}, new int[]{8, 16}),
                Arguments.of(new String[]{"8", "3", "X", "X"}, new int[]{11}),
                Arguments.of(new String[]{"XXXXXX1", "98X6528", "X55X9XX", "35X3XX2"}, new int[]{2, 3, 31, 35}),
                Arguments.of(new String[]{"232", "86X"}, new int[]{21}),
                Arguments.of(new String[]{"X6X"}, new int[]{6}),
                Arguments.of(new String[]{"X9X3", "X1XX", "3X67", "2X9X"}, new int[]{3, 5, 10, 22})
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(String[] maps, int[] expected) {
        assertArrayEquals(expected, solution(maps));
    }
}
