package Java.Code.unsorted.classes.classesInstance;

@SuppressWarnings({"unused", "unchecked"})
public class Edge<X extends Comparable<X>, Y> implements Comparable<Edge<X, Y>> {
  private final X id;
  private Y edgeData;

  public Edge(Object id, Object edgeData) {
    this(id);
    this.edgeData = (Y) edgeData;
  }

  public Edge(Object id) {
    assert id != null;
    this.id = (X) id;
  }

  @Override
  public int compareTo(Edge<X, Y> target) {
    return this.id.compareTo(target.getId());
  }

  public X getId() {
    return this.id;
  }

  public Y getEdgeData() {
    return this.edgeData;
  }

  @Override
  public String toString() {
    if (edgeData == null) {
      return String.format("(id: %s)", this.id.toString());
    } else {
      return String.format("(id: %s, edgeData: %s)", this.id.toString(), this.edgeData.toString());
    }
  }
}
