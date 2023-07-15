package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_02_Is_Permutation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"NewClassNamingConvention", "ConstantValue", "SpellCheckingInspection"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_02_Is_Permutation_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void isPermutation_false() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = "dog";
        boolean result = Q1_02_Is_Permutation.isPermutation(left, right);
        assertFalse(result);
        System.out.format("\t%s is a permutation of %s: %b\n", left, right, result);
    }

    @Test
    public void isPermutation_solution_1_false() {
        printTestHeader(name.getMethodName());
        String left = "good";
        String right = "bad";
        boolean result = Q1_02_Is_Permutation.isPermutation_solution_1(left, right);
        assertFalse(result);
        System.out.format("\t%s is a permutation of %s: %b\n", left, right, result);
    }

    @Test
    public void isPermutation_solution_1_true() {
        printTestHeader(name.getMethodName());
        String left = "123";
        String right = "321";
        boolean result = Q1_02_Is_Permutation.isPermutation_solution_1(left, right);
        assertTrue(result);
        System.out.format("\t%s is a permutation of %s: %b\n", left, right, result);
    }

    @Test
    public void isPermutation_solution_2_false() {
        printTestHeader(name.getMethodName());
        String left = "right";
        String right = "wrong";
        boolean result = Q1_02_Is_Permutation.isPermutation_solution_2(left, right);
        assertFalse(result);
        System.out.format("\t%s is a permutation of %s: %b\n", left, right, result);
    }

    @Test
    public void isPermutation_solution_2_true() {
        printTestHeader(name.getMethodName());
        String left = "god";
        String right = "dog";
        boolean result = Q1_02_Is_Permutation.isPermutation_solution_2(left, right);
        assertTrue(result);
        System.out.format("\t%s is a permutation of %s: %b\n", left, right, result);
    }

    @Test
    public void isPermutation_true() {
        printTestHeader(name.getMethodName());
        String left = "apple";
        String right = "elppa";
        boolean result = Q1_02_Is_Permutation.isPermutation(left, right);
        assertTrue(result);
        System.out.format("\t%s is a permutation of %s: %b\n", left, right, result);
    }
}
