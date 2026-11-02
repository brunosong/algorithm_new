package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

public class 유연근무제 {
    
    @Test
    void test() {
//        int[] schedules = {700,800,1100};
//        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};

        int[] schedules = {700, 700};
        int[][] timelogs = {
                {700, 800, 700, 700, 700, 700, 700},  // 화요일에 지각
                {700, 700, 700, 700, 700, 800, 800}   // 토·일에만 늦음 → 인정돼야 함
        };

        int startday = 1;

        System.out.println(solution(schedules, timelogs, startday));

    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            schedules[i] = getTime(schedules[i]);
        }

        for (int i = 0; i < timelogs.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {
                timelogs[i][j] = getTime(timelogs[i][j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < schedules.length; i++) {
            int limitTime = schedules[i] + 10;

            boolean check = true;
            int day = startday - 1;

            for (int j = 0; j < timelogs[i].length; j++) {
                if (limitTime < timelogs[i][j] && day != 5 && day != 6) {
                    check = false;
                    break;
                }
                day = (day + 1) % 7;
            }
            if (check) {
                cnt++;
            }
        }

        return cnt;
    }

    int getTime(int time) {
        int hour = time / 100;
        int min = time % 100;

        return hour * 60 + min;
    }
}
