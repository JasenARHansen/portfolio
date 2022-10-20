package Test.Java.CTCI.other.Ch_01_Arrays_and_Strings;

import Code.Java.CTCI.other.Ch_01_Arrays_and_Strings.Q1_02_Is_Permutation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_02_Is_Permutation_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void isPermutation_true() {
        String left = "apple";
        String right = "papel";
        boolean success = Q1_02_Is_Permutation.isPermutation(left, right);
        System.out.format(
                "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, success);
        assertTrue(success);
    }

    @Test
    public void isPermutation_false() {
        String left = "cat";
        String right = "dog";
        boolean success = Q1_02_Is_Permutation.isPermutation(left, right);
        System.out.format(
                "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, success);
        assertFalse(success);
    }

    @Test
    public void isPermutation_solution_1_true() {
        String left = "123";
        String right = "321";
        boolean success = Q1_02_Is_Permutation.isPermutation_solution_1(left, right);
        System.out.format(
                "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, success);
        assertTrue(success);
    }

    @Test
    public void isPermutation_solution_1_false() {
        String left = "good";
        String right = "bad";
        boolean success = Q1_02_Is_Permutation.isPermutation_solution_1(left, right);
        System.out.format(
                "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, success);
        assertFalse(success);
    }

    @Test
    public void isPermutation_solution_2_true() {
        String left = "god";
        String right = "dog";
        boolean success = Q1_02_Is_Permutation.isPermutation_solution_2(left, right);
        System.out.format(
                "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, success);
        assertTrue(success);
    }

    @Test
    public void isPermutation_solution_2_false() {
        String left = "right";
        String right = "wrong";
        boolean success = Q1_02_Is_Permutation.isPermutation_solution_2(left, right);
        System.out.format(
                "%s: %s is a permutation of %s: %b\n", name.getMethodName(), left, right, success);
        assertFalse(success);
    }
}
