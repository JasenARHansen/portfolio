package classesStatic;

public class Utilities {

    public static void printeMatrix(int[][] input) {
        for (int[] ints : input) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] cloneMatrix(int[][] input) {
        int[][] returnArray = new int[input.length][];
        for (int outter = 0; outter < input.length; outter++) {
            returnArray[outter] = new int[input[outter].length];
            System.arraycopy(input[outter], 0, returnArray[outter], 0, input[outter].length);
        }
        return returnArray;
    }
}
