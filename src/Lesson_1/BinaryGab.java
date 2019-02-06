package Lesson_1;

// Lesson 1
// Iterations

// BinaryGap
// Find longest sequence of zeros in binary representation of an integer.
// https://app.codility.com/programmers/lessons/1-iterations/
// https://app.codility.com/demo/results/trainingP74SWF-D9N/

public class BinaryGab {

  public static void main(String[] args) {
    int result;
    result = solution(9);
    System.out.printf("result = %d, pass = %b\n", result, result == 2); // 1001
    result = solution(529);
    System.out.printf("result = %d, pass = %b\n", result, result == 4); // 0001 0100
    result = solution(20);
    System.out.printf("result = %d, pass = %b\n", result, result == 1); // 0001 0100
    result = solution(15);
    System.out.printf("result = %d, pass = %b\n", result, result == 0); // 1111
    result = solution(32);
    System.out.printf("result = %d, pass = %b\n", result, result == 0); // 0010 0000
    result = solution(66561);
    System.out.printf("result = %d, pass = %b\n", result, result == 9); // 0001 0000 0100 0000 0001
  }

  public static int solution(int N) {
    String binaryNumber = Integer.toBinaryString(N);
    int len = binaryNumber.length();
    int maxCount = 0, count = 0;

    for (int idx = 0; idx < len; idx++) {
      if (binaryNumber.charAt(idx) == '1') {
        if (maxCount < count)
          maxCount = count;
        count = 0;
      } else
        count++;
    }

    return maxCount;
  }
}
