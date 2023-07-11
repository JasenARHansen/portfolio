package Java.code.ctci.source.ch_17_Hard.q17_14_Smallest_K;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QuestionB {
  public static void main(String[] args) {
    int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
    int[] smallest = smallestK(array, 3);
    System.out.println(AssortedMethods.arrayToString(smallest));
  }

  public static int[] smallestK(int[] array, int k) {
    if (k <= 0 || k > array.length) {
      throw new IllegalArgumentException();
    }
    PriorityQueue<Integer> heap = getKMaxHeap(array, k);
    return heapToIntArray(heap);
  }

  public static int[] heapToIntArray(PriorityQueue<Integer> heap) {
    /* Convert heap to int array. */
    int[] array = new int[heap.size()];
    while (!heap.isEmpty()) {
      array[heap.size() - 1] = heap.poll();
    }
    return array;
  }

  public static PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
    /* Create max heap of smallest k elements. */
    PriorityQueue<Integer> heap = new PriorityQueue<>(k, new MaxHeapComparator());
    for (int a : array) {
      assert heap.peek() != null;
      if (heap.size() < k) { // If space remaining
        heap.add(a);
      } else if (a < heap.peek()) { // If full and top is small
        heap.poll(); // remove highest
        heap.add(a); // insert new element
      }
    }
    return heap;
  }

  public static class MaxHeapComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
      return y - x;
    }
  }
}
