package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 잃어버린강아지_2 {

    @Test
    void test() {

        int[][] board1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        Assertions.assertThat(solution(board1)).isEqualTo(51);

        int[][] board2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};

        Assertions.assertThat(solution(board2)).isEqualTo(17);
    }

    public int solution(int[][] board) {
        int answer = 0;

        int n = 10;
        int m = 10;

        int[] pPosition = new int[2];
        int[] dPosition = new int[2];

        //현수와 강아지 위치 찾기
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 2) {
                    pPosition[0] = x;
                    pPosition[1] = y;
                } else if (board[x][y] == 3) {
                    dPosition[0] = x;
                    dPosition[1] = y;
                }
            }
        }

        int[] dx = { -1,0,1,0 };
        int[] dy = {  0,1,0,-1};

        // 출발은 북쪽
        int pDirection = 0;
        int dDirection = 0;

        int time = 1;
        for (int i = 1; i <= 10000; i++) {

            //현수
            int pDx = pPosition[0] + dx[pDirection];
            int pDy = pPosition[1] + dy[pDirection];

            //강아지
            int dDx = dPosition[0] + dx[dDirection];
            int dDy = dPosition[1] + dy[dDirection];

            if (pDx >= 0 && pDx < n && pDy >= 0 && pDy < m && board[pDx][pDy] != 1) {
                pPosition[0] = pDx;
                pPosition[1] = pDy;
            } else {
                pDirection = (pDirection + 1) % 4;
            }

            if (dDx >= 0 && dDx < n && dDy >= 0 && dDy < m && board[dDx][dDy] != 1) {
                dPosition[0] = dDx;
                dPosition[1] = dDy;
            } else {
                dDirection = (dDirection + 1) % 4;
            }

            if ((pPosition[0] == dPosition[0]) && (pPosition[1] == dPosition[1])) {
                break;
            }

            time++;
        }

        if(time >= 10000) return 0;

        return time;
    }



}
