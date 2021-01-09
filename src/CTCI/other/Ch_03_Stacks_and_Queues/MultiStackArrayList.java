package CTCI.other.Ch_03_Stacks_and_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MultiStackArrayList {

  private final int defaultVolume = 2;
  private final int stackCount;
  private final List<Integer> stackSizes;
  private final List<Integer> stackIndex;
  private int[] stackValues;

  public MultiStackArrayList() {
    this(3);
  }

  public MultiStackArrayList(int count) {
    this.stackCount = count;
    this.stackSizes = new ArrayList<>();
    this.stackIndex = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      this.stackSizes.add(this.defaultVolume);
      this.stackIndex.add(0);
    }
    this.stackValues = new int[this.defaultVolume * count];
  }

  public int getSize(int stack) {
    return this.stackIndex.get(stack);
  }

  @SuppressWarnings("unused")
  public int getStackCount() {
    return this.stackCount;
  }

  public int peek(int stack) {
    if (this.isEmpty(stack)) {
      throw new EmptyStackException();
    }
      // Identify relevant index
      int index = 0;
      for (int i = 0; i < stack; i++) {
          index += this.stackSizes.get(i);
      }
      index += this.stackIndex.get(stack) - 1;
      return this.stackValues[index];
  }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int baseIndex = 0;
        for (int i = 0; i < this.stackSizes.size(); i++) {
            stringBuilder.append("Stack ").append(i).append(": ");
            if (this.isEmpty(i)) {
                stringBuilder.append("empty");
            } else {
                stringBuilder.append(this.stackValues[baseIndex + this.stackIndex.get(i) - 1]);
                for (int j = 1; j < this.stackIndex.get(i); j++) {
                    stringBuilder
                            .append(", ")
                            .append(this.stackValues[baseIndex + this.stackIndex.get(i) - j - 1]);
                }
            }
            stringBuilder.append("\n");
            baseIndex += this.stackSizes.get(i);
        }
        return stringBuilder.toString();
    }

    public int pop(int stack) {
        if (this.isEmpty(stack)) {
            throw new EmptyStackException();
        }
        // Identify relevant index
        int index = 0;
        for (int i = 0; i < stack; i++) {
            index += this.stackSizes.get(i);
        }
    index += this.stackIndex.get(stack) - 1;
    this.stackIndex.set(stack, this.stackIndex.get(stack) - 1);
    return this.stackValues[index];
  }

  public void push(int stack, int data) {
    // Determine if stack has to grow
    if (this.stackSizes.get(stack).equals(this.stackIndex.get(stack))) {
      this.growStack(stack);
    }
      // Identify relevant index
      int index = 0;
      for (int i = 0; i < stack; i++) {
          index += this.stackSizes.get(i);
      }
      // update array
      this.stackValues[index + this.stackIndex.get(stack)] = data;
      this.stackIndex.set(stack, this.stackIndex.get(stack) + 1);
  }

    public boolean isEmpty(int stack) {
        return this.stackIndex.get(stack) == 0;
    }

    private void growStack(int stack) {
        // Define new stack array
        int[] newStackValues = new int[this.stackValues.length + this.defaultVolume];
        // copy items before growing stack
        int baseIndex = 0;
        int grownIndex = 0;
        // Copy items up to and including stack that is growing stack
        for (int i = 0; i <= stack; i++) {
            if (this.stackIndex.get(i) >= 0)
                System.arraycopy(
                        this.stackValues, baseIndex, newStackValues, grownIndex, this.stackIndex.get(i));
            baseIndex += this.stackSizes.get(i);
            grownIndex += this.stackSizes.get(i);
        }
        // Alter values to account for grown stack
        grownIndex += defaultVolume;
        this.stackSizes.set(stack, this.stackSizes.get(stack) + this.defaultVolume);
        // copy items into stacks after grown stack
        for (int i = stack + 1; i < this.stackIndex.size(); i++) {
            if (this.stackIndex.get(i) >= 0)
                System.arraycopy(
                        this.stackValues, baseIndex, newStackValues, grownIndex, this.stackIndex.get(i));
            baseIndex += this.stackSizes.get(i);
            grownIndex += this.stackSizes.get(i);
        }
        this.stackValues = newStackValues;
    }
}
