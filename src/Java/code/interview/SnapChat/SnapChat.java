package Java.code.interview.SnapChat;

@SuppressWarnings("SpellCheckingInspection")
public class SnapChat {
  public static void main(String[] args) {
    String[][] inputArray = {
      {"A", "T", "Y", "B"}, {"A", "Y", "V", "Q"}, {"D", "N", "L", "T"}, {"R", "Q", "Y", "B"}
    };
    boolean test;
    String target;
    target = "ATA";
    test = pathDetected(target, inputArray);
    System.out.println("Found: " + test);
    target = "QYLVY";
    test = pathDetected(target, inputArray);
    System.out.println("Found: " + test);
    target = "RQB";
    test = pathDetected(target, inputArray);
    System.out.println("Found: " + test);
    target = "TYB";
    test = pathDetected(target, inputArray);
    System.out.println("Found: " + test);
    target = "ATYBQVYADNLTBYQR";
    test = pathDetected(target, inputArray);
    System.out.println("Found: " + test);
  }

  public static boolean pathDetected(String inputString, String[][] searchArray) {
    if ((inputString == null) || (searchArray == null)) {
      return false;
    }
    if ((inputString.length() == 0) || (searchArray.length == 0)) {
      return false;
    }
    for (String[] strings : searchArray) {
      if (searchArray[0].length != strings.length) {
        return false;
      }
    }
    // Visited array
    boolean[][] visitedArray = new boolean[searchArray.length][];
    for (int i = 0; i < searchArray.length; i++) {
      visitedArray[i] = new boolean[searchArray[i].length];
    }
    // Initial search point determination
    for (int outerSearchIndex = 0; outerSearchIndex < searchArray.length; outerSearchIndex++) {
      for (int innerSearchIndex = 0;
          innerSearchIndex < searchArray[outerSearchIndex].length;
          innerSearchIndex++) {
        if (subProcessing(
            inputString, 0, outerSearchIndex, innerSearchIndex, searchArray, visitedArray)) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean subProcessing(
      String inputString,
      int stringIndex,
      int outerSearchIndex,
      int innerSearchIndex,
      String[][] searchArray,
      boolean[][] visitedArray) {
    // base case, last character found
    if (stringIndex == inputString.length()) {
      return true;
    }
    // Exit cases
    // outerSearchIndex out of bounds
    if ((outerSearchIndex < 0) || (outerSearchIndex >= searchArray.length)) {
      return false;
    }
    // OuterInner Search Index out of bounds
    if ((innerSearchIndex < 0) || (innerSearchIndex >= searchArray[outerSearchIndex].length)) {
      return false;
    }
    // Previously visited
    if (visitedArray[outerSearchIndex][innerSearchIndex]) {
      return false;
    }
    // String at search point not equal to target string
    if (!searchArray[outerSearchIndex][innerSearchIndex].equals(
        inputString.substring(stringIndex, stringIndex + 1))) {
      return false;
    }
    // Set the visited flag at search point
    visitedArray[outerSearchIndex][innerSearchIndex] = true;
    // Character search
    // This will indicate a path has been found and also short circuit the
    // remaining blocks on a success
    boolean found =
        subProcessing(
            inputString,
            stringIndex + 1,
            outerSearchIndex + 1,
            innerSearchIndex,
            searchArray,
            visitedArray);
    // Case 1: outerIndex + 1
    // Case 2: outerIndex - 1
    if (!found) {
      if (subProcessing(
          inputString,
          stringIndex + 1,
          outerSearchIndex - 1,
          innerSearchIndex,
          searchArray,
          visitedArray)) {
        found = true;
      }
    }
    // Case 3: innerIndex + 1
    if (!found) {
      if (subProcessing(
          inputString,
          stringIndex + 1,
          outerSearchIndex,
          innerSearchIndex + 1,
          searchArray,
          visitedArray)) {
        found = true;
      }
    }
    // Case 5: innerIndex - 1
    if (!found) {
      if (subProcessing(
          inputString,
          stringIndex + 1,
          outerSearchIndex,
          innerSearchIndex - 1,
          searchArray,
          visitedArray)) {
        found = true;
      }
    }
    // Unset the visited flag at search point
    visitedArray[outerSearchIndex][innerSearchIndex] = false;
    return found;
  }
}
