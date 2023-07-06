package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.*;

public class 신고결과받기 {

    public static void main(String[] args) {

//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        solution2(id_list,report,k);

    }


    public static int[] solution2(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String,Set<String>> sayUsersName = new HashMap<>();
        Map<String,Long> sayNamesCnt = new HashMap<>();

        for(int i = 0 ; i < report.length ; i++) {
            String[] s = report[i].split(" ");

            //신고한 사람
            String name = s[0];

            //신고당한 사람
            String sayName = s[1];

            //신고당한 사람 카운트 구하기 같은 사람이 여러번 신고해도 한건으로 처리
            //신고한 사람의 신고한 리스트를 뽑아봄
            Set<String> strings = sayUsersName.get(name);
            //신고 당한 사람중에 중복이 있는지 확인
            if(strings == null || !strings.contains(sayName)){
                sayNamesCnt.put(sayName,
                        sayNamesCnt.getOrDefault(sayName,0L) + 1L );
            }

            //신고한 사람 내역 구하기
            Set<String> reportedUser = sayUsersName.getOrDefault(name, new HashSet<>());
            reportedUser.add(sayName);
            sayUsersName.put(name, reportedUser);

        }

        //신고당한 사람들만 구한다.


        for(int i = 0 ; i < id_list.length ; i++) {
            //메일을 받을수 있는 사람인지 확인한다.
            String user = id_list[i];
            Set<String> strings = sayUsersName.get(user); //신고한 내역을 가져온다.
            if(strings != null) {
                for (String sayUser : strings){
                    if(sayNamesCnt.get(sayUser) >= k){
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }



    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        int[] counts = new int[id_list.length];

        HashSet<String> re = new HashSet<>();
        for(String s : report){
            re.add(s);
        }

        Map<String,String> target = new HashMap<>();

        for(int i = 0 ; i < id_list.length ; i++) {
            String name = id_list[i];
            long count = re.stream().filter(str -> str.split(" ")[1].equals(name)).count();
            counts[i] = (int)count;
            if(count >= k){
                target.put(name,name);
            }
        }

//        System.out.println(target);
//
//        for(int i = 0 ; i < id_list.length ; i++) {
//            String name = id_list[i];
//            List<String> collect = re.stream().filter(str -> str.split(" ")[0].equals(name))
//                    .map(str -> str.split(" ")[1]).collect(Collectors.toList());
//
//            long mailCnt = 0;
//
//            for(String user : target){
//                mailCnt = collect.stream().filter( s -> s.equals(user)).count();
//                answer[i] = answer[i] + (int)mailCnt;
//            }
//
//
//        }


        return answer;
    }
}
