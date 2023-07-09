package Java.Code.CTCI.CTCI_SOURCE.other.Ch_10_Sorting_and_Searching.Q10_11_Peaks_and_Valleys;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

@SuppressWarnings("StatementWithEmptyBody")
public class Tester {
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      int[] originalArray = AssortedMethods.randomArray(10, 0, 100);
      int[] arrayA = originalArray.clone();
      int[] arrayB = originalArray.clone();
      int[] arrayC = originalArray.clone();
      // System.out.println(AssortedMethods.arrayToString(array));
      QuestionA.sortValleyPeak(arrayA);
      QuestionB.sortValleyPeak(arrayB);
      QuestionC.sortValleyPeak(arrayC);
      if (!confirmValleyPeak(arrayA) || !confirmValleyPeak(arrayB) || !confirmValleyPeak(arrayC)) {
        System.out.println(AssortedMethods.arrayToString(originalArray));
        System.out.println(AssortedMethods.arrayToString(arrayA));
        System.out.println(AssortedMethods.arrayToString(arrayB));
        System.out.println(AssortedMethods.arrayToString(arrayC));
        System.out.println(confirmValleyPeak(arrayA));
        System.out.println(confirmValleyPeak(arrayB));
        System.out.println(confirmValleyPeak(arrayC));
        break;
      }
    }
  }

  public static boolean confirmValleyPeak(int[] array) {
    for (int i = 1; i < array.length - 1; i++) {
      int prev = array[i - 1];
      int curr = array[i];
      int next = array[i + 1];
      if (prev <= curr && curr >= next) {
      } else if (prev >= curr && curr <= next) {
      } else {
        return false;
      }
    }
    return true;
  }
}
