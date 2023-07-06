package com.brunosong.algorithm_new.프로그래머스LV1;

public class 문자열나누기 {


    public static void main(String[] args) {


        Solution solution = new Solution();
        solution.solution("abracadabra");
    }

}


class Solution {

    public int solution(String s) {
        int answer = 0;

        char[] sc = s.toCharArray();
        //먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
        char x = sc[0];
        int xCnt = 1;
        int otherCnt = 0;


        //aaabbaccccabba
        boolean first = true;
        //이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
        for (int i = 0; i < sc.length; i++) {

            if(first) {
                x = sc[i];
                first = false;
                xCnt = 1;
                continue;
            }

            if(x == sc[i]) {
                xCnt++;
            } else {
                otherCnt++;
                if(xCnt == otherCnt) {
                    answer++;
                    xCnt = 0;
                    otherCnt = 0;
                    first = true;
                }
            }
        }




        return answer;
    }

}