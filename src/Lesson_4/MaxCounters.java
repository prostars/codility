package Lesson_4;

// Lesson 4
// Counting Elements

// MaxCounters
// Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
// https://app.codility.com/demo/results/trainingX5CJCU-JQW/

import java.util.Arrays;

public class MaxCounters {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    System.out.println(Arrays.toString(solution(5, new int[]{3})));
    System.out.println(Arrays.toString(solution(5, new int[]{6})));
  }

  public static int[] solution(int N, int[] A) {
    final int SetMaxCount = N + 1;
    int[] counters = new int[N];
    int maxCount = 0;
    int baseCount = 0;

    for (int operatorValue : A) {
      if (1 <= operatorValue && operatorValue <= N)
        maxCount = increase(operatorValue - 1, counters, maxCount, baseCount);
      else if (operatorValue == SetMaxCount)
        baseCount = maxCount;
    }

    for (int idx = 0; idx < counters.length; idx++) {
      if (counters[idx] < baseCount)
        counters[idx] = baseCount;
    }

    return counters;
  }

  private static int increase(int index, int[] counters, int maxCount, int baseCount) {
    if (counters[index] < baseCount)
      counters[index] = baseCount + 1;
    else
      counters[index]++;
    if (counters[index] > maxCount)
      return counters[index];
    return maxCount;
  }
}
