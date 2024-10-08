package com.brunosong.algorithm_new.시뮬레이션;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 과일가져가기 {

    @Test
    void test() {
        //        각 학생은 책상에 있는 세 바구니 중 하나를 가질 수 있습니다. 단 이 세 바구니 중 가장 적게
        //        과일이 담겨있는 바구니를 가집니다.
        //        1) 1번 학생부터 번호 순으로 교환을 할 건지 결정합니다.
        //        2) 교환을 하는 양쪽 학생이 서로 이득이 되면 무조건 교환을 합니다. 즉 양쪽이 모두 가져가
        //        는 과일의 개수가 원래 가져가려고 했던 것보다 증가한다면 교환을 무조건 합니다.
        //        3) 교환을 할 때는 A바구니는 사과만, B바구니에는 배만, C바구니에는 귤만 담아야 합니다.
        //        4) 교환 가능한 학생이 여러명일 경우 가장 번호가 작은 학생과 교환합니다.
        //        5) 서로가 이득이 생기는 경우가 존재하지 않으면 교환하지 않는 학생도 있습니다.
        //int[][] fruit = {{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10},{10, 15, 10}};
        int[][] fruit = {{10, 9, 11}, {15, 20, 25}};
        solution(fruit);
    }

    public int solution(int[][] fruit) {
        int answer = 0;
        int[] persons = getMinIndex(fruit);

        int[] dis = new int[persons.length];
        for (int p1 = 0; p1 < persons.length; p1++) {
            if (dis[p1] == 1) continue;
            if (!isMinUnique(fruit[p1][persons[p1]], fruit[p1])) continue;

            for (int p2 = 0; p2 < persons.length; p2++) {
               if (p1 == p2) continue;
                if (persons[p1] != persons[p2] && fruit[p1][persons[p2]] > 0 && fruit[p2][persons[p1]] > 0) {

                    if (fruit[p1][persons[p2]] - 1 > fruit[p1][persons[p1]] + 1 && fruit[p2][persons[p1]] - 1 > fruit[p2][persons[p2]] + 1) {
                        fruit[p1][persons[p1]]++;
                        fruit[p1][persons[p2]]--;

                        fruit[p2][persons[p2]]++;
                        fruit[p2][persons[p1]]--;

                        dis[p1] = 1;
                        dis[p2] = 1;

                        break;
                    }
                }

            }
        }


        int sum = 0;
        for (int i = 0; i < persons.length; i++) {
            sum += fruit[i][persons[i]];
        }
        System.out.println(sum);
        System.out.println(Arrays.toString(persons));
        return answer;
    }

    public boolean isMinUnique(int min, int[] fruit) {
        int cnt = 0;
        for (int i = 0; i < fruit.length; i++) {
            if (min == fruit[i]) cnt++;
        }
        return cnt == 1;
    }


    public int[] getMinIndex(int[][] fruit) {
        int[] persons = new int[fruit.length];
        int cnt = 0;
        for (int[] f : fruit) {
            int rowIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < f.length; i++) {
                if (f[i] < min) {
                    min = f[i];
                    rowIndex = i;
                }
            }
            persons[cnt++] = rowIndex;
        }
        return persons;
    }
}
