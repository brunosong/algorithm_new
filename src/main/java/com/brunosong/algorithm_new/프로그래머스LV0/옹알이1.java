package com.brunosong.algorithm_new.프로그래머스LV0;

import java.util.HashMap;
import java.util.Map;

public class 옹알이1 {

    public static void main(String[] args) {


        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};   // 1
                    //["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3


        Solution s = new Solution();
        s.solution(babbling);


    }


}

class Solution {
    /*
    머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma"
    네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인)
    발음밖에 하지 못합니다. 문자열 배열 babbling이 매개변수로 주어질 때,
    머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
    */
    public int solution(String[] babbling) {
        int answer = 0;

        String[] speaks = {"aya", "ye", "woo", "ma"};


        int cnt = 0;
        for (String baby : babbling) {

            for (int i = 0; i < speaks.length; i++) {
                String speak = speaks[i];

                if(baby.indexOf(speak) > -1){
                    baby = baby.replaceAll(speak," ");
                }
            }

            if(baby.replaceAll(" ","").equals("")) {
                cnt++;
            }


        }


        System.out.println(cnt);

        return answer;
    }
}
