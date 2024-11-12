package com.brunosong.algorithm_new.백준.그래프탐색;

import java.util.*;

public class 미로탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split("");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = split[j];
            }
        }

        System.out.println(findShortRoad(board));

    }

    public static int findShortRoad(String[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int x = 0;
        int y = 0;

        queue.add(new int[]{x,y});
        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                board[current[0]][current[1]] = "0";

                for (int d = 0; d < 4; d++) {
                    int nx = current[0] + dx[d];
                    int ny = current[1] + dy[d];

                    if (board.length <= nx || nx < 0 || board[0].length <= ny || ny < 0) continue;
                    if (board[nx][ny].equals("1")) {
                        if (nx == board.length-1 && ny == board[0].length-1) {
                            return level + 1;
                        }
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
