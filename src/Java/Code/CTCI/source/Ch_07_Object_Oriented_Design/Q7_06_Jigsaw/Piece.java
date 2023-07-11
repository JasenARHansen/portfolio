package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_06_Jigsaw;

import java.util.HashMap;
import java.util.Map.Entry;

public class Piece {
  private static final int NUMBER_OF_EDGES = 4;
  private HashMap<Orientation, Edge> edges = new HashMap<>();

  public Piece(Edge[] edgeList) {
    Orientation[] orientations = Orientation.values();
    for (int i = 0; i < edgeList.length; i++) {
      Edge edge = edgeList[i];
      edge.setParentPiece(this);
      edges.put(orientations[i], edge);
    }
  }

  public void setEdgeAsOrientation(Edge edge, Orientation orientation) {
    /* Set this edge in the appropriate orientation, rotating the piece as necessary. */
    Orientation currentOrientation = getOrientation(edge);
    assert currentOrientation != null;
    rotateEdgesBy(orientation.ordinal() - currentOrientation.ordinal());
  }

  private Orientation getOrientation(Edge edge) {
    /* Return the current orientation of the edge. */
    for (Entry<Orientation, Edge> entry : edges.entrySet()) {
      if (entry.getValue() == edge) {
        return entry.getKey();
      }
    }
    return null;
  }

  public void rotateEdgesBy(int numberRotations) {
    /* Rotate edges by "numberRotations". */
    Orientation[] orientations = Orientation.values();
    HashMap<Orientation, Edge> rotated = new HashMap<>();
    numberRotations = numberRotations % NUMBER_OF_EDGES;
    if (numberRotations < 0) numberRotations += NUMBER_OF_EDGES;
    for (int i = 0; i < orientations.length; i++) {
      Orientation oldOrientation =
          orientations[(i - numberRotations + NUMBER_OF_EDGES) % NUMBER_OF_EDGES];
      Orientation newOrientation = orientations[i];
      rotated.put(newOrientation, edges.get(oldOrientation));
    }
    edges = rotated;
  }

  public boolean isCorner() {
    /* Check if this piece is a corner piece. */
    Orientation[] orientations = Orientation.values();
    for (int i = 0; i < orientations.length; i++) {
      Shape current = edges.get(orientations[i]).getShape();
      Shape next = edges.get(orientations[(i + 1) % NUMBER_OF_EDGES]).getShape();
      if (current == Shape.FLAT && next == Shape.FLAT) {
        return true;
      }
    }
    return false;
  }

  public boolean isBorder() {
    /* Check if this piece has a border edge. */
    Orientation[] orientations = Orientation.values();
    for (Orientation orientation : orientations) {
      if (edges.get(orientation).getShape() == Shape.FLAT) {
        return true;
      }
    }
    return false;
  }

  public Edge getEdgeWithOrientation(Orientation orientation) {
    /* Get edge at this orientation. */
    return edges.get(orientation);
  }

  public Edge getMatchingEdge(Edge targetEdge) {
    /* Return the edge that matches targetEdge. Returns null if there is no match. */
    for (Edge e : edges.values()) {
      if (targetEdge.fitsWith(e)) {
        return e;
      }
    }
    return null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    Orientation[] orientations = Orientation.values();
    for (Orientation o : orientations) {
      sb.append(edges.get(o).toString()).append(",");
    }
    return "[" + sb + "]";
  }
}
