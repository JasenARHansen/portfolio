package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_05_Recursive_Multiply;

@SuppressWarnings("DuplicatedCode")
public class QuestionB {
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
        int[] memo = new int[sum(smaller, 1)];
        return minProduct(smaller, bigger, memo);
    }

    public static int minProduct(int smaller, int bigger, int[] memo) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        }
    /* Compute half. If uneven, compute other half. If even,
    double it. */
        int s = smaller >> 1; // Divide by 2
        int side1 = minProduct(s, bigger, memo); // Compute half
        int side2 = side1;
        if (smaller % 2 == 1) {
            counter++;
            side2 = minProduct(smaller - s, bigger, memo);
        }
        /* Sum and cache. */
        counter++;
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }

    public static int sum(int x, int y) {
        counter += 1;
        return x + y;
    }
}
