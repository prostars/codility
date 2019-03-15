package Lesson_7;

// Lesson 7
// Stacks and Queues

// Nesting
// Determine whether a given string of parentheses (single type) is properly nested.
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
// https://app.codility.com/demo/results/training52F4AT-EDE/

public class NestingWithoutStack {

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
        int sum = 0;
        for (char ch : S.toCharArray()) {
            if (')' == ch)
                sum--;
            else
                sum++;
            if (sum < 0)
                return 0;
        }

        return sum == 0 ? 1 : 0;
    }
}
