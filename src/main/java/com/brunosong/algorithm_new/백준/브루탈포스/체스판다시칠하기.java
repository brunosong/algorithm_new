package com.brunosong.algorithm_new.백준.브루탈포스;

import java.util.Scanner;

public class 체스판다시칠하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nNums = sc.nextLine().split(" ");

        int m = Integer.parseInt(nNums[0]);
        int n = Integer.parseInt(nNums[1]);

        String[][] board = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] tmp = sc.nextLine().split("");
            for (int j = 0; j < tmp.length; j++) {
                board[i][j] = tmp[j];
            }
        }
        sc.close();

        int answer = Integer.MAX_VALUE;
        for (int x = 0; x < board.length - 7; x++) {
            for (int y = 0; y < board[x].length - 7; y++) {
                answer = Math.min(check(board,x,y,"W"),answer);
                answer = Math.min(check(board,x,y,"B"),answer);
            }
        }

        sc.close();

        System.out.println(answer);
    }

    public static int check(String[][] board,int x, int y, String startCh) {
        String[] checker = {"W","B"};
        int cnt = 0;
        int checkIndex = startCh.equals("W") ? 0 : 1;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (!checker[checkIndex].equals(board[i][j])) {
                    cnt++;
                }
                checkIndex = (checkIndex + 1) % 2;
            }
            checkIndex = (checkIndex + 1) % 2;
        }
        return cnt;
    }
}