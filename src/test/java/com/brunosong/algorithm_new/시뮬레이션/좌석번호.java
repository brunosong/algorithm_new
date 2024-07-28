package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class 좌석번호 {


    @Test
    void test() {

        Assertions.assertThat(solution(6,5, 12)).isEqualTo(new int[]{6,3});
        Assertions.assertThat(solution(6,5, 20)).isEqualTo(new int[]{2,3});
        Assertions.assertThat(solution(6,5, 30)).isEqualTo(new int[]{4,3});
        Assertions.assertThat(solution(6,5, 31)).isEqualTo(new int[]{0,0});

    }

    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];

        int[][] seats = new int[c][r];

        int x = 0;
        int y = 0;

        seats[x][y] = 1;

        //위 오른쪽 아래 왼쪽
        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};

        //시작방향은 오른쪽
        int drivingPosition = 1;

        if(r * c < k) return answer;

        int cnt = 1;
        while (cnt < k) {

            int nx = x + dx[drivingPosition];
            int ny = y + dy[drivingPosition];

            if(nx < c && nx >= 0 && ny < r && ny >= 0 && seats[nx][ny] == 0) {
                seats[nx][ny] = 1;

                x = nx;
                y = ny;

            } else {
                //방향전환
                drivingPosition = (drivingPosition + 1) % 4;
                continue;
            }
            cnt++;
        }

        answer[0] = x+1;
        answer[1] = y+1;

        return answer;
    }



}
