package Java.Code.unsorted.classesMain;

import Java.Code.unsorted.classes.classesInstance.Tuple;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SameParameterValue")
public class KeyToValue {
  static Map<Integer, Tuple<Integer, Integer>> map = new HashMap<>();

  public static void main(String[] argv) {
    getDescription();
    getValueKey(1, 1);
    addValue(1, 1);
    addValue(1, 1);
    getValue(0);
    getValueKey(1, 1);
  }

  private static void addValue(int leftValue, int rightValue) {
    boolean insert = true;
    for (int key = 0; key < map.size(); key++) {
      if ((map.get(key).getLeftData() == leftValue)
          && (map.get(key).getRightData() == rightValue)) {
        System.out.format(
            "The the values '%d' and '%d' are already mapped to key '%d'\n",
            leftValue, rightValue, key);
        insert = false;
        break;
      }
    }
    if (insert) {
      System.out.format(
          "Mapping the values '%d' and '%d' to key '%d'\n", leftValue, rightValue, map.size());
      map.put(map.size(), new Tuple<>(leftValue, rightValue));
    }
  }

  private static void getDescription() {
    System.out.println(
        "Given (x, y) coordinates, create a function such that each coordinate is uniquely mapped to an integer. Also make sure that given an integer, you should be able to find (x, y) coordinates. So F(x, y) = z and also that inverse F(z) = (x, y).");
  }

  private static void getValue(int key) {
    if (map.containsKey(key)) {
      Tuple<Integer, Integer> data = map.get(key);
      System.out.format(
          "The key '%d' maps to values '%d' and '%d'\n",
          key, data.getLeftData(), data.getRightData());
    } else {
      System.out.format("The key '%d' is not in the data set.\n", key);
    }
  }

  private static void getValueKey(int leftValue, int rightValue) {
    boolean notFound = true;
    for (int key = 0; key < map.size(); key++) {
      if ((map.get(key).getLeftData() == leftValue)
          && (map.get(key).getRightData() == rightValue)) {
        System.out.format(
            "The the values '%d' and '%d' are mapped to key '%d'\n", leftValue, rightValue, key);
        notFound = false;
        break;
      }
    }
    if (notFound) {
      System.out.format(
          "The values '%d' and '%d' are not mapped to a key\n", leftValue, rightValue);
    }
  }
}
