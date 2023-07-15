package Java.code.ctci.source.ch_15_Threads_and_Locks.introductionA;

@SuppressWarnings("BusyWait")
public class RunnableThreadExample implements Runnable {
    public int count = 0;

    public void run() {
        System.out.println("RunnableThread starting.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("RunnableThread count: " + count);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("RunnableThread interrupted.");
        }
        System.out.println("RunnableThread terminating.");
    }
}
