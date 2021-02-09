package Code.CTCI.CTCI_SOURCE.other.Ch_16_Moderate.Q16_24_Pairs_With_Sum;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {
        int[] array = {9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0};
        int sum = 12;

        ArrayList<Pair> pairsA = QuestionA.printPairSums(array, sum);
        ArrayList<Pair> pairsB = QuestionB.printPairSums(array, sum);
        ArrayList<Pair> pairsC = QuestionC.printPairSums(array, sum);

        System.out.println(AssortedMethods.arrayToString(array));
        System.out.println("sum: " + sum);
        print(pairsA);
        print(pairsB);
        print(pairsC);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void print(ArrayList<Pair> pairs) {
        for (Pair p : pairs) {
            System.out.print(p.toString() + ", ");
        }
        System.out.println();
    }

}
