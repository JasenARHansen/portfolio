package Test.CTCI.other.Ch_01_Arrays_and_Strings;

import CTCI.Ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_04_Palindrome_Permutation_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void palindromePermutation_true() {
        String source = "Tact Coa";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertTrue(success);
    }

    @Test
    public void palindromePermutation_false() {
        String source = "Taco";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertFalse(success);
    }

    @Test
    public void palindromePermutation_solution_1_true() {
        String source = "Rats live on no evil star";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation_solution_1(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertTrue(success);
    }

    @Test
    public void palindromePermutation_solution_1_false() {
        String source = "A ball in spring";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation_solution_1(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertFalse(success);
    }

    @Test
    public void palindromePermutation_solution_2_true() {
        String source = "Rats live on no evil star";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation_solution_2(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertTrue(success);
    }

    @Test
    public void palindromePermutation_solution_2_false() {
        String source = "A ball in summer";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation_solution_2(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertFalse(success);
    }

    @Test
    public void palindromePermutation_solution_3_true() {
        String source = "Zeus was deified, saw Suez";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation_solution_3(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertTrue(success);
    }

    @Test
    public void palindromePermutation_solution_3_false() {
        String source = "A ball in winter";
        boolean success = Q1_04_Palindrome_Permutation.palindromePermutation_solution_3(source);
        System.out.format(
                "%s: %s has a palindrome permutation: %b\n", name.getMethodName(), source, success);
        assertFalse(success);
    }
}
