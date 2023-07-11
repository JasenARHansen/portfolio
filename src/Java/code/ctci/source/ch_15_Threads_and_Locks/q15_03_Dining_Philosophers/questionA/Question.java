package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_03_Dining_Philosophers.questionA;

@SuppressWarnings("DuplicatedCode")
public class Question {
  public static final int size = 3;

  public static void main(String[] args) {
    Chopstick[] chopsticks = new Chopstick[size + 1];
    for (int i = 0; i < size + 1; i++) {
      chopsticks[i] = new Chopstick();
    }
    Philosopher[] philosophers = new Philosopher[size];
    for (int i = 0; i < size; i++) {
      Chopstick left = chopsticks[leftOf(i)];
      Chopstick right = chopsticks[rightOf(i)];
      philosophers[i] = new Philosopher(i, left, right);
    }
    for (int i = 0; i < size; i++) {
      philosophers[i].start();
    }
  }

  public static int leftOf(int i) {
    return i;
  }

  public static int rightOf(int i) {
    return (i + 1) % size;
  }
}
