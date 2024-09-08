package com.brunosong.algorithm_new.BFS;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 토마토3 {

    @Test
    void test() {
        int n = 6, m = 4;

        int[][] board = {
                {0,0,-1,0,0,0},
                {0,0,1,0,-1,0},
                {0,0,-1,0,0,0},
                {0,0,0,0,-1,1}
        };

        System.out.println(findDayWhenTomatoRipe(board,n,m));
    }

    int findDayWhenTomatoRipe(int[][] board, int n, int m) {
        int day = -1;
        int[][] dis = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        // 익은 토마토의 위치를 찾는다.
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 1) {
                    queue.offer(new int[]{x,y});
                }
            }
        }

        if (queue.isEmpty()) return day;

        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] tomatoPo = queue.poll();
                int curX = tomatoPo[0];
                int curY = tomatoPo[1];

                for (int po = 0; po < 4; po++) {
                    int nx = curX + dx[po];
                    int ny = curY + dy[po];

                    if (m <= nx || 0 > nx || n <= ny || 0 > ny || board[nx][ny] != 0) continue;

                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[curX][curY] + 1;
                    queue.offer(new int[]{nx,ny});
                }
            }
            day++;
        }

        // 다 익었는지 확인하면서 가장 높은 날짜를 찾는다
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 0) {
                    return -1;
                }
                day = Math.max(dis[x][y], day);
            }
        }

        return day;
    }




}
