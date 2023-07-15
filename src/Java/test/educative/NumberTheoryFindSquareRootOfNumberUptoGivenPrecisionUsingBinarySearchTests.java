package Java.test.educative;

import Java.code.educative.NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.text.DecimalFormat;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearchTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void nThRoot_1() {
        double expected = 2;
        printTestHeader(name.getMethodName());
        int number = 4;
        int root = 2;
        int precision = 2;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        float result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
                        number, root, precision);
        System.out.format(
                "\tThe %d root of %d is %s.\n",
                root, number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void nThRoot_2() {
        double expected = 7.071;
        printTestHeader(name.getMethodName());
        int number = 50;
        int root = 2;
        int precision = 3;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        float result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
                        number, root, precision);
        System.out.format(
                "\tThe %d root of %d is %s.\n",
                root, number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void nThRoot_3() {
        double expected = 3.1622;
        printTestHeader(name.getMethodName());
        int number = 10;
        int root = 2;
        int precision = 4;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        float result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
                        number, root, precision);
        System.out.format(
                "\tThe %d root of %d is %s.\n",
                root, number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void nThRoot_4() {
        double expected = 2;
        printTestHeader(name.getMethodName());
        int number = 8;
        int root = 3;
        int precision = 4;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        float result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
                        number, root, precision);
        System.out.format(
                "\tThe %d root of %d is %s.\n",
                root, number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void nThRoot_5() {
        double expected = 3.6840;
        printTestHeader(name.getMethodName());
        int number = 50;
        int root = 3;
        int precision = 3;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        float result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.nThRoot(
                        number, root, precision);
        System.out.format(
                "\tThe %d root of %d is %s.\n",
                root, number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void squareRoot_1() {
        double expected = 2;
        printTestHeader(name.getMethodName());
        int number = 4;
        int precision = 2;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        float result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.squareRoot(
                        number, precision);
        System.out.format(
                "\tThe square root of %d is %s.\n", number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void squareRoot_2() {
        double expected = 7.071;
        printTestHeader(name.getMethodName());
        int number = 50;
        int precision = 3;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        double result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.squareRoot(
                        number, precision);
        System.out.format(
                "\tThe square root of %d is %s.\n", number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void squareRoot_3() {
        double expected = 3.1622;
        printTestHeader(name.getMethodName());
        int number = 10;
        int precision = 4;
        DecimalFormat format = new DecimalFormat("0.#" + "#".repeat(precision));
        double result =
                NumberTheoryFindSquareRootOfNumberUptoGivenPrecisionUsingBinarySearch.squareRoot(
                        number, precision);
        System.out.format(
                "\tThe square root of %d is %s.\n", number, format.format(result));
        assertEquals(expected, result, 0.0001);
    }
}
