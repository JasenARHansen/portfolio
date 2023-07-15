package Java.code.ctci.source.ch_15_Threads_and_Locks.introductionLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("UnusedReturnValue")
public class LockedATM {
    private final Lock lock;
    private int balance = 100;

    public LockedATM() {
        lock = new ReentrantLock();
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
}
