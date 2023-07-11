package Java.code.interview.Google.jan_14_2021.interview_2;

import java.util.ArrayList;
import java.util.List;

public class TrieNode<T extends Comparable<T>> {
  private final T data;
  private final List<TrieNode<T>> children = new ArrayList<>();
  boolean terminator = false;

  public TrieNode(T data) {
    this.data = data;
  }

  public boolean containsTerminator() {
    return this.terminator;
  }

  public void insert(T data) {
    if (!this.containsChild(data)) {
      this.createChild(data);
    }
  }

  private boolean containsChild(T value) {
    return this.getChild(value) != null;
  }

  public TrieNode<T> getChild(T value) {
    for (TrieNode<T> node : this.children) {
      if (node.getData().compareTo(value) == 0) {
        return node;
      }
    }
    return null;
  }

  public T getData() {
    return this.data;
  }

  private void createChild(T value) {
    this.children.add(new TrieNode<>(value));
  }

  public void setTerminator() {
    this.terminator = true;
  }
}
