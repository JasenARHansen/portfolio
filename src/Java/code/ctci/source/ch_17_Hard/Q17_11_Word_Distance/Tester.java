package Java.code.ctci.source.ch_17_Hard.q17_11_Word_Distance;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.HashMapList;

public class Tester {
  public static void main(String[] args) {
    String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
    System.out.println(AssortedMethods.stringArrayToString(wordlist));
    HashMapList<String, Integer> locations = QuestionB.getWordLocations(wordlist);
    String[][] pairs = {{"Lara", "the"}, {"river", "life"}, {"path", "their"}, {"life", "a"}};
    for (String[] pair : pairs) {
      String word1 = pair[0];
      String word2 = pair[1];
      LocationPair pairA = QuestionA.findClosest(wordlist, word1, word2);
      LocationPair pairB = QuestionB.findClosest(word1, word2, locations);
      boolean confirmC = searchConfirm(wordlist, word1, word2, pairA.distance());
      System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + confirmC);
      System.out.println(pairA + ": " + pairA.distance());
      System.out.println(pairB.toString() + ": " + pairB.distance());
      System.out.println();
    }
  }

  public static boolean searchConfirm(String[] words, String word1, String word2, int distance) {
    // Method to confirm other result
    boolean found_at_distance = false;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        for (int j = 1; j < distance; j++) {
          String loc2a = wordAtLocation(words, i - j);
          String loc2b = wordAtLocation(words, i + j);
          if (word2.equals(loc2a) || word2.equals(loc2b)) {
            return false;
          }
        }
        String loc2a = wordAtLocation(words, i - distance);
        String loc2b = wordAtLocation(words, i + distance);
        if (word2.equals(loc2a) || word2.equals(loc2b)) {
          found_at_distance = true;
        }
      }
    }
    return found_at_distance;
  }

  public static String wordAtLocation(String[] words, int loc) {
    if (loc < 0 || loc >= words.length) {
      return null;
    }
    return words[loc];
  }
}
