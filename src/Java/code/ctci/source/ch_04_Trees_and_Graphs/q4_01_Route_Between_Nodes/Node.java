package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_01_Route_Between_Nodes;

import java.util.Arrays;

public class Node {
  private final Node[] adjacent;
  private final String vertex;
  public int adjacentCount;
  public Question.State state;

  public Node(String vertex, int adjacentLength) {
    this.vertex = vertex;
    this.adjacentCount = 0;
    this.adjacent = new Node[adjacentLength];
  }

  public void addAdjacent(Node x) {
    if (this.adjacentCount < this.adjacent.length) {
      this.adjacent[this.adjacentCount] = x;
      this.adjacentCount++;
    } else {
      System.out.print("No more adjacent can be added");
    }
  }

  public Node[] getAdjacent() {
    return this.adjacent;
  }

  @SuppressWarnings("unused")
  public String getVertex() {
    return this.vertex;
  }

  @Override
  public String toString() {
    return String.format("adjacent: %s, adjacent: %s", this.vertex, Arrays.toString(this.adjacent));
  }
}
