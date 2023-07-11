package Java.code.ctci.source.ch_06_Math_and_Logic_Puzzles.q6_10_Test_Strips;

public class Bottle {
  private final int id;
  private boolean poisoned = false;

  public Bottle(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setAsPoisoned() {
    poisoned = true;
  }

  public boolean isPoisoned() {
    return poisoned;
  }
}
