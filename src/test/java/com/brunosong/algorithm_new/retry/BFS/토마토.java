package com.brunosong.algorithm_new.retry.BFS;

import com.brunosong.algorithm_new.재귀.경로탐색_DFS;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {

    @Test
    void test() {
        int[][] board = {
                {0,0,-1,0,0,0},
                {0,0,1,0,-1,0},
                {0,0,-1,0,0,0},
                {0,0,0,0,-1,1}
        };
        System.out.println(
        solution(board)
        );
    }

    public int solution(int[][] board) {
        int answer = 0;

        // 좌표를 찾아야-
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    queue.offer(new Point(i,j));
                }
            }
        }

        int[][] bfs = bfs(board, queue);

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == 0) return -1;
            }
        }

        for (int i = 0; i < bfs.length; i++) {
            for (int j = 0; j < bfs[i].length; j++) {
                answer = Math.max(answer, bfs[i][j]);
            }
        }

        return answer;
    }

    public int[][] bfs(int[][] board, Queue<Point> queue) {

        int[][] dis = new int[board.length][board[0].length];

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = current.row + dRow[i];
                int nCol = current.col + dCol[i];

                if (nRow < 0 || nCol < 0 || nRow >= board.length || nCol >= board[0].length) continue;

                if (board[nRow][nCol] == 0) {
                    board[nRow][nCol] = 1;
                    queue.offer(new Point(nRow, nCol));
                    dis[nRow][nCol] = dis[current.row][current.col] + 1;
                }
            }
        }

        return dis;
    }

    public static class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
