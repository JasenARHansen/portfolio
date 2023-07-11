package Java.code.ctci.source.ch_16_Moderate.q16_22_Langtons_Ant;
import java.util.HashSet;

public class Board {
  private final HashSet<Position> blackCells = new HashSet<>();
  private final Ant ant = new Ant();
  private final Position topLeftCorner = new Position(0, 0);
  private final Position bottomRightCorner = new Position(0, 0);

  public Board() {}

  public void move() {
    /* Move ant. */
    ant.turn(!isBlack(ant.position)); // Turn clockwise on white, counter on black
    flip(ant.position); // flip
    ant.move(); // move
    ensureFit(ant.position);
  }

  private void flip(Position position) {
    /* Flip color of cells. */
    if (blackCells.contains(position)) {
      blackCells.remove(position);
    } else {
      blackCells.add(position.clone());
    }
  }

  private void ensureFit(Position position) {
    /* "Grow" the grid by tracking the most top-left and
       bottom-right position that we've seen. */
    int row = position.row;
    int column = position.column;
    topLeftCorner.row = Math.min(topLeftCorner.row, row);
    topLeftCorner.column = Math.min(topLeftCorner.column, column);
    bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
    bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
  }

  public boolean isBlack(Position p) {
    /* Check if cell is white. */
    return blackCells.contains(p);
  }

  public String toString() {
    /* Print board. */
    StringBuilder sb = new StringBuilder();
    int rowMin = topLeftCorner.row;
    int rowMax = bottomRightCorner.row;
    int colMin = topLeftCorner.column;
    int colMax = bottomRightCorner.column;
    for (int r = rowMin; r <= rowMax; r++) {
      for (int c = colMin; c <= colMax; c++) {
        if (r == ant.position.row && c == ant.position.column) {
          sb.append(ant.orientation);
        } else if (isBlack(r, c)) {
          sb.append("X");
        } else {
          sb.append("_");
        }
      }
      sb.append("\n");
    }
    sb.append("Ant: ").append(ant.orientation).append(". \n");
    return sb.toString();
  }

  public boolean isBlack(int row, int column) {
    /* Check if cell is white. */
    return blackCells.contains(new Position(row, column));
  }
}
