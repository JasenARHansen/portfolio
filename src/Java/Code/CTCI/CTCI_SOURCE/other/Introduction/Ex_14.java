package Java.Code.CTCI.CTCI_SOURCE.other.Introduction;

@SuppressWarnings("UnusedAssignment")
public class Ex_14 {
  public static void main(String[] args) {
    int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int x : array) {
      boolean isPrimeNumber = isPrime(x);
      if (isPrimeNumber) {
        System.out.println(x + ": prime");
      } else {
        System.out.println(x + ": not prime");
      }
    }
  }

  public static boolean isPrime(int n) {
    for (int x = 2; x * x <= n; x++) {
      return n % x != 0;
    }
    return true;
  }
}
