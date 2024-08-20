package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

public class 미로탐색3 {

    int cnt = 0;

    @Test
    void test(){
        int x = 0, y = 0;
        int[][] maze = {
                {0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,1 ,1 ,1 ,1 ,1 ,0},
                {0 ,0 ,0 ,1 ,0 ,0 ,0},
                {1 ,1 ,0 ,1 ,0 ,1 ,1},
                {1 ,1 ,0 ,0 ,0 ,0 ,1},
                {1 ,1 ,0 ,1 ,1 ,0 ,0},
                {1 ,0 ,0 ,0 ,0 ,0 ,0}
        };
        maze[x][y] = 1;

        findRoad(x,y,maze);
        System.out.println(cnt);
    }

    public void findRoad(int x, int y, int[][] maze) {

        if (x == 6 && y == 6) {
            cnt++;
        } else {

            int[] dx = {-1,0,1, 0};
            int[] dy = { 0,1,0,-1};

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] != 1) {
                    maze[nx][ny] = 1;
                    findRoad(nx,ny,maze);
                    maze[nx][ny] = 0;
                }
            }

        }


    }




}
