package Java.Code.CTCI.CTCI_SOURCE.other.Ch_15_Threads_and_Locks.IntroductionLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("UnusedReturnValue")
public class LockedATM {
  private final Lock lock;
  private int balance = 100;

  public LockedATM() {
    lock = new ReentrantLock();
  }

  public int withdraw(int value) {
    lock.lock();
    int temp = balance;
    try {
      Thread.sleep(100);
      temp = temp - value;
      Thread.sleep(100);
      balance = temp;
    } catch (InterruptedException ignored) {
    }
    lock.unlock();
    return temp;
  }

  public int deposit(int value) {
    lock.lock();
    int temp = balance;
    try {
      Thread.sleep(100);
      temp = temp + value;
      Thread.sleep(100);
      balance = temp;
    } catch (InterruptedException ignored) {
    }
    lock.unlock();
    return temp;
  }

  public int getBalance() {
    return balance;
  }
}
