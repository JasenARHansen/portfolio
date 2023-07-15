package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_11_Coins;

public class Tester {

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            int[] denominations = {25, 10, 5, 1};
            int waysA = Question.makeChange(i, denominations);
            int waysB = QuestionB.makeChange(i, denominations);
            if (waysA != waysB) {
                System.out.println("Error: " + i + " : " + waysA + ", " + waysB);
            }
        }
    }
}
