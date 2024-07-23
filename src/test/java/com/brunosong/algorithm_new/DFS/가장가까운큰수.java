package com.brunosong.algorithm_new.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 가장가까운큰수 {

    List<Integer> nums;
    int[] ch;

    boolean ckFlag;

    @Test
    void test() {
        //자연수 N이 주어지면 , n과 구성이 같으면서 n보다 큰 수 중 가장 작은 수를 출력하는 프로그램
        // n                answer
        // 123              132
        // 321              -1
        // 20573            20735
        // 27711            71127
        // 54312            54321
        // n과 구성이 같으면서 n보다 큰 수가 없으면 -1을 반환한다.

        //POINT : 순열로 구할수 있다.
        Assertions.assertThat(solution(123)).isEqualTo(132);
        Assertions.assertThat(solution(321)).isEqualTo(-1);
        Assertions.assertThat(solution(20573)).isEqualTo(20735);

    }

    public int solution(int n) {

        int[] answer = {-1};
        nums = new ArrayList<>();
        ckFlag = false;

        //n을 쪼개서 배열로 만든다. {2,0,5,7,3}
        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            tmp = tmp / 10;
            nums.add(t);
        }
        //체크 배열을 생성한다.
        ch = new int[nums.size() + 1];
        nums.sort(Comparator.comparingInt(c -> c));
        DFS(0,0 , answer, n);

        return answer[0];
    }


    void DFS(int L, int num, int[] answer, int n) {

        // 답을 찾으면 다른 스텍들을 종료시켜준다.
        if(ckFlag) return;

        if(L == nums.size()) {
            if(num > n) {
                answer[0] = num;
                ckFlag = true;
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                if(L == 0 && i == 0 && nums.get(i) == 0) continue;
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1,  num * 10  + nums.get(i), answer, n);
                    ch[i] = 0;
                }
            }
        }
    }
}
