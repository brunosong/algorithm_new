package com.brunosong.algorithm_new.연습.week0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 가장큰수 (11-13, 정렬)
 * 비슷한 원래 문제: 프로그래머스 "가장 큰 수". 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=가장큰수
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 0 이상의 정수가 들어 있는 배열 numbers가 주어집니다. 숫자들의 순서를 바꿔 이어 붙여서 만들 수 있는 가장 큰 수를
 * 문자열로 return 하도록 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * - numbers의 길이는 1 이상 100,000 이하입니다.
 * - 각 원소는 0 이상 1,000 이하입니다.
 * - 답이 너무 클 수 있으니 문자열로 return 합니다.
 *
 * [입출력 예]
 *   numbers          result
 *   [5, 40, 7]       "7540"
 *   [9, 91, 34, 3]   "991343"
 *   [0, 0, 0]        "0"
 *
 * [입출력 예 설명]
 * 입출력 예 #2: 9와 91은 "991"이 "919"보다 크니 9가 앞, 34와 3은 "343"이 "334"보다 크니 34가 앞입니다.
 */
public class 가장큰수 {

    public String solution(int[] numbers) {

        // 0 체크
        boolean check = true;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                check = false;
            }
        }

        if (check) {
            return "0";
        }
        // 여기에 풀이를 작성합니다.
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a,b) -> {
            int aTemp = a;
            int bTemp = b;

            while (aTemp >= 10) {
                aTemp = aTemp / 10;
            }
            while (bTemp >= 10) {
                bTemp = bTemp / 10;
            }

            if (aTemp == bTemp) {
                String tempA = String.valueOf(a) + String.valueOf(b);
                int num1 = Integer.parseInt(tempA);

                String tempB = String.valueOf(b) + String.valueOf(a);
                int num2 = Integer.parseInt(tempB);

                return num2 - num1;

            } else {
                return bTemp - aTemp;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(String.valueOf(nums[i]));
        }

        return sb.toString();
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertEquals("7540", solution(new int[]{5, 40, 7})); }
    @Test void 예제2() { assertEquals("991343", solution(new int[]{9, 91, 34, 3})); }
    @Test void 예제3_전부0() { assertEquals("0", solution(new int[]{0, 0, 0})); }
    @Test void 십과이() { assertEquals("210", solution(new int[]{10, 2})); }
    @Test void 천() { assertEquals("10001000", solution(new int[]{1000, 1000})); }
    @Test void 첫자리같은세개() { assertEquals("34330", solution(new int[]{3, 30, 34})); }
    @Test void 한번훑기로안됨() { assertEquals("110100", solution(new int[]{10, 100, 1})); }
    @Test @Timeout(3) void 큰입력() {
        int[] a = new int[100_000]; Arrays.fill(a, 1);
        assertEquals("1".repeat(100_000), solution(a));
    }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of(new int[]{343, 3, 303, 330, 330, 343, 300, 33}, "343343333330330303300"),
                Arguments.of(new int[]{505, 550, 5, 5, 54}, "5555054505"),
                Arguments.of(new int[]{8, 12, 255, 435, 441}, "844143525512"),
                Arguments.of(new int[]{100, 101, 1}, "1101100"),
                Arguments.of(new int[]{909, 99, 909}, "99909909"),
                Arguments.of(new int[]{989, 9, 909, 9, 989}, "99989989909"),
                Arguments.of(new int[]{100, 34, 264, 50, 3}, "50343264100"),
                Arguments.of(new int[]{10, 0, 837, 9, 0}, "98371000"),
                Arguments.of(new int[]{5}, "5"),
                Arguments.of(new int[]{581, 17, 300, 799}, "79958130017"),
                Arguments.of(new int[]{33, 898, 303, 8, 99}, "99898833303"),
                Arguments.of(new int[]{1, 10, 110, 11}, "11111010"),
                Arguments.of(new int[]{450, 89, 421}, "89450421"),
                Arguments.of(new int[]{99, 1000, 0, 89, 303, 3, 894, 500}, "9989894500330310000"),
                Arguments.of(new int[]{909, 909, 990}, "990909909"),
                Arguments.of(new int[]{505, 50, 5, 54, 5, 50}, "55545055050"),
                Arguments.of(new int[]{5, 3, 99}, "9953"),
                Arguments.of(new int[]{990, 99, 990, 990, 9, 990, 990, 990}, "999990990990990990990"),
                Arguments.of(new int[]{1, 999, 4, 121}, "99941211"),
                Arguments.of(new int[]{33, 303, 343, 3, 303, 30}, "34333330330330"),
                Arguments.of(new int[]{121, 9, 91, 898, 10, 859, 744}, "99189885974412110"),
                Arguments.of(new int[]{110, 10, 101, 110, 100, 101, 1000}, "110110101101101001000"),
                Arguments.of(new int[]{135, 34, 30, 9, 99, 330, 9, 50}, "9999503433030135"),
                Arguments.of(new int[]{10, 1, 100, 101, 12, 1}, "121110110100"),
                Arguments.of(new int[]{90, 909, 9}, "990990")
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(int[] numbers, String expected) {
        assertEquals(expected, solution(numbers));
    }
}
