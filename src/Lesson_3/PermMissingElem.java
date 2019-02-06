package Lesson_3;

// Lesson 3
// Time Complexity

// PermMissingElem
// Find the missing element in a given permutation.
// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
// https://app.codility.com/demo/results/trainingU8UKUY-QBU/

public class PermMissingElem {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{2, 3, 1, 5});
    System.out.printf("result = %d, pass = %b\n", result, result == 4);
    result = solution(new int[]{1});
    System.out.printf("result = %d, pass = %b\n", result, result == 2);
    result = solution(new int[]{2});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
    result = solution(new int[]{});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
  }

  public static int solution(int[] A) {
    if (A == null || A.length == 0)
      return 1;

    int sum = 0;
    for (int n : A)
      sum += n;

    return sumOfPermutation(A.length + 1) - sum;
  }

  private static int sumOfPermutation(int maxValue) {
    if (maxValue % 2 == 0)
      return (maxValue + 1) * (maxValue / 2);
    return maxValue * ((maxValue - 1) / 2) + maxValue;
  }
}
