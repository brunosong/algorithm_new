package com.brunosong.algorithm_new.자료구조;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CPU스케쥴링 {

    @Test
    void test(){

        int[][] tasks = {
                //{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}
                {5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}
                //{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}
        };

        solution_basic(tasks);
    }

    public int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];

        Map<Integer,List<Cpu>> taskMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            List<Cpu> cpuList = taskMap.getOrDefault(tasks[i][0], new ArrayList<>());
            cpuList.add(new Cpu(tasks[i][0],tasks[i][1],i));
            taskMap.put(tasks[i][0], cpuList);
        }

        PriorityQueue<Cpu> pQueue = new PriorityQueue<>((c1,c2) -> {
            if (c1.processingTime == c2.processingTime) {
                return c1.requestTime = c2.requestTime;
            }
            return c1.processingTime - c2.processingTime;
        });

        int startTime = taskMap.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
        int finishTime = -1;

        
        List<Integer> answerList = new ArrayList<>();
        
        for (int time = startTime; time < 10000; time++) {

            if (taskMap.containsKey(time)) {
                List<Cpu> cpus = taskMap.get(time);
                for (Cpu cpu : cpus) {
                    pQueue.offer(cpu);
                }
                taskMap.remove(time);
            }

            if(pQueue.isEmpty() && finishTime < time && !taskMap.isEmpty()) {
                time = taskMap.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
                continue;
            } else if(taskMap.isEmpty() && pQueue.isEmpty()){
                break;
            }

            while (!pQueue.isEmpty() && finishTime <= time) {
                Cpu poll = pQueue.poll();
                finishTime = time + poll.processingTime;
                answerList.add(poll.idx);
            }

        }

        System.out.println(answerList);


        return answer;
    }

    public int[] solution_basic(int[][] tasks) {

        int n = tasks.length;
        int[] answer = new int[n];

        LinkedList<int[]> programs = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            programs.add(new int[]{tasks[i][0],tasks[i][1],i});
        }

        Collections.sort(programs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int finishTime = 0;
        int idx = 0;
        while (!programs.isEmpty() || !priorityQueue.isEmpty()) {

            if (priorityQueue.isEmpty()) {
                finishTime = Math.max(finishTime,programs.peek()[0]);
            }

            while (!programs.isEmpty() && finishTime >= programs.peek()[0]) {
                int[] p = programs.pollFirst();
                priorityQueue.offer(new int[]{p[1],p[2]});
            }

            int[] out = priorityQueue.poll();
            finishTime = finishTime + out[0];
            answer[idx++] = out[1];

        }


        return answer;
    }

    public static class Cpu {

        int requestTime;
        int processingTime;
        int idx;

        public Cpu(int requestTime, int processingTime, int idx) {
            this.requestTime = requestTime;
            this.processingTime = processingTime;
            this.idx = idx;
        }
    }

}
