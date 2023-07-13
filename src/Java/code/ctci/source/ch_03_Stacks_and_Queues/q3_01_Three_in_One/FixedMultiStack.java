package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_01_Three_in_One;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import java.util.Arrays;
import java.util.EmptyStackException;

@SuppressWarnings({"FieldCanBeLocal", "unused", "ConstantValue"})
public class FixedMultiStack {
  private final int stackCapacity;
  private final int[] values;
  private final int[] sizes;
  private final int numberOfStacks = 3;

  public FixedMultiStack(int stackSize) {
    stackCapacity = stackSize;
    values = new int[stackSize * numberOfStacks];
    sizes = new int[numberOfStacks];
  }

  public void push(int stackNum, int value) throws FullStackException {
    /* Push value onto stack. */
    /* Check that we have space for the next element. */
    if (isFull(stackNum)) {
      throw new FullStackException();
    }
    /* Increment stack pointer and then update top value. */
    sizes[stackNum]++;
    values[indexOfTop(stackNum)] = value;
  }

  public boolean isFull(int stackNum) {
    /* Return if stack is full. */
    return sizes[stackNum] == stackCapacity;
  }

  private int indexOfTop(int stackNum) {
    /* Returns index of the top of the stack. */
    int offset = stackNum * stackCapacity;
    int size = sizes[stackNum];
    return offset + size - 1;
  }

  public int pop(int stackNum) {
    /* Pop item from top stack. */
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    int topIndex = indexOfTop(stackNum);
    int value = values[topIndex]; // Get top
    values[topIndex] = 0; // Clear
    sizes[stackNum]--; // Shrink
    return value;
  }

  public boolean isEmpty(int stackNum) {
    /* Return if stack is empty. */
    return sizes[stackNum] == 0;
  }

  public int peek(int stackNum) {
    /* Return top element. */
    if (isEmpty(stackNum)) {
      throw new EmptyStackException();
    }
    return values[indexOfTop(stackNum)];
  }

  public String stackToString(int stackNum) {
    int[] items = getStackValues(stackNum);
    return stackNum + ": " + AssortedMethods.arrayToString(items);
  }

  public int[] getStackValues(int stackNum) {
    int[] items = new int[sizes[stackNum]];
    if (items.length >= 0)
      System.arraycopy(values, stackNum * stackCapacity, items, 0, items.length);
    return items;
  }

  @Override
  public String toString() {
    return Arrays.toString(this.getValues()).replace("[", "").replace("]", "");
  }

  public int[] getValues() {
    return values;
  }
}
