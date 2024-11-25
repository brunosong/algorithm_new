package com.brunosong.algorithm_new.백준.dfs_bfs;

import java.util.*;
import java.util.stream.Stream;

public class 단지번호붙이기 {

    public static int[] dRow = {-1,0,1, 0};
    public static int[] dCol = { 0,1,0,-1};
    public static int n = 0;
    public static boolean[][] check;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int[] array = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = array;
        }

        int aptComplex = 0;
        List<Integer> aptComplexCounts = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 1 && !check[row][col]) {
                    aptComplex++;
                    aptComplexCounts.add(findAptComplex(row,col,board));
                }
            }
        }

        System.out.println(aptComplex);
        Collections.sort(aptComplexCounts);

        for (int a : aptComplexCounts) {
            System.out.println(a);
        }
    }

    public static int findAptComplex(int row, int col, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        check[row][col] = true;

        int aptCnt = 1;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = dRow[i] + current[0];
                int nCol = dCol[i] + current[1];

                if ((nRow >= 0 && nRow < n) && (nCol >= 0 && nCol < n) && board[nRow][nCol] == 1 && !check[nRow][nCol]) {
                    check[nRow][nCol] = true;
                    aptCnt++;
                    queue.add(new int[]{nRow,nCol});
                }
            }
        }

        return aptCnt;
    }
}
