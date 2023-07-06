package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.*;

public class 달리기경주 {

    /*
        https://school.programmers.co.kr/learn/courses/30/lessons/178871
        players	 ["mumu", "soe", "poe", "kai", "mine"]
        callings  ["kai", "kai", "mine", "mine"]
        result ["mumu", "kai", "mine", "soe", "poe"]


    */

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        solution3(players,callings);
    }

    public static String[] solution2(String[] players, String[] callings) {

        String[] answer = {};

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];

            for (int j = 0; j < players.length; j++) {
                if(calling.equals(players[j])){
                    String temp = players[j-1];
                    players[j-1] = players[j];
                    players[j] = temp;
                    break;
                }
            }

            System.out.println(Arrays.toString(players));

        }

        return answer;
    }

    public static String[] solution(String[] players, String[] callings) {

        String[] answer = new String[players.length];

        Map<String,Integer> currentPos = new HashMap<>();
        Map<Integer,String> position = new HashMap<>();

        for (int i = 1; i <= players.length; i++) {
            currentPos.put(players[i - 1], i);
            position.put(i,players[i - 1]);
        }

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];

            //현재 선수의 번호를 가져온다.
            Integer curPlayerNumber = currentPos.get(calling);
            //현재 선수가 이동할 번호를 구한다.
            int nextPlayerNumber = curPlayerNumber - 1;

            //이동할 다음 선수의 이름을 가져온다.
            String movePlayerName = position.get(nextPlayerNumber);
            Integer movePlayerNumber = currentPos.get(movePlayerName);

            currentPos.put(movePlayerName,movePlayerNumber + 1);
            currentPos.put(calling,nextPlayerNumber);

            position.put(movePlayerNumber + 1, movePlayerName);
            position.put(nextPlayerNumber,calling);
        }

        position.forEach( (k,v) -> {
            answer[k-1] = v;
        });

        System.out.println(Arrays.toString(answer));
        System.out.println(currentPos);


        return answer;
    }


    public static String[] solution3(String[] players, String[] callings) {

        String[] answer = new String[players.length];

        Map<String,Integer> currentPos = new HashMap<>();

        for (int i = 1; i <= players.length; i++) {
            currentPos.put(players[i - 1], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];

            int curPlayerNumber = currentPos.get(calling);

            String temp = players[curPlayerNumber - 1];

            String moveP = players[curPlayerNumber - 2];
            players[curPlayerNumber - 1] = moveP;
            players[curPlayerNumber - 2] = temp;


            currentPos.put(calling, curPlayerNumber - 1);
            currentPos.put(moveP, curPlayerNumber);

        }


        System.out.println(Arrays.toString(players));
        System.out.println(currentPos);


        return answer;
    }

}
