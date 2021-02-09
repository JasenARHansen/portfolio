package Code.interview.Google.Jan_14_2021.interview_2;

/*
Given a list of letters, the assistant must return all possible words (in some language) that can be created with those letters.
        The returned words can contain all the provided letters or a subset of them.

        For example, if the user has the letters “H”, ‘C”, “A”, “T”, then the assistant should suggest the words “CHAT”, “CAT”, “HAT”, “AT”
        and “A” (valid words in the English dictionary).
*/

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Scrabble {
  Trei dictionary = new Trei();

  public void setup(List<String> wordList) {
    this.dictionary.setup(wordList);
  }

  public Collection<String> getWords(String letters) {
    HashSet<String> permutations = new HashSet<>();
    this.getPermutations(letters.toLowerCase().toCharArray(), permutations, "");
    // Navigate tree here....
    HashSet<String> words = new HashSet<>();
    for (String permutation : permutations) {
      this.getWords(permutation, words);
    }
    return words;
  }

  public void main(String[] args) {

    this.getWords("CHAT");
  }

  private void getWords(String permutation, Set<String> words) {
    List<Character> chars =
            permutation
                    .chars() // IntStream
                    .mapToObj(e -> (char) e) // Stream<Character>
                    .collect(Collectors.toList());
    dictionary.getPaths(chars, words);
  }

  private void getPermutations(char[] letters, HashSet<String> returns, String current) {
    if (letters.length == 0) {
      returns.add(current);
    }

    for (int index = 0; index < letters.length; index++) {
      char[] remainder =
              this.getRemainder(
                      index,
                      letters); // this returns the remainder of the char array.  I was given the ok to skip
      String newCurrent = current + letters[index];
      this.getPermutations(remainder, returns, newCurrent);
    }
  }

  private char[] getRemainder(int index, char[] letters) {
    char[] returnArray = new char[letters.length - 1];
    for (int lettersIndex = 0, newIndex = 0; lettersIndex < letters.length; lettersIndex++) {
      if (index == lettersIndex) {
        continue;
      }
      returnArray[newIndex++] = letters[lettersIndex];
    }
    return returnArray;
  }
}
