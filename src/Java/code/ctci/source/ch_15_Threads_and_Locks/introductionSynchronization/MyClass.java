package Java.code.ctci.source.ch_15_Threads_and_Locks.introductionSynchronization;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public class MyClass extends Thread {
    private final MyObject myObj;
    private final String name;

    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
        if (name.equals("1")) {
            MyObject.foo(name);
        } else if (name.equals("2")) {
            MyObject.bar(name);
        }
    }
}
