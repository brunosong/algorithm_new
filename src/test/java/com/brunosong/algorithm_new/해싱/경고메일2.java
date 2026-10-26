package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 경고메일2 {

    @Test
    void test() {
        Assertions.assertThat(solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out","luis 11:57 in",
                "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)).isEqualTo(new String[]{"daniel", "john"});

        Assertions.assertThat(solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in",
                "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)).isEqualTo(new String[]{"daniel", "luis"});

        Assertions.assertThat(solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out",
                "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)).isEqualTo(new String[]{"bill", "cody"});


    }

    String[] solution(String[] reports, int limitTime) {

        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> sumTime = new HashMap<>();

        for (String report : reports) {
            String name = report.split(" ")[0];
            int time = getTime(report.split(" ")[1]);
            String type = report.split(" ")[2];

            if (type.equals("in")) {
                inTime.put(name, time);
            } else {
                int checkTime = time - inTime.getOrDefault(name, 0);
                sumTime.put(name, sumTime.getOrDefault(name, 0) + checkTime);
            }
        }

        List<String> list = new ArrayList<>();
        for (String key : sumTime.keySet()) {
            Integer totalTime = sumTime.get(key);
            if (totalTime >= limitTime) {
                list.add(key);
            }
        }

        list.sort((a,b) -> a.compareTo(b));

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    int getTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    static class Info implements Comparable<Info> {
        String name;
        int time;
        String type;

        public Info(String name, int time, String type) {
            this.name = name;
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }
    }
}
