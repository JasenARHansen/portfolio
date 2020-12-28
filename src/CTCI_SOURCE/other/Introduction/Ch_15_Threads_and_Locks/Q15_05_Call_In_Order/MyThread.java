package CTCI_SOURCE.other.Introduction.Ch_15_Threads_and_Locks.Q15_05_Call_In_Order;

public class MyThread extends Thread {
	private final String method;
	private final FooBad foo;

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
