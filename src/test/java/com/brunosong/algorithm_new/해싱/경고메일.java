package com.brunosong.algorithm_new.해싱;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 경고메일 {

    @Test
    void test() {
        Assertions.assertThat(solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out","luis 11:57 in",
                        "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)).isEqualTo(new String[]{"daniel", "john"});

        Assertions.assertThat(solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in",
                "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)).isEqualTo(new String[]{"daniel", "luis"});

        Assertions.assertThat(solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out",
                "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)).isEqualTo(new String[]{"bill", "cody"});


    }

    String[] solution(String[] reports, int time) {
        int[] answer = {};

        Map<String,List<Integer>> map = new HashMap<>();
        TreeSet<String> userSet = new TreeSet<>();

        for (int i = 0; i < reports.length; i++) {
            String[] info = reports[i].split(" ");

            String name = info[0];
            String[] times = info[1].split(":");
            int targetTime = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
            String type = info[2];

            String key = name + "#" + type;
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(targetTime);
            map.put(key, list);
            userSet.add(name);
        }

        List<String> targetList = new ArrayList<>();
        for (String name : userSet) {
            List<Integer> inList = map.get(name + "#in");
            List<Integer> outList = map.get(name + "#out");

            Collections.sort(inList);
            Collections.sort(outList);

            int totalTime = 0;
            for (int i = 0; i < inList.size(); i++) {
                totalTime += outList.get(i) - inList.get(i);
                if (totalTime >= time) {
                    targetList.add(name);
                    break;
                }
            }
        }

        System.out.println(targetList);

        return targetList.toArray(new String[0]);
    }
}
