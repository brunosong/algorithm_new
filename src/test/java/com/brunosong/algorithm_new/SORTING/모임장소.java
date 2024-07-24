package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 모임장소 {

    @Test
    void test() {

        // 서로가 만날수 있는 최소로 이동할수 있는 거리를 구해라


        int[][] board = {
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, }
        };

        Assertions.assertThat(solution(board)).isEqualTo(8);


        int[][] board2 = {
                {1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1}
        };

        Assertions.assertThat(solution(board2)).isEqualTo(37);


    }

    public int solution(int[][] board) {
        int answer = 0;

        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();

        //1. 총 인원수와 현재 위치를 구한다.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }

        //2. 최적에 조인 포인트를 찾기위해서는 컬럼을 오름차순해줘야한다.
        Collections.sort(columnList);

        //3. 가장 만나기 쉬운 짧은 거리를 찾는다. 일부러 풀어서 코딩했다.
        int rowIndex = rowList.size() / 2;
        int columnIndex = columnList.size() / 2;

        int rowPoint = rowList.get(rowIndex);
        int columnPoint = columnList.get(columnIndex);

        System.out.println(" 서로가 가장 만나기 좋은 포인트 지점은 " + rowPoint +"," + columnPoint);

        //4. row는 로우끼리 거리를 구해서 더해주면 되고 column은 컬럼끼리 거리를 구해서 더해주면 된다.
        for (int row : rowList) answer += Math.abs(row - rowPoint);
        for (int col : columnList) answer += Math.abs(col - columnPoint);

        return answer;
    }




}
