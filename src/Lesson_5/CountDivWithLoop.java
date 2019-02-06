package Lesson_5;

// Lesson 5
// Prefix Sums

// CountDiv
// Compute number of integers divisible by k in range [a..b].
// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
// https://app.codility.com/demo/results/training3MTV4N-YJF/
// Performance : 25%

public class CountDivWithLoop {

  public static void main(String[] args) {
    int result;
    result = solution(6, 11, 2);
    System.out.printf("result = %d, pass = %b\n", result, result == 3);

    result = solution(6, 11, 3);
    System.out.printf("result = %d, pass = %b\n", result, result == 2);

    result = solution(6, 55, 5);
    System.out.printf("result = %d, pass = %b\n", result, result == 10);

    result = solution(10, 10, 7);
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(11, 14, 2);
    System.out.printf("result = %d, pass = %b\n", result, result == 2);

    result = solution(11, 14, 20);
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(11, 140000, 100000);
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(0, 0, 11);
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(0, 0, 5);
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(0, 3, 1);
    System.out.printf("result = %d, pass = %b\n", result, result == 4);
  }

  public static int solution(int A, int B, int K) {
    int start = A;
    if (start % K != 0) {
      if (K > start)
        start = K;
      else if (K * 2 > start)
        start = K * 2;
      else
        start += start % K;
    }
    
    int count = 0;
    for (int n = start; n <= B; n += K)
      if (n % K == 0)
        count++;

    return count;
  }
}
