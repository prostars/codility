package Lesson_2;

// Lesson 2
// Arrays

// OddOccurrencesInArray
// Find value that occurs in odd number of elements.
// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
// https://app.codility.com/demo/results/trainingH6VKNU-BUK/
// Performance : 75%

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OddOccurrencesInArrayWithStream {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{9, 3, 9, 3, 9, 7, 9});
    System.out.printf("result = %d, pass = %b\n", result, result == 7);

    result = solution(new int[]{2, 2, 3, 3, 7, 4, 4, 3, 3, 3, 3});
    System.out.printf("result = %d, pass = %b\n", result, result == 7);

    result = solution(new int[]{7, 7, 7, 6, 7, 5, 5, 3, 2, 3, 2, 4, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 6);

    result = solution(new int[]{7, 7, 7, 7, 7, 5, 5, 3, 2, 3, 2, 4, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 7);

    result = solution(new int[]{2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 98});
    System.out.printf("result = %d, pass = %b\n", result, result == 2);
  }

  public static int solution(int[] A) {
    if (A.length < 2)
      return A[0];

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int idx = 0; idx < A.length; idx++) {
      map.computeIfPresent(A[idx], (k, v) -> v + 1);
      map.putIfAbsent(A[idx], 1);
    }

    Optional<Integer> unpaired = map.entrySet().stream()
      .filter(entry -> entry.getValue() % 2 == 1)
      .map(Map.Entry::getKey)
      .findFirst();

    return unpaired.orElse(0);
  }
}