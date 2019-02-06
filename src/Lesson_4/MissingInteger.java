package Lesson_4;

// Lesson 4
// Counting Elements

// MissingInteger
// Find the smallest positive integer that does not occur in a given sequence.
// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
// https://app.codility.com/demo/results/trainingNKJJQJ-KV9/

import java.util.HashSet;

public class MissingInteger {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{1, 3, 6, 4, 1, 2});
    System.out.printf("result = %d, pass = %b\n", result, result == 5);

    result = solution(new int[]{1, 2, 3});
    System.out.printf("result = %d, pass = %b\n", result, result == 4);

    result = solution(new int[]{-1, -3});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{1});
    System.out.printf("result = %d, pass = %b\n", result, result == 2);

    result = solution(new int[]{2});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{1, 3, 6, 1, 2});
    System.out.printf("result = %d, pass = %b\n", result, result == 4);

    result = solution(new int[]{-7, 9, 2000, 3, 1, 2});
    System.out.printf("result = %d, pass = %b\n", result, result == 4);
  }

  public static int solution(int[] A) {
    HashSet<Integer> integers = new HashSet<>();

    for (Integer number : A) {
      if (number > 0)
        integers.add(number);
    }

    for (int number = 1; number <= 1_000_000; number++) {
      if (!integers.contains(number))
        return number;
    }

    return 1;
  }
}

