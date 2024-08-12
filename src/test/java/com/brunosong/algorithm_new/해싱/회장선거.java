package com.brunosong.algorithm_new.해싱;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 회장선거 {

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
        String[] votes = {
                "john tom", "park luis", "john luis", "luis tom",
                "park tom", "luis john", "luis park", "park john",
                "john park", "tom john", "tom park", "tom luis"
        };

        System.out.println();solution2(votes,n);

    }


    public String solution(String[] votes, int n) {
        String answer = "";

        //각 추천 수를 구하자
        //HashMap<String,Recommend> userRecommendMap = new HashMap<>();
        List<Recommend> userRecommendList = new ArrayList<>();

        //가장 많은 추천을 받은 사람을 구한다.
        for (int i = 0; i < votes.length; i++) {
            String[] tmp = votes[i].split(" ");

            //추천을 받은 사람
            Recommend recommend = new Recommend(tmp[1]);
            recommend.addUser(tmp[0]);

            userRecommendList.add(recommend);
        }

        userRecommendList.forEach(r -> System.out.println(r.getCnt()));

        //회장선거에 출전할수 있는 사람만 구한다.
        List<Recommend> collect = userRecommendList.stream().filter(u -> u.getCnt() >= n)
                                                            .collect(Collectors.toList());


        HashMap<String,Integer> map = new HashMap<>();
        for (Recommend recommend : collect) {
            for (int i = 0; i < recommend.getCnt(); i++) {
                map.put(recommend.users.get(i), map.getOrDefault(recommend.users.get(i),0) + 1);
            }
        }

        System.out.println(map);
//
//        List<String> recommendMap = userRecommendMap.keySet().stream()
//                                            .filter(k -> userRecommendMap.get(k) >= n)
//                                            .collect(Collectors.toList());
//


        return answer;
    }



    public String solution2(String[] votes, int n) {
        String answer = "";

        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            String[] tmp = votes[i].split(" ");

            List<String> orDefault = map.getOrDefault(tmp[1], new ArrayList<>());
            orDefault.add(tmp[0]);
            map.put(tmp[1],orDefault);
        }

        SortedMap<String,Integer> sortedMap = new TreeMap<>() ;

        int max = 0;
        // 후보자 선정
        for (String name : map.keySet()) {
            if(map.get(name).size() >= n) {
                max = Math.max(map.get(name).size(),max);
                map.get(name).stream().forEach( v -> sortedMap.put(v,sortedMap.getOrDefault(v,0)+1));
            }
        }

        //Stream.of(sortedMap).flatMap()


        for (String key  : sortedMap.keySet()) {
            if(sortedMap.get(key) == max) {

            }
        }

        return sortedMap.firstKey();
    }


    public static class Recommend {

        String name;
        List<String> users = new ArrayList<>();

        public Recommend(String name) {
            this.name = name;
        }

        public void addUser(String user) {
            users.add(user);
        }

        public int getCnt() {
            return users.size();
        }

    }


}
