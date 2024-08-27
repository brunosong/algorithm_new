package com.brunosong.algorithm_new.BFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토2 {

    @Test
    void test() {
        solution();
    }

    void solution() {
        int n = 6, m = 4;

        int[][] board = {
                {0,0,-1,0,0,0},
                {0,0,1,0,-1,0},
                {0,0,-1,0,0,0},
                {0,0,0,0,-1,1}
        };


        Assertions.assertThat(findRipeTomatoDay(board,m,n)).isEqualTo(4);

    }

    public int findRipeTomatoDay(int[][] board, int m, int n) {

        int[][] dis = new int[m][n];

        // 익어있는 토마토(1) 위치 찾기
        Queue<int[]> queue = new LinkedList<>();

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 1) {
                    queue.offer(new int[]{x,y});
                }
            }
        }

        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};

        int day = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] findPosition = queue.poll();

                int x = findPosition[0];
                int y = findPosition[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= m || nx < 0 || ny >= n || ny < 0 || board[nx][ny] != 0) continue;

                    dis[nx][ny] = dis[x][y] + 1;
                    board[nx][ny] = 1;
                    queue.offer(new int[]{nx,ny});
                }

            }
            day++;
        }

        // 하나라도 안익은게 존재하면
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == 0) return -1;
            }
        }

        return day;
    }


}
