package com.brunosong.algorithm_new.프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 단체사진찍기 {
    int cnt = 0;


    @Test
    void test() {

//        n	data	answer
//        2	["N~F=0", "R~T>2"]	3648
//        2	["M~C<2", "C~M>1"]	0

        String[] data = {"N~F=0", "R~T>2"};
        Assertions.assertThat(solution(2, data)).isEqualTo(3648);

        String[] data2 = {"M~C<2", "C~M>1"};
        Assertions.assertThat(solution(2, data2)).isEqualTo(0);

    }


    public int solution(int n, String[] data) {
        cnt = 0; // Reset the counter for each test case

        List<Condition> conditionList = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            // 이름
            String[] names = data[i].substring(0, 3).split("~");
            // 조건
            String cond = data[i].substring(3, 4);
            // 간격
            int count = Integer.parseInt(data[i].substring(4));

            conditionList.add(new Condition(names[0], names[1], cond, count));
        }

        String[] people = {"A", "C", "F", "J", "M", "N", "R", "T"};
        int[] ch = new int[people.length];
        StringBuilder sb = new StringBuilder();

        dfs(0, people, ch, sb, conditionList);
        return cnt;
    }

    public void dfs(int l, String[] people, int[] ch, StringBuilder sb, List<Condition> conditionList) {
        if (l == 8) {
            cnt++;
        } else {
            for (int i = 0; i < people.length; i++) {
                if (ch[i] == 0) {
                    sb.append(people[i]);
                    if (isPartialValid(sb.toString(), conditionList)) {
                        ch[i] = 1;
                        dfs(l + 1, people, ch, sb, conditionList);
                        ch[i] = 0;
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public boolean isPartialValid(String arrangement, List<Condition> conditionList) {
        for (Condition condition : conditionList) {
            int pos1 = arrangement.indexOf(condition.name);
            int pos2 = arrangement.indexOf(condition.targetName);

            // 두 캐릭터 중 하나만 배치된 경우 유효성 체크 생략
            if (pos1 == -1 || pos2 == -1) continue;

            int distance = Math.abs(pos1 - pos2) - 1;

            if (condition.cond.equals("=") && distance != condition.cnt) {
                return false;
            } else if (condition.cond.equals("<") && distance >= condition.cnt) {
                return false;
            } else if (condition.cond.equals(">") && distance <= condition.cnt) {
                return false;
            }
        }
        return true;
    }

    static class Condition {
        String name;
        String targetName;
        String cond;
        int cnt;

        public Condition(String name, String targetName, String cond, int cnt) {
            this.name = name;
            this.targetName = targetName;
            this.cond = cond;
            this.cnt = cnt;
        }
    }

}
