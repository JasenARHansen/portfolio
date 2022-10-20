package Test.Java.Interview.Facebook.Practice;

import Code.Java.Interview.Facebook.Practice.RotationalCipher;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RotationalCipherTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void RotationalCipher() {
        System.out.format("%s: ", name.getMethodName());
        RotationalCipher.getDescription();
    }

    @Test
    public void rotationalCipher_1() {
        String expected = "Cheud-726?";
        String input = "Zebra-493?";
        int rotationFactor = 3;
        String result = RotationalCipher.rotationalCipher(input, rotationFactor);
        System.out.format("%s: The value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void rotationalCipher_2() {
        String expected = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int rotationFactor = 39;
        String result = RotationalCipher.rotationalCipher(input, rotationFactor);
        System.out.format("%s: The value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void rotationalCipher_3() {
        String expected = "Epp-gsrzsCw-3-fi:Epivx5.";
        String input = "All-convoYs-9-be:Alert1.";
        int rotationFactor = 4;
        String result = RotationalCipher.rotationalCipher(input, rotationFactor);
        System.out.format("%s: The value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void rotationalCipher_4() {
        String expected = "stuvRPQrpq-999.@";
        String input = "abcdZXYzxy-999.@";
        int rotationFactor = 200;
        String result = RotationalCipher.rotationalCipher(input, rotationFactor);
        System.out.format("%s: The value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void decodeCipher_1() {
        String expected = "Zebra-493?";
        String input = "Cheud-726?";
        int rotationFactor = 3;
        String result = RotationalCipher.decodeCipher(input, rotationFactor);
        System.out.format("%s: Decode the value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void decodeCipher_2() {
        String expected = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        String input = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
        int rotationFactor = 39;
        String result = RotationalCipher.decodeCipher(input, rotationFactor);
        System.out.format("%s: Decode the value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void decodeCipher_3() {
        String expected = "All-convoYs-9-be:Alert1.";
        String input = "Epp-gsrzsCw-3-fi:Epivx5.";
        int rotationFactor = 4;
        String result = RotationalCipher.decodeCipher(input, rotationFactor);
        System.out.format("%s: Decode the value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }

    @Test
    public void decodeCipher_4() {
        String expected = "abcdZXYzxy-999.@";
        String input = "stuvRPQrpq-999.@";
        int rotationFactor = 200;
        String result = RotationalCipher.decodeCipher(input, rotationFactor);
        System.out.format("%s: Decode the value '%s' with a rotational factor of %d results in '%s'\n", name.getMethodName(), input, rotationFactor, result);
        assertEquals(expected, result);
    }
}
