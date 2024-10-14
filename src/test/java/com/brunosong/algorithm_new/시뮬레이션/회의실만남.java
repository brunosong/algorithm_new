package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 회의실만남 {

    @Test
    void test() {
//        enter exit answer
//        [1, 2, 3, 4] [2, 4, 1, 3] [3, 1, 2, 2]
//        [1, 2, 5, 3, 4] [2, 3, 1, 4, 5] [3, 1, 2, 1, 3]
//        [1, 3, 2, 4, 5, 7, 6, 8] [2, 3, 5, 6, 1, 4, 8, 7] [6, 2, 2, 4, 2, 3, 4, 1]
//        [1, 4, 7, 2, 3, 5, 6] [5, 2, 6, 1, 7, 3, 4] [6, 5, 6, 6, 5, 4, 6]
//        [1, 4, 2, 3] [2, 1, 4, 3] [2, 2, 0, 2]
        // 반드시 만난 사람은 몇 명
        Assertions.assertThat(solution(new int[]{1, 2, 3, 4},new int[]{2, 4, 1, 3})).isEqualTo(new int[]{3, 1, 2, 2});
        Assertions.assertThat(solution(new int[]{1, 2, 5, 3, 4},new int[]{2, 3, 1, 4, 5})).isEqualTo(new int[]{3, 1, 2, 1, 3});

    }

    public int[] solution(int[] enter, int[] exit) {
        int[] answer = new int[enter.length];

        Map<Integer,Integer> user = new HashMap<>();
        Queue<Integer> enterQ = new LinkedList<>();
        for (int x : enter) enterQ.add(x);

        for (int i = 0; i < exit.length; i++) {
            int current = -1;
            while (!enterQ.isEmpty() && (current = enterQ.poll()) != exit[i]) {
                for (Integer key : user.keySet()) user.put(key,user.get(key) + 1);
                user.put(current, user.size());
            }
            if (current == exit[i]) {
                for (Integer key : user.keySet()) user.put(key,user.get(key) + 1);
                user.put(current, user.size());
            }

            if (enterQ.isEmpty()) {
                answer[exit[i]-1] = user.get(exit[i]);
                user.remove(exit[i]);
            } else {
                answer[current-1] = user.get(current);
                user.remove(current);
            }
        }

        System.out.println(Arrays.toString(answer));


//        Map<Integer,Integer> userCnt = new HashMap<>();
//
//        while (!exitQ.isEmpty()) {
//            int current = exitQ.poll();
//
//            Stack<Integer> stack = new Stack<>();
//            int exitNum = -1;
//            while ((exitNum = enterQ.poll()) != current) {
//                stack.push(exitNum);
//            }
//            userCnt.put(exitNum, userCnt.getOrDefault(exitNum,0) + stack.size());
//
//            while (!stack.isEmpty()) {
//                Integer enterNum = stack.pop();
//                userCnt.put(enterNum, userCnt.getOrDefault(enterNum,0) + 1);
//                enterQ.addFirst(enterNum);
//            }
//        }
//
//        System.out.println(userCnt);

        return answer;
    }
}
