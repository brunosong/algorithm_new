package com.brunosong.algorithm_new.백준.그래프탐색;

import java.util.*;

public class 미로탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split("");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(findShortRoad(board,n,m));

    }

    public static int findShortRoad(int[][] board, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{0,0});
        visited[0][0] = true;

        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = current[0] + dx[d];
                    int ny = current[1] + dy[d];

                    if (board.length <= nx || nx < 0 || board[0].length <= ny || ny < 0 || visited[nx][ny]) continue;
                    if (board[nx][ny] == 1) {
                        if (nx == board.length-1 && ny == board[0].length-1) {
                            return level + 1;
                        }
                        queue.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
