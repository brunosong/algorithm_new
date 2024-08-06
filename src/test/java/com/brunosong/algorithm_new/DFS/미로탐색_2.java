package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

public class 미로탐색_2 {

    int startX = 0;
    int startY = 0;

    int arriveX = 6;
    int arriveY = 6;

    int answer = 0;

    @Test
    void test(){

        int[][] maze = {
                {0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,1 ,1 ,1 ,1 ,1 ,0},
                {0 ,0 ,0 ,1 ,0 ,0 ,0},
                {1 ,1 ,0 ,1 ,0 ,1 ,1},
                {1 ,1 ,0 ,0 ,0 ,0 ,1},
                {1 ,1 ,0 ,1 ,1 ,0 ,0},
                {1 ,0 ,0 ,0 ,0 ,0 ,0}
        };
        maze[startX][startY] = 1;
        findRoad(maze,startX,startY);
        System.out.println(answer);
    }

    void findRoad(int[][] maze,int x, int y) {

        if(x == arriveX && y == arriveY) {
            answer++;
        } else {

            int[] dx = {-1, 0,1, 0};
            int[] dy = { 0, 1,0,-1};

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= maze.length || nx < 0 || ny >= maze[0].length || ny < 0 || maze[nx][ny] == 1) continue;

                maze[x][y] = 1;
                findRoad(maze,nx,ny);
                maze[x][y] = 0;
            }
        }
    }




}
