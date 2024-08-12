package com.brunosong.algorithm_new.기초;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Array {

    @Test
    void 큰수출력하기() {

        // 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
        int[] arr = {7 ,3 ,9 ,5 ,6 ,12};
        System.out.print(arr[0] + " ");

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i -1]) {
                System.out.print(arr[i] + " ");
            }
        }

    }


    @Test
    void 보이는학생() {

        //선생님이 볼 수 있는 최대학생수를 출력한다.

        int[] students = {130 ,135 ,148 ,140 ,145 ,150 ,150 ,153};

        int answer = 1;
        int currentHeight = students[0];

        for (int i = 1; i < students.length; i++) {
            if(currentHeight < students[i]) {
                answer++;
                currentHeight = students[i];
            }
        }

        System.out.println(answer);

    }

    @Test
    void 같은숫자는싫어() {

        //[1,3,0,1]
        int[] arr = {1,1,3,3,0,1,1};

        int tmp = arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(tmp);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != tmp) {
                list.add(arr[i]);
                tmp = arr[i];
            }
        }

        System.out.println(list);

        list.toArray(Integer[]::new);

    }

    @Test
    void 뒤집은소수() {

        int[] arr = {32 ,55 ,62 ,20 ,250 ,370 ,200 ,30 ,100};

        for (int i = 0; i < arr.length; i++) {
            // 뒤집기
            StringBuilder sb = new StringBuilder(String.valueOf(arr[i]));
            sb.reverse();
            int val = Integer.parseInt(sb.toString());
            if(isPrime(val)) {
                System.out.print(val + " ");
            }
        }


    }


    @Test
    void 격자판최대합() {

        int[][] board = {
                {10 ,13 ,10 ,12 ,15},
                {12 ,39 ,30 ,23 ,11},
                {11 ,25 ,50 ,53 ,15},
                {19 ,27 ,29 ,37 ,27},
                {19 ,13 ,30 ,13 ,19},
        };

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            int colSum = 0, rowSum = 0;
            for (int j = 0; j < board[i].length; j++) {
                colSum += board[i][j];
                rowSum += board[j][i];
            }
            answer = Math.max(answer,colSum);
            answer = Math.max(answer,rowSum);
        }


        int left = 0,right = 0;
        // 대각선
        for (int i = 0; i < board.length; i++) {
            left += board[i][i];
            right += board[(board.length-1) - i][(board.length-1) - i];
        }

        answer = Math.max(answer,left);
        answer = Math.max(answer,right);

        System.out.println(answer);

    }
    
    
    @Test
    void 봉우리구하기() {

        int[][] board = {
                {5 ,3 ,7 ,2 ,3},
                {3 ,7 ,1 ,6 ,1},
                {7 ,2 ,5 ,3 ,4},
                {4 ,3 ,6 ,4 ,1},
                {8 ,7 ,3 ,5 ,2},
        };


        //봉우리는 상하좌우 자신보다 큰 값이 없으면 봉우리다
        int answer = 0;
        //상 우 하 좌
        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                boolean isFlag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] >= board[i][j]) {
                        isFlag = false;
                        break;
                    }
                }

                if(isFlag) answer++;

            }
        }

        System.out.println(answer);

    }


    public boolean isPrime(int num){
        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }


}
