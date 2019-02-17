package Lesson_6;

// Lesson 6
// Sorting

// NumberOfDiscIntersections
// Compute the number of intersections in a sequence of discs.
// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
// https://app.codility.com/demo/results/training7YFMKR-NMP/
// Performance : 0%

import java.util.ArrayList;

public class NumberOfDiscIntersectionsUsingStreamAndPair {

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
      private Pair(long left,long right) {
        this.left = left;
        this.right = right;
      }

      private Long left;
      private Long right;
    }

    ArrayList<Pair> discs = new ArrayList<>();
    for (int x = 0; x < A.length; x++)
      discs.add(new Pair((long)x - A[x], (long)x + A[x]));

    discs.sort((a, b) -> b.right.compareTo(a.right));

    int intersects = 0;
    while (discs.size() > 1) {
      Long left = discs.get(0).left;
      discs.remove(0);
      intersects += discs.stream().filter(disc -> disc.right >= left).count();
      if (intersects > 10_000_000)
        return -1;
    }

    return intersects;
  }
}
