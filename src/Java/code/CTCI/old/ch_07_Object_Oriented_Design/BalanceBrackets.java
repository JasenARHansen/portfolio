package Java.code.ctci.old.ch_07_Object_Oriented_Design;

import java.util.List;
import java.util.Stack;

@SuppressWarnings({"DuplicatedCode", "GrazieInspection", "unused"})
public class BalanceBrackets {
  /*
  Balance Brackets
  A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
  We consider two brackets to be matching if the first element is an open-bracket, e.g., (, {, or [, and the second bracket is a close-bracket of the same type, e.g., ( and ), [ and ], and { and } are the only pairs of matching brackets.
  Furthermore, a sequence of brackets is said to be balanced if the following conditions are met:

      The sequence is empty, or
      The sequence is composed of two, non-empty, sequences both of which are balanced, or
      The first and last brackets of the sequence are matching, and the portion of the sequence without the first and last elements is balanced.

  You are given a string of brackets. Your task is to determine whether each sequence of brackets is balanced. If a string is balanced, return true, otherwise, return false
  Signature
  bool isBalanced(String s)
  Input
  String s with length between 1 and 1000
  Output
  A boolean representing if the string is balanced or not
  Example 1
  s = {[()]}
  output: true
  Example 2
  s = {}()
  output: true
  Example 3
  s = {(})
  output: false
  Example 4
  s = )
  output: false
  */

  public static boolean isBalanced(String s) {
    List<Character> open = "{[(".chars().mapToObj((i) -> (char) i).toList();
    List<Character> close = "}])".chars().mapToObj((i) -> (char) i).toList();
    Stack<Character> stack = new Stack<>();
    for (int index = 0; index < s.length(); index++) {
      if (close.contains(s.charAt(index))) {
        if (stack.isEmpty()) {
          return false;
        }
        if (stack.peek().equals(open.get(close.indexOf(s.charAt(index))))) {
          stack.pop();
        } else {
          return false;
        }
      } else if (open.contains(s.charAt(index))) {
        stack.push(s.charAt(index));
      }
    }
    return stack.isEmpty();
  }
}
