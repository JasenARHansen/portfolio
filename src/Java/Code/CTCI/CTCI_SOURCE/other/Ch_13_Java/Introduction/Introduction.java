package Java.Code.CTCI.CTCI_SOURCE.other.Ch_13_Java.Introduction;

public class Introduction {
  public static void main(String[] args) {
    bar();
  }

  public static void bar() {
    System.out.println("start bar");
    String v = foo();
    System.out.println(v);
    System.out.println("end bar");
  }

  public static String foo() {
    int x = 0;
    int y = 5;
    try {
      System.out.println("start try");
      @SuppressWarnings("divzero")
      int b = y / x;
      System.out.println("end try");
      return "returned from try";
    } catch (Exception ex) {
      System.out.println("catch");
      return lem() + " | returned from catch";
    } finally {
      System.out.println("finally");
    }
  }

  public static String lem() {
    System.out.println("lem");
    return "return from lem";
  }
}
