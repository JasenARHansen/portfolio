package CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionA;

import CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Chopstick;
import CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Philosopher;

public class Question {
    public static int size = 3;

    public static int leftOf(int i) {
        return i;
    }

    public static int rightOf(int i) {
        return (i + 1) % size;
    }

    public static void main(String[] args) {
        CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Chopstick[] chopsticks = new CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Chopstick[size + 1];
        for (int i = 0; i < size + 1; i++) {
            chopsticks[i] = new CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Chopstick();
        }

        CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Philosopher[] philosophers = new CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Philosopher[size];
        for (int i = 0; i < size; i++) {
            CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionB.Chopstick left = chopsticks[leftOf(i)];
            Chopstick right = chopsticks[rightOf(i)];
            philosophers[i] = new Philosopher(i, left, right);
        }

        for (int i = 0; i < size; i++) {
            philosophers[i].start();
        }
    }

}
