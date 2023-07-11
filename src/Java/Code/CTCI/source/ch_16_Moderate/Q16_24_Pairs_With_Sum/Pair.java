package Java.code.ctci.source.ch_16_Moderate.q16_24_Pairs_With_Sum;

public record Pair(int first, int second) {

  public int first() {
    return this.first;
  }

  public int second() {
    return this.second;
  }

  @Override
  public String toString() {
    return "(" + this.first + ", " + this.second + ")";
  }
}
