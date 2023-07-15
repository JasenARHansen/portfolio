package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_03_URLify;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_03_URLify_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void URLify() {
        String expected = "Mr%20John%20Smith";
        printTestHeader(name.getMethodName());
        String source = "Mr John Smith    ";
        String result = Q1_03_URLify.URLify(source);
        assertEquals(expected, result);
        System.out.format("\t'%s' was converted to '%s'\n", source, expected);
    }

    @Test
    public void URLify_solution_1() {
        String expected = "Mr%20John%20Smith";
        printTestHeader(name.getMethodName());
        String source = "Mr John Smith    ";
        char[] arr = source.toCharArray();
        int trueLength = Q1_03_URLify.findLastCharacter(arr) + 1;
        Q1_03_URLify.replaceSpaces(arr, trueLength);
        String result = new String(arr);
        assertEquals(expected, result);
        System.out.format("\t'%s' was converted to '%s'\n", source, result);
    }
}
