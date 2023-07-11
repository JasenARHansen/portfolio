package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_06_Jigsaw;

import java.util.LinkedList;

@SuppressWarnings("UnusedReturnValue")
public class Puzzle {
  private final LinkedList<Piece> pieces; /* Remaining pieces left to put away. */
  private final int size;
  private Piece[][] solution;

  public Puzzle(int size, LinkedList<Piece> pieces) {
    this.pieces = pieces;
    this.size = size;
  }

  public boolean solve() {
    /* Group pieces. */
    LinkedList<Piece> cornerPieces = new LinkedList<>();
    LinkedList<Piece> borderPieces = new LinkedList<>();
    LinkedList<Piece> insidePieces = new LinkedList<>();
    groupPieces(cornerPieces, borderPieces, insidePieces);
    /* Walk through puzzle, finding the piece that joins the previous one. */
    solution = new Piece[size][size];
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        LinkedList<Piece> piecesToSearch =
            getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, column);
        if (!fitNextEdge(piecesToSearch, row, column)) {
          return false;
        }
      }
    }
    return true;
  }

  public void groupPieces(
      /* Group pieces into border pieces (including corners) and inside pieces. */
      LinkedList<Piece> cornerPieces,
      LinkedList<Piece> borderPieces,
      LinkedList<Piece> insidePieces) {
    for (Piece p : pieces) {
      if (p.isCorner()) {
        cornerPieces.add(p);
      } else if (p.isBorder()) {
        borderPieces.add(p);
      } else {
        insidePieces.add(p);
      }
    }
  }

  private LinkedList<Piece> getPieceListToSearch(
      /* Return the list where a piece with this index would be found. */
      LinkedList<Piece> cornerPieces,
      LinkedList<Piece> borderPieces,
      LinkedList<Piece> insidePieces,
      int row,
      int column) {
    if (isBorderIndex(row) && isBorderIndex(column)) {
      return cornerPieces;
    } else if (isBorderIndex(row) || isBorderIndex(column)) {
      return borderPieces;
    } else {
      return insidePieces;
    }
  }

  public boolean isBorderIndex(int location) {
    /* Bounds check. Check if this index is on a border (0 or size - 1). */
    return location == 0 || location == size - 1;
  }

  private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
    /* Find the matching piece within piecesToSearch and insert it at row, column. */
    if (row == 0 && column == 0) {
      Piece p = piecesToSearch.remove();
      orientTopLeftCorner(p);
      solution[0][0] = p;
    } else {
      /* Get the right edge and list to match. */
      Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
      Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM : Orientation.RIGHT;
      Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);
      /* Get matching edge. */
      Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);
      if (edge == null) return false; // Can't solve
      Orientation orientation = orientationToMatch.getOpposite();
      setEdgeInSolution(piecesToSearch, edge, row, column, orientation);
    }
    return true;
  }

  public void orientTopLeftCorner(Piece piece) {
    /* Orient this corner piece so that its flat edges are on the top and left. */
    if (!piece.isCorner()) return;
    Orientation[] orientations = Orientation.values();
    for (int i = 0; i < orientations.length; i++) {
      Edge current = piece.getEdgeWithOrientation(orientations[i]);
      Edge next = piece.getEdgeWithOrientation(orientations[(i + 1) % orientations.length]);
      if (current.getShape() == Shape.FLAT && next.getShape() == Shape.FLAT) {
        piece.setEdgeAsOrientation(current, Orientation.LEFT);
        return;
      }
    }
  }

  private Edge getMatchingEdge(Edge targetEdge, LinkedList<Piece> pieces) {
    /* Given a list of pieces, check if any have an edge that matches this piece. Return the edge. */
    for (Piece piece : pieces) {
      Edge matchingEdge = piece.getMatchingEdge(targetEdge);
      if (matchingEdge != null) {
        return matchingEdge;
      }
    }
    return null;
  }

  private void setEdgeInSolution(
      /* Put the edge/piece into the solution, turn it appropriately, and remove from list. */
      LinkedList<Piece> pieces, Edge edge, int row, int column, Orientation orientation) {
    Piece piece = edge.getParentPiece();
    piece.setEdgeAsOrientation(edge, orientation);
    pieces.remove(piece);
    solution[row][column] = piece;
  }

  public Piece[][] getCurrentSolution() {
    return solution;
  }
}
