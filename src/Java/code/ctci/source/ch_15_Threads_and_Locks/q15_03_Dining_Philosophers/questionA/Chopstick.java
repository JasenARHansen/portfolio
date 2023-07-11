package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_03_Dining_Philosophers.questionA;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
  private final Lock lock;

  public Chopstick() {
    lock = new ReentrantLock();
  }

  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  public boolean pickUp() {
    return lock.tryLock();
  }

  public void putDown() {
    lock.unlock();
  }
}
