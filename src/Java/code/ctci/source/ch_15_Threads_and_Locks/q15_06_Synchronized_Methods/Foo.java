package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_06_Synchronized_Methods;

public class Foo {
  private final String name;

  public Foo(String nm) {
    name = nm;
  }

  public String getName() {
    return name;
  }

  public synchronized void methodA(String threadName) {
    System.out.println("thread " + threadName + " starting: " + name + ".methodA()");
    pause();
    System.out.println("thread " + threadName + " ending: " + name + ".methodA()");
  }

  public void pause() {
    try {
      Thread.sleep(1000 * 3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void methodB(String threadName) {
    System.out.println("thread " + threadName + " starting: " + name + ".methodB()");
    pause();
    System.out.println("thread " + threadName + " ending: " + name + ".methodB()");
  }
}
