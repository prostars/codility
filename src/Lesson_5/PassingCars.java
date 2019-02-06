package Lesson_5;

// Lesson 5
// Prefix Sums

// PassingCars
// Count the number of passing cars on the road.
// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
// https://app.codility.com/demo/results/training48ZD3W-SDM/

public class PassingCars {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{0, 1, 0, 1, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 5);
    result = solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 13);
    result = solution(new int[]{0});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
    result = solution(new int[]{1});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
    result = solution(new int[]{1, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
    result = solution(new int[]{0, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
    result = solution(new int[]{0, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
    result = solution(new int[]{1, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
  }

  public static int solution(int[] A) {
    final int LimitPassingCars = 1_000_000_000;
    final int East = 0;
    final int West = 1;
    int eastCars = 0;
    int passingCars = 0;

    for (int direction : A) {
      if (direction == East)
        eastCars++;
      else if (direction == West) {
        passingCars += eastCars;
        if (passingCars > LimitPassingCars)
          return -1;
      }
    }

    return passingCars;
  }
}
