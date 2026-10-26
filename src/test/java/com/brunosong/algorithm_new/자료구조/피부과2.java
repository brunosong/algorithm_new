package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 피부과2 {

    @Test
    void test() {

        int[] laser = {30, 20, 25, 15};

        String[] enter = {"10:23 0", "10:40 3", "10:42 2", "10:52 3","11:10 2"};
        Assertions.assertThat(solution(laser,enter)).isEqualTo(3);

//        String[] enter2 = {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0" };
//        Assertions.assertThat(solution(laser,enter2)).isEqualTo(4);
    }

    int solution(int[] laser, String[] enter) {
        int answer = 0;

        Queue<Person> personQueue = new LinkedList<>();
        for (String e : enter) {
            int time = getTime(e.split(" ")[0]);
            int type = Integer.parseInt(e.split(" ")[1]);

            personQueue.offer(new Person(time,type));
        }

        int endTime = getTime("20:00");

        Queue<Integer> roomQueue = new LinkedList<>();
        Person first = personQueue.poll();
        roomQueue.offer(first.type);

        int finishTime = first.time;

        for (int time = finishTime; time <= endTime; time++) {
            if (!personQueue.isEmpty() && personQueue.peek().time == time) {
                if (roomQueue.isEmpty() && time > finishTime) finishTime = time;
                Person poll = personQueue.poll();
                roomQueue.offer(poll.type);
            }

            if (!roomQueue.isEmpty() && finishTime == time) {
                Integer poll = roomQueue.poll();
                finishTime += laser[poll];
            }

            answer = Math.max(answer, roomQueue.size());
        }

        return answer;
    }

    static class Person {
        int time;
        int type;

        Person(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    int getTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
}
