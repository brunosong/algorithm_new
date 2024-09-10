package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 회장선거2 {


    @Test
    void test() {

        String[] votes = {
                "cody tom", "john tom", "cody luis", "daniel luis",
                "john luis", "luis tom", "daniel tom", "luis john"
        };

        int k = 2;

        Assertions.assertThat(findMostReceivedGifts2(votes,k)).isEqualTo("cody");

    }

    public String findMostReceivedGifts(String[] votes, int k) {
        String answer = "";

        //추천을 받은
        Map<String, Integer> recommendStudent = new HashMap<>();
        //추천을 해준
        Map<String, List<String>> recommend = new HashMap<>();

        for (String students : votes) {
            String[] s = students.split(" ");
            recommendStudent.put(s[1], recommendStudent.getOrDefault(s[1],0)+1);

            List<String> list = recommend.getOrDefault(s[0], new ArrayList<>());
            list.add(s[1]);

            recommend.put(s[0], list);
        }

        TreeMap<String,Integer> sss = new TreeMap<>();
        for (String key : recommendStudent.keySet()) {
            if (recommendStudent.get(key) >= k) {
                for (String student : recommend.keySet()) {
                    if (recommend.get(student).contains(key)) {
                        sss.put(student, sss.getOrDefault(student,0) + 1);
                    }
                }
            }
        }

        return sss.firstKey();
    }


    public String findMostReceivedGifts2(String[] votes, int k) {
        String answer = "";

        Map<String,Set<String>> votesMap = new HashMap<>();
        Map<String,Integer> recommend = new HashMap<>();

        for (String students : votes) {
            String[] s = students.split(" ");
            votesMap.putIfAbsent(s[0], new HashSet<>());
            votesMap.get(s[0]).add(s[1]);

            recommend.put(s[1], recommend.getOrDefault(s[1],0)+1);
        }

        Map<String,Integer> present = new HashMap<>();
        int max = Integer.MAX_VALUE;
        for (String a : votesMap.keySet()) {
            int cnt = 0;
            for (String b : votesMap.get(a)) {
                if (recommend.get(b) >= k) {
                    cnt++;
                }
            }
            present.put(a, cnt);
            max = Math.max(max,cnt);
        }

        List<String> tmp = new ArrayList<>();
        for (String name : present.keySet()) {
            if (present.get(name) == max) tmp.add(name);
        }

        tmp.sort((a,b) -> a.compareTo(b));
        return tmp.get(0);
    }

}
