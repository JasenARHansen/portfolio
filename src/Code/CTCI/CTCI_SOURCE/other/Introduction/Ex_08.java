package Code.CTCI.CTCI_SOURCE.other.Introduction;

public class Ex_08 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3};
        printUnorderedPairs(array);
    }

    public static void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
}