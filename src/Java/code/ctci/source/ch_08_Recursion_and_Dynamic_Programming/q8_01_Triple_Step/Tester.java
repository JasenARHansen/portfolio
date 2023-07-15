package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_01_Triple_Step;

public class Tester {

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int c1 = QuestionB.countWays(i);
            int c2 = QuestionA.countWays(i);
            System.out.println(i + ": " + c1 + " " + c2);
        }
    }
}
