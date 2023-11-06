package com.brunosong.algorithm_new.프로그래머스LV0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 한번만등장 {

    @Test
    void test() {
    }

    public String solution(String s) {
        String answer = "";

        char[] charArray = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i],map.getOrDefault(charArray[i],0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        map.forEach( (k,v) -> {
            if(v == 1) {
                sb.append(k);
            }
        });

        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

}
