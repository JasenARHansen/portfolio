package Java.Code.CTCI.CTCI_SOURCE.other.Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks;

public class MyClass extends Thread {
  private final String name;
  private final MyObject myObj;

  public MyClass(MyObject obj, String n) {
    name = n;
    myObj = obj;
  }

  public void run() {
    myObj.foo(name);
  }
}
