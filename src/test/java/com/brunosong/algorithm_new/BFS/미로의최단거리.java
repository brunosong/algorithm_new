package com.brunosong.algorithm_new.BFS;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 미로의최단거리 {

    @Test
    void test() {

        int[][] maze = {
                {0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,1 ,1 ,1 ,1 ,1 ,0},
                {0 ,0 ,0 ,1 ,0 ,0 ,0},
                {1 ,1 ,0 ,1 ,0 ,1 ,1},
                {1 ,1 ,0 ,1 ,0 ,0 ,1},
                {1 ,0 ,0 ,0 ,1 ,0 ,0},
                {1 ,0 ,1 ,0 ,0 ,0 ,0}
        };

        findShortRoad(maze);

    }

    void findShortRoad(int[][] maze) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int[] dx = {-1, 0,1, 0};
        int[] dy = { 0, 1,0,-1};

        int l = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                maze[current[0]][current[1]] = l;

                for (int j = 0; j < 4; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if(nx < maze.length && nx >= 0 && ny < maze[0].length && ny >= 0 && maze[nx][ny] == 0 ) {
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
            l++;
        }


    }



}
