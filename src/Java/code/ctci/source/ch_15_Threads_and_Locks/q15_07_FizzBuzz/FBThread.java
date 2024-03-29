package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_07_FizzBuzz;

import java.util.function.Function;
import java.util.function.Predicate;

public class FBThread extends Thread {
    private static final Object lock = new Object();
    protected static int current = 1;
    private final int max;
    private final Function<Integer, String> printer;
    private final Predicate<Integer> validate;

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
