package com.brunosong.algorithm_new.그리디;
/*
        씨름 선수
        현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다. 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
        현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다. “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은 (크고, 무겁다)
        지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
        N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.

        ▣ 입력설명
        첫째 줄에 지원자의 수 N(5<=N<=100,000)이 주어집니다.
        두 번째 줄부터 N명의 키와 몸무게 정보가 차례로 주어집니다. 각 선수의 키와 몸무게는 모두 다릅니다.

        ▣ 출력설명
        첫째 줄에 씨름 선수로 뽑히는 최대 인원을 출력하세요.

        ▣ 입력예제 1
        5
        172 67
        183 65
        180 70
        170 72
        181 60

        ▣ 출력예제 1
        3

        출력설명 (183, 65), (180, 70), (170, 72) 가 선발됩니다. (181, 60)은 (183, 65)보다 키와 몸무게 모두
        낮기 때문에 탈락이고, (172, 67)은 (180, 70) 때문에 탈락입니다.
*/

import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 씨름선수_복습 {

    @Test
    void test() {

        List<Player> list = new ArrayList<>();
        list.add(new Player(172, 67));
        list.add(new Player(183, 65));
        list.add(new Player(180, 70));
        list.add(new Player(170, 72));
        list.add(new Player(181, 60));
        Collections.sort( list );

        assertThat(solution(list)).isEqualTo(3);
    }


    public int solution(List<Player> players) {

        int cnt = 0;
        int max = 0; //가장 작은값으로 해도 되지만 0으로 해도 될것 같다 키는 0보다 작을순 없을것 같다.

        /* 일단 가장 키가 큰놈은 통과다 */
        for (Player player : players) {
            if ( player.weight > max ) {
                cnt++;
                max = player.weight;
            }
        }

        return cnt;

    }

    @ToString
    static class Player implements Comparable<Player>{

        int height;
        int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player o) {
            return o.height- this.height;
        }
    }


}
