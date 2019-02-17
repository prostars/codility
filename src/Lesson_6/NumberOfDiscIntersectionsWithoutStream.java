package Lesson_6;

// Lesson 6
// Sorting

// NumberOfDiscIntersections
// Compute the number of intersections in a sequence of discs.
// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
// https://app.codility.com/demo/results/trainingXAMBCV-56C/
// Performance : 25%

import java.util.Arrays;

public class NumberOfDiscIntersectionsWithoutStream {

  static public void main(String[] args) {
    int result;
    result = solution(new int[]{1, 5, 2, 1, 4, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 11);

    result = solution(new int[]{1, 1, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 3);

    result = solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
    System.out.printf("result = %d, pass = %b\n", result, result == 3);

    result = solution(new int[]{});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{3});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
  }

  static public int solution(int[] A) {
    class Pair {
      private long left;
      private long right;
    }

    Pair[] discs = new Pair[A.length];
    for (int x = 0; x < A.length; x++) {
      Pair p = new Pair();
      p.left = (long)x - A[x];
      p.right = (long)x + A[x];
      discs[x] = p;
    }

    Arrays.sort(discs, (a, b) -> (b.right < a.right) ? -1 : ((a.right == b.right) ? 0 : 1));

    int intersects = 0;
    for (int i = 0; i < A.length - 1; i++) {
      long left = discs[i].left;
      for (int j = i + 1; j < A.length; j++) {
        if (intersects > 10_000_000)
          return -1;

        if (left <= discs[j].right && left <= discs[A.length - 1].right) {
          intersects += A.length - j;
          break;
        }
        else if (left > discs[j].right)
          break;
        
        intersects++;
      }
    }

    return intersects;
  }
}
