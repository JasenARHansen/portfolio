package Code.Java.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_05_Letters_and_Numbers;

public class QuestionA {
    public static void main(String[] args) {
        char b = '1';
        char a = 'a';
        char[] array = {a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a};
        for (char value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        char[] max = findLongestSubarray(array);
        System.out.println(max.length);
        for (char c : max) {
            System.out.print(c + " ");
        }
        System.out.println("\nIs Valid? " + hasEqualLettersNumbers(max, 0, max.length - 1));
    }

    public static char[] findLongestSubarray(char[] array) {
        for (int len = array.length; len > 1; len--) {
            for (int i = 0; i <= array.length - len; i++) {
                if (hasEqualLettersNumbers(array, i, i + len - 1)) {
                    return extractSubarray(array, i, i + len - 1);
                }
            }
        }
        return null;
    }

    public static char[] extractSubarray(char[] array, int start, int end) {
        if (start > end) return null;
        char[] subArray = new char[end - start + 1];
        if (end + 1 - start >= 0) System.arraycopy(array, start, subArray, 0, end + 1 - start);
        return subArray;
    }

    public static boolean hasEqualLettersNumbers(char[] array, int start, int end) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (Character.isLetter(array[i])) {
                counter++;
            } else if (Character.isDigit(array[i])) {
                counter--;
            }
        }
        return counter == 0;
    }

}
