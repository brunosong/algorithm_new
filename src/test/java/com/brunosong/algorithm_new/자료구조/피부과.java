package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 피부과 {

    @Test
    void test() {

        int[] laser = {30, 20, 25, 15};

        String[] enter = {"10:23 0", "10:40 3", "10:42 2", "10:52 3","11:10 2"};
        Assertions.assertThat(solution(laser,enter)).isEqualTo(3);

        String[] enter2 = {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0" };
        Assertions.assertThat(solution(laser,enter2)).isEqualTo(4);
    }

    int solution(int[] laser, String[] enter) {
        int answer = 0;

        Queue<WaitingPerson> waitingQueue = new LinkedList<>();

        // 타임을 00:00에서 분으로 바꿔준다.
        for (int i = 0; i < enter.length; i++) {
            String[] element = enter[i].split(" ");

            String[] strTime = element[0].split(":");
            int minuteTime = Integer.parseInt(strTime[0]) * 60 + Integer.parseInt(strTime[1]);

            int type = Integer.parseInt(element[1]);

            waitingQueue.add(new WaitingPerson(minuteTime,type));
        }

        int openTime = waitingQueue.peek().arriveTime;
        int nextTime = 0;
        boolean surging = false;


        Queue<WaitingPerson> queue = new LinkedList<>();

        //첫 시작 시간을 계산한다.  종료시간은 20:00 :
        for (int currentTime = openTime; currentTime <= 1200 && (!queue.isEmpty() || !waitingQueue.isEmpty()); currentTime++) {

            if (!waitingQueue.isEmpty() && waitingQueue.peek().arriveTime == currentTime) {
                queue.offer(waitingQueue.poll());
            }

            if(!queue.isEmpty() && !surging) {
                WaitingPerson person = queue.poll();
                nextTime = Math.max(person.arriveTime,currentTime) + laser[person.type];
                surging = true;
            }

            answer = Math.max(answer,queue.size());

            if(nextTime == currentTime) surging = false;

        }

        return answer;
    }


    public int solution2(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]);
        int fT = inList[0][0];

        int pos = 1;

        for(int t = fT; t <= 1200; t++){

            if(pos < n && t == inList[pos][0]){
                if(Q.isEmpty() && t > fT) fT= t;
                Q.offer(inList[pos][1]);
                pos++;
            }
            if(t == fT && !Q.isEmpty()){
                int idx = Q.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }



    static class WaitingPerson {

        int arriveTime;
        int type;

        public WaitingPerson(int arriveTime, int type) {
            this.arriveTime = arriveTime;
            this.type = type;
        }

    }





}
