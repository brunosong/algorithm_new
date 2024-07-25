package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 사다리타기 {

    /*
    입출력 예:
    제한사항:
    • 3 ≤ n ≤ 25입니다.
    • 매개변수 ladder의 길이(사다리 가로줄의 개수)는 1,000을 넘지 않습니다.
    • 매개변수 ladder[i]의 길이는 10을 넘지 않습니다.
    n           ladder                                                              answer
    5 [[1, 3], [2, 4], [1, 4]]                                                      ['D', 'B', 'A', 'C', 'E']
    7 [[1, 3, 5], [1, 3, 6], [2, 4]]                                                ['A', 'C', 'B', 'F', 'D', 'G', 'E']
    8 [[1, 5], [2, 4, 7], [1, 5, 7], [2, 5, 7]]                                     ['C', 'A', 'B', 'F', 'D', 'E', 'H', 'G']
    12 [[1, 5, 8, 10], [2, 4, 7], [1, 5, 7, 9, 11],[2, 5, 7, 10], [3, 6, 8, 11]]    ['C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H']

    */

    @Test
    void test(){

        //복잡해보일수 있지만 생각보다 간단하게 풀수 있는 방법이 있다.
        //한명 한명 계산을 하게 된다면 생각하기도 어렵고 문제를 푸는 방법도 어려울 것이다.

        int n = 5;
        int[][] ladder = {{1, 3}, {2, 4}, {1, 4}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'D', 'B', 'A', 'C', 'E'});

        n = 7;
        ladder = new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'A', 'C', 'B', 'F', 'D', 'G', 'E'});

        n = 8;
        ladder = new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'C', 'A', 'B', 'F', 'D', 'E', 'H', 'G'});

        n = 12;
        ladder = new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11},{2, 5, 7, 10}, {3, 6, 8, 11}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H'});


    }

    public char[] solution(int n, int[][] ladder) {

        // 1. 사다리 순서대로 A,B,C,D,E를 만들어 준다.
        char[] answer = new char[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (char) (65 + i);
        }

        // 2. 위치가 바뀌는 곳이 어디인지 체크한다. (1,3) 이면 1번과 3번에 세로줄에 (1->2) (3->4) 가로줄이 연결된 것이다.
        // [[1, 3], [2, 4], [1, 4]] 이걸로만 놓고 보았을때 사다리.png 그림이 된다. 행별로 2개씩의 사다리가 생겨난 것이다.
        for (int[] line : ladder) {
            for (int x : line) {
                // 시작하는 라인
                int startLine = x - 1;
                // 도착하는 라인
                int arriveLine = startLine + 1;

                // 교환해준다.
                char tmp = answer[startLine];
                answer[startLine] = answer[arriveLine];
                answer[arriveLine] = tmp;
            }
        }

        return answer;
    }



}
