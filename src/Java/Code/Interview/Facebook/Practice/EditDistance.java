package Java.Code.Interview.Facebook.Practice;

public class EditDistance {
  public static void getDescription() {
    System.out.println(
        """
                Question 3: Edit Distance
                Write a function that returns whether two words are exactly "one edit" away using the following signature:
                bool OneEditApart(string s1, string s2);
                An edit is:
                  Inserting one character anywhere in the word (including at the beginning and end)
                  Removing one character
                  Replacing one character
                Examples:
                OneEditApart("cat", "dog") = false
                OneEditApart("cat", "cats") = true
                OneEditApart("cat", "cut") = true
                OneEditApart("cat", "cast") = true
                OneEditApart("cat", "at") = true
                OneEditApart("cat", "act") = false
                """
            .indent(2));
  }

  public static boolean oneEditApart(String left, String right) {
    if ((left == null) && (right == null)) {
      return true;
    }
    if ((left == null) || (right == null)) {
      return false;
    }
    if (left.equals(right)) {
      return true;
    }
    if (Math.abs(left.length() - right.length()) > 1) {
      return false;
    }
    boolean edited = false;
    if (right.length() != left.length()) {
      String longer;
      String shorter;
      if (right.length() > left.length()) {
        longer = right;
        shorter = left;
      } else {
        longer = left;
        shorter = right;
      }
      for (int index = 0; index < shorter.length(); index++) {
        if (edited) {
          if (longer.charAt(index + 1) != shorter.charAt(index)) {
            return false;
          }
        } else {
          if (longer.charAt(index) != shorter.charAt(index)) {
            edited = true;
          }
        }
      }
    } else {
      for (int index = 0; index < left.length(); index++) {
        if (left.charAt(index) != right.charAt(index)) {
          if (edited) {
            return false;
          }
          edited = true;
        }
      }
    }
    return true;
  }
}
