package Java.code.ctci.source.introduction.big_O;

public class Q_06 {
  public static void main(String[] args) {
    System.out.println(sqrt(26));
  }

  public static int sqrt(int n) {
    for (int guess = 1; guess * guess <= n; guess++) {
      if (guess * guess == n) {
        return guess;
      }
    }
    return -1;
  }
}
