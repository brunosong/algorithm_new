package com.brunosong.algorithm_new.자료구조;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 현관문출입순서 {

    public static class Person {

        int num;
        int arrival;
        int state;

        int outTime;

        public Person(int num, int arrival, int state) {
            this.num = num;
            this.arrival = arrival;
            this.state = state;
        }
    }

    @Test
    void test() {

//        int[] arrival = {0, 1, 1, 1, 2, 3, 8, 8};
//        int[] state = {1, 0, 0, 1, 0, 0, 1, 0};
//        int[] arrival = {3, 3, 4, 5, 5, 5};
//        int[] state = {1, 0, 1, 0, 1, 0};

        int[] arrival = {2, 2, 2, 3, 4, 8, 8, 9, 10,10};
        int[] state = {1, 0, 0, 0, 1, 1, 0, 1, 1,0};


//        [0, 2, 3, 1, 4, 5, 8, 9]
//[3, 3, 4, 5, 5, 5] [1, 0, 1, 0, 1, 0] [3, 6, 4, 7, 5, 8]
//[2, 2, 2, 3, 4, 8, 8, 9, 10,
//                10]
//[1, 0, 0, 0, 1, 1, 0, 1, 1,
//                0]
//[2, 3, 4, 5, 6, 8, 11,
//                9, 10, 12

        solution(arrival,state);

    }

    // 이 방식은 한번에 큐에 다 밀어넣고 처리를 하는 방법
    public int[] solution(int[] arrival, int[] state) {
        int[] answer = {};
        Queue<Person> outQueue = new LinkedList<>();
        Queue<Person> inQueue = new LinkedList<>();

        for (int i = 0; i < arrival.length; i++) {
            if(state[i] == 1) {
                outQueue.offer(new Person(i,arrival[i],state[i]));
            } else {
                inQueue.offer(new Person(i,arrival[i],state[i]));
            }
        }

        int time = arrival[0];
        int doorState = state[0];
        List<Person> answerList  = new ArrayList<>();

        while (!outQueue.isEmpty() && !inQueue.isEmpty()) {
            Person p = null;
            if(outQueue.peek().arrival == time && inQueue.peek().arrival == time) {

                // 값이 같으면 1부터
                if(doorState == 1) {
                    p = outQueue.poll();
                } else {
                    p = inQueue.poll();
                }

            // 여기 부분 때문에 한번에 넣고 처리하는 건 로직상 힘들어 진다.
            } else if(outQueue.peek().arrival <= time && outQueue.peek().arrival < inQueue.peek().arrival) {
                p = outQueue.poll();
            } else if(inQueue.peek().arrival <= time && inQueue.peek().arrival < outQueue.peek().arrival) {
                p = inQueue.poll();
            // 시간 건너 뛰기
            } else if(inQueue.peek().arrival > time && outQueue.peek().arrival > time){
                p = outQueue.poll();
                time = p.arrival;
            }

            doorState = p.state;
            p.outTime = time;
            answerList.add(p);
            time++;
        }

        Queue<Person> remain = new LinkedList<>();

        if(!outQueue.isEmpty()) remain = outQueue;
        else if (!inQueue.isEmpty()) remain = inQueue;

        if(!remain.isEmpty()) {
            Person p = remain.peek();
            if(p.arrival > time) {
                time = p.arrival;
            }

            while (!remain.isEmpty()) {
                Person poll = remain.poll();
                poll.outTime = time;
                answerList.add(poll);
                time++;
            }
        }

        Collections.sort(answerList, (p1,p2) -> p1.num - p2.num);

        answerList.forEach(p -> System.out.print(p.outTime + " "));

        return answer;
    }

    // 이 방식은 그때 그때 큐에 밀어넣고 처리하는 방식임
    public int[] solution2(int[] arrival, int[] state) {

        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();

        int n = arrival.length, prev = 1;
        int[] answer = new int[n];

        // 무한루프처럼 사용
        for (int t = 0, i = 0, cnt = 0 ;; t++) {

            // 큐에 값이 없고 인덱스가 끝나지 않았다면
            if(enter.isEmpty() && exit.isEmpty() && i < n) {
                //현재 돌고 있는 타임보다 배열에 들어 있는 사원의 입장시간이 더 늦는다면
                //그 사원의 입장 순서로 타임을 건너띄워줌
                if(t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }

            // 현재시간보다 작거나 같은 입장시간을 가진 사원을 큐에 넣어준다.
            while (i < n && arrival[i] <= t) {
                if(state[i] == 0) enter.offer(i);
                else {
                    exit.offer(i);
                }
                i++;
            }

            if(prev == 1) {
                if(!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if(prev == 0) {
                if(!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }

            }

            cnt++;
            if(cnt == n) break;

        }

        System.out.println(Arrays.toString(answer));

        return answer;

    }

}
