package Java.code.ctci.source.ch_17_Hard.q17_22_Word_Transformer;

import java.util.LinkedList;

public class PathNode {
  private final String word;
  private final PathNode previousNode;

  public PathNode(String word, PathNode previous) {
    this.word = word;
    previousNode = previous;
  }

  public String getWord() {
    return word;
  }

  public LinkedList<String> collapse(boolean startsWithRoot) {
    /* Traverse path and return linked list of nodes. */
    LinkedList<String> path = new LinkedList<>();
    PathNode node = this;
    while (node != null) {
      if (startsWithRoot) {
        path.addLast(node.word);
      } else {
        path.addFirst(node.word);
      }
      node = node.previousNode;
    }
    return path;
  }
}
