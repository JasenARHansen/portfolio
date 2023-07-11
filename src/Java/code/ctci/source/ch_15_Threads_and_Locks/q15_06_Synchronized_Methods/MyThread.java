package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_06_Synchronized_Methods;

public class MyThread extends Thread {
  public final String name;
  public final String firstMethod;
  private final Foo foo;

  public MyThread(Foo f, String nm, String fM) {
    foo = f;
    name = nm;
    firstMethod = fM;
  }

  public void run() {
    if (firstMethod.equals("A")) {
      foo.methodA(name);
    } else {
      foo.methodB(name);
    }
  }
}
