package Java.Code.unsorted.classes.classesInstance;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Heap<T extends Comparable<T>> {
  private final List<T> heapItems;
  // Determines heap type: true for minHeap and false for maxHeap
  private boolean heapType = true;

  public Heap(boolean heapType) {
    this();
    this.heapType = heapType;
  }

  public Heap() {
    /* Constructor. */
    this.heapItems = new ArrayList<>();
  }

  public void insert(T input) {
    this.heapItems.add(input);
    heapifyUp();
  }

  private void heapifyUp(int... values) {
    int index;
    if (values.length == 0) {
      index = this.heapItems.size() - 1;
    } else {
      index = values[0];
    }
    if (this.heapType) {
      while (hasParent(index) && (getParent(index).compareTo(this.heapItems.get(index)) > 0)) {
        swapData(getParentIndex(index), index);
        index = getParentIndex(index);
      }
    } else {
      while (hasParent(index) && (getParent(index).compareTo(this.heapItems.get(index)) < 0)) {
        swapData(getParentIndex(index), index);
        index = getParentIndex(index);
      }
    }
  }

  public String getHeapType() {
    if (this.heapType) {
      return "MinHeap";
    } else {
      return "MaxHeap";
    }
  }

  public void setHeapType(boolean heapType) {
    this.heapType = heapType;
  }

  public int getSize() {
    return this.heapItems.size();
  }

  public T peek() {
    if (this.heapItems.size() == 0) {
      throw new IllegalStateException("Empty Heap");
    }
    return this.heapItems.get(0);
  }

  private T getParent(int index) {
    return this.heapItems.get(getParentIndex(index));
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public boolean isEmpty() {
    return this.heapItems.size() == 0;
  }

  public void makeEmpty() {
    this.heapItems.clear();
  }

  public void printHeap() {
    System.out.format("\n%s: '%s'", getHeapType(), this.heapItems.toString());
  }

  private boolean hasParent(int index) {
    return (getLeftChildIndex(getParentIndex(index)) >= 0);
  }

  public T remove() {
    if (this.heapItems.size() == 0) {
      throw new IllegalStateException("Empty Heap");
    }
    T item = this.heapItems.get(0);
    this.heapItems.set(0, this.heapItems.get(this.heapItems.size() - 1));
    this.heapItems.remove(getSize() - 1);
    heapifyDown();
    // I need to find out if any items anywhere are less than the root and
    // if they are I need to heapify it up.
    for (int i = 0; i < heapItems.size(); i++) {
      if (this.heapType && peek().compareTo(this.heapItems.get(i)) > 0) {
        heapifyUp(i);
      } else if (!this.heapType && peek().compareTo(this.heapItems.get(i)) < 0) {
        heapifyUp(i);
      }
    }
    return item;
  }

  private int getLeftChildIndex(int parentIndex) {
    return (2 * parentIndex) + 1;
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int childIndex = getLeftChildIndex(index);
      if (this.heapType
          && hasRightChild(index)
          && (getRightChild(index).compareTo(getLeftChild(index)) < 0)) {
        childIndex = getRightChildIndex(index);
      } else if (!this.heapType
          && hasRightChild(index)
          && (getRightChild(index).compareTo(getLeftChild(index)) > 0)) {
        childIndex = getRightChildIndex(index);
      }
      if (this.heapType
          && hasRightChild(index)
          && (this.heapItems.get(index).compareTo(this.heapItems.get(childIndex)) < 0)) {
        break;
      } else if (!this.heapType
          && hasRightChild(index)
          && (this.heapItems.get(index).compareTo(this.heapItems.get(childIndex)) > 0)) {
        break;
      } else {
        swapData(childIndex, index);
        index = childIndex;
      }
    }
  }

  private void swapData(int indexOne, int indexTwo) {
    T tempValue = this.heapItems.get(indexOne);
    this.heapItems.set(indexOne, this.heapItems.get(indexTwo));
    this.heapItems.set(indexTwo, tempValue);
  }

  private T getLeftChild(int index) {
    return this.heapItems.get(index);
  }

  private T getRightChild(int index) {
    return this.heapItems.get(getRightChildIndex(index));
  }

  private boolean hasLeftChild(int index) {
    return (getLeftChildIndex(getLeftChildIndex(index)) < this.heapItems.size());
  }

  private boolean hasRightChild(int index) {
    return (getLeftChildIndex(getRightChildIndex(index)) < this.heapItems.size());
  }

  private int getRightChildIndex(int parentIndex) {
    return (2 * parentIndex) + 2;
  }
}
