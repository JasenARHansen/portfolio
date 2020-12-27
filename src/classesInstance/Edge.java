package classesInstance;

import static org.junit.Assert.assertNotNull;

@SuppressWarnings("unchecked")
public class Edge<X extends Comparable<X>, Y> implements Comparable<Edge<X, Y>> {

    private final X id;
    private Y edgeData;

    public Edge(Object id) {
        assertNotNull(id);
        this.id = (X) id;
    }

    public Edge(Object id, Object edgeData) {
        this(id);
        this.edgeData = (Y) edgeData;
    }

    @Override
    public int compareTo(Edge<X, Y> target) {
        return this.id.compareTo(target.getId());
    }

    public Y getEdgeData() {
        return this.edgeData;
    }

    public X getId() {
        return this.id;
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
