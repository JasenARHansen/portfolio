package Java.code.unsorted.classesStatic;

@SuppressWarnings("unused")
public class Utilities {
    public static int[][] cloneMatrix(int[][] input) {
        int[][] returnArray = new int[input.length][];
        for (int outer = 0; outer < input.length; outer++) {
            returnArray[outer] = new int[input[outer].length];
            System.arraycopy(input[outer], 0, returnArray[outer], 0, input[outer].length);
        }
        return returnArray;
    }

    public static void printMatrix(int[][] input) {
        for (int[] ints : input) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }
}
