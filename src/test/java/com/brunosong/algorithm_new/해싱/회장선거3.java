package com.brunosong.algorithm_new.해싱;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 회장선거3 {

    @Test
    void test() {

//        현수네 반은 오늘 회장선거를 합니다. 현수네 반 N명의 학생은 각자 자기가 좋아하는 학생을
//        회장후보로 추천합니다. 한 학생이 여러명을 추천할 수 있습니다.
//        추천횟수가 k번 이상인 학생들만 회장선거에 출마할 수 있습니다. 회장선거에 출마한 학생들
//        은 자기를 추천해준 학생들에게 감사의 선물을 보내기로 했습니다.
//        매개변수 votes에 추천정보가 주어지면 가장 많은 감사 선물을 받은 학생의 이름을 반환하는
//        프로그램을 작성하세요. 답이 여러명일 경우 사전순으로 가장 빠른 이름을 반환합니다.
//        만약 john이 tom을 추천 했다면 [john, tom]의 순써쌍 입력정보가 들어옵니다
        int n = 3;
//        String[] votes = {
//                "john tom", "park luis", "john luis", "luis tom",
//                "park tom", "luis john", "luis park", "park john",
//                "john park", "tom john", "tom park", "tom luis"
//        };
        String[] votes = {
                "cody tom", "john tom", "cody luis", "daniel luis",
                "john luis", "luis tom", "daniel tom", "luis john"
        };

        System.out.println(solution(votes,n));

    }


    public String solution(String[] votes, int n) {
        String answer = "";

        // 추천 대상자 모으기
        Map<String, Set<String>> recommend = new HashMap<>();
        Map<String, Integer> candidate = new HashMap<>();

        for (String vote : votes) {
            String recommender = vote.split(" ")[0];
            String callUser = vote.split(" ")[1];

            candidate.put(callUser, candidate.getOrDefault(callUser, 0) + 1);

            Set<String> users = recommend.getOrDefault(recommender, new HashSet<>());
            users.add(callUser);

            recommend.put(recommender, users);
        }

        Map<String, Integer> present = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (String a : recommend.keySet()) {
            int cnt = 0;
            for (String b : recommend.get(a)) {
                if (candidate.get(b) >= n) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (String name : present.keySet()){
            if (present.get(name) == max) tmp.add(name);
        }
        tmp.sort((a, b)->a.compareTo(b));
        answer= tmp.get(0);

        System.out.println(present);
        System.out.println(recommend);
        System.out.println(candidate);


        return answer;
    }


}
