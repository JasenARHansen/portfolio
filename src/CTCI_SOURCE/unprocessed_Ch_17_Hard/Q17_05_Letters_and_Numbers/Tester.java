package CTCI_SOURCE.unprocessed_Ch_17_Hard.Q17_05_Letters_and_Numbers;

public class Tester {

    public static void main(String[] args) {
        char b = 'b';
        char a = '1';
        char[] array = {a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a};
        for (char value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println();
        char[] maxA = QuestionA.findLongestSubarray(array);
        char[] maxB = QuestionB.findLongestSubarray(array);

        if (maxA == null) {
            System.out.println("A is null.");
        } else {
            System.out.println("A: " + maxA.length);
            for (char c : maxA) {
                System.out.print(c + " ");
            }
            System.out.println("\nIs Valid? " + QuestionA.hasEqualLettersNumbers(maxA, 0, maxA.length - 1));
            System.out.println();
        }

        if (maxB == null) {
            System.out.println("B is null.");
        } else {
            System.out.println("B: " + maxB.length);
            for (char c : maxB) {
                System.out.print(c + " ");
            }
            System.out.println("\nIs Valid? " + QuestionA.hasEqualLettersNumbers(maxB, 0, maxB.length - 1));
        }
    }

}
