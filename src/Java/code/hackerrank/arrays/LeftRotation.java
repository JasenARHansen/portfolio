package Java.code.hackerrank.arrays;

@SuppressWarnings({"GrazieInspection", "SpellCheckingInspection"})
public class LeftRotation {
  /*
  A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, if 2
   left rotations are performed on array [1, 2, 3, 4, 5], then the array would become [3, 4, 5, 1, 2]. Note that
   the lowest index item moves to the highest index in a rotation. This is called a circular array.

  Given an array <a> of <n> integers and a number, <d>, perform <d> left rotations on the array. Return the
   updated array to be printed as a single line of space-separated integers.

  Function Description
  Complete the function rotLeft in the editor below.
  rotLeft has the following parameter(s):
      int a[n]: the array to rotate
      int d: the number of rotations
  Returns
      int a'[n]: the rotated array
  Input Format
  The first line contains two space-separated integers <n> and <d>, the size of and the number of left rotations.
  The second line contains <n> space-separated integers, each an a[i].

  Sample Input
    5 4
    1 2 3 4 5

  Sample Output
    5 1 2 3 4

  Explanation

  When we perform <d> left rotations, the array undergoes the following sequence of changes:
    [1, 2, 3, 4, 5] -> [2, 3, 4, 5, 1] -> [3, 4, 5, 1, 2] -> [4, 5, 1, 2, 3] -> [5, 1, 2, 3, 4]

    1 2 3 4 5

    1
      2 3 4 5
    1
    3 2   4 5
    3 2 1 4 5

      2
    3   1 4 5
    3 4 1   5
    3 4 1 2 5
        1
    3 4   2 5
    3 4 5 2
    3 4 5 2 1

  */
  /*
  public static int[] rotateLeft(int[] a, int d) {
    int hold;
    for (int index = 0; index < a.length; index++) {
      hold = a[index];
      int foo = (index + d) % a.length;
      a[index] = a[(index + d) % a.length];
      a[(index + d) % a.length] = hold;
    }
    // a[(a.length + d) % a.length] = hold;
    return a;
  }. */

    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public static int[] rotateLeft(int[] a, int d) {
        if ((a.length == 0) || (d % a.length == 0)) {
            return a;
        }
        int rotate;
        if (d >= 0) {
            rotate = d % a.length;
        } else {
            rotate = a.length + d % a.length;
        }
        int hold;
        int greatestCommonDivisor = gcdByEuclidsAlgorithm(rotate, a.length);
        for (int cycle = 0; cycle < greatestCommonDivisor; cycle++) {
            hold = a[cycle];
            int left;
            int right;
            for (int set = 0; set < (a.length / greatestCommonDivisor) - 1; set++) {
                left = ((set * rotate) + cycle) % a.length;
                right = (((set + 1) * rotate) + cycle) % a.length;
                a[left] = a[right];
            }
            int result = (a.length - rotate % a.length + cycle) % a.length;
            a[result] = hold;
        }
        return a;
    }
}
