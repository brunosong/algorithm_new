package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringTest {

    @Test
    void test(){
        //이거를 쪼개려면
        String s = "aya";
        String test = "ayayeyeayayeaya";

        /*  " yeye ye"
         */

        //test = test.replaceAll(s , " ");

        //test = test.("ye" , " ");

        System.out.println(test.substring(3,5));

    }

    @Test
    void ddd() {

        String a = "aBcDeFg";

        char[] chars = a.toCharArray();

        for (char ch : chars) {
            if(Character.isUpperCase(ch)){
                System.out.println(String.valueOf(ch).toLowerCase());
            }else{
                System.out.println(String.valueOf(ch).toUpperCase());
            }
        }


//        my_string	overwrite_string	s	result
//        "He11oWor1d"	"lloWorl"	2	"HelloWorld"
//        "Program29b8UYP"	"merS123"	7	"ProgrammerS123"

        String aa = "Program29b8UYP";
        String bb = "merS123";

        int length = bb.length();

        System.out.println(aa.substring(0,7) + bb + aa.substring(length+7));
        System.out.println(aa.substring(length+7));

//        str1	str2	result
//        "aaaaa"	"bbbbb"	"ababababab"

        String str1 = "aaaaa";
        String str2 = "bbbbb";

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars1.length; i++) {
            sb.append(chars1[i]);
            sb.append(chars2[i]);
        }

        System.out.println(sb.toString()
        );
    }
}
