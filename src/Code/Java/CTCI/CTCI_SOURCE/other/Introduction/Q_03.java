package Code.Java.CTCI.CTCI_SOURCE.other.Introduction;

public class Q_03 {

    public static void main(String[] args) {
        System.out.println(mod(3, 6));
    }

    public static int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

}
