package Java.code.unsorted.classes.classesInstance;

import java.util.*;
import java.util.Queue;

@SuppressWarnings("SpellCheckingInspection")
public class GraphAdjacency<X extends Comparable<X>, Y> {
  final HashMap<X, LinkedList<Edge<X, Y>>> map;

  public GraphAdjacency() {
    this.map = new HashMap<>();
  }

  public void addEdge(X source, X target, Y targetData) {
    map.computeIfAbsent(source, k -> new LinkedList<>());
    map.get(source).add(new Edge<>(target, targetData));
  }

  public ArrayList<X> getNodeIDs() {
    return new ArrayList<>(map.keySet());
  }

  public void printBreadthFirst(X source) {
    List<X> path = new ArrayList<>();
    Queue<X> queue = new LinkedList<>();
    Set<X> visited = new HashSet<>();
    queue.add(source);
    visited.add(source);
    while (!queue.isEmpty()) {
      X local = queue.remove();
      path.add(local);
      LinkedList<Edge<X, Y>> edges = map.get(local);
      for (Edge<X, Y> edge : edges) {
        if (!visited.contains(edge.getId())) {
          queue.add(edge.getId());
          visited.add(edge.getId());
        }
      }
    }
    System.out.format("%s: -> %s\n", source, path.toString().replace("[", "").replace("]", ""));
  }

  @Override
  public String toString() {
    StringBuilder returnString = new StringBuilder();
    for (X key : map.keySet()) {
      returnString.append(
          String.format("key: %s, adjacencies: %s\n", key.toString(), map.get(key).toString()));
    }
    return returnString.toString();
  }
}
