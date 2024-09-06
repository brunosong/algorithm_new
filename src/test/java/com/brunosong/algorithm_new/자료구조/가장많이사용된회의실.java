package com.brunosong.algorithm_new.자료구조;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 가장많이사용된회의실 {

    @Test
    void test() {
        int n = 4;  //룸 넘버
        int[][] meetings =
                {{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14},{15, 20}};
                //{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}};

        solution(n,meetings);

    }

    public int solution(int n, int[][] meetings){

        Arrays.sort(meetings, (a1,a2) -> a1[0] - a2[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a1,a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);

        TreeSet<Integer> rooms = new TreeSet<>();
        for (int i = 0; i < n; i++) rooms.add(i);

        int[] cnts = new int[n];

        for (int[] m : meetings) {
            /* 시작하기 전에 비울 수 있는건 비워준다. */
            while (!queue.isEmpty() && queue.peek()[0] <= m[0]) {
                rooms.add(queue.poll()[1]);
            }

            if (!rooms.isEmpty()) {
                Integer roomNum = rooms.pollFirst();
                queue.offer(new int[]{m[1], roomNum});
                cnts[roomNum]++;
            } else {

                int[] lowEndTimeRooms = queue.poll();
                cnts[lowEndTimeRooms[1]]++;
                queue.offer(new int[]{ lowEndTimeRooms[0] + (m[1] - m[0]), lowEndTimeRooms[1]});
            }
        }

        System.out.println(Arrays.toString(cnts));

        return 1;
    }

    public int solution2(int n, int[][] meetings){
        int answer = 0;
        int[] res = new int[n];
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] -
                b[0]);
        TreeSet<Integer> rooms = new TreeSet<>();
        for(int i = 0; i < n; i++) rooms.add(i);
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for(int[] m : meetings){
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) rooms.add(ends.poll()[1]);
            if(!rooms.isEmpty()){
                int room = rooms.pollFirst();
                res[room]++;
                ends.add(new int[]{m[1], room});
            }
            else{
                int[] e = ends.poll();
                res[e[1]]++;
                ends.add(new int[]{e[0] + (m[1] - m[0]), e[1]});
            }
        }
        int maxi = 0;
        for(int i = 0; i < n; i++){
            if(res[i] > maxi){
                maxi = res[i];
                answer = i;
            }
        }

        System.out.println(Arrays.toString(res));


        return answer;
    }


}
