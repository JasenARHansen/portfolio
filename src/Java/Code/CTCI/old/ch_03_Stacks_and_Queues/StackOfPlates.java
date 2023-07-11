package Java.code.ctci.old.ch_03_Stacks_and_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class StackOfPlates<T extends Comparable<T>> {
  final List<List<T>> stackList;

  public StackOfPlates() {
    this.stackList = new ArrayList<>();
  }

  public boolean isEmpty() {
    return this.getSize() == 0;
  }

  public int getSize() {
    int size = 0;
    for (List<T> element : this.stackList) {
      size += element.size();
    }
    return size;
  }

  public void push(T data) {
    // initial insert case
    if (this.stackList.size() == 0) {
      this.stackList.add(new ArrayList<>());
    }
    // if current stack is full, create next
    int maxVolume = 2;
    if (this.stackList.get(0).size() == maxVolume) {
      this.stackList.add(0, new ArrayList<>());
    }
    // insert to stack
    this.stackList.get(0).add(0, data);
  }

  public T peek() {
    // empty stack case
    if (this.stackList.size() == 0 || this.stackList.get(0).size() == 0) {
      throw new EmptyStackException();
    }
    return this.stackList.get(0).get(0);
  }

  public T pop() {
    // empty stack case
    if (this.stackList.size() == 0 || this.stackList.get(0).size() == 0) {
      throw new EmptyStackException();
    }
    T toReturn = this.stackList.get(0).remove(0);
    if (this.stackList.get(0).isEmpty()) {
      this.stackList.remove(0);
    }
    return toReturn;
  }

  public T popAt(int index) throws Exception {
    // Input validation
    int size = this.getSize();
    if (size <= index || index < 1) {
      throw new Exception();
    }
    int local_index = 0;
    while (index > this.stackList.get(local_index).size()) {
      index -= this.stackList.get(local_index++).size();
    }
    T toReturn = this.stackList.get(local_index).remove(index - 1);
    // Test to see if the current stack is empty
    if (this.stackList.get(local_index).isEmpty()) {
      this.stackList.remove(local_index);
    }
    return toReturn;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (List<T> element : this.stackList) {
      for (Object item : element) {
        stringBuilder.append(item).append(", ");
      }
    }
    stringBuilder.setLength(stringBuilder.length() - 2);
    return stringBuilder.toString();
  }
}
