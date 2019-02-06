package Lesson_3;

// Lesson 3
// Time Complexity

// FrogJmp
// Count minimal number of jumps from position X to Y.
// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
// https://app.codility.com/demo/results/training4T87X4-Y8S/

public class FrogJump {

  public static void main(String[] args) {
    int result;
    result = solution(10, 85, 30);
    System.out.printf("result = %d, pass = %b\n", result, result == 3);
    result = solution(10, 13, 2);
    System.out.printf("result = %d, pass = %b\n", result, result == 2);
    result = solution(10, 10, 30);
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
    result = solution(10, 13, 3);
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
    result = solution(1, 5, 2);
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
    result = solution(3, 999111321, 7);
    System.out.printf("result = %d, pass = %b\n", result, result == 142730189);
  }

  public static int solution(int X, int Y, int D) {
    if (X == Y)
      return 0;

    int jumps = (Y - X) / D;
    if (jumps * D + X < Y)
      return jumps + 1;

    return jumps;
  }
}
