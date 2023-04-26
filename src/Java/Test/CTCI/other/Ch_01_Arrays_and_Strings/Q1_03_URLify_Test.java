package Test.Java.CTCI.other.Ch_01_Arrays_and_Strings;

import Java.Code.CTCI.other.Ch_01_Arrays_and_Strings.Q1_03_URLify;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_03_URLify_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void URLify() {
        String source = "Mr John Smith    ";
        String expected = "Mr%20John%20Smith";
        String result = Q1_03_URLify.URLify(source);
        System.out.format("%s: '%s' was converted to '%s'\n", name.getMethodName(), source, expected);
        assertEquals(expected, result);
    }

    @Test
    public void URLify_solution_1() {
        String source = "Mr John Smith    ";
        String expected = "Mr%20John%20Smith";
        char[] arr = source.toCharArray();
        int trueLength = Q1_03_URLify.findLastCharacter(arr) + 1;
        Q1_03_URLify.replaceSpaces(arr, trueLength);
        String result = new String(arr);
        System.out.format("%s: '%s' was converted to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }
}
