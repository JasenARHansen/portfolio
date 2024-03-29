package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_03_Dining_Philosophers.questionB;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

@SuppressWarnings("FieldCanBeLocal")
public class Philosopher extends Thread {
    private final int bites = 10;
    private final Chopstick higher;
    private final int index;
    private final Chopstick lower;
    private final int maxPause = 100;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        if (left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        } else {
            this.lower = right;
            this.higher = left;
        }
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public void eat() {
        System.out.println("Philosopher " + index + ": start eating");
        pickUp();
        chew();
        putDown();
        System.out.println("Philosopher " + index + ": done eating");
    }

    public void pickUp() {
        pause();
        lower.pickUp();
        pause();
        higher.pickUp();
        pause();
    }

    public void chew() {
        System.out.println("Philosopher " + index + ": eating");
        pause();
    }

    public void putDown() {
        higher.putDown();
        lower.putDown();
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
