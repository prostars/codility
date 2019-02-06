package Lesson_5;

// Lesson 5
// Prefix Sums

// GenomicRangeQuery
// Find the minimal nucleotide from a range of sequence DNA.
// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// https://app.codility.com/demo/results/training95XBU2-2PY/
// Performance : 0%

import java.util.Arrays;

public class GenomicRangeQueryWithoutPrefixSums {

  public static void main(String[] args) {
    String result;
    result = Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[2, 4, 1]"));

    result = Arrays.toString(solution("C", new int[]{0}, new int[]{0}));
    System.out.printf("result = %s, pass = %b\n", result, result.equals("[2]"));
  }

  public static int[] solution(String S, int[] P, int[] Q) {
    final char TypeA = 'A', TypeC = 'C', TypeG = 'G', TypeT = 'T';
    final int FactorA = 1, FactorC = 2, FactorG = 3, FactorT = 4;
    int[] answers = new int[P.length];
    int p, q;
    int minFactor = FactorT;
    for (int idx = 0; idx < P.length; idx++) {
      p = P[idx];
      q = Q[idx];

      char type;
      for (int position = p; position <= q; position++) {
        type = S.charAt(position);
        if (type == TypeA) {
          minFactor = FactorA;
          break;
        } else if (type == TypeC && FactorC < minFactor)
          minFactor = FactorC;
        else if (type == TypeG && FactorG < minFactor)
          minFactor = FactorG;
      }
      answers[idx] = minFactor;
      minFactor = FactorT;
    }

    return answers;
  }
}
