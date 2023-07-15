package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_05_One_Away;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"NewClassNamingConvention", "SpellCheckingInspection", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_05_One_Away_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void oneAway_different_false() {
        printTestHeader(name.getMethodName());
        String a = "pse";
        String b = "pale";
        boolean result = Q1_05_One_Away.oneAway(a, b);
        assertFalse(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_different_true() {
        printTestHeader(name.getMethodName());
        String a = "cat";
        String b = "at";
        boolean result = Q1_05_One_Away.oneAway(a, b);
        assertTrue(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_same_false() {
        printTestHeader(name.getMethodName());
        String a = "past";
        String b = "pale";
        boolean result = Q1_05_One_Away.oneAway(a, b);
        assertFalse(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_same_true() {
        printTestHeader(name.getMethodName());
        String a = "cat";
        String b = "bat";
        boolean result = Q1_05_One_Away.oneAway(a, b);
        assertTrue(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_solution_1_false() {
        printTestHeader(name.getMethodName());
        String a = "pkle";
        String b = "pable";
        boolean result = Q1_05_One_Away.oneAway_solution_1(a, b);
        assertFalse(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_solution_1_true() {
        printTestHeader(name.getMethodName());
        String a = "d";
        String b = "de";
        boolean result = Q1_05_One_Away.oneAway_solution_1(a, b);
        assertTrue(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_solution_2_false() {
        printTestHeader(name.getMethodName());
        String a = "adfdsfadsf";
        String b = "acdfdsfdsf";
        boolean result = Q1_05_One_Away.oneAway_solution_2(a, b);
        assertFalse(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }

    @Test
    public void oneAway_solution_2_true() {
        printTestHeader(name.getMethodName());
        String a = "pale";
        String b = "pkle";
        boolean result = Q1_05_One_Away.oneAway_solution_2(a, b);
        assertTrue(result);
        System.out.format("\t'%s' is 1 edit away from '%s': %b\n", a, b, result);
    }
}
