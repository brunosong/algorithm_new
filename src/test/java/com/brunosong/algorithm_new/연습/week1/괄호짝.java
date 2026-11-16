package com.brunosong.algorithm_new.연습.week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Stream;
// 풀이에 필요한 import는 직접 추가합니다.

import static org.junit.jupiter.api.Assertions.*;

/*
 * [문제] 괄호짝 (11-16, 스택)
 * 비슷한 원래 문제: 프로그래머스 "올바른 괄호", LeetCode 20. 지문과 데이터는 새로 만들었습니다.
 * 목표 시간: 40분. 넘기면 D:\SideProject\algorithm_new\풀이 를 봅니다.
 * 확인: IntelliJ에서 클래스 옆 실행 버튼, 또는 mvnw test -Dtest=괄호짝
 * 테스트: 예제와 경계값, 큰 입력(시간 제한), 추가 케이스 25개. 전부 통과해야 푼 것입니다.
 *
 * 괄호 (), [], {} 로만 된 문자열 s가 주어집니다.
 * 여는 괄호마다 같은 종류의 닫는 괄호가 올바른 순서로 짝지어져 있으면 true, 아니면 false를 return 해 주세요.
 *
 * [제한사항]
 * - s의 길이는 1 이상 100,000 이하입니다.
 *
 * [입출력 예]
 *   s          result
 *   "([]{})"   true
 *   "([)]"     false
 *   "(("       false
 *   "}{"       false
 */
public class 괄호짝 {

    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // ---------------- 테스트 ----------------

    @Test void 예제1() { assertTrue(solution("([]{})")); }
    @Test void 예제2() { assertFalse(solution("([)]")); }
    @Test void 예제3() { assertFalse(solution("((")); }
    @Test void 예제4() { assertFalse(solution("}{")); }
    @Test void 닫는것만() { assertFalse(solution(")")); }
    @Test @Timeout(2) void 큰입력() { assertTrue(solution("(".repeat(50_000) + ")".repeat(50_000))); }

    static Stream<Arguments> 추가케이스() {
        return Stream.of(
                Arguments.of("(}))", false),
                Arguments.of(")(", false),
                Arguments.of("[]([]){}{}", true),
                Arguments.of("{}[()]{}()", true),
                Arguments.of("{[{}(", false),
                Arguments.of("{))(}(]]", false),
                Arguments.of("([])({})", true),
                Arguments.of("[]({})()", true),
                Arguments.of("[{}][]{[{]]}", false),
                Arguments.of("}[", false),
                Arguments.of("([)){({{]", false),
                Arguments.of("{", false),
                Arguments.of("]]]}]{)[]", false),
                Arguments.of("([{{}[[]]}()", false),
                Arguments.of("()[()][]({})", true),
                Arguments.of("(}}{]{{)(", false),
                Arguments.of("]}}(", false),
                Arguments.of("])(()[[]", false),
                Arguments.of("()}]}({]]", false),
                Arguments.of("[]", true),
                Arguments.of("[[))]", false),
                Arguments.of(")(({", false),
                Arguments.of("])", false),
                Arguments.of("[]({[)", false),
                Arguments.of("([", false)
        );
    }

    @ParameterizedTest(name = "[{index}] {arguments}")
    @MethodSource("추가케이스")
    void 추가케이스(String s, boolean expected) {
        assertEquals(expected, solution(s));
    }
}
