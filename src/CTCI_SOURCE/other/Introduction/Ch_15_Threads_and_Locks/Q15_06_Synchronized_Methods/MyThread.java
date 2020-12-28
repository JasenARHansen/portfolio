package CTCI_SOURCE.other.Introduction.Ch_15_Threads_and_Locks.Q15_06_Synchronized_Methods;

public class MyThread extends Thread {
    public String name;
    public String firstMethod;
    private Foo foo;

    public MyThread(Foo f, String nm, String fM) {
        foo = f;
        name = nm;
        firstMethod = fM;
    }

    public void run() {
        if (firstMethod.equals("A")) {
            foo.methodA(name);
        } else {
            foo.methodB(name);
        }
    }
}
