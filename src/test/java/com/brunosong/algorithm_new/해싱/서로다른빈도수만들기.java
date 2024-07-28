package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 서로다른빈도수만들기 {

    @Test
    void test() {

        Assertions.assertThat(solution("aaabbbcc")).isEqualTo(2);
        Assertions.assertThat(solution("aaabbc")).isEqualTo(0);
        Assertions.assertThat(solution("aebbbbc")).isEqualTo(2);
        Assertions.assertThat(solution("aaabbbcccde")).isEqualTo(5);
        Assertions.assertThat(solution("aaabbbcccdddeeeeeff")).isEqualTo(8);

    }

    int solution(String s) {

        int answer = 0;

        //1. 해싱처리
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        Set<Integer> cntSet = new HashSet<>();
        for (char key : hashMap.keySet()) {
            while (cntSet.contains(hashMap.get(key))) {
                hashMap.put(key,hashMap.get(key) - 1);
                answer++;
            }
            if(hashMap.get(key) == 0) continue;
            cntSet.add(hashMap.get(key));
        }

        return answer;

    }




}
