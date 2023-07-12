package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_08_Find_Duplicates;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

public class Question {

  public static void checkDuplicates(int[] array) {
    BitSet bs = new BitSet(32000);
    for (int num : array) {
      int num0 = num - 1; // bitset starts at 0, numbers start at 1
      if (bs.get(num0)) {
        System.out.println(num);
      } else {
        bs.set(num0);
      }
    }
  }

  public static void main(String[] args) {
    int[] array = AssortedMethods.randomArray(30, 1, 30);
    System.out.println(AssortedMethods.arrayToString(array));
    checkDuplicates(array);
  }
}