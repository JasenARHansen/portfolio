package Java.code.ctci.old.ch_03_Stacks_and_Queues;

import java.util.Stack;

@SuppressWarnings("unused")
public class MinStack<T extends Comparable<T>> {
  private final Stack<T> stack;
  private final Stack<T> min;

  public MinStack() {
    stack = new Stack<>();
    min = new Stack<>();
  }

  public boolean isEmpty() {
    return this.getSize() == 0;
  }

  public int getSize() {
    return stack.size();
  }

  public T min() {
    return min.peek();
  }

  public T peek() {
    return stack.peek();
  }

  public T pop() {
    T data = stack.pop();
    if (data.compareTo(min.peek()) == 0) {
      min.pop();
    }
    return data;
  }

  public void push(T data) {
    this.stack.add(data);
    if (this.min.isEmpty()) {
      min.add(data);
    } else {
      if (data.compareTo(min.peek()) <= 0) {
        min.add(data);
      }
    }
  }

  @Override
  public String toString() {
    return stack.toString();
  }
}
