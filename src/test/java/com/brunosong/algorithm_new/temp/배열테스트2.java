package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 배열테스트2 {

    @Test
    void 배열만들기5() {

        String[] intStrs = {"0123456789","9876543210","9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;
        //[56789, 99999]
        solution(intStrs,k,s,l);

    }


    @Test
    void qrCode(){

//        q	r	code	result
//        3	1	"qjnwezgrpirldywt"	"jerry"
//        1	0	"programmers"	"programmers"
        int q = 3;
        int r = 1;

        String code = "qjnwezgrpirldywt";

        solution(q,r,code);

    }


    public int[] solution(String[] intStrs, int k, int s, int l) {

        List<Integer> list = new ArrayList<>();

        for (String str : intStrs) {

            String sub1 = str.substring(s);

            int num = Integer.parseInt(sub1.substring(0, l));

            if(k < num) list.add(num);

        }



        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public String solution(int q, int r, String code) {
        String answer = "";

        char[] chars = code.toCharArray();

        for ( int i = 0 ; i < chars.length; i++ ) {


        }


        return answer;
    }
}
