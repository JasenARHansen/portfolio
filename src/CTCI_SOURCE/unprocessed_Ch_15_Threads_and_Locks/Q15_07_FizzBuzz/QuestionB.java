package CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_07_FizzBuzz;

public class QuestionB {

    public static void main(String[] args) {
        int n = 100;
        Thread[] threads = {new FizzBuzzThread(true, true, n, "FizzBuzz"),
                new FizzBuzzThread(true, false, n, "Fizz"),
                new FizzBuzzThread(false, true, n, "Buzz"),
                new NumberThread(false, false, n)};
        for (Thread thread : threads) {
            thread.start();
        }
    }

}
