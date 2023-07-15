package Java.code.ctci.source.ch_15_Threads_and_Locks.q15_07_FizzBuzz;

public class QuestionA {
    public static void main(String[] args) {
        fizzbuzz(100);
    }

    public static void fizzbuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
