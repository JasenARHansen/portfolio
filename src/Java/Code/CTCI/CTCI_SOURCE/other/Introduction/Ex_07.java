package Java.Code.CTCI.CTCI_SOURCE.other.Introduction;

public class Ex_07 {
  public static void main(String[] args) {
    int[] array = {0, 1, 2, 3};
    printPairs(array);
  }

  public static void printPairs(int[] array) {
    for (int j : array) {
      for (int k : array) {
        System.out.println(j + "," + k);
      }
    }
  }
}
