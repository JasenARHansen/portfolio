package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_03_Dining_Philosophers.questionA;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

@SuppressWarnings("FieldCanBeLocal")
public class Philosopher extends Thread {
    private final int bites = 10;
    private final int index;
    private final Chopstick left;
    private final int maxPause = 100;
    private final Chopstick right;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        this.left = left;
        this.right = right;
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public void eat() {
        System.out.println("Philosopher " + index + ": start eating");
        if (pickUp()) {
            chew();
            putDown();
            System.out.println("Philosopher " + index + ": done eating");
        } else {
            System.out.println("Philosopher " + index + ": gave up on eating");
        }
    }

    public boolean pickUp() {
        pause();
        if (!left.pickUp()) {
            return false;
        }
        pause();
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        pause();
        return true;
    }

    public void chew() {
        System.out.println("Philosopher " + index + ": eating");
        pause();
    }

    public void putDown() {
        right.putDown();
        left.putDown();
    }

    public void pause() {
        try {
            int pause = AssortedMethods.randomIntInRange(0, maxPause);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
