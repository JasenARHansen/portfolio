package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_05_Recursive_Multiply;

@SuppressWarnings("DuplicatedCode")
public class QuestionC {
    public static int counter = 0;

    public static void main(String[] args) {
        int a = 13494;
        int b = 22323;
        int product = a * b;
        int minProduct = minProduct(a, b);
        if (product == minProduct) {
            System.out.println("Success: " + a + "   " + b + " = " + product);
        } else {
            System.out.println(
                    "Failure: " + a + "   " + b + " = " + product + " instead of " + minProduct);
        }
        System.out.println("Adds: " + counter);
    }

    public static int minProduct(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        return minProductHelper(smaller, bigger);
    }

    public static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }
        int s = smaller >> 1;
        int halfProd = minProductHelper(s, bigger);
        if (smaller % 2 == 0) {
            counter++;
            return halfProd + halfProd;
        } else {
            counter += 2;
            return halfProd + halfProd + bigger;
        }
    }
}
