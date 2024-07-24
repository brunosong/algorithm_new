package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

public class 카드가져가기 {

    @Test
    void test() {

//        nums k answer
//                [7, 8, 5, 12, 3, 1, 3, 1, 1, 12] 2 28
//                [8, 2, 12, 12, 12, 12, 2, 2] 2 34
//                [3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7] 3 60
//                [12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12]  3 283
//                [14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19] 3 129

        int k = 2;
        int[] nums = {7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        Assertions.assertThat(solution(k,nums)).isEqualTo(28);

        k = 2;
        nums = new int[]{8, 2, 12, 12, 12, 12, 2, 2};
        Assertions.assertThat(solution(k,nums)).isEqualTo(34);

        k = 3;
        nums = new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7};
        Assertions.assertThat(solution(k,nums)).isEqualTo(60);

        k = 3;
        nums = new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12};
        Assertions.assertThat(solution(k,nums)).isEqualTo(283);


    }

    public int solution(int k, int[] nums) {

        Integer[] numsBox = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        //가장 높은 순으로 nums를 정렬한다. : 이유는 항상 이기기 위해 최선을 다하니깐 서로가 가장 높은 수를 뽑을라고 하기때문이다.
        Arrays.sort(numsBox, (a1,a2) -> a2-a1);

        int totalScore = 0;
        //내가 가져올 총합을 구한다.( 가장 큰수부터 차례로 가져가기 때문에 홀수가 된다.
        for (int i = 1; i < numsBox.length; i+=2) {
            totalScore += numsBox[i];
        }

        //다른 방식으로 구해본다.
        totalScore = IntStream.range(0, numsBox.length)
                .filter(i -> i % 2 == 1) //홀수만 선택
                .map(i -> numsBox[i])
                .sum();

        //이제 k(우선권)을 사용하기 위해서 0-1,2-3 이런식으로 묶어서 차이를 계산한다.
        List<Integer> kList = new ArrayList<>();
        for (int i = 0; i < numsBox.length; i+=2) {
            kList.add(numsBox[i] - numsBox[i + 1]);
        }

        Collections.sort(kList, Collections.reverseOrder());

        //우선권 만큼 더해준다.
        for (int i = 0; i < k; i++) {
            totalScore += kList.get(i);
        }

        return totalScore;
    }


}
