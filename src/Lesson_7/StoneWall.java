package Lesson_7;

// Lesson 7
// Stacks and Queues

// StoneWall
// Cover "Manhattan skyline" using the minimum number of rectangles.
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
// https://app.codility.com/demo/results/trainingDSZUZ8-S4E/

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {
        int result;

        result = solution(new int[]{1, 3, 5, 4, 1});
        System.out.printf("result = %d, pass = %b\n", result, result == 4);

        result = solution(new int[]{1, 3, 5, 3, 1});
        System.out.printf("result = %d, pass = %b\n", result, result == 3);

        result = solution(new int[]{5, 3, 1, 3, 5});
        System.out.printf("result = %d, pass = %b\n", result, result == 5);

        result = solution(new int[]{5, 4, 3, 2, 1});
        System.out.printf("result = %d, pass = %b\n", result, result == 5);

        result = solution(new int[]{1, 2, 3, 4, 5});
        System.out.printf("result = %d, pass = %b\n", result, result == 5);

        result = solution(new int[]{8, 8, 4, 6, 4});
        System.out.printf("result = %d, pass = %b\n", result, result == 3);

        result = solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8});
        System.out.printf("result = %d, pass = %b\n", result, result == 7);

        result = solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 4});
        System.out.printf("result = %d, pass = %b\n", result, result == 6);

        result = solution(new int[]{8, 8, 5, 7, 9, 9, 7, 4, 4});
        System.out.printf("result = %d, pass = %b\n", result, result == 5);

        result = solution(new int[]{8});
        System.out.printf("result = %d, pass = %b\n", result, result == 1);

        result = solution(new int[]{8, 8, 8, 8, 8});
        System.out.printf("result = %d, pass = %b\n", result, result == 1);

        result = solution(new int[]{8, 8, 4, 4, 4});
        System.out.printf("result = %d, pass = %b\n", result, result == 2);
    }

    public static int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;

        for (int current : H) {
            while (!stack.isEmpty() && stack.peek() > current) {
                stack.pop();
                blocks++;
            }

            if (stack.isEmpty() || stack.peek() != current)
                stack.push(current);
        }

        return blocks + stack.size();
    }
}
