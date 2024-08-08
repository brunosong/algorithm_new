package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    @Test
    void test() {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };

        System.out.println(solution(maps));

    }


    public int solution(int[][] maps) {
        int answer = -1;

        int startX = 0;
        int startY = 0;

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] dis = new int[maps.length][maps[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});

        int[] dx = {-1, 0,1, 0};
        int[] dy = { 0, 1,0,-1};
        visited[0][0] = true;
        dis[startX][startY] = 1;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < maps.length && nx >= 0 && ny < maps[0].length && ny >= 0 && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                    dis[nx][ny] += dis[x][y] + 1;

                    if (nx == n-1 && ny == m-1) return dis[nx][ny];

                }
            }
        }

        return answer;
    }


    /* 이것도 통과하긴 함 (근데 maps를 수정하는거라 오류가 발생할 확률도 있어서 조심해야함) */
    public int noVisitedSolution(int[][] maps) {
        int answer = -1;

        int startX = 0;
        int startY = 0;

        int n = maps.length;
        int m = maps[0].length;

        int[][] dis = new int[maps.length][maps[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY});

        int[] dx = {-1, 0,1, 0};
        int[] dy = { 0, 1,0,-1};
        maps[startX][startY] = 0;
        dis[startX][startY] = 1;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < maps.length && nx >= 0 && ny < maps[0].length && ny >= 0 && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0;
                    queue.offer(new int[]{nx,ny});
                    dis[nx][ny] += dis[x][y] + 1;

                    if (nx == n-1 && ny == m-1) return dis[nx][ny];

                }
            }
        }

        return answer;
    }




    public int solution2(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dis = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        dis[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[x][y] + 1;

                    if (nx == n - 1 && ny == m - 1) {
                        return dis[nx][ny];
                    }
                }
            }
        }

        return -1;
    }

}
