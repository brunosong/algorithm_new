package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 문제도난 {

    @Test
    void test() {


        String[] reports = {"john 15:23", "daniel 09:30", "tom 07:23","park 09:59", "luis 08:57"};
        Assertions.assertThat(solution2(reports,"08:33 09:45")).isEqualTo(new String[]{"luis", "daniel"});

        reports = new String[]{"ami 12:56", "daniel 15:00", "bob 19:59",
                                "luis 08:57", "bill 17:35", "tom 07:23",
                                "john 15:23", "park 09:59"};
        Assertions.assertThat(solution2(reports,"15:01 19:59")).isEqualTo(new String[]{"john", "bill", "bob"});

    }

    public String[] solution(String[] reports, String times) {
        String[] answer = {};

        String[] time = times.split(" ");
        LocalTime startTime = LocalTime.parse(time[0], DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse(time[1], DateTimeFormatter.ofPattern("HH:mm"));

        List<User> members = new ArrayList<>();

        for (String report : reports) {
            String[] info = report.split(" ");
            String name = info[0];
            LocalTime inputTime = LocalTime.parse(info[1], DateTimeFormatter.ofPattern("HH:mm"));

            // 방법 1
//            if ((inputTime.equals(startTime) || inputTime.isAfter(startTime)) &&
//                    (inputTime.isBefore(endTime) || inputTime.equals(endTime))) {
//                members.add(new User(name,inputTime));
//            }

            // 방법 2
            if (inputTime.compareTo(startTime) > 0 && inputTime.compareTo(endTime) <= 0) {
                members.add(new User(name,inputTime));
            }
        }

        Collections.sort(members, Comparator.comparing(User::getLocalTime));

        return members.stream()
                .map(User::getName)
                .toArray(String[]::new);
    }



    public String[] solution2(String[] reports, String times) {
        String[] answer = {};

        // 시간을 숫자로 바꿔주는 전략을 사용한다.
        String[] timeRange = times.split(" ");

        int startTime = (Integer.parseInt(timeRange[0].split(":")[0]) * 60) + Integer.parseInt(timeRange[0].split(":")[1]);
        int endTime = (Integer.parseInt(timeRange[1].split(":")[0]) * 60) + Integer.parseInt(timeRange[1].split(":")[1]);

        Map<String,Integer> members = new HashMap<>();
        for (String memberInfo : reports) {

            String[] member = memberInfo.split(" ");
            String name = member[0];
            int inputTime = (Integer.parseInt(member[1].split(":")[0]) * 60) + Integer.parseInt(member[1].split(":")[1]);

            if (startTime <= inputTime && endTime >= inputTime) {
                members.put(name,inputTime);
            }
        }

        answer = members.entrySet()
                .stream()
                .sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(entry -> entry.getKey())
                .toArray(String[]::new);

        return answer;
    }




    public static class User {

        String name;
        LocalTime time;

        public User(String name, LocalTime time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public LocalTime getLocalTime() {
            return time;
        }
    }


}
