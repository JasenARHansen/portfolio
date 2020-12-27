package CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronization;

import CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks.MyObject;
import CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionWaitNotify.MyClass;

public class Intro {

    public static void main(String[] args) {
        try {
            CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks.MyObject obj1 = new CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks.MyObject();
            CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionSynchronizedBlocks.MyObject obj2 = new MyObject();
            CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionWaitNotify.MyClass thread1 = new CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionWaitNotify.MyClass(obj1, "1");
            CTCI_SOURCE.unprocessed.unprocessed_Ch_15_Threads_and_Locks.IntroductionWaitNotify.MyClass thread2 = new MyClass(obj2, "2");

            thread1.start();
            thread2.start();

            Thread.sleep(3000 * 3);
        } catch (InterruptedException exc) {
            System.out.println("Program Interrupted.");
        }
        System.out.println("Program terminating.");
    }

}
