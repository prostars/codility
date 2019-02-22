package Lesson_6;

// Lesson 6
// Sorting

// NumberOfDiscIntersectionsWithLucainvernizzi
// Compute the number of intersections in a sequence of discs.
// https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/
// https://app.codility.com/demo/results/training3TTP59-TRV/
// Performance : 62%

// reference
// http://www.lucainvernizzi.net/blog/2014/11/21/codility-beta-challenge-number-of-disc-intersections/

import java.util.*;

public class NumberOfDiscIntersectionsWithLucainvernizzi {

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

    static public int solution(int[] A) {
        class XPosition {
            long x;
            boolean start;

            public XPosition(long x, boolean start) {
                this.x = x;
                this.start = start;
            }
        }

        XPosition[] xPositions = new XPosition[A.length * 2];
        int idx = 0;
        for (int x = 0; x < A.length; x++) {
            XPosition xStartPos = new XPosition((long)x - A[x], true);
            xPositions[idx] = xStartPos;
            XPosition xEndPos = new XPosition((long)x + A[x], false);
            xPositions[idx + 1] = xEndPos;
            idx += 2;
        }

        Arrays.sort(xPositions, (a, b) -> {
            if (a.x < b.x)
                return -1;
            else if (a.x > b.x)
                return 1;
            else if (!b.start)
                return -1;
            else
                return 1;
        });

        int intersections = 0, actives = 0;
        for (idx = 0; idx < xPositions.length; idx++) {
            if (xPositions[idx].start) {
                intersections += actives;
                actives++;
            } else
                actives--;
            if (intersections > 10_000_000)
                return -1;
        }
        return intersections;
    }
}
