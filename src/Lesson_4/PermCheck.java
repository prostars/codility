package Lesson_4;

// Lesson 4
// Counting Elements

// PermCheck
// Check whether array A is a permutation.
// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
// https://app.codility.com/demo/results/trainingPYGY5A-ABK/

import java.util.HashMap;

public class PermCheck {

  public static void main(String[] args) {
    int result;

    result = solution(new int[]{4, 1, 3, 2});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{4, 1, 3});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{1});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
    
    result = solution(new int[]{3});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{3, 2, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{3, 1, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{1, 4, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
  }

  public static int solution(int[] A) {
    HashMap<Integer, Integer> counter = new HashMap<>();
    Integer value = 0;

    for (int number : A) {
      value = counter.get(number);
      if (value == null)
        counter.put(number, 1);
      else
        return 0;
    }

    int sum = 0;
    for (int n : A)
      sum += n;

    return sumOfPermutation(A.length) == sum ? 1 : 0;
  }

  private static int sumOfPermutation(int maxValue) {
    if (maxValue % 2 == 0)
      return (maxValue + 1) * (maxValue / 2);
    return maxValue * ((maxValue - 1) / 2) + maxValue;
  }
}
