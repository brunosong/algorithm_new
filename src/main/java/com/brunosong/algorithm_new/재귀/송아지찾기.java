package com.brunosong.algorithm_new.재귀;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지찾기 {

    /*

    송아지 찾기(BFS : 상태트리탐색)
    현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다. 현수의 위치와 송아
    지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음
    과 같은 방법으로 이동한다. 송아지는 움직이지 않고 제자리에 있다.
    현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수
    있다. 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성
    하세요.
    ▣ 입력설명
    첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000
    까지이다.
    ▣ 출력설명
    점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
    ▣ 입력예제 1
    5 14
    ▣ 출력예제 1
    3
    ▣ 입력예제 2
    8 3
    ▣ 출력예제 2
    5

    */

    //시작점
    static int s = 8;

    //송아지 위치
    static int point = 3;

    static int[] steps = {1,-1,5};

    //지나온 길은 다시 가지 않기 위해서다.
    static int[] past = new int[10001];

    public static void main(String[] args) {
        System.out.println(
            BFS()
        );

    }


    static int BFS() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int lv = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();

                for (int j = 0; j < steps.length; j++) {
                    int nextStep = poll + steps[j];
                    if(nextStep == point) return lv++;
                    if(past[nextStep] == 0) {
                        past[nextStep] = 1;
                        queue.offer(nextStep);
                    }
                }
            }
            lv++;

        }

        return 0;

    }


}
