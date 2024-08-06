package com.brunosong.algorithm_new.BFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {
    
    @Test
    void test() {
        solution();
    }
    
    void solution() {

        int[][] board = {
                {0,0,-1,0,0,0},
                {0,0,1,0,-1,0},
                {0,0,-1,0,0,0},
                {0,0,0,0,-1,1}
            };

        int[][] dis = new int[board.length][board[0].length];

        Assertions.assertThat(BFS(board,dis)).isEqualTo(4);

    }

    public int BFS(int[][] board,int[][] dis) {
        int answer = Integer.MIN_VALUE;

        Queue<int[]> queue = new LinkedList<>();

        //1. 토마토의 위치를 넣는다.
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if(board[x][y] == 1) queue.offer(new int[]{x,y});
            }
        }

        int[] dx = {-1, 0,1, 0};
        int[] dy = { 0, 1,0,-1};

        int l = 0;
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = current[0] + dx[j];
                int ny = current[1] + dy[j];

                if (nx < board.length && nx >= 0 && ny < board[0].length && ny >= 0 && board[nx][ny] == 0 ) {
                    board[nx][ny] = 1;
                    queue.add(new int[]{nx,ny});
                    dis[nx][ny] = dis[current[0]][current[1]] + 1;
                }
            }
        }

        boolean flag = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        } else {
            answer = -1;
        }

        return answer;
    }
    
    
}
