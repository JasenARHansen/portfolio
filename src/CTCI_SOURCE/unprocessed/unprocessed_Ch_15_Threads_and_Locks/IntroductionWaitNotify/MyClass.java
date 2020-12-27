package CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionWaitNotify;

import CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks.MyObject;

public class MyClass extends Thread {
    private final String name;
    private final CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks.MyObject myObj;

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
