package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열테스트6 {

    @Test
    void test() {
        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};
        Arrays.toString(solution(names));

        String my_string = "banana";
        String is_suffix = "ana";



    }

    public String[] solution(String[] names) {

        List<String> list = new ArrayList<>();

        int i = 0;
        for (; i < names.length; i+=5) {
            list.add(names[i]);
        }

        return list.toArray(new String[0]);
    }


    public int is_suffix(String my_string, String is_suffix) {
        int answer = 0;




        return answer;
    }

}
