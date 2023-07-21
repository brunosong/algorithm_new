package com.brunosong.algorithm_new.그리디;
/*

    최대 수입 스케쥴(PriorityQueue 응용문제)
    현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
    각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
    단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

    ▣ 입력설명
    첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과
    D(1<=D<=10,000)가 차례로 주어진다.

    ▣ 출력설명
    첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

    ▣ 입력예제 1
    6
    50 2
    20 1
    40 2
    60 3
    30 3
    30 1

    ▣ 출력예제 1
    150

    해설 : 가장 첫째날인 1은 선택 범위가 좁다 . 하루만에 해야 하는것이기 때문이다 그래서 가장 선택 폭이 넓은 3일 부터로 정리한다.
*/

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 최대수입스케쥴 {

    public static void main(String[] args) {
        int[][] arr = {
            {50, 2},
            {20, 1},
            {40, 2},
            {60, 3},
            {30, 3},
            {30, 1}
        };

        List<Schedule> list = new ArrayList<>();
        for (int[] a : arr ) {
            list.add(new Schedule(a[0],a[1]));
        }

        Collections.sort(list);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int maxDay = list.get(0).day;   //정렬이 된 상태라 가장 긴 날짜가 0번째로 온다.
        int sum = 0;

        int j = 0;

        for (int i = maxDay ; i > 0; i--) {

            for (; j < list.size(); j++) {
                if(list.get(j).day < i ) break;
                queue.offer(list.get(j).money);
            }

            if(!queue.isEmpty()) sum += queue.poll();

        }


        System.out.println(sum);

    }

}


@ToString
class Schedule implements Comparable<Schedule>{

    int money;
    int day;

    public Schedule(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Schedule o) {
        return o.day - this.day;
    }
}