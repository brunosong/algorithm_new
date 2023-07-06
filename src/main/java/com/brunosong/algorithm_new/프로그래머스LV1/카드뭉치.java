package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {

    public static void main(String[] args) {

        String[] cards1 = {"i", "water","drink" };
        String[] cards2 = new String[0];
        //String[] goal = {"i", "want", "to", "drink", "water"};
        String[] goal = {"a", "b", "c", "d", "e"};

        System.out.println(solution(cards1,cards2,goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        //card들에 들어있는 값이 goal에 들어있지 않는경우 에러가 납니다.
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Queue<String> queue3 = new LinkedList<>();

        for (String s : cards1) { queue1.offer(s); }
        for (String s : cards2) { queue2.offer(s); }

        for (String s : goal) {

            String peek1 = "";
            if(!queue1.isEmpty()) {
                peek1 = queue1.peek();
            }

            String peek2 = "";
            if(!queue2.isEmpty()) {
                peek2 = queue2.peek();
            }

            //q1 이 비어있는 상태 이거나 문자가 같지 않은상태 이거나

            if((queue1.isEmpty() || !peek1.equals(s)) && (queue2.isEmpty() || !peek2.equals(s))) {
                answer = "No";
                break;
            }

            if (!queue1.isEmpty() && peek1.equals(s)) {
                queue1.poll();
            } else if (!queue2.isEmpty() && peek2.equals(s) ) {
                queue2.poll();
            }

            // 이렇게 하면 76점이 나옴... 뭐가 문제지... 허허
            // 하.... queue.isEmpty() ... 를 peek1.isEmpty() ... String 도 이게 되는구나
        }

        return answer;
    }


    public static String solution2(String[] cards1, String[] cards2, String[] goal) {

        int index1 = 0; // 카드 1의 인덱스
        int index2 = 0; // 카드 2의 인덱스

        for(int i = 0; i < goal.length; i++){
            if(cards1[index1].equals(goal[i])){  // goal의 카드가 cards1의 카드라면
                index1 = (index1 < cards1.length-1) ? index1 + 1 : index1;    // 카드를 모두 순회했으면 인덱스가 더 이상 증가하지 않음
            }else if(cards2[index2].equals(goal[i])){    // goal의 카드가 cards2의 카드라면
                index2 = (index2 < cards2.length-1) ? index2 + 1 : index2;    // 카드를 모두 순회했으면 인덱스가 더 이상 증가하지 않음
            }else{  // 둘 다 같지 않으면
                return "No";
            }
        }

        return "Yes";
    }



}
