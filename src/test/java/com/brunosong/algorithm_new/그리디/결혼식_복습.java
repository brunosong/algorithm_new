package com.brunosong.algorithm_new.그리디;

/*
    결혼식
    현수는 다음 달에 결혼을 합니다.
    현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다. 피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
    각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다. 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여
    그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
    만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.

    ▣ 입력설명
    첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
    두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
    시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.

    ▣ 출력설명
    첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.

    ▣ 입력예제 1
    5
    14 18
    12 15
    15 20
    20 30
    5 14

    ▣ 출력예제 1
    2
*/

import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 결혼식_복습 {

    /* 객체를 만들어서 오는 시간을 s 로 만들고 가는 시간을 e 로 만들어서 시간으로 정렬을 한 후 같은 시간이 겹친다면 e 부터 정렬이 되도록 한다.
    *  그 후 s면 1을 추가 e면 1을 빼고 s가 누적되는 최대값이 최대 인원수 이다.
    * */
    @Test
    void test(){

        int[][] arr = {
                {14, 18},
                {12, 15},
                {15, 20},
                {20, 30},
                {5, 14}
        };

        List<Person> personList = new ArrayList<>();

        for (int[] a : arr) {
            personList.add(new Person('s',a[0]));
            personList.add(new Person('e',a[1]));
        }

        Collections.sort(personList);

        System.out.println(solution(personList));

    }

    public int solution(List<Person> people) {

        int answer = 0;

        int cnt = 0;
        for (Person person : people) {

            if (person.state == 's') cnt++;
            else cnt--;

            answer = Math.max(cnt,answer);

        }

        return answer;

    }




    @ToString
    static class Person implements Comparable<Person>{

        char state;
        int time;

        public Person(char state, int time) {
            this.state = state;
            this.time = time;
        }

        @Override
        public int compareTo(Person person) {

            if(this.time == person.time) {
                return this.state - person.state;
            }
            return this.time - person.time;
        }

    }
}

