package Lesson_6;

// Lesson 6
// Sorting

// MaxProductOfThree
// Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
// https://app.codility.com/demo/results/trainingA3EPJG-3TG/
// Performance : 0%

public class MaxProductOfThreeWithoutSort {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{-3, 1, 2, -2, 5, 6});
    System.out.printf("result = %d, pass = %b\n", result, result == 60);

    result = solution(new int[]{6, 2, 1, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 48);

    result = solution(new int[]{6, 2, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 12);
  }

  public static int solution(int[] A) {
    int max = Integer.MIN_VALUE;

    for (int p = 0; p < A.length - 2; p++) {
      for (int q = p + 1; q < A.length - 1; q++) {
        for (int r = q + 1; r < A.length; r++) {
          int product = A[p] * A[q] * A[r];
          if (product > max)
            max = product;
        }
      }
    }

    return max;
  }
}
