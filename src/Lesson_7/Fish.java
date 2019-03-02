package Lesson_7;

// Lesson 7
// Stacks and Queues

// Fish
// N voracious fish are moving along a river. Calculate how many fish are alive.
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
// https://app.codility.com/demo/results/trainingH76XFB-B78/

import java.util.Stack;

public class Fish {

  public static void main(String[] args) {
    int result;
    result = solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 2);

    result = solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 0, 0, 0, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 5);

    result = solution(new int[]{4}, new int[]{0});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{4, 1}, new int[]{0, 1});
    System.out.printf("result = %d, pass = %b\n", result, result == 2);

    result = solution(new int[]{4, 1}, new int[]{1, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{4, 3, 2, 1, 5}, new int[]{1, 1, 0, 0, 0});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
  }

  public static int solution(int[] A, int[] B) {
    Stack<Integer> downstream = new Stack<>();
    int survivor = 0;

    for (int idx = 0; idx < A.length; idx++) {
      if (B[idx] == 0) {
        survivor++;
        while (!downstream.isEmpty()) {
          survivor--;
          if (downstream.peek() < A[idx])
            downstream.pop();
          else
            break;
        }
      } else {
        downstream.push(A[idx]);
        survivor++;
      }
    }

    return survivor;
  }
}
