package Java.code.ctci.source.introduction.big_O;

public class Q_04 {
    public static void main(String[] args) {
        System.out.println(div(12, 4));
    }

    public static int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }
}
