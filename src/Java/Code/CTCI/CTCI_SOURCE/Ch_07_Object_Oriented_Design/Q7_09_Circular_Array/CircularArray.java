package Java.Code.CTCI.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_09_Circular_Array;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class CircularArray<T> implements Iterable<T> {
  private final T[] items;
  private int head = 0;

  public CircularArray(int size) {
    //noinspection unchecked
    items = (T[]) new Object[size];
  }

  public void rotate(int shiftRight) {
    head = convert(shiftRight);
  }

  private int convert(int index) {
    if (index < 0) {
      index += items.length;
    }
    return (head + index) % items.length;
  }

  public T get(int i) {
    if (i < 0 || i >= items.length) {
      throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
    }
    return items[convert(i)];
  }

  public void set(int i, T item) {
    items[convert(i)] = item;
  }

  public @NotNull Iterator<T> iterator() {
    return new CircularArrayIterator();
  }

  private class CircularArrayIterator implements Iterator<T> {
    private int _current = -1;

    public CircularArrayIterator() {}

    @Override
    public boolean hasNext() {
      return _current < items.length - 1;
    }

    @Override
    public T next() {
      _current++;
      return items[convert(_current)];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Remove is not supported by CircularArray");
    }
  }
}
