package Java.Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_03_Random_Set;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import java.util.Random;

@SuppressWarnings({"DuplicatedCode", "unused"})
public class Question {
  public static void main(String[] args) {
    int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(AssortedMethods.arrayToString(cards));
    int[] set = pickMRandomly(cards, 4);
    System.out.println(AssortedMethods.arrayToString(set));
  }

  public static int[] pickMRandomly(int[] original, int m) {
    /* pick M elements from original array.  Clone original array so that
    we don�t destroy the input. */
    Random rand = new Random();
    for (int i = 0; i < original.length; i++) {
      int k = rand.nextInt(i + 1); // Generate random between 0 and i (inclusive)
      int temp = original[k];
      original[k] = original[i];
      original[i] = temp;
    }
    return original;
  }
}
