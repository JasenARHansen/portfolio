package Java.Code.CTCI.unsorted;

import java.util.HashMap;
import java.util.Map.Entry;

@SuppressWarnings("DuplicatedCode")
public class RansomNote {
  public static boolean findNoteLetters(String note, String source) {
    HashMap<String, Integer> noteMap = permuteLetters(note);
    HashMap<String, Integer> sourceMap = permuteLetters(source);
    for (Entry<String, Integer> noteLetter : noteMap.entrySet()) {
      if (sourceMap.containsKey(noteLetter.getKey())) {
        if (sourceMap.get(noteLetter.getKey()) < noteLetter.getValue()) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  private static HashMap<String, Integer> permuteLetters(String input) {
    HashMap<String, Integer> letterMap = new HashMap<>();
    String temp = input.replaceAll("\\s+", "");
    for (int i = 0; i < temp.length(); i++) {
      String letter = temp.substring(i, i + 1);
      if (letterMap.containsKey(letter)) {
        letterMap.put(letter, letterMap.get(letter) + 1);
      } else {
        letterMap.put(letter, 1);
      }
    }
    return letterMap;
  }

  public static boolean findNoteWords(String note, String source) {
    HashMap<String, Integer> noteMap = permuteWords(note);
    HashMap<String, Integer> sourceMap = permuteWords(source);
    for (Entry<String, Integer> noteWord : noteMap.entrySet()) {
      if (sourceMap.containsKey(noteWord.getKey())) {
        if (sourceMap.get(noteWord.getKey()) < noteWord.getValue()) {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  private static HashMap<String, Integer> permuteWords(String input) {
    HashMap<String, Integer> wordMap = new HashMap<>();
    String[] words = input.split("\\s+");
    for (String word : words) {
      if (wordMap.containsKey(word)) {
        wordMap.put(word, wordMap.get(word) + 1);
      } else {
        wordMap.put(word, 1);
      }
    }
    return wordMap;
  }

  public static void getDescription() {
    System.out.println(
        "A ransom  note can be formed by cutting words out of a magazine to form a new sentence. How would you figure out is a ransom note (represented as a string) can be formed from a given magazine (String)?");
  }
}
