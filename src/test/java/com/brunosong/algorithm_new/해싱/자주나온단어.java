package com.brunosong.algorithm_new.해싱;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 자주나온단어 {

    @Test
    void test() {
        String[] strings = {"search","index","search","query","index","search","log"};
        System.out.println(Arrays.toString(solution(strings,3)));
    }

    String[] solution(String[] strings, int k) {
        String[] answer = new String[k];

        Map<String, Integer> hash = new HashMap<>();
        for (String str : strings) {
            hash.put(str, hash.getOrDefault(str, 0) + 1);
        }

        List<Word> words = new ArrayList<>();
        for (String key : hash.keySet()) {
            words.add(new Word(hash.get(key), key));
        }

        Collections.sort(words);

        for (int i = 0; i < k; i++) {
            answer[i] = words.get(i).answer;
        }

        return answer;
    }

    static class Word implements Comparable<Word> {
        int cnt;
        String answer;

        public Word(int cnt, String answer) {
            this.cnt = cnt;
            this.answer = answer;
        }

        @Override
        public int compareTo(Word o) {
            if (this.cnt == o.cnt) {
                return this.answer.compareTo(o.answer);
            }
            return o.cnt - this.cnt;
        }
    }
}
