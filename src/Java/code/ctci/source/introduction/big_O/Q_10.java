package Java.code.ctci.source.introduction.big_O;

public class Q_10 {
    public static void main(String[] args) {
        System.out.println(sumDigits(1252));
    }

    public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
