package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 숫자짝꿍 {

//        X	Y	result
//        "100"	"2345"	"-1"
//        "100"	"203045"	"0"
//        "100"	"123450"	"10"
//        "12321"	"42531"	"321"
//        "5525"	"1255"	"552"

    public static void main(String[] args) {

        String X = "0012321";
        String Y = "0042531";

        System.out.println(solution2(X,Y));

    }

    public static String solution(String X, String Y) {
        String answer = "";

//        Arrays.sort(X);
//        Arrays.sort(Y);




        return answer;

    }


    public static String solution2(String X, String Y) {

        String answer = "";

        Set<Character> set = new HashSet<>();

        for(char c : X.toCharArray()){
            set.add(c);
        }

        List<Long> list = new ArrayList<>();

        boolean zero = true;
        for(char cc : Y.toCharArray()) {
            if (cc == '0') {
                if (set.contains(cc) && zero) {
                    zero = false;
                    list.add((long) Character.getNumericValue(cc));
                }
            }else{
                if (set.contains(cc)) {
                    list.add((long) Character.getNumericValue(cc));
                }

            }

        }

        if(list.isEmpty()){
            return "-1";
        }

        Collections.sort(list, Collections.reverseOrder());

        Stream<String> stringStream = list.stream().map(String::valueOf);
        String collect = stringStream.collect(Collectors.joining());

        System.out.println(collect);

        return collect;
    }
}
