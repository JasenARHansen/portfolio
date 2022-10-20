package Code.Java.Educative;

public class ArraysMoveZeros {
  /*
  Given an integer array, move all elements that are 0 to the left while maintaining the order of other elements
   in the array. The array has to be modified in-place.
  Try it yourself before reviewing the solution and explanation.

  Runtime complexity: Linear, O(n)O(n)O(n)
  Memory Complexity: Constant, O(1)O(1)O(1)
  Keep two markers: read_index and write_index and point them to the end of the array. Let’s take a look at an
   overview of the algorithm.

  While moving read_index towards the start of the array:

  If read_index points to 0, skip.
  If read_index points to a non-zero value, write the value at read_index to write_index and decrement write_index.
  Assign zeros to all the values before the write_index and to the current position of write_index as well.
  */

    public static void moveZerosRight(int[] array) {
        int readIndex = 0;
        int writeIndex = 0;
        while (readIndex < array.length) {
            while ((writeIndex < array.length) && (array[writeIndex] != 0)) {
                writeIndex++;
            }
            if (readIndex < writeIndex) {
                readIndex = writeIndex + 1;
            }
            while ((readIndex < array.length) && (array[readIndex] == 0)) {
                readIndex++;
            }
            if (readIndex < array.length) {
                array[writeIndex] = array[readIndex];
                array[readIndex] = 0;
            }
        }
    }

    public static void moveZerosLeft(int[] array) {
        int readIndex = array.length - 1;
        int writeIndex = array.length - 1;
        while (readIndex > 0) {
            while ((writeIndex > 0) && (array[writeIndex] != 0)) {
                writeIndex--;
            }
            if (readIndex > writeIndex) {
                readIndex = writeIndex - 1;
            }
            while ((readIndex > 0) && (array[readIndex] == 0)) {
                readIndex--;
            }
            if (readIndex >= 0) {
                array[writeIndex] = array[readIndex];
                array[readIndex] = 0;
            }
        }
    }
}
