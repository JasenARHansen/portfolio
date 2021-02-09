package Code.CTCI.CTCI_SOURCE.other.Ch_15_Threads_and_Locks.Q15_07_FizzBuzz;

public class FizzBuzzThread extends Thread {
    private static final Object lock = new Object();
    protected static int current = 1;
    private final int max;
    private final boolean div3;
    private final boolean div5;
    private final String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint) {
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (current > max) {
                    return;
                }

                if ((current % 3 == 0) == div3 && (current % 5 == 0) == div5) {
                    print();
                    current++;
                }
            }
        }
    }

    public void print() {
        System.out.println(toPrint);
    }
}
