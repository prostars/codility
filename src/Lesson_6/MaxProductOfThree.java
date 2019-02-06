package Lesson_6;

// Lesson 6
// Sorting

// MaxProductOfThree
// Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
// https://app.codility.com/demo/results/trainingVZWPNQ-FYD/

import java.util.Arrays;

public class MaxProductOfThree {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{-3, 1, 2, -2, 5, 6});
    System.out.printf("result = %d, pass = %b\n", result, result == 60);

    result = solution(new int[]{6, 2, 1, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 48);

    result = solution(new int[]{6, 2, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 12);

    result = solution(new int[]{-5, 5, -5, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 125);
  }

  public static int solution(int[] A) {
    Arrays.sort(A);
    int front = A[0] * A[1] * A[A.length - 1];
    int back = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
    return Math.max(front, back);
  }
}
