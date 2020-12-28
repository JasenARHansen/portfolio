package CTCI_SOURCE.Ch_15_Threads_and_Locks.IntroductionWaitNotify;

public class MyObject {
	public void foo(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}
}
