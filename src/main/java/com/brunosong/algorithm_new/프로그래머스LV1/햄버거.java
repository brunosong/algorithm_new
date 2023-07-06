package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.*;

public class 햄버거 {

    public static void main(String[] args) {

        int[] ingredient = //{2, 1, 1, 2, 3, 1, 1, 2, 3, 1};	//2
         //{1, 3, 2, 1, 2, 1, 3, 1, 2};	//0
               {2, 3, 2, 3, 1, 2, 3, 1};
        System.out.println(solution2(ingredient));
    }



    public static int solution2(int[] ingredient) {
        int answer = 0;

        int[] ch = { 1 , 2 , 3 , 1 };

        Stack<Integer> stack = new Stack<>();

        int cnt = 0;

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);

            if(ingredient[i] == 1 && stack.size() > 3) {

                if(!stack.isEmpty()){
                    boolean com = true;
                    List<Integer> temp = new ArrayList<>();
                    for (int j = ch.length - 1; j >= 0; j--) {
                        if(!stack.isEmpty() && ch[j] == stack.peek()) {
                            temp.add(stack.pop());
                        } else {
                            com = false;
                            Collections.reverse(temp);
                            temp.forEach( (t) -> stack.push(t) );  //롤백
                            break;
                        }
                    }

                    if(com) cnt++;

                } else {
                    stack.push(ingredient[i]);
                }
            }


        }






        return cnt;
    }


    public static int solution(int[] ingredient) {
        int answer = 0;

        int[] ch = { 1 , 2 , 3 , 1 };

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < ingredient.length; i++) {
            queue.offer(ingredient[i]);
        }

        int cnt = 0;

        while(!queue.isEmpty()) {

            Integer poll = queue.poll();

            if(queue.isEmpty()) break;

            if(ch[0] == poll) {
                int j = 1;
                for (; j < ch.length; j++) {

                    if (queue.isEmpty()) break;

                    if (ch[j] != queue.peek()) {
                        break;
                    } else {
                        if (queue.peek() != ch[0]) {
                            queue.poll();
                        }

                    }

                }

                if(j == ch.length) {
                    cnt++;
                }
            }

        }


        System.out.println(cnt
        );

        return answer;
    }
}
