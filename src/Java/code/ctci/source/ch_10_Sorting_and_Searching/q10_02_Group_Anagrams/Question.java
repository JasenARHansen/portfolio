package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_02_Group_Anagrams;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import java.util.Arrays;

public class Question {
  public static void main(String[] args) {
    String[] array = {
      "apple", "banana", "carrot", "ele", "duck", "cat", "fish", "tree", "eel", "lee"
    };
    System.out.println(AssortedMethods.stringArrayToString(array));
    Arrays.sort(array, new AnagramComparator());
    System.out.println(AssortedMethods.stringArrayToString(array));
  }
}
