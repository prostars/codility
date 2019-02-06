package Lesson_5;

// Lesson 5
// Prefix Sums

// MinAvgTwoSlice
// Find the minimal average of any slice containing at least two elements.
// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// https://app.codility.com/demo/results/trainingYZ3ZH5-SAQ/

public class MinAvgTwoSlice {

  public static void main(String[] args) {
    int result = solution(new int[]{4, 2, 2, 5, 1, 5, 8});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution(new int[]{1, 5, 1, 9});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{1, 5});
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution(new int[]{1, -5, -200, 30});
    System.out.printf("result = %d, pass = %b\n", result, result == 1);
  }

  public static int solution(int[] A) {
    float minAvg = (A[0] + A[1]) / 2.0f;
    int startIdxForMinAvgSlice = 0;
    for (int idx = 2; idx < A.length; ++idx) {
      float avg = (A[idx - 1] + A[idx]) / 2.0f;
      if (avg < minAvg) {
        minAvg = avg;
        startIdxForMinAvgSlice = idx - 1;
      }
      avg = (A[idx- 2] + A[idx - 1] + A[idx]) / 3.0f;
      if (avg < minAvg) {
        minAvg = avg;
        startIdxForMinAvgSlice = idx - 2;
      }
    }
    return startIdxForMinAvgSlice;
  }
}
