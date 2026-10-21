package com.brunosong.algorithm_new.retry.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 미로탐색 {

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static int answer = 0;

    @Test
    void test() {

        int[][] maze = {
                {0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,1 ,1 ,1 ,1 ,1 ,0},
                {0 ,0 ,0 ,1 ,0 ,0 ,0},
                {1 ,1 ,0 ,1 ,0 ,1 ,1},
                {1 ,1 ,0 ,0 ,0 ,0 ,1},
                {1 ,1 ,0 ,1 ,1 ,0 ,0},
                {1 ,0 ,0 ,0 ,0 ,0 ,0}
        };

        maze[0][0] = 1;
        DFS(0,0, maze);

        System.out.println(answer);
    }

    void DFS(int row, int col, int[][] maze) {

        if (row == 6 && col == 6) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow <= 6 && nCol >= 0 && nCol <= 6 && maze[nRow][nCol] == 0){
                    maze[nRow][nCol] = 1;
                    DFS(nRow, nCol, maze);
                    maze[nRow][nCol] = 0;
                }
            }
        }
    }


}
