package com.brunosong.algorithm_new.연습.week2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 목표값만들기 (11-25, DFS)
 * 비슷한 원래 문제: 프로그래머스 "타겟 넘버". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=목표값만들기
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 정수 배열 numbers가 있습니다. 순서는 바꾸지 않고, 각 수 앞에 + 또는 -를 붙여 모두 더합니다.
 * 합이 target이 되는 부호 조합이 몇 가지인지 return 해 주세요.
 *
 * [제한사항]
 * - numbers의 길이는 2 이상 20 이하입니다.
 * - 각 수는 1 이상 50 이하입니다.
 * - target은 -1,000 이상 1,000 이하입니다.
 *
 * [입출력 예]
 *   입력               result
 *   {2, 3, 1}, 4       1
 *   {1, 1, 1, 1}, 0    6
 *   {5, 2}, 1          0
 *
 * [입출력 예 설명]
 * 입출력 예 #1: +2 +3 -1 = 4 한 가지뿐입니다.
 */
public class 목표값만들기 {
    private int count = 0;
    public int solution(int[] numbers, int target) {
        // 여기에 풀이를 작성합니다.
        dfs(0, numbers.length, 0, numbers, target);
        return count;
    }

    public void dfs(int level, int n, int sum, int[] numbers, int target) {

        if (level == n) {
            if (sum == target) count++;
        } else {
            dfs(level + 1, n, sum + numbers[level], numbers,target);
            dfs(level + 1, n, sum - numbers[level], numbers,target);
        }
    }

    // ================= 솔루션 2 (더 깔끔한 방법) =================
    // 내 풀이와 같은 DFS인데, count 필드 대신 dfs가 "만든 방법 수"를 return 합니다.
    // → 필드가 없으니 solution을 여러 번 불러도 값이 섞이지 않습니다.
    // → n은 numbers.length로 알 수 있어서 따로 넘기지 않습니다.

    public int solution2(int[] numbers, int target) {
        // 0번째 수부터, 합계 0에서 출발
        return dfs2(numbers, target, 0, 0);
    }

    // index번째 수부터 끝까지 부호를 정했을 때, 합이 target이 되는 방법 수를 돌려준다
    private int dfs2(int[] numbers, int target, int index, int sum) {
        // 모든 수에 부호를 다 붙였다 → 합이 target이면 1가지, 아니면 0가지
        if (index == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        // 지금 수에 +를 붙이는 경우
        int plusWays = dfs2(numbers, target, index + 1, sum + numbers[index]);

        // 지금 수에 -를 붙이는 경우
        int minusWays = dfs2(numbers, target, index + 1, sum - numbers[index]);

        // 두 갈래의 방법 수를 더한다
        return plusWays + minusWays;
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals(1, solution(new int[]{2, 3, 1}, 4)); }
    @Test void 예제2() { assertEquals(6, solution(new int[]{1, 1, 1, 1}, 0)); }
    @Test void 예제3() { assertEquals(0, solution(new int[]{5, 2}, 1)); }
    @Test void 불가능() { assertEquals(0, solution(new int[]{1, 2}, 10)); }
    @Test @Timeout(2) void 큰입력_스무개() {
        int[] a = new int[20]; Arrays.fill(a, 1);
        assertEquals(167960, solution(a, 2));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{12, 11, 16, 12, 13, 4, 2, 4, 19}, -35, 11),
                Arguments.of(new int[]{17, 18, 19, 2, 17, 1, 16, 9, 10, 16, 2, 12}, -49, 46),
                Arguments.of(new int[]{19, 5, 18, 2, 20, 2, 6, 5, 16, 11, 13, 17}, 7, 0),
                Arguments.of(new int[]{13, 20, 19, 6, 9, 8, 16, 15, 2, 7, 8, 11}, -28, 58),
                Arguments.of(new int[]{4, 10, 16, 8, 3}, -3, 1),
                Arguments.of(new int[]{20, 7, 9, 20, 5}, -11, 2),
                Arguments.of(new int[]{14, 8, 4, 2, 6, 16}, -14, 3),
                Arguments.of(new int[]{3, 7, 13, 10, 15, 9, 4}, -1, 3),
                Arguments.of(new int[]{1, 13, 2, 5, 14, 10, 4, 19, 3, 9}, -14, 25),
                Arguments.of(new int[]{6, 13, 1, 5, 16}, -27, 1),
                Arguments.of(new int[]{11, 4, 11, 1, 11, 4, 13, 5, 19}, 45, 5),
                Arguments.of(new int[]{13, 12, 8, 15}, 18, 1),
                Arguments.of(new int[]{9, 18, 8, 19, 12, 17, 4, 8, 18}, -5, 7),
                Arguments.of(new int[]{5, 2}, -7, 1),
                Arguments.of(new int[]{20, 17, 20, 20, 11, 11, 4, 16, 8}, 39, 8),
                Arguments.of(new int[]{11, 19, 14, 7, 12, 8, 19, 6, 7, 1, 5, 9}, 24, 72),
                Arguments.of(new int[]{8, 18, 4, 11, 10, 8, 3}, -40, 3),
                Arguments.of(new int[]{7, 7, 4, 14, 10}, 14, 3),
                Arguments.of(new int[]{18, 11, 18, 12, 7}, -6, 3),
                Arguments.of(new int[]{7, 20, 4, 6}, 28, 0),
                Arguments.of(new int[]{15, 4, 14, 3, 16, 14, 20, 19, 1}, 27, 0),
                Arguments.of(new int[]{10, 14, 4, 14, 9, 2, 4, 3}, 14, 9),
                Arguments.of(new int[]{15, 12, 15, 15, 6}, 9, 3),
                Arguments.of(new int[]{4, 6, 6, 5, 20, 18, 19, 1, 9}, -8, 11),
                Arguments.of(new int[]{17, 3, 13}, -7, 1)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] numbers, int target, int expected) {
        assertEquals(expected, solution(numbers, target));
    }
}
