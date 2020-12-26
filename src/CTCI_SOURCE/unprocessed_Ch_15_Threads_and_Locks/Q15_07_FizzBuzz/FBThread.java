package CTCI_SOURCE.unprocessed_Ch_15_Threads_and_Locks.Q15_07_FizzBuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class FBThread extends Thread {
    protected static int current = 1;
    private static Object lock = new Object();
    int x = 1;
    private int max;
    private Predicate<Integer> validate;
    private Function<Integer, String> printer;

    public FBThread(Predicate<Integer> validate, Function<Integer, String> printer, int max) {
        this.validate = validate;
        this.printer = printer;
        this.max = max;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (current > max) {
                    return;
                }
                if (validate.test(current)) {
                    System.out.println(printer.apply(current));
                    current++;
                }
            }
        }
    }
}
