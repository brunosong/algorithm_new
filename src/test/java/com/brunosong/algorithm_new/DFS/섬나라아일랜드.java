package com.brunosong.algorithm_new.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 섬나라아일랜드 {

    @Test
    void test() {
        int[][] board = {
            {1 ,1 ,0 ,0 ,0 ,1 ,0},
            {0 ,1 ,1 ,0 ,1 ,1 ,0},
            {0 ,1 ,0 ,0 ,0 ,0 ,0},
            {0 ,0 ,0 ,1 ,0 ,1 ,1},
            {1 ,1 ,0 ,1 ,1 ,0 ,0},
            {1 ,0 ,0 ,0 ,1 ,0 ,0},
            {1 ,0 ,1 ,0 ,1 ,0 ,0}
        };

        boolean[][] check = new boolean[board.length][board[0].length];

        List<int[]> startPosition = new ArrayList<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] != 0) {
                    startPosition.add(new int[]{x,y});
                }
            }
        }

        int answer = 0;
        for (int[] po : startPosition) {
            int x = po[0];
            int y = po[1];

            if(!check[x][y]) {
                check[x][y] = true;
                findIsland(x,y,board,check);
                answer++;
            }
        }

        Assertions.assertThat(answer).isEqualTo(5);
    }

    void findIsland(int currentX, int currentY, int[][] board, boolean[][] check) {
        int[] dx = {-1,-1,0,1,1, 1, 0,-1};
        int[] dy = { 0, 1,1,1,0,-1,-1,-1};

        for (int i = 0; i < 8; i++) {

            int nx = currentX + dx[i];
            int ny = currentY + dy[i];

            if (nx >= board.length || nx < 0 || ny >= board[0].length || ny < 0) continue;

            if (board[nx][ny]==1 && !check[nx][ny]) {
                check[nx][ny] = true;
                findIsland(nx,ny,board,check);
            }
        }
    }

}
