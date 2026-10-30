package com.brunosong.algorithm_new.해싱;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 중복문서 {

    /**
     * 문서 배열 `docs`가 주어집니다. 각 문서는 단어를 공백 하나로 이어 붙인 문자열입니다.
     * 단어 순서만 다르고 단어 구성(같은 단어가 몇 번 나왔는지까지)이 같으면 같은 문서로 봅니다. 서로 다른 문서가 몇 종류인지 반환하세요.
     * 제한사항
     *
     * - `docs` 길이 1 이상 10,000 이하
     * - 각 문서의 단어 수는 1 이상 100 이하, 단어는 알파벳 소문자 1~20자
     *
     * | docs | result |
     * |---|---|
     * | ["data search engine","engine search data","search data","data search","data data search"] | 3 |
     *
     * 1, 2번 문서가 같고, 3, 4번 문서가 같습니다. 5번은 "data"가 두 번 나오므로 3, 4번과 다릅니다.
     */

    @Test
    void test() {
        String[] docs = {"data search engine","engine search data","search data","data search","data data search"};

        Assertions.assertEquals(3, solution(docs));
    }

    public int solution(String[] docs) {

        Set<Map<String,Integer>> data = new HashSet<>();
        for (int i = 0; i < docs.length; i++) {
            String[] s = docs[i].split(" ");

            Map<String, Integer> temp = new HashMap<>();
            for (int j = 0; j < s.length; j++) {
                temp.put(s[j], temp.getOrDefault(s[j],0) + 1);
            }

            data.add(temp);
        }

        return data.size();
    }


}
