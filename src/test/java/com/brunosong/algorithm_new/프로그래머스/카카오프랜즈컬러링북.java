package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 카카오프랜즈컬러링북 {

//    int m = 6;
//    int n = 4;

    @Test
    void test() {
        solution();
    }

    void solution( ){

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        //리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

        int m = 6;
        int n = 4;

        int[][] picture = {
                 {1, 1, 1, 0},
                 {1, 2, 2, 0},
                 {1, 0, 0, 1},
                 {0, 0, 0, 1},
                 {0, 0, 0, 3},
                 {0, 0, 0, 3}
            };

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if(picture[i][j] != -1 && picture[i][j] != 0) {
                    int[] cnt = {1};
                    set.add(picture[i][j]);
                    int current = picture[i][j];
                    picture[i][j] = -1;
                    DFS(i,j,current,picture,cnt,m,n);
                    Math.max(maxSizeOfOneArea,cnt[0]);
                }
            }
        }

        // [4, 5]
    }

    void DFS(int i, int j, int current, int[][] picture,int[] cnt,int m, int n) {
        int[] dx = {-1,0,1, 0};
        int[] dy = { 0,1,0,-1};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx < m && nx >= 0 && ny < n && ny >= 0 && picture[nx][ny] == current) {
                picture[nx][ny] = -1;

                cnt[0] += 1;
                DFS(nx, ny, current, picture,cnt,m,n);
            }
        }
    }



}
