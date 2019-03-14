package Lesson_7;

// Lesson 7
// Stacks and Queues

// Nesting
// Determine whether a given string of parentheses (single type) is properly nested.
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
// https://app.codility.com/demo/results/trainingVQQFGT-8XT/

import java.util.Stack;

public class Nesting {

    public static void main(String[] args) {
        int result;
        result = solution("(()(())())");
        System.out.printf("result = %d, pass = %b\n", result, result == 1);

        result = solution("(()(())()");
        System.out.printf("result = %d, pass = %b\n", result, result == 0);

        result = solution("(()(())");
        System.out.printf("result = %d, pass = %b\n", result, result == 0);

        result = solution("((())");
        System.out.printf("result = %d, pass = %b\n", result, result == 0);

        result = solution("((())())");
        System.out.printf("result = %d, pass = %b\n", result, result == 1);

        result = solution("())");
        System.out.printf("result = %d, pass = %b\n", result, result == 0);
    }

    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (')' == ch) {
                if (stack.isEmpty())
                    return 0;

                stack.pop();
            }
            else
                stack.push(ch);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
