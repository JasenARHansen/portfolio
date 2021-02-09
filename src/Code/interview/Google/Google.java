package Code.interview.Google;

import Code.unsorted.classes.classesInstance.Tuple;

import java.util.*;

public class Google {

  @SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {

    // Determine weather a circular array of relative indices compose of a
    // single, complete cycle
    int[] cycle = {2, 2, -1};

    detectCircularArrayCycle(cycle);
    cycle = new int[]{-2, -2, 1};
    detectCircularArrayCycle(cycle);

    String test = "-123.456";
    Double result = convertNumber(test);
    System.out.println("Result: " + result);
    test = ".456";
    result = convertNumber(test);
    System.out.println("Result: " + result);
    test = "-123";
    result = convertNumber(test);
    System.out.println("Result: " + result);
    test = "0.456";
    result = convertNumber(test);
    System.out.println("Result: " + result);
    String output = addStrings("-100.006", "-.05", "-23", "-0.4");
    System.out.println("Result: " + output);
    output = addStrings("100.006", "-.05", "-23", "0.4");
    System.out.println("Result: " + output);

    // Array simulating a bit map. True represents White and False
    // represents Black

    boolean[][] source = {
            {true, false, true, false},
            {false, false, false, true},
            {true, false, true, true},
            {true, false, false, true}
    };

    System.out.println("\nBase Image:");
    printBitMap(source);
    boolean[][] modified;
    modified = floodFill(false, 0, 3, source);
    System.out.format("\nFlooded black (%d, %d)\n", 0, 3);
    printBitMap(modified);
    modified = floodFill(true, 1, 1, source);
    System.out.format("\nFlooded white (%d, %d)\n", 1, 1);
    printBitMap(modified);
    modified = floodFill(true, 3, 0, source);
    System.out.format("\nFlooded white (%d, %d)\n", 3, 0);
    printBitMap(modified);

    // Sample rotated array.
    int[] rotatedArray = {3, 4, 5, 6, 1, 2};
    System.out.format("\nArray Search 1: %s\n", Arrays.toString(rotatedArray));
    System.out.format("Find %d: found at index %d\n", 0, searchRotatedArray(0, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 1, searchRotatedArray(1, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 2, searchRotatedArray(2, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 3, searchRotatedArray(3, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 4, searchRotatedArray(4, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 5, searchRotatedArray(5, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 6, searchRotatedArray(6, rotatedArray));
    System.out.format("Find %d: found at index %d\n", 7, searchRotatedArray(7, rotatedArray));

    // Sample rotated array: but the rotation is 0
    int[] rotatedArray2 = {1, 2, 3, 4, 5, 6};
    System.out.format("\nArray Search 2: %s\n", Arrays.toString(rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 0, searchRotatedArray(0, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 1, searchRotatedArray(1, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 2, searchRotatedArray(2, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 3, searchRotatedArray(3, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 4, searchRotatedArray(4, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 5, searchRotatedArray(5, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 6, searchRotatedArray(6, rotatedArray2));
    System.out.format("Find %d: found at index %d\n", 7, searchRotatedArray(7, rotatedArray2));

    // Sample rotated array.
    int[] rotatedArray3 = {10, 12, 2, 4, 6, 8};
    System.out.format("\nArray Search 3: %s\n", Arrays.toString(rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 1, searchRotatedArray(1, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 2, searchRotatedArray(2, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 3, searchRotatedArray(3, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 4, searchRotatedArray(4, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 5, searchRotatedArray(5, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 6, searchRotatedArray(6, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 10, searchRotatedArray(10, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 12, searchRotatedArray(12, rotatedArray3));
    System.out.format("Find %d: found at index %d\n", 13, searchRotatedArray(13, rotatedArray3));
  }

  private static String addStrings(String... numbers) throws Exception {
    double accumulator = 0;
    for (String number : numbers) {
      accumulator += convertNumber(number);
    }
    return Double.toString(accumulator);
  }

  private static Double convertNumber(String number) throws Exception {
    if (number == null) {
      throw new Exception("Null Input");
    }
    String base = number.trim();
    if (base.isEmpty()) {
      throw new Exception("Empty Input");
    }

    int sign = 1;
    String decimal = "";
    if (base.charAt(0) == '-') {
      // Negative found
      sign = -1;
      base = base.substring(1);
    }
    if (base.contains(".")) {
      decimal = base.substring(base.indexOf('.') + 1);
      base = base.substring(0, base.indexOf('.'));
    }
    return (sign
            * (convertInteger(base) + (convertInteger(decimal) * Math.pow(10, -decimal.length()))));
  }

  private static Double convertInteger(String number) throws Exception {
    if (!number.matches("[1234567890]*")) {
      throw new Exception("Invalid Input");
    }
    double accumulator = 0;
    int offset = number.length() - 1;
    for (int i = 0; i < number.length(); i++) {
      accumulator += (((int) number.charAt(i) - (int) '0') * Math.pow(10, offset - i));
    }
    return accumulator;
  }

  private static boolean[][] floodFill(boolean color, int x, int y, boolean[][] bitMap) {
    /*
     * https://docs.google.com/document/d/1l_59pIyArA0Mr3k6dJptyoatFXZhqY9fIMV7_WsT828/edit
     *  In Flood Fill, you
     * start with a bitmap where pixels are either black or white. The user
     * selects a point on the bitmap and a color, and the program flood-fills
     * the bitmap outward from that point (up, down, left, right) until a
     * boundary is encountered. A boundary is a cell of the same color or
     * out of range.
     */

    // (x, y) coordinate mapping array[y][x]
    if ((y < 0) || (y >= bitMap.length)) {
      System.out.format(
              "Value '%d' is not bin the range of y values [%d, %d)", y, 0, bitMap.length);
      return bitMap;
    }

    if ((x < 0) || (x >= bitMap[y].length)) {
      System.out.format(
              "Value '%d' is not bin the range of x values [%d, %d)", x, 0, bitMap[y].length);
      return bitMap;
    }

    Queue<Tuple<Integer, Integer>> floodQueue = new LinkedList<>();
    // A set will help eliminate duplicate processing
    Set<Tuple<Integer, Integer>> pixelSet = new HashSet<>();
    Tuple<Integer, Integer> startPoint = new Tuple<>(x, y);
    floodQueue.add(startPoint);
    pixelSet.add(startPoint);

    boolean[][] toModify = cloneBitMap(bitMap);

    while (!floodQueue.isEmpty()) {
      Tuple<Integer, Integer> current = floodQueue.remove();
      // Boundary check
      Integer newX = current.getLeftData();
      Integer newY = current.getRightData();
      if ((0 <= newY) && (newY < bitMap.length) && (0 <= newX) && (newX < bitMap[newY].length)) {
        if (toModify[newY][newX] != color) {
          toModify[newY][newX] = color;

          // Pixel right from test
          @SuppressWarnings("SuspiciousNameCombination") Tuple<Integer, Integer> pixelRight = new Tuple<>(newX + 1, newY);
          if (!pixelSet.contains(pixelRight)) {
            floodQueue.add(pixelRight);
            pixelSet.add(pixelRight);
          }

          // Pixel down from test
          Tuple<Integer, Integer> pixelLeft = new Tuple<>(newX - 1, newY);
          if (!pixelSet.contains(pixelLeft)) {
            floodQueue.add(pixelLeft);
            pixelSet.add(pixelLeft);
          }

          // Pixel up from test
          Tuple<Integer, Integer> pixelUp = new Tuple<>(newX, newY + 1);
          if (!pixelSet.contains(pixelUp)) {
            floodQueue.add(pixelUp);
            pixelSet.add(pixelUp);
          }

          // Pixel down from test
          Tuple<Integer, Integer> pixelDown = new Tuple<>(newX, newY - 1);
          if (!pixelSet.contains(pixelDown)) {
            floodQueue.add(pixelDown);
            pixelSet.add(pixelDown);
          }
        }
      }
    }
    return toModify;
  }

  // Clone bitMap array so the original is not altered by processing
  private static boolean[][] cloneBitMap(boolean[][] bitMap) {
    boolean[][] cloned = new boolean[bitMap.length][];
    for (int i = 0; i < bitMap.length; i++) {
      int innerLength = bitMap[i].length;
      cloned[i] = new boolean[innerLength];
      System.arraycopy(bitMap[i], 0, cloned[i], 0, innerLength);
    }
    return cloned;
  }

  // Print the Bit Map Simulation array
  private static void printBitMap(boolean[][] toPrint) {
    for (boolean[] entry : toPrint) {
      StringBuilder builder = new StringBuilder();
      builder.append("[");
      if (entry.length > 0) {
        builder.append(getColor(entry[0]));
        if (entry.length > 1) {
          for (int i = 1; i < entry.length; i++) {
            builder.append("\t");
            builder.append(getColor(entry[i]));
          }
        }
      }
      builder.append("]");
      System.out.println(builder.toString());
    }
  }

  // Helper method for printing BitMap array
  private static String getColor(boolean color) {
    if (color) {
      return "white";
    } else {
      return "black";
    }
  }

  // Method to search a rotated array for a number. IF the number si found the
  // first index in the array where the number is found is returned. If the
  // number is not found a '-1' is returned to indicate failure
  private static int searchRotatedArray(int value, int[] toSearch) {

    /*
     * https://docs.google.com/document/d/1l_59pIyArA0Mr3k6dJptyoatFXZhqY9fIMV7_WsT828/edit
     * Given a rotated
     * sorted array of integers, and a number n, write an algorithm to find
     * the number in the array. Sorted Array: [ 1, 2, 3, 4, 5, 6] Rotated
     * Sorted Array [ 3, 4, 5, 6, 1, 2] (Please note we do not know the
     * number of places by which the array has been rotated, we just know
     * that the array is rotated)
     */

    // Termination cases
    if ((toSearch == null) || (toSearch.length == 0)) {
      return -1;
    }

    // Quick test to short circuit
    if (toSearch[0] == value) {
      return 0;
    }

    int leftPointer = 0;
    int rightPointer = toSearch.length - 1;
    int midPointer;

    // Use binary search to find inflection point
    while (true) {
      midPointer = leftPointer + (rightPointer - leftPointer) / 2;
      if (toSearch[leftPointer] < toSearch[midPointer]) {
        leftPointer = midPointer;
      } else {
        rightPointer = midPointer;
      }

      // Termination case due to integer division not always allowing
      // a valid midPointer
      if (((rightPointer - leftPointer)) <= 1) {
        if (toSearch[leftPointer] < toSearch[rightPointer]) {
          midPointer = rightPointer;
        } else {
          midPointer = leftPointer;
        }
        break;
      }
    }

    // Determine what side of the divide is searched
    if (toSearch[0] < value) {
      leftPointer = 0;
      rightPointer = midPointer;
    } else {
      leftPointer = midPointer;
      rightPointer = toSearch.length - 1;
    }

    // Use binary search from inflection point find number
    while (true) {
      midPointer = leftPointer + (rightPointer - leftPointer) / 2;
      if (toSearch[midPointer] == value) {
        return midPointer;
      } else if (toSearch[midPointer] < value) {
        leftPointer = midPointer;
      } else {
        rightPointer = midPointer;
      }

      // Termination case due to integer division not always allowing
      // rightPointer == leftPointer
      if (((rightPointer - leftPointer)) <= 1) {
        if (toSearch[leftPointer] == value) {
          return leftPointer;
        } else if (toSearch[rightPointer] == value) {
          return rightPointer;
        } else {
          return -1;
        }
      }
    }
  }

  private static boolean detectCircularArrayCycle(int[] toSearch) {
    int searchIndex = 0;
    // Circular array is that when you exceed a boundary you wrap around to
    // the
    // Relative index means the value of the element is a modification of
    // the current index
    // Complete cycle means that all elements are examined
    boolean[] visited = new boolean[toSearch.length];

    while (!visited[searchIndex]) {
      visited[searchIndex] = true;
      // Handle overflow case
      searchIndex = (searchIndex + toSearch[searchIndex]) % toSearch.length;
      // Cover underflow case and wrap around.
      if (searchIndex < 0) {
        searchIndex += toSearch.length;
      }
    }

    for (boolean value : visited) {
      if (!value) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("unused")
  private static boolean hasCycleGoogleSample(int[] x) {
    // Test for null or zero length, else
    int currentPos = 0;
    int n = x.length;
    for (int i = 0; i < n; i++) {
      currentPos = (currentPos + x[currentPos]) % n;
      // -n < currentPos < n; fix so non-negative
      if (currentPos < 0) {
        currentPos += n;
      }
      // watch the fencepost!
      if (currentPos == 0 && i < n - 1) {
        return false;
      }
    }

    return currentPos == 0;
  }
}
