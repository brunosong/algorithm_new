package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 겹쳐진압축해제 {

    @Test
    void test() {

        Assertions.assertThat(solution("3(a2(b))ef")).isEqualTo("abbabbabbef");
        Assertions.assertThat(solution("2(ab)k3(bc)")).isEqualTo("ababkbcbcbc");
        Assertions.assertThat(solution("2(ab3(((cd))))")).isEqualTo("abcdcdcdabcdcdcd");
        Assertions.assertThat(solution("2(2(ab)3(2(ac)))")).isEqualTo("ababacacacacacacababacacacacacac");
        Assertions.assertThat(solution("3(ab2(sg))")).isEqualTo("absgsgabsgsgabsgsg");


    }


    public String solution(String s) {
        String answer = "";

        //() 쌍이 나오면 무조건 스택이다
        Stack<String> stack = new Stack<>();

        String[] charArray = s.split("");

        for (int i = 0; i < charArray.length; i++) {

            if(charArray[i].equals(")")) {
                String repeatTmp = "";
                while (!stack.peek().equals("(")) {
                    repeatTmp = stack.pop() + repeatTmp;
                }
                stack.pop();

                /* 숫자가 1의 자리일때와 10의자리 일때도 처리가 가능하다 그리고 숫자 1일때만 꺼낸다 */
                String multiNum = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    multiNum = stack.pop() + multiNum;
                }

                // 숫자면 기본 로직
                if(!multiNum.equals("")) {
                    String tmp = repeatTmp;
                    for (int j = 1; j < Integer.parseInt(multiNum); j++) {
                        repeatTmp += tmp;
                    }
                }

                stack.push(repeatTmp);

            } else {
                stack.push(charArray[i]);
            }

        }

        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }

        return answer;
    }



    public String solution2(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();

        for (char x : s.toCharArray()) {

            if(x == ')') {
                String tmp = "";
                //스텍안에서 처리
                while (!stack.isEmpty()){
                    String c = stack.pop();
                    if(c.equals("(")) {
                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }

                        String result = "";
                        int cnt = 0;
                        if(num.equals("")) cnt = 1; //곱할값이 없으면 ((ab)) 이런것들
                        else {
                            cnt = Integer.parseInt(num);
                        }

                        for (int i = 0; i < cnt; i++) {
                            result += tmp;
                        }

                        stack.push(result);
                        break;
                        
                    } else {
                        tmp = c + tmp;
                    }

                }


            } else {
                stack.push(String.valueOf(x));
            }

        }






        return answer;
    }


}
