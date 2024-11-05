package com.brunosong.algorithm_new.프로그래머스;

import com.jayway.jsonpath.internal.function.numeric.Max;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 공원 {

    @Test
    void test() {

        int[] mats = {1};
        String[][] park = {
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"A", "A", "-1", "B", "B", "B", "B", "-1"},
            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        Assertions.assertThat(solution(mats,park)).isEqualTo(3);
    }

    public int solution(int[] mats, String[][] park) {

        int max = -1;

        Integer[] matsBox = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(matsBox, Collections.reverseOrder());

        for (int x = 0; x < park.length; x++) {
            for (int y = 0; y < park[x].length; y++) {
                if (park[x][y].equals("-1")) {
                    int size = matchMats(x,y,matsBox,park);
                    max = Math.max(max,size);
                }
            }
        }

        return max;
    }

    public int matchMats(int x, int y, Integer[] mats, String[][] park) {
        for (int size : mats) {
            int ex = x + size-1;
            int ey = y + size-1;
            boolean ch = true;

            if (ex >= park.length || ey >= park[0].length) continue;

            outerLoop:
            for (int i = x; i <= ex; i++) {
                for (int j = y; j <= ey; j++) {
                    if(!park[i][j].equals("-1")) {
                        ch = false;
                        break outerLoop;
                    }
                }
            }
            if (ch) return size;
        }
        return -1;
    }
}
