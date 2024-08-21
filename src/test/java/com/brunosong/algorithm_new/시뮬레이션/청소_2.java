package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 청소_2 {

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

        int x = 0, y = 0;

        int[] dx = {0,1, 0,-1};
        int[] dy = {1,0,-1, 0};

        int direction = 0;

        for (int i = 1; i <= k; i++) {

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                direction = (direction + 1) % 4;
            }
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }



}
