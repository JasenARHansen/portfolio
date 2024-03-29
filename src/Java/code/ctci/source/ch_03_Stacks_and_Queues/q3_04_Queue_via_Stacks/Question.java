package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_04_Queue_via_Stacks;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.LinkedList;
import java.util.Queue;

public class Question {
    public static void main(String[] args) {
        MyQueue<Integer> my_queue = new MyQueue<>();
        // Let's test our code against a "real" queue
        Queue<Integer> test_queue = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);
            if (choice <= 5) { // enqueue
                int element = AssortedMethods.randomIntInRange(1, 10);
                test_queue.add(element);
                my_queue.add(element);
                System.out.println("Enqueued " + element);
            } else if (test_queue.size() > 0) {
                int top1 = test_queue.remove();
                int top2 = my_queue.remove();
                if (top1 != top2) { // Check for error
                    System.out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
                }
                System.out.println("Dequeued " + top1);
            }
            if (test_queue.size() == my_queue.size()) {
                if (test_queue.size() > 0 && !test_queue.peek().equals(my_queue.peek())) {
                    System.out.println(
                            "******* FAILURE - DIFFERENT TOPS: "
                                    + test_queue.peek()
                                    + ", "
                                    + my_queue.peek()
                                    + " ******");
                }
            } else {
                System.out.println("******* FAILURE - DIFFERENT SIZES ******");
            }
        }
    }
}
