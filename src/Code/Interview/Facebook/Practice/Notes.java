package Code.Interview.Facebook.Practice;

import java.util.*;
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
    int[] array2 = array.clone();
    int length = array.length;

    // copy a piece of 1 array into a 2nd array.
    // the positions are the start index of the copy from and copy to.  Te length is how many
    // characters are copied.
    System.arraycopy(array, 1, set, 1, set.length - 1);

    Set<String> stringSet = new HashSet<>();

    List<Character> open = "{[(".chars().mapToObj((i) -> (char) i).collect(Collectors.toList());
    List<String> list = Arrays.asList("foo", "bar");
    ArrayList<Integer> boxes = new ArrayList<>(Arrays.asList(1, 2, 3));
    boxes.add(4);

    List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
    Collections.sort(list);
    list.sort(Collections.reverseOrder());
    int value = arrayList.get(0);

    Stack<Character> stack = new Stack<>();
    int size = stack.size();
    Queue<Integer> level = new LinkedList<>();
    size = level.size();

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    Queue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
    size = priorityQueue2.size();

    Map<Integer, Integer> hashMap = new HashMap<>();
    size = hashMap.size();

    Notes ob = new Notes();
    int[] arr = {2, 3, 4, 10, 40};
    int n = arr.length;
    int x = 10;
    int result = ob.binarySearch(arr, 0, n - 1, x);
    if (result == -1) System.out.println("Element not present");
    else System.out.println("Element found at index " + result);

    System.out.format(
        "%s: The after shifting the zeros in array '%s' the array becomes '%s' with %d non zero values\n",
        Arrays.toString(array), result);
    int foo = 1;
  }

  private static boolean isLetterOrDigit_1(char character) {
    return Character.isLetterOrDigit(character);
  }

  private static boolean isLetterOrDigit_2(char character) {
    return (character >= '0' && character <= '9')
        || (character >= 'a' && character <= 'z')
        || (character >= 'A' && character <= 'Z');
  }

  // Returns index of x if it is present in arr[l..r], else return -1
  int binarySearch(int[] arr, int left, int right, int search) {
    if (right >= left) {
      int mid = left + (right - left) / 2;

      // If the element is present at the middle itself
      if (arr[mid] == search) return mid;

      // If element is smaller than mid, then it can only be present in left subarray
      if (arr[mid] > search) return binarySearch(arr, left, mid - 1, search);

      // Else the element can only be present in right subarray
      return binarySearch(arr, mid + 1, right, search);
    }

    // We reach here when element is not present in array
    return -1;
  }
}
