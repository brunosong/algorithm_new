package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 청소 {

    @Test
    void test() {
        int[][] board = {
                {0,0,0,0,0},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,0,1,0,1},
                {0,0,0,0,0}
        };      // k=10, answer = [2,2]

        Assertions.assertThat(solution(10,board)).containsExactly(2,2);

        int[][] board2 = {
                {0,0,0,1,0,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1},
                {1,1,0,0,1,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };      // k=20, answer = [4,5]

        Assertions.assertThat(solution(20,board2)).containsExactly(4,5);

    }


    public int[] solution(int k, int[][] board) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;

        int boardXSize = board[0].length - 1;
        int boardYSize = board.length - 1;

        // 위 앞 아래 뒤  ( 행(row) : x , 열(컬럼): y )
        int[] dx = { -1,0,1,0 };
        int[] dy = {  0,1,0,-1};

        // 가야할 방향은 오른쪽
        int drivingPosition = 1;

        while (k != 0) {

            int nx = x + dx[drivingPosition];
            int ny = y + dy[drivingPosition];

            if((nx <= boardXSize && ny <= boardYSize) && (nx >= 0 && ny >= 0) && board[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                drivingPosition = (drivingPosition + 1) % 4;
            }
            k--;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }




}
