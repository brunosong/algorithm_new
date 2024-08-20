package com.brunosong.algorithm_new.BFS;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리2 {

    @Test
    void test() {

        int startX = 0, startY = 0;
        int arriveX = 6, arriveY = 6;

        int[][] maze = {
                {0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,1 ,1 ,1 ,1 ,1 ,0},
                {0 ,0 ,0 ,1 ,0 ,0 ,0},
                {1 ,1 ,0 ,1 ,0 ,1 ,1},
                {1 ,1 ,0 ,1 ,0 ,0 ,1},
                {1 ,0 ,0 ,0 ,1 ,0 ,0},
                {1 ,0 ,1 ,0 ,0 ,0 ,0}
        };

        int[][] dis = new int[maze.length][maze[0].length];

        findShortRoad(startX,startY,maze,dis);
        System.out.println(dis[arriveX][arriveY]);
    }

    public void findShortRoad(int x, int y, int[][] maze, int[][] dis) {

        Queue<int[]> queue = new LinkedList<>();
        maze[x][y] = 1;
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int[] dx = {-1,0,1, 0};
            int[] dy = { 0,1,0,-1};

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    dis[nx][ny] = dis[current[0]][current[1]] + 1;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }

    }

}
