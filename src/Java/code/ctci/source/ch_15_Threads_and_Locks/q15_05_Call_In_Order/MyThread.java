package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_05_Call_In_Order;

public class MyThread extends Thread {
    private final FooBad foo;
    private final String method;

    public MyThread(FooBad foo, String method) {
        this.method = method;
        this.foo = foo;
    }

    public void run() {
        switch (method) {
            case "first" -> foo.first();
            case "second" -> foo.second();
            case "third" -> foo.third();
        }
    }
}
