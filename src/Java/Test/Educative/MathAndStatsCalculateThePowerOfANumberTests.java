package Java.Test.Educative;

import static org.junit.Assert.assertEquals;

import Java.Code.Educative.MathAndStatsCalculateThePowerOfANumber;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MathAndStatsCalculateThePowerOfANumberTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void power_1() {
        double expected = 25;
        double base = 5;
        double power = 2;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_2() {
        double expected = 0.5;
        double base = 2;
        double power = -1;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_3() {
        double expected = 2;
        double base = 4;
        double power = 0.5;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_4() {
        double expected = 1;
        double base = 0;
        double power = 0;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_5() {
        double expected = 32;
        double base = 2;
        double power = 5;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_6() {
        double expected = 81;
        double base = 3;
        double power = 4;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_7() {
        double expected = 3.375;
        double base = 1.5;
        double power = 3;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_8() {
        double expected = 0.25;
        double base = 2;
        double power = -2;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void power_9() {
        double expected = 8;
        double base = 4;
        double power = 1.5;
        double result = MathAndStatsCalculateThePowerOfANumber.power(base, power);
        System.out.format(
                "%s: The number '%.2f' to the power of '%.2f' is '%.2f'.\n",
                name.getMethodName(), base, power, result);
        assertEquals(expected, result, 0.0001);
    }
}
