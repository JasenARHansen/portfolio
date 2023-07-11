package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_06_String_Compression;

@SuppressWarnings("DuplicatedCode")
public class QuestionB {
  public static void main(String[] args) {
    String str = "aa";
    System.out.println(str);
    System.out.println(compress(str));
  }

  public static String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      /* If next character is different then current, append this char to result. */
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }
}
