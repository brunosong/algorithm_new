package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 청소3 {

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

        int time = 0;

        int[] dRow = {-1,0,1, 0};
        int[] dCol = { 0,1,0,-1};

        // 현재 방향
        int currentView = 1;

        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < k; i++) {

            int nextRow = currentRow + dRow[currentView];
            int nextCol = currentCol + dCol[currentView];

            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length
                     && board[nextRow][nextCol] == 0) {
                currentRow = nextRow;
                currentCol = nextCol;
            } else {
                currentView = (currentView  + 1) % 4;
            }

        }

        return new int[]{currentRow,currentCol};
    }
}
