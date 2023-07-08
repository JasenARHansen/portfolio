package Java.Test.CTCI.other.Ch_01_Arrays_and_Strings;

import static org.junit.Assert.assertEquals;

import Java.Code.CTCI.other.Ch_01_Arrays_and_Strings.Q1_06_String_Compression;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_06_String_Compression_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void stringCompression_small() {
        String source = "aa";
        String expected = "aa";
        String result = Q1_06_String_Compression.stringCompression(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_large() {
        String source = "abbbaaaa";
        String expected = "a1b3a4";
        String result = Q1_06_String_Compression.stringCompression(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_solution_1_small() {
        String source = "bb";
        String expected = "bb";
        String result = Q1_06_String_Compression.stringCompression_solution_1(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_solution_1_large() {
        String source = "aabbb";
        String expected = "a2b3";
        String result = Q1_06_String_Compression.stringCompression_solution_1(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_solution_2_small() {
        String source = "cc";
        String expected = "cc";
        String result = Q1_06_String_Compression.stringCompression_solution_2(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_solution_2_large() {
        String source = "aabbccc";
        String expected = "a2b2c3";
        String result = Q1_06_String_Compression.stringCompression_solution_2(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_solution_3_small() {
        String source = "dd";
        String expected = "dd";
        String result = Q1_06_String_Compression.stringCompression_solution_3(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }

    @Test
    public void stringCompression_solution_3_large() {
        String source = "aaaaabbbbaaaabbddc";
        String expected = "a5b4a4b2d2c1";
        String result = Q1_06_String_Compression.stringCompression_solution_3(source);
        System.out.format("%s: '%s' converts to '%s'\n", name.getMethodName(), source, result);
        assertEquals(expected, result);
    }
}
