package Code.Java.CTCI.CTCI_SOURCE.other.Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private final Lock lock;
    private final int number;

    public Chopstick(int n) {
        lock = new ReentrantLock();
        this.number = n;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }

    public int getNumber() {
        return number;
    }
}
