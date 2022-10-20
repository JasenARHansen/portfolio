package Code.Java.CTCI.CTCI_SOURCE.other.Ch_15_Threads_and_Locks.IntroductionWaitNotify;

public class MyClass extends Thread {
    private final String name;
    private final MyObject myObj;

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
