package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class 배열테스트5 {

    @Test
    void test() {
        String[] arr = {"u", "u", "l", "r","b","b","l"};//	["u", "u"]
        System.out.println(Arrays.toString(solution(arr)));

        String myString = "ihrhbakrfpndopljhygc";
        int m = 4;
        int c = 2;

        System.out.println(solution2(myString,m,c));

        int[] num_list  = {2, 1, 6};
        int n = 1;

        System.out.println(solution(num_list,n));

    }

    public String[] solution(String[] str_list) {

        ArrayList<String> list = new ArrayList<>();

        int point = 0;
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                for (; point < i; point++) {
                    list.add(str_list[point]);
                }
                break;
            } else if (str_list[i].equals("r")) {
                for (int j = i + 1; j < str_list.length; j++) {
                    list.add(str_list[j]);
                }
                break;
            }
        }


        return list.toArray(new String[0]);

    }


    public String[] solution2(String[] str_list) {

        String[] temp = new String[str_list.length];
        int count = 0;

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l")) {
                for (int j = 0; j < i; j++) {
                    temp[count] = str_list[j];
                    count++;
                }
                break;
            } else if (str_list[i].equals("r")) {
                for (int j = i + 1; j < str_list.length; j++) {
                    temp[count] = str_list[j];
                    count++;
                }
                break;
            }
        }


        String[] answer = new String[count];
        for (int i = 0; i < count; i++) {
            answer[i] = temp[i];
        }


        return answer;
    }


    public String solution(String my_string, int m, int c) {
        String answer = "";

        char[] chars = my_string.toCharArray();

        List<Character[]> list = new ArrayList<>();
        Character[] aa = null;

        for (int i = 0; i < chars.length; i++) {
            if (i % m == 0) {
                aa = new Character[m];
                list.add(aa);
            }
            aa[i % m] = chars[i];
        }

        list.forEach( v -> System.out.println(Arrays.toString(v)));

        String collect = list.stream().map(v -> v[c - 1])
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println();

        return collect;
    }

    /* 간단식으로 풀기 */
    public String solution2(String my_string, int m, int c) {

        String answer = "";

        //포문 자체를 4칸씩 돌리자
        for (int i = 0; i < my_string.length(); i += m) {
            //첫번째 문자만 출력
            System.out.println(my_string.charAt(i));
        }

        //이렇게 되면 4개씩 돌리게 되는거고 그중에 원하는건 c 번째 값이다.
        //하지만 c 는 1부터 시작하기때문에 -1 을 해준다.
        for (int i = c - 1; i < my_string.length(); i += m) {
            //첫번째 문자만 출력
            answer += my_string.charAt(i);
        }


        return answer;
    }


    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = num_list[i];
        }

        return answer;
    }
}
