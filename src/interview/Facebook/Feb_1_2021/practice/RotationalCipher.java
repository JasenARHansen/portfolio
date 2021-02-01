package interview.Facebook.Feb_1_2021.practice;

public class RotationalCipher {
  /*
  Rotational Cipher
  One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
  For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
  Given a string and a rotation factor, return an encrypted string.
  Signature
  string rotationalCipher(string input, int rotationFactor)
  Input
  1 <= |input| <= 1,000,000
  0 <= rotationFactor <= 1,000,000
  Output
  Return the result of rotating input a number of times equal to rotationFactor.
  Example 1
  input = Zebra-493?
  rotationFactor = 3
  output = Cheud-726?
  Example 2
  input = abcdefghijklmNOPQRSTUVWXYZ0123456789
  rotationFactor = 39
  output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
  */

  public static String rotationalCipher(String input, int rotationFactor) {
    char[] characters = input.toCharArray();
    int start_Upper = 'A';
    int start_Lower = 'a';
    int range_Letter = (int) 'Z' - start_Upper;
    int start_Number = '0';
    int range_Number = (int) '9' - start_Number;

    for (int index = 0; index < characters.length; index++) {
      if (('A' <= characters[index]) && (characters[index] <= 'Z')) {
        characters[index] =
                (char)
                        ((((int) characters[index] - start_Upper + rotationFactor) % (range_Letter + 1))
                                + start_Upper);
      } else if (('a' <= characters[index]) && (characters[index] <= 'z')) {
        characters[index] =
                (char)
                        ((((int) characters[index] - start_Lower + rotationFactor) % (range_Letter + 1))
                                + start_Lower);
      } else if (('0' <= characters[index]) && (characters[index] <= '9')) {
        characters[index] =
                (char)
                        ((((int) characters[index] - start_Number + rotationFactor) % (range_Number + 1))
                                + start_Number);
      }
    }
    return String.valueOf(characters);
  }
}
