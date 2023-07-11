package Java.code.hackerrank.sorting;

public record Player(String name, int score) {

  public String name() {
    return this.name;
  }

  public int score() {
    return this.score;
  }
}
