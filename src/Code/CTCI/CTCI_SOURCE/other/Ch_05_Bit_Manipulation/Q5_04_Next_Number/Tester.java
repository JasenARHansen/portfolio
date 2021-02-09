package Code.CTCI.CTCI_SOURCE.other.Ch_05_Bit_Manipulation.Q5_04_Next_Number;

public class Tester {
    public static void main(String[] args) {
        for (int i = 0; i < 20000; i++) {
            int p1 = QuestionA.getPrevSlow(i);
            int p2 = QuestionB.getPrev(i);
            int p3 = QuestionC.getPrevArithmetic(i);

            int n1 = QuestionA.getNextSlow(i);
            int n2 = QuestionB.getNext(i);
            int n3 = QuestionC.getNextArithmetic(i);

            if (p1 != p2 || p2 != p3 || n1 != n2 || n2 != n3) {
                binPrint(i);
                binPrint(p1);
                binPrint(p2);
                binPrint(p3);
                binPrint(n1);
                binPrint(n2);
                binPrint(n3);
                System.out.println();
                break;
            }
            System.out.format(
                    "Initial number is %d with %d as previous and %d as next\n", i, n3, p1);
        }
        System.out.println("Done!");
    }

    public static void binPrint(int i) {
        System.out.println(i + ": " + Integer.toBinaryString(i));
    }
}
