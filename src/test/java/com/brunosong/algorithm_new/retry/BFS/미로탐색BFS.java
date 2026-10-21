package com.brunosong.algorithm_new.retry.BFS;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색BFS {

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

        int[][] bfs = BFS(maze);

        if (bfs[6][6] == 0) System.out.println(-1);
        else {
            System.out.println(bfs[6][6]);
        }
    }

    public int solution() {
        int answer = 0;


        //[BFS()

        return answer;
    }

    public int[][] BFS(int[][] maze) {

        int[][] dis = new int[maze.length][maze[0].length];

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        maze[0][0] = 1;
        queue.add(new int[]{0,0});

        int level = 0;
        while (!queue.isEmpty()) {

            int[] currentPosition = queue.poll();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            if (currentRow == 6 && currentCol == 6) continue;

            for (int j = 0; j < 4; j++) {
                int nRow = currentRow + dRow[j];
                int nCol = currentCol + dCol[j];

                if (nRow < 0 || nRow >= 7 || nCol < 0 || nCol >= 7) continue;

                if (maze[nRow][nCol] == 0) {
                    maze[nRow][nCol] = 1;
                    queue.offer(new int[]{nRow,nCol});
                    dis[nRow][nCol] = dis[currentRow][currentCol] + 1;
                }
            }
        }

        return dis;
    }

}
