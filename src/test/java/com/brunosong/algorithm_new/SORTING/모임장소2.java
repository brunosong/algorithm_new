package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 모임장소2 {
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

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a,b) -> a-b);

        int rowCenter = row.get(row.size() / 2); // 가운데 값을 가져옴
        int colCenter = col.get(col.size() / 2);

        for (Integer r : row) {
            answer += Math.abs(rowCenter - r);
        }

        for (Integer p : col) {
            answer += Math.abs(colCenter - p);
        }

        return answer;
    }
}
