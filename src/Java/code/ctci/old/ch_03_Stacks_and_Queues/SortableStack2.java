package Java.code.ctci.old.ch_03_Stacks_and_Queues;

import java.util.Stack;

@SuppressWarnings("DuplicatedCode")
public class SortableStack2 {

  public static Stack<Integer> mergesort(Stack<Integer> inStack) {
    if (inStack.size() <= 1) {
      return inStack;
    }
    Stack<Integer> left = new Stack<>();
    Stack<Integer> right = new Stack<>();
    int count = 0;
    while (inStack.size() != 0) {
      count++;
      if (count % 2 == 0) {
        left.push(inStack.pop());
      } else {
        right.push(inStack.pop());
      }
    }
    left = mergesort(left);
    right = mergesort(right);
    while (left.size() > 0 || right.size() > 0) {
      if (left.size() == 0) {
        inStack.push(right.pop());
      } else if (right.size() == 0) {
        inStack.push(left.pop());
      } else if (right.peek().compareTo(left.peek()) <= 0) {
        inStack.push(left.pop());
      } else {
        inStack.push(right.pop());
      }
    }
    Stack<Integer> reverseStack = new Stack<>();
    while (inStack.size() > 0) {
      reverseStack.push(inStack.pop());
    }
    return reverseStack;
  }

  public static void sort(Stack<Integer> s) {
    Stack<Integer> r = new Stack<>();
    while (!s.isEmpty()) {
      /* Insert each element in s in sorted order into r. */
      int tmp = s.pop();
      while (!r.isEmpty() && r.peek() > tmp) {
        s.push(r.pop());
      }
      r.push(tmp);
    }
    /* Copy the elements back. */
    while (!r.isEmpty()) {
      s.push(r.pop());
    }
  }
}
