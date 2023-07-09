package Java.Code;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class Notes {

  private static boolean isLetterOrDigit_1(char character) {
    return Character.isLetterOrDigit(character);
  }

  private static boolean isLetterOrDigit_2(char character) {
    return (character >= '0' && character <= '9')
        || (character >= 'a' && character <= 'z')
        || (character >= 'A' && character <= 'Z');
  }

  int binarySearch(int[] arr, int left, int right, int search) {
    // Returns index of x if it is present in arr[l. r], else return -1
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
