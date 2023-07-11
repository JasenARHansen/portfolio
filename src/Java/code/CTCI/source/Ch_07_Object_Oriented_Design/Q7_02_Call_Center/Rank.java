package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_02_Call_Center;

public enum Rank {
  Responder(0),
  Manager(1),
  Director(2);
  private final int value;

  Rank(int v) {
    value = v;
  }

  public int getValue() {
    return value;
  }
}
