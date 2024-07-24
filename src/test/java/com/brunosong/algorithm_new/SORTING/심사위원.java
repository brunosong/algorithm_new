package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 심사위원 {
//    심사위원
//    올림픽 체조 대회에서 각 선수들이 수행한 연기를 점수화하는 채점은 굉장히 어렵습니다. 모
//    든 심사위원이 주관적인 판단을 하기 때문입니다. 어떤 선수는 자신이 받은 점수를 공평한 점
//    수라고 생각할 수 있고, 어떤 선수는 불공평한 점수라고 생각 할 수 있습니다.
//    이번 대회는 채점방식을 좀 더 공평하게 해볼려고 합니다.
//    n명의 심사위원이 점수를 주면 그 중 k개를 골라 제일 큰 점수와 제일 낮은 점수의 차가 10점
//    이하면 k개 점수의 평균을 해당선수의 최종점수로 결정하기로 했습니다.
//    k개를 골라서 제일 큰 점수와 제일 낮은 점수의 차가 10점 이하인 경우가 여러개면 그 중 k개
//    의 평균점수가 가장 작은 값을 최종점수로 결정합니다.
//    평균점수는 소수점 이하는 버립니다.
//    매개변수 score에 n명의 심사위원이 준 점수가 주어지고, k가 주어지면 최종점수를 반환하는
//    프로그램을 작성하세요. 최종 점수는 반드시 존재합니다.

    /*

    제한사항:
        • score의 길이는 300,000을 넘지 않습니다.
        • score의 원소는 100,000을 넘지 않는 자연수입니다.
        • 3 <= k <= 100,000
        입출력 예제 1번 설명 :
        91, 85, 92 로 3개의 점수 평균이 최종점수가 됩니다.

    */


    @Test
    void test() {
        // 문제에서 가장중요한 부분은 300,000이다. 이걸 재귀로 풀면 하루종일 걸린다.
        // 일단 슬라이딩 윈도우로 풀어야 한다.
        // k개를 골라서 제일 큰 점수와 제일 낮은 점수의 차가 10점 이하인 경우중에서 k개의 평균이 가장 작은 값을 최종 점수로 한다.


//        score k answer
//                [99, 97, 80, 91, 85, 95, 92] 3 89
//                [92, 90, 77, 91, 70, 83, 89, 76, 95, 92] 4 88
//                [77, 88, 78, 80, 78, 99, 98, 92, 93, 89] 5 92
//                [88, 99, 91, 89, 90, 72, 75, 94, 95, 100] 5 90

        int k = 3;
        int[] score = {99, 97, 80, 91, 85, 95, 92};
        Assertions.assertThat(solution(k,score)).isEqualTo(89);

        k = 4;
        score = new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92};
        Assertions.assertThat(solution(k,score)).isEqualTo(88);

        k = 5;
        score = new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89};
        Assertions.assertThat(solution(k,score)).isEqualTo(92);

    }

    public int solution(int k, int[] score) {

        //일단 이 문제를 해결하기 위해서는 스코어를 오름차순으로 정렬을 해주면 간단하게 해결이 된다.
        //오름 차순을 해놓고 k개 만큼 가져와서 가장 작은 값과 가장 큰값을 비교했을때 10이하가 된다면 그게 정답인 것이다.
        //k가 3이었을때 3개를 아무거나 가져와서 일일이 높은값과 낮은값을 비교하게 된다면 정말 힘들게 문제를 풀어야 한다.

        //오름차순으로 정렬한다.
        Arrays.sort(score);

        //슬라이딩 윈도우로 밀고간다.
        for (int i = 0; i < score.length - k; i++) {
            if(score[i + k-1] - score[i] <= 10) {
                return getAvg(score,i, i + k-1);
            }
        }

        return 0;
    }

    public int getAvg(int[] score, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += score[i];
        }

        return (int)Math.floor(sum / ( endIndex - startIndex + 1));
    }

}
