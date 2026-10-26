package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문제도난2 {

    @Test
    void test() {


        String[] reports = {"john 15:23", "daniel 09:30", "tom 07:23","park 09:59", "luis 08:57"};
        Assertions.assertThat(solution(reports,"08:33 09:45")).isEqualTo(new String[]{"luis", "daniel"});

        reports = new String[]{"ami 12:56", "daniel 15:00", "bob 19:59",
                "luis 08:57", "bill 17:35", "tom 07:23",
                "john 15:23", "park 09:59"};
        Assertions.assertThat(solution(reports,"15:01 19:59")).isEqualTo(new String[]{"john", "bill", "bob"});

    }

    String[] solution(String[] reports, String times) {

        int startTime = getTime(times.split(" ")[0]);
        int endTime = getTime(times.split(" ")[1]);

        List<Person> personList = new ArrayList<>();
        for (String info : reports) {
            String name = info.split(" ")[0];
            int time = getTime(info.split(" ")[1]);

            if (startTime <= time && endTime >= time) {
                personList.add(new Person(name, time));
            }
        }

        Collections.sort(personList);
        String[] answer = new String[personList.size()];
        for (int i = 0; i < personList.size(); i++) {
            answer[i] = personList.get(i).name;
        }

        return answer;
    }

    int getTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    static class Person implements Comparable<Person> {
        String name;
        int time;

        Person(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            return this.time - o.time;
        }
    }


}
