package Java.test.ctci.old.ch_03_Stacks_and_Queues;

import Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_04_Queue_via_Stacks.MyQueue;
import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"NewClassNamingConvention", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_04_Queue_via_Stacks_Test {
  @Rule public final TestName name = new TestName();

  @Test
  public void MyQueue_solution_1() {
    System.out.format("%s:\n", name.getMethodName());
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
