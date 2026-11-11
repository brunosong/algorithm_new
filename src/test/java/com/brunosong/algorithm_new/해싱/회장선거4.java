package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 회장선거4 {

    @Test
    void test() {

        String[] votes = {
                "cody tom", "john tom", "cody luis", "daniel luis",
                "john luis", "luis tom", "daniel tom", "luis john"
        };

        int k = 2;

        Assertions.assertThat(findMostReceivedGifts(votes,k)).isEqualTo("cody");

    }

    public String findMostReceivedGifts(String[] votes, int k) {
        String answer = "";

        // 추천 받은 카운트
        Map<String, Integer> candidate = new HashMap<>();
        Map<String, Set<String>> temp = new HashMap<>();
        for (String s : votes) {
            String[] person = s.split(" ");
            String a = person[0];
            String b = person[1];

//            // 선물을 받을 사람
//            temp.put(a, );

            // 추천 받은 숫자
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }


        return answer;
    }
}
