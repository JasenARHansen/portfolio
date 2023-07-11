package Java.code.ctci.source.ch_03_Stacks_and_Queues.introduction;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

@SuppressWarnings("DuplicatedCode")
public class QueueTester {
  public static void main(String[] args) {
    int[] array = AssortedMethods.randomArray(100, -100, 100);
    MyQueue<Integer> queue1 = new MyQueue<>();
    Queue<Integer> queue2 = new LinkedList<>();
    for (int a : array) {
      if (a < 0) {
        int top1, top2;
        try {
          top1 = queue1.remove();
        } catch (NoSuchElementException ex) {
          top1 = Integer.MIN_VALUE;
        }
        try {
          top2 = queue2.remove();
        } catch (NoSuchElementException ex) {
          top2 = Integer.MIN_VALUE;
        }
        if (top1 != top2) {
          System.out.println("ERROR: mismatching tails");
        } else {
          System.out.println("SUCCESS: matching tails: " + top1);
        }
      } else {
        queue1.add(a);
        queue2.add(a);
      }
    }
    while (!queue1.isEmpty() || !queue2.isEmpty()) {
      int top1, top2;
      try {
        top1 = queue1.remove();
      } catch (NoSuchElementException ex) {
        top1 = Integer.MIN_VALUE;
      }
      try {
        top2 = queue2.remove();
      } catch (NoSuchElementException ex) {
        top2 = Integer.MIN_VALUE;
      }
      if (top1 != top2) {
        System.out.println("ERROR: mismatching tails");
      } else {
        System.out.println("SUCCESS: matching tails: " + top1);
      }
    }
  }
}
