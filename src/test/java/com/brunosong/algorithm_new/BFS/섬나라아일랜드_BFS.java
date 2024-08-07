package com.brunosong.algorithm_new.BFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 섬나라아일랜드_BFS {

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

        int answer = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 1) {
                    answer++;
                    BFS(x,y,board);
                }

            }
        }

        Assertions.assertThat(answer).isEqualTo(5);
    }


    void BFS(int x, int y, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        board[x][y] = 0;

        int[] dx = {-1,-1,0,1,1, 1, 0,-1};
        int[] dy = { 0, 1,1,1,0,-1,-1,-1};

        while (!queue.isEmpty()) {

            int[] position = queue.poll();

            for (int i = 0; i < 8; i++) {

                int nx = position[0] + dx[i];
                int ny = position[1] + dy[i];

                if (nx >= board.length || nx < 0 || ny >= board[0].length || ny < 0) continue;

                if (board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }


    }




}
