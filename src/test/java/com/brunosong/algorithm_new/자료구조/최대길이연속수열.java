package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.TreeSet;

public class 최대길이연속수열 {


    @Test
    void test() {
//        제한사항:
//        • nums의 길이는 300,000을 넘지 않습니다.
//        • nums[i]의 값은 -1,000,000,000에서 1,000,000,000까지이며, 중복된 값도 있습니다.

        int[] nums = {8, 1, 9, 3, 10, 2, 4, 0, 2, 3};

        Assertions.assertThat(solution(nums)).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0})).isEqualTo(10);
        Assertions.assertThat(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3})).isEqualTo(1);
        Assertions.assertThat(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1})).isEqualTo(7);
        Assertions.assertThat(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7})).isEqualTo(3);

        solution2(nums);
        // 정답맞춤
    }


    public int solution(int[] nums) {
        int answer = Integer.MIN_VALUE;

        // 해싱을 한다. 해싱을 할때 정렬을 해서 넣으면 될것 같다.
        TreeSet<Integer> set = new TreeSet<>();

        // 가장 큰수와 가장 작은 수 만큼 for문을 돌리려고 했으나 제한사항에서 그런거 하지 말라는 조건이 붙었다. -1,000,000,000에서 1,000,000,000 다른 방법을 찾아야한다.
        for (int x : nums) { set.add(x); }

        int cnt = 1;
        int before = set.first();
        for(int x : set) {
            if(before + 1 == x) {
                cnt++;
            } else {
                cnt = 1;
            }
            before = x;
            answer =Math.max(cnt,answer);
        }


        return answer;
    }

    /* 정렬을 하지 않고 사용하는 방법 */
    public int solution2(int[] nums) {
        int answer = 0;

        // 기본적으로 정렬이 되는것 같지만 확실하게 되는것은 아니다.
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) { set.add(x); }

        for (int x : set) {
            if(set.contains(x-1)) continue;   // 만약 { 8, 9, 10, 0, 1, 2, 3, 4 } 있다면 자신보다 작은수가 없을 때에 시작을 한다. 그리고 자신보다 1작은 수가 있다면 while() 에서 구하기 때문에 패스해준다.
            int cnt = 0;
            while (set.contains(x)) {         // 자신보다 1이 큰 수열을 여기서 구한다. 만약 x 보다 1큰 수열이 없다면 종료하게 된다.
                cnt++;
                x++;
            }
            answer =Math.max(cnt,answer);
        }

        return answer;
    }


}
