package Java.code.ctci.source.ch_15_Threads_and_Locks.introductionA;

public class ExampleA {
  public static void main(String[] args) {
    RunnableThreadExample instance = new RunnableThreadExample();
    Thread thread = new Thread(instance);
    thread.start();
    /* waits until earlier thread counts to 5 (slowly). */
    while (instance.count != 5) {
      try {
        //noinspection BusyWait
        Thread.sleep(250);
      } catch (InterruptedException exc) {
        exc.printStackTrace();
      }
    }
    System.out.println("Program Terminating.");
  }
}
