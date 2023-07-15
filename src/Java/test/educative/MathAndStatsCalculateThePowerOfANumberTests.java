package Java.test.educative;

import Java.code.educative.MathAndStatsCalculateThePowerOfANumber;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MathAndStatsCalculateThePowerOfANumberTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void power_1() {
        double expected = 25;
        printTestHeader(name.getMethodName());
        double base = 5;
        double power = 2;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_2() {
        double expected = 0.5;
        printTestHeader(name.getMethodName());
        double base = 2;
        double power = -1;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_3() {
        double expected = 2;
        printTestHeader(name.getMethodName());
        double base = 4;
        double power = 0.5;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_4() {
        double expected = 1;
        printTestHeader(name.getMethodName());
        double base = 0;
        double power = 0;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_5() {
        double expected = 32;
        printTestHeader(name.getMethodName());
        double base = 2;
        double power = 5;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_6() {
        double expected = 81;
        printTestHeader(name.getMethodName());
        double base = 3;
        double power = 4;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_7() {
        double expected = 3.375;
        printTestHeader(name.getMethodName());
        double base = 1.5;
        double power = 3;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_8() {
        double expected = 0.25;
        printTestHeader(name.getMethodName());
        double base = 2;
        double power = -2;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_9() {
        double expected = 8;
        printTestHeader(name.getMethodName());
        double base = 4;
        double power = 1.5;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "\tThe number '%.2f' to the power of '%.2f' is '%.2f'.\n", base, power, result);
        assertEquals(expected, result, 0.0001);
    }
}
