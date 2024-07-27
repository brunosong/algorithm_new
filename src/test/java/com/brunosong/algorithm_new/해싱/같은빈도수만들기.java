package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class 같은빈도수만들기 {

    @Test
    void test() {
//        "aaabc"   [0, 2, 2, 3, 3]
//        "aabb"   [0, 0, 2, 2, 2]
//        "abcde"   [0, 0, 0, 0, 0]
//        "abcdeabc"  [0, 0, 0, 1, 1]
//        "abbccddee"  [1, 0, 0, 0, 0]
//
//      answer == [a,b,c,d,e] 여기에 빈도수를 돌려준다.
        Assertions.assertThat(solution("aaabc"))
                             .isEqualTo(new int[]{0, 2, 2, 3, 3});

        Assertions.assertThat(solution("aabb"))
                            .isEqualTo(new int[]{0, 0, 2, 2, 2});

        Assertions.assertThat(solution("abcde"))
                            .isEqualTo(new int[]{0, 0, 0, 0, 0});

        Assertions.assertThat(solution("abcdeabc"))
                            .isEqualTo(new int[]{0, 0, 0, 1, 1});

        Assertions.assertThat(solution("abbccddee"))
                .           isEqualTo(new int[]{1, 0, 0, 0, 0});

    }


    public int[] solution(String s) {
        int[] answer = new int[5];
        int max = Integer.MIN_VALUE;

        HashMap<Character,Integer> hashset = new HashMap<>();
        for (char x : s.toCharArray()) {
            int val = hashset.getOrDefault(x,0)+1;
            max = Math.max(val,max);
            hashset.put(x, val);
        }

        for (int i = 0; i < answer.length; i++) {
            Integer integer = hashset.getOrDefault((char) (i + 97),0);

            if(integer != max ) {
                answer[i] = max - integer;
            }
        }

        return answer;
    }

    public int[] solution2(String s){

        int[] answer = new int[5];
        HashMap<Character, Integer> sH= new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        String tmp="abcde";

        for(char key : tmp.toCharArray()){
            if(sH.getOrDefault(key, 0) > max){
                max = sH.getOrDefault(key, 0);
            }
        }

        for(int i =0; i < tmp.length(); i++){
            answer[i] = max-sH.getOrDefault(tmp.charAt(i), 0);
        }

        return answer;
    }
}
