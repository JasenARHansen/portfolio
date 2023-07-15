package Java.code.ctci.source.ch_15_Threads_and_Locks.introductionSynchronizedBlocks;

public class MyClass extends Thread {
    private final MyObject myObj;
    private final String name;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
        myObj.foo(name);
    }
}
