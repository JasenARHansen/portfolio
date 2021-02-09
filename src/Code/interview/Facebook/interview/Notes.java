package Code.interview.Facebook.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Notes {

  public static void main(String[] argv) {

    Map<Integer, Integer> values = new HashMap<>();
    values.put(3, 3);
    values.put(5, 5);
    values.put(2, 2);
    values.put(1, 1);
    values.put(7, 7);
    // to sort the keyset

    List<Integer> sortedKeys = values.keySet().stream().sorted().collect(Collectors.toList());
    String string = "12345";
    // make substring "123" Notice that you give the index AFTER the last desires character
    String subString = string.substring(0, 3);
    int[] array = {1, 2, 3, 4, 5};
    int[] set = new int[4];
    // copy a piece os 1 array into a 2nd array.
    // the positions are the start index of the copy from and copy to.  Te length is how many
    // characters are copied.
    System.arraycopy(array, 1, set, 1, set.length - 1);
    int foo = 1;
  }
}
