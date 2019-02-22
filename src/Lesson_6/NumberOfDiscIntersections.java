package Lesson_6;

// Lesson 6
// Sorting

// NumberOfDiscIntersectionsWithLucainvernizzi
// Compute the number of intersections in a sequence of discs.
// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
// https://app.codility.com/demo/results/trainingCXZV7G-NWR/
// Performance : 100%

// reference
// https://stackoverflow.com/a/16814894/9218101

public class NumberOfDiscIntersections {

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

    private static int solution(int[] A)
    {
        int[] startCounts = new int[A.length];
        int[] endCounts = new int[A.length];
        for (int x = 0, maxXPosition = A.length - 1; x < A.length; x++) {
            int startCount = x > A[x] ? x - A[x] : 0;
            int endCount = maxXPosition - x > A[x]? x + A[x] : maxXPosition;
            startCounts[startCount]++;
            endCounts[endCount]++;
        }

        int result = 0, activeDiscs = 0;
        for (int x = 0; x < A.length; x++) {
            if (startCounts[x] > 0) {
                result += activeDiscs * startCounts[x];
                result += startCounts[x] * (startCounts[x] - 1) / 2;
                if (10_000_000 < result)
                    return -1;
                activeDiscs += startCounts[x];
            }
            activeDiscs -= endCounts[x];
        }

        return result;
    }
}
