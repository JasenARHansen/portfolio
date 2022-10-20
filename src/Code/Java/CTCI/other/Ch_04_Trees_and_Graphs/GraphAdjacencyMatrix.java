package Code.Java.CTCI.other.Ch_04_Trees_and_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GraphAdjacencyMatrix<T extends Comparable<T>> {
  HashMap<T, HashSet<T>> map;
  HashMap<T, State> visited;

  public GraphAdjacencyMatrix() {
    map = new HashMap<>();
    visited = new HashMap<>();
  }

  public void addEdge(T source, T target) {
    if (!map.containsKey(source)) {
      this.addNode(source);
    }
    if (!map.containsKey(target)) {
      this.addNode(target);
    }

    map.get(source).add(target);
  }

  public void addNode(T source) {
    if (!map.containsKey(source)) {
      HashSet<T> set = new HashSet<>();
      map.put(source, set);
      visited.put(source, State.Unvisited);
    }
  }

  public boolean pathExists(T source, T target) {
    boolean pathExists = false;
    if (map.containsKey(source)) {
      visited.put(source, State.Visited);
      if (map.get(source).contains(target)) {
        pathExists = true;
      } else {
        for (T newSource : map.get(source)) {
          if ((visited.get(newSource) == State.Unvisited) && (this.pathExists(newSource, target))) {
            pathExists = true;
            break;
          }
        }
      }

      visited.put(source, State.Unvisited);
    }

    return pathExists;
  }

  public String buildOrder_DFS() {
    ArrayList<T> processed = new ArrayList<>();
    ArrayList<T> remaining = new ArrayList<>(this.map.keySet());

    for (T element : this.map.keySet()) {
      this.build_dfs(element, processed, remaining);
    }

    StringBuilder order = new StringBuilder();
    // Generate output list
    order.append("Build order: ");
    for (T s : processed) {
      order.append(s.toString()).append(" ");
    }

    if (!remaining.isEmpty()) {
      order.append("  Cycle exists in: ");
      for (T s : remaining) {
        order.append(s.toString()).append(" ");
      }
    }
    return order.toString().trim();
  }

  public String buildOrder_BFS() {
    ArrayList<T> processed = new ArrayList<>();
    ArrayList<T> remaining = new ArrayList<>(this.map.keySet());
    boolean process = true;

    while (process) {
      process = false;
      //noinspection unchecked
      ArrayList<T> copy = (ArrayList<T>) remaining.clone();
      for (T element : copy) {
        boolean build = true;
        for (T inner : this.map.get(element))
          if (copy.contains(inner)) {
            build = false;
            break;
          }
        if (build) {
          process = true;
          remaining.remove(element);
          processed.add(element);
        }
      }
    }

    StringBuilder order = new StringBuilder();
    // Generate output list
    order.append("Build order: ");
    for (T s : processed) {
      order.append(s.toString()).append(" ");
    }

    if (!remaining.isEmpty()) {
      order.append("  Cycle exists in: ");
      for (T s : remaining) {
        order.append(s.toString()).append(" ");
      }
    }
    return order.toString().trim();
  }

  private boolean build_dfs(T data, ArrayList<T> processed, ArrayList<T> remaining) {
    if (visited.get(data) == State.Visited) {
      return false;
    }

    this.visited.put(data, State.Visited);
    boolean success = true;
    for (T element : this.map.get(data)) {
      if (!processed.contains(element)) {
        if (!this.build_dfs(element, processed, remaining)) {
          success = false;
        }
      }
    }
    if (success) {
      if (!processed.contains(data)) {
        processed.add(data);
        remaining.remove(data);
      }
    }
    this.visited.put(data, State.Unvisited);
    return success;
  }

  public enum State {
    Unvisited,
    Visited
  }
}
