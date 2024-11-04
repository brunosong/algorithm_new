package com.brunosong.algorithm_new.프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 공원 {

    @Test
    void test() {

        int[] mats = {5,3,2};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        Assertions.assertThat(solution(mats,park)).isEqualTo(3);
    }

    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int[] dx = {-1,1, 0,0};
        int[] dy = { 0,0, -1,1};
        int parkXSize = park.length;

        for (int x = 0; x < park.length; x++) {
            for (int y = 0; y < park[x].length; y++) {
                if (park[x][y].equals("-1")) {
                    int tempX = 1;
                    int tempY = 1;

                    //위만 확인
                    int nx = x - 1;
                    if (nx >= 0) {
                        // 알파벳이 아니면 무조건 1:1이런식이다
                        if (!park[nx][y].matches("[A-Z]")) {
                            String value = park[nx][y];
                            String[] xy = value.split(":");
                            tempX += Integer.parseInt(xy[0]);
                        }
                    }

                    //왼쪽만 확인
                    int ny = y - 1;
                    if (ny >= 0) {
                        // 알파벳이 아니면 무조건 1:1이런식이다
                        if (!park[x][ny].matches("[A-Z]")) {
                            String value = park[x][ny];
                            String[] xy = value.split(":");
                            tempX += Integer.parseInt(xy[1]);
                        }
                    }
                    park[x][y] = String.format("%d:%d", tempX, tempY);

                }
            }
        }


        return answer;
    }

    public int findBigMatsSize(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        int[] pox = {};

        while (!queue.isEmpty()) {



        }

        return 0;
    }

}
