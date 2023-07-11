package Java.code.ctci.source.ch_17_Hard.q17_24_Max_Submatrix;

public record Range(int start, int end, int sum) {
  public int start() {
    return this.start;
  }

  public int end() {
    return this.end;
  }

  public int sum() {
    return this.sum;
  }
}
