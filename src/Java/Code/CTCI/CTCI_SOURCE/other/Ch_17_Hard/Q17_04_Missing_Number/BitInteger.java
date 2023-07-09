package Java.Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_04_Missing_Number;

@SuppressWarnings({"DanglingJavadoc", "unused"})
public class BitInteger {
  public static int INTEGER_SIZE;
  private final boolean[] bits;

  public BitInteger() {
    bits = new boolean[INTEGER_SIZE];
  }

  public BitInteger(int value) {
    /* Creates a number equal to given value. Takes time proportional to INTEGER_SIZE. */
    bits = new boolean[INTEGER_SIZE];
    for (int j = 0; j < INTEGER_SIZE; j++) {
      bits[INTEGER_SIZE - 1 - j] = ((value >> j) & 1) == 1;
    }
  }

  public void set(int k, char bitValue) {
    /* Sets k-th most-significant bit. */
    bits[k] = bitValue != '0';
  }

  public void set(int k, boolean bitValue) {
    /* Sets k-th most-significant bit. */
    bits[k] = bitValue;
  }

  public void swapValues(BitInteger number) {
    for (int i = 0; i < INTEGER_SIZE; i++) {
      int temp = number.fetch(i);
      number.set(i, this.fetch(i));
      this.set(i, temp);
    }
  }

  public int fetch(int k) {
    /* Returns k-th most-significant bit. */
    if (bits[k]) return 1;
    else return 0;
  }

  public void set(int k, int bitValue) {
    /* Sets k-th most-significant bit. */
    bits[k] = bitValue != 0;
  }

  public int toInt() {
    int number = 0;
    for (int j = INTEGER_SIZE - 1; j >= 0; j--) {
      number = number | fetch(j);
      if (j > 0) {
        number = number << 1;
      }
    }
    return number;
  }
}
