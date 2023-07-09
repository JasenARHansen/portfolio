package Java.Code.Interview.Facebook.Practice;

public class DetectPalindrome {
  public static void getDescription() {
    System.out.println(
        """
                DetectPalindrome
                Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
                bool isPalindrome(String s)
                Input
                 String s with length between 1 and 1000
                Output
                 A boolean representing if the string is palindrome
                Example 1
                 s = "A man, a plan, a canal: Panama"
                 output: true
                Example 2
                 s = "race a car"
                 output: false
                """
            .indent(2));
  }

  public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (!Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true;
  }
}
