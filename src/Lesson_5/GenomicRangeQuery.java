package Lesson_5;

// Lesson 5
// Prefix Sums

// GenomicRangeQuery
// Find the minimal nucleotide from a range of sequence DNA.
// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// https://app.codility.com/demo/results/trainingRQPKRE-FC5/

import java.util.Arrays;

public class GenomicRangeQuery {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    System.out.println(Arrays.toString(solution("C", new int[]{0}, new int[]{0})));
    System.out.println(Arrays.toString(solution("GGGGGGGGGGGGGGGGG", new int[]{2, 6, 0}, new int[]{3, 9, 10})));
  }

  public static int[] solution(String S, int[] P, int[] Q) {
    final int MaxFactor = 4;
    int[] countOfFactors = new int[MaxFactor];
    int[][] timeLine = new int[MaxFactor][S.length() + 1];
    int[] answers = new int[P.length];

    // prepare timeline for change
    for (int idx = 0; idx < S.length(); idx++) {
      switch (S.charAt(idx)) {
        case 'A':
          countOfFactors[0]++;
          break;
        case 'C':
          countOfFactors[1]++;
          break;
        case 'G':
          countOfFactors[2]++;
          break;
        case 'T':
          countOfFactors[3]++;
          break;
      }

      for (int factor = 0; factor < MaxFactor; factor++)
        timeLine[factor][idx + 1] = countOfFactors[factor];
    }

    // query
    for (int idx = 0; idx < P.length; idx++) {
      int p = P[idx];
      int q = Q[idx] + 1;

      for (int factor = 0; factor < MaxFactor; factor++) {
        if (timeLine[factor][p] != timeLine[factor][q]) {
          answers[idx] = factor + 1;
          break;
        }
      }
    }

    return answers;
  }
}
