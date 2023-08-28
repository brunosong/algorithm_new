package com.brunosong.algorithm_new.프로그래머스LV0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 전국대회선발대회 {

    public static void main(String[] args) {

        int[] rank = {3, 7, 2, 5, 4, 6, 1};
        boolean[] attendance = {false, true, true, true, true, false, false};

        solution(rank,attendance);

    }

//        rank	attendance	result
//        [3, 7, 2, 5, 4, 6, 1]	[false, true, true, true, true, false, false]	20403
//        [1, 2, 3]	[true, true, true]	102
//        [6, 1, 5, 2, 3, 4]	[true, false, true, false, false, true]	50200

    public static int solution(int[] rank, boolean[] attendance) {

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < rank.length; i++) {
            students.add(new Student(rank[i],attendance[i],i));
        }

        Collections.sort(students);

        int[] ints = students.stream().filter(s -> s.att)
                .mapToInt(s -> s.index)
                .toArray();


        int result = 10000 * ints[0] + 100 * ints[1] + ints[2];

        return result;
    }



}

class Student implements Comparable<Student>{

    int num;
    boolean att;
    int index;
    public Student(int num, boolean att, int index) {
        this.num = num;
        this.att = att;
        this.index = index;
    }

    @Override
    public int compareTo(Student o) {
        return this.num - o.num;
    }
}
