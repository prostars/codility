package Lesson_4;

// Lesson 4
// Counting Elements

// FrogRiverOne
// Find the earliest time when a frog can jump to the other side of a river.
// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
// https://app.codility.com/demo/results/trainingWQ7G5A-JZP/

public class FrogRiverOne {

  public static void main(String[] args) {
    int result;
    result = solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
    System.out.printf("result = %d, pass = %b\n", result, result == 6);
    result = solution(1, new int[]{1});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
  }

  public static int solution(int X, int[] A) {
    final int targetValue = sumOfPermutation(X);
    int sumOfLeaves = 0;
    boolean[] leaves = new boolean[X];

    for (int second = 0; second < A.length; second++) {
      final int position = A[second];
      if (!leaves[position - 1]) {
        leaves[position - 1] = true;
        sumOfLeaves += position;

        if (sumOfLeaves == targetValue)
          return second;
      }
    }
    
    return -1;
  }

  private static int sumOfPermutation(int maxValue) {
    if (maxValue % 2 == 0)
      return (maxValue + 1) * (maxValue / 2);
    return maxValue * ((maxValue - 1) / 2) + maxValue;
  }
}
