package Java.Code.unsorted.classes.classesInstance;

import java.util.*;

import static org.junit.Assert.assertNotNull;

@SuppressWarnings("unchecked")
public class NodeGraph<X extends Comparable<X>, Y, Z> implements Comparable<NodeGraph<X, Y, Z>> {
  private final Map<X, Edge<X, Z>> adjacent = new HashMap<>();
  private X id;
  private Y data;

  public NodeGraph(Object id, Object data) {
    this(id);
    this.data = (Y) data;
  }

  public NodeGraph(Object id) {
    assertNotNull(id);
    this.id = (X) id;
  }

  public void addAdjacent(Object... values) {
    X id = null;
    Object edgeData = null;

    if (values.length > 0) {
      if (values[0] instanceof NodeGraph<?, ?, ?>) {
        id = (X) ((NodeGraph<?, ?, ?>) values[0]).getId();
      } else {
        id = (X) values[0];
      }
    }

    if (values.length > 1) {
      edgeData = values[1];
    }

    this.adjacent.put(id, new Edge<>(id, edgeData));
  }

  public X getId() {
    return this.id;
  }

  @Override
  public int compareTo(NodeGraph<X, Y, Z> target) {
    return this.id.compareTo(target.getId());
  }

  public int getAdjacencyCount() {
    return adjacent.size();
  }

  public Y getData() {
    return this.data;
  }

  public void setData(Object data) {
    this.data = (Y) data;
  }

  public void setId(Object id) {
    this.id = (X) id;
  }

  public boolean isAdjacent(Object value) {
    Object id;

    if (value instanceof NodeGraph<?, ?, ?>) {
      id = ((NodeGraph<?, ?, ?>) value).getId();
    } else {
      id = value;
    }

    //noinspection SuspiciousMethodCalls
    return this.adjacent.containsKey(id);
  }

  public void removeAdjacent(Object value) {
    Object id;

    if (value instanceof NodeGraph<?, ?, ?>) {
      id = ((NodeGraph<?, ?, ?>) value).getId();
    } else {
      id = value;
    }

    //noinspection SuspiciousMethodCalls
    this.adjacent.remove(id);
  }

  public void setAdjacent(Object... values) {
    X id = null;
    Object data = null;

    if (values.length > 0) {
      if (values[0] instanceof NodeGraph<?, ?, ?>) {
        id = (X) ((NodeGraph<?, ?, ?>) values[0]).getId();
      } else {
        id = (X) values[0];
      }
    }

    if (values.length > 1) {
      if (values[1] instanceof NodeGraph<?, ?, ?>) {
        data = ((NodeGraph<?, ?, ?>) values[1]).getId();
      } else {
        data = values[1];
      }
    }
    this.adjacent.put(id, new Edge<>(id, data));
  }

  @Override
  public String toString() {
    if (this.adjacent.isEmpty()) {
      if (data == null) {
        return String.format("(id: %s, data: null)", this.id.toString());
      } else {
        return String.format("(id: %s, data: %s)", this.id.toString(), this.data.toString());
      }
    } else {
      if (data == null) {
        return String.format(
                "(id: %s, data: null, adjacent to: %s)",
                this.id.toString(), getAdjacencyList().toString().replace("[", "").replace("]", ""));
      } else {
        return String.format(
                "(id: %s, data: %s, adjacent to: %s)",
                this.id.toString(),
                this.data.toString(),
                getAdjacencyList().toString().replace("[", "").replace("]", ""));
      }
    }
  }

  public List<X> getAdjacencyList() {
    List<X> forSorting = new ArrayList<>(this.adjacent.keySet());
    Collections.sort(forSorting);
    return forSorting;
  }
}
