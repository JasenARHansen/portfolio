package Java.code.ctci.source.ch_15_Threads_and_Locks.introductionWaitNotify;

public class MyClass extends Thread {
    private final MyObject myObj;
    private final String name;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
        try {
            myObj.wait(1000);
            myObj.foo(name);
            myObj.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
