package Java.code.ctci.source.ch_17_Hard.q17_01_Add_Without_Plus;

@SuppressWarnings("unused")
public class Tester {
    public static void main(String[] args) {
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 1000; b++) {
                int sumA = QuestionA.add(a, b);
                int sumB = QuestionB.add(a, b);
                int sum = a + b;
                if (sumA != sum || sumB != sum) {
                    System.out.println(
                            "ERROR: " + a + " + " + b + " = " + sum + " vs: " + sumA + ", " + sumB);
                } else {
                    System.out.println("SUCCESS: " + a + " + " + b + " = " + sum);
                }
            }
        }
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }
}
