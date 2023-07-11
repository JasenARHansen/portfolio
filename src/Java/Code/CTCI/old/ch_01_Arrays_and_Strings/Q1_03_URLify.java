package Java.code.ctci.old.ch_01_Arrays_and_Strings;

@SuppressWarnings({"DuplicatedCode", "SpellCheckingInspection"})
public class Q1_03_URLify {
  public static String URLify(String input) {
    char[] char_array = input.toCharArray();
    char space = ' ';
    int read_index = char_array.length - 1;
    int write_index = read_index;
    while (read_index >= 0 && char_array[read_index] == space) {
      read_index--;
    }
    while (read_index >= 0) {
      if (char_array[read_index] == space) {
        char_array[write_index--] = '0';
        char_array[write_index--] = '2';
        char_array[write_index--] = '%';
      } else {
        char_array[write_index--] = char_array[read_index];
      }
      read_index--;
    }
    return new String(char_array);
  }

  public static void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0, index, i;
    for (i = 0; i < trueLength; i++) {
      if (str[i] == ' ') {
        spaceCount++;
      }
    }
    index = trueLength + spaceCount * 2;
    if (trueLength < str.length) str[trueLength] = '\0';
    for (i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[index - 1] = '0';
        str[index - 2] = '2';
        str[index - 3] = '%';
        index = index - 3;
      } else {
        str[index - 1] = str[i];
        index--;
      }
    }
  }

  public static int findLastCharacter(char[] str) {
    for (int i = str.length - 1; i >= 0; i--) {
      if (str[i] != ' ') {
        return i;
      }
    }
    return -1;
  }
}
