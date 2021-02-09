package Code.CTCI_SOURCE.Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

public class Edge {
    private final Shape shape;
    private final String code; // used to mock how pieces would fit together.
    private Piece parentPiece;

    public Edge(Shape shape, String code) {
        this.shape = shape;
        this.code = code;
    }

    public Edge _createMatchingEdge() {
        if (shape == Shape.FLAT) return null;
        return new Edge(shape.getOpposite(), getCode());
    }

    private String getCode() {
        return code;
    }

    /* Check if this edge fits into the other one. */
    public boolean fitsWith(Edge edge) {
        return edge.getCode().equals(getCode());
    }

    /* Get the parent piece. */
    public Piece getParentPiece() {
        return parentPiece;
    }

    /* Set parent piece. */
    public void setParentPiece(Piece parentPiece) {
        this.parentPiece = parentPiece;
    }

    /* Return the shape of the edge. */
    public Shape getShape() {
        return shape;
    }

    public String toString() {
        return code;
    }
}
