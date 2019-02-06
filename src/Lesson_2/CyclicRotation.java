package Lesson_2;

// Lesson 2
// Arrays

// CyclicRotation
// Rotate an array to the right by a given number of steps.
// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
// https://app.codility.com/demo/results/trainingTX3EYU-RSB/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicRotation {

  public static void main(String[] args) {
    String result;
    result = Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[9, 7, 6, 3, 8]"));

    result = Arrays.toString(solution(new int[]{0, 0 ,0}, 1));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[0, 0, 0]"));

    result = Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[1, 2, 3, 4]"));

    result = Arrays.toString(solution(new int[]{}, 0));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[]"));

    result = Arrays.toString(solution(new int[]{-1000, 3, -200, 1000, 333}, 7));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[1000, 333, -1000, 3, -200]"));

  }

  public static int[] solution(int[] A, int K) {
    if (A == null || A.length == 0 || K == 0)
      return A;

    List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

    for (int i = 0; i < K; i++) {
      list.add(0, list.get(list.size() - 1));
      list.remove(list.size() - 1);
    }

    return list.stream().mapToInt(i->i).toArray();
  }
}
