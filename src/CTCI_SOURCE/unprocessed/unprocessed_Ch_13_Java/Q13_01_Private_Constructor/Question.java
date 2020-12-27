package CTCI_SOURCE.unprocessed.unprocessed_Ch_13_Java.Q13_01_Private_Constructor;

public class Question {
    private Question() {
        System.out.println("Q");
    }

    public static void main(String[] args) {
        new B();
    }

    static class A {
        private A() {
        }
    }

    static class B extends A {
        public B() {
        }
    }

}
