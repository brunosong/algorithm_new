package com.brunosong.algorithm_new.프로그래머스LV1;

public class 덧칠하기 {

    public static void main(String[] args) {

//        n	m	section	result
//        8	4	[2, 3, 6]	2
//        5	4	[1, 3]	1
//        4	1	[1, 2, 3, 4]	4

        int[] section = {2, 3, 6};
        solution2(8,4, section);

    }

    public static int solution2(int n, int m, int[] section) {

//        전반적인 접근법 [JS풀이O]
//        n은 사실 고려하지 않아도 되는 문제입니다.
//
//        section의 원소는 오름차순으로 정렬되어 있기 때문에 section을 순회하며 해당 지점을 시작으로 하여 최대로 칠하고 칠해진 마지막 인덱스를 갱신해 가면 됩니다.
//
//        예를 들어 section이 [1,3,4]이고 m이 2인 경우
//
//        아직 칠하지 않았으므로 칠해진 마지막 인덱스는 0 입니다
//        1번 인덱스를 칠했는지 판별합니다 (0 보다 크므로 칠하지 않았습니다)
//        1, 2번 인덱스를 칠합니다 (칠해진 마지막 인덱스를 2로 갱신합니다)
//        3번 인덱스를 칠했는지 판별합니다 (2 보다 크므로 칠하지 않았습니다)
//        3, 4번 인덱스를 칠합니다 (칠해진 마지막 인덱스를 4로 갱신합니다)
//        4번 인덱스를 칠했는지 판별합니다 (4 보다 크지 않으므로 칠했습니다)
//        이와 같이 순회하면 answer의 값이 2임을 풀이 하실 수 있습니다.

        int answer = 0;
        int max = 0;

        for(int s : section) {
            if(s > max) {
                answer++;
                max = s + m - 1;
            }
        }

        System.out.println(answer);
        return answer;
    }

    public static int solution(int n, int m, int[] section) {

        if(m >= n) return 1;

        int answer = 0;
        int[] wall = new int[n+1];

        for(int a : section) {
            wall[a] = 1;
        }

        int start = section[0];
        int end = section[section.length - 1];
        int cnt = 0;
        for (int i = start; i <= end ; i++) {
            if(wall[i] == 1) {
                if(i + m <= wall.length - 1) {
                    for (int j = 0; j < m; j++) {
                        int w = wall[i + j];
                        if(w == 1) {
                            wall[i+j] = 0;
                        }
                    }
                    cnt++;
                } else if(i + m > wall.length - 1) {
                    for (int j = 0; j < m; j++) {
                        int w = wall[i - j];
                        if(w == 1) {
                            wall[i-j] = 0;
                        }
                    }
                    cnt++;
                }
            }

        }

        return cnt;
    }




}
