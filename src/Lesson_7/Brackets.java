package Lesson_7;

// Lesson 7
// Stacks and Queues

// Brackets
// Determine whether a given string of parentheses (multiple types) is properly nested.
// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
// https://app.codility.com/demo/results/trainingGN2ANN-S7A/

import java.util.Stack;

public class Brackets {

  public static void main(String[] args) {
    int result;
    result = solution("{[()()]}");
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution("([)()]");
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution("");
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution("{[(){[]()}]}");
    System.out.printf("result = %d, pass = %b\n", result, result == 1);

    result = solution("{");
    System.out.printf("result = %d, pass = %b\n", result, result == 0);

    result = solution("}");
    System.out.printf("result = %d, pass = %b\n", result, result == 0);
  }

  public static int solution(String S) {
    if (S.isEmpty())
      return 1;

    Stack<Character> stack = new Stack<>();
    try {
      for (Character ch : S.toCharArray()) {
        switch (ch) {
          case '(':
          case '{':
          case '[':
            stack.push(ch);
            break;

          case ')':
            if (stack.pop() == '(')
              break;
            else
              return 0;
          case '}':
            if (stack.pop() == '{')
              break;
            else
              return 0;

          case ']':
            if (stack.pop() == '[')
              break;
            else
              return 0;
        }
      }
    } catch (Exception e) {
      return 0;
    }

    if (stack.isEmpty())
      return 1;
    return 0;
  }
}
