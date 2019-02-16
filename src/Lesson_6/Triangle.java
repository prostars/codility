package Lesson_6;

// Lesson 6
// Sorting

// Triangle
// Determine whether a triangle can be built from a given set of edges.
// https://app.codility.com/demo/results/trainingZKGHPS-WB2/

import java.util.Arrays;

public class Triangle {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{10, 2, 5, 1, 8, 20});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{10, 50, 5, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{5, 4, 2, 4, 1, 2});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{3});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{3, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{3, 1, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
  }

  public static int solution(int[] A) {
    Arrays.sort(A);

    for (int idx = 0; idx < A.length; idx++) {
      if (idx + 2 < A.length) {
        long sum = (long)A[idx] + A[idx + 1];
        if (sum > A[idx + 2])
          return 1;
      }
    }

    return 0;
  }
}
