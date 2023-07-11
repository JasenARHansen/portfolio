package Java.code.ctci.source.ch_16_Moderate.q16_22_Langtons_Ant;

@SuppressWarnings("MethodDoesntCallSuperMethod")
public class Position {
  public int row;
  public int column;

  public Position(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public int hashCode() {
    return (row * 31) ^ column;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Position p) {
      return p.row == row && p.column == column;
    }
    return false;
  }

  public Position clone() {
    return new Position(row, column);
  }
}
