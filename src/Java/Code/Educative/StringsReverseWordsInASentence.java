package Java.Code.Educative;

public class StringsReverseWordsInASentence {
  /*
  Reverse the order of words in a given sentence (an array of characters). Take the “Hello World” string for example:
    Hello -> reverse "Hello" -> olleH

  Here is how the solution works:
      Reverse the string.
      Traverse the string and reverse each word in place.

      For more on string reversal, read my article Best practices for reversing a string in JavaScript, C++, and Python.

  */

  public static String reverse_words(String sentence) {
    char[] sentenceCharacters = sentence.toCharArray();
    int readPointer = 0;
    int writePointer = 0;
    while (readPointer < sentenceCharacters.length) {
      while (((writePointer < sentenceCharacters.length))
          && (sentenceCharacters[writePointer] == ' ')) {
        writePointer++;
      }
      if (readPointer <= writePointer) {
        readPointer = writePointer + 1;
      }
      while (((readPointer < sentenceCharacters.length))
          && (sentenceCharacters[readPointer] != ' ')) {
        readPointer++;
      }
      if (readPointer == sentenceCharacters.length) {
        readPointer--;
      }
      if (writePointer < sentenceCharacters.length) {
        char swap;
        int endOffset = 0;
        if (sentenceCharacters[readPointer] == ' ') {
          endOffset = 1;
        }
        for (int offset = 0; offset < (readPointer - writePointer + 1 - endOffset) / 2; offset++) {
          swap = sentenceCharacters[writePointer + offset];
          sentenceCharacters[writePointer + offset] =
              sentenceCharacters[readPointer - offset - endOffset];
          sentenceCharacters[readPointer - offset - endOffset] = swap;
        }
        writePointer = readPointer + 1;
      }
    }
    return String.valueOf(sentenceCharacters);
  }
}
