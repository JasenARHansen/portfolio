package Code.CTCI_SOURCE.other.Introduction;

public class Ex_06 {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 2, 2, 5, -1, 9, 3};
        foo(array);
    }

    public static void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int k : array) {
            sum += k;
        }
        for (int j : array) {
            product *= j;
        }
        System.out.println(sum + ", " + product);
    }
}
