package Lesson_6;

// Lesson 6
// Sorting

// Distinct
// Compute number of distinct values in an array.
// https://app.codility.com/programmers/lessons/6-sorting/distinct/
// https://app.codility.com/demo/results/trainingCRRXGB-ZU2/

import java.util.HashSet;

public class Distinct {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{2, 1, 1, 2, 3, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 3);

    result = solution(new int[]{2, 1, 1, 2, 3, 1, 6, 8});
    System.out.printf("result = %d, pass = %b\n", result, result == 5);

    result = solution(new int[]{});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{2});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{-2, -1324, 14234, -2, 4345});
    System.out.printf("result = %d, pass = %b\n", result, result == 4);

    result = solution(new int[]{-2242342});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
  }

  public static int solution(int[] A) {
    HashSet<Integer> distinct = new HashSet<>();

    for (int number : A)
      distinct.add(number);

    return distinct.size();
  }
}
