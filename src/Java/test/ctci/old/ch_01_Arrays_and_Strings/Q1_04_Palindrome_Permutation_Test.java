package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_04_Palindrome_Permutation;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"NewClassNamingConvention", "ConstantValue"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_04_Palindrome_Permutation_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void palindromePermutation_false() {
        printTestHeader(name.getMethodName());
        String source = "Taco";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation(source);
        assertFalse(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_solution_1_false() {
        printTestHeader(name.getMethodName());
        String source = "A ball in spring";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation_solution_1(source);
        assertFalse(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_solution_1_true() {
        printTestHeader(name.getMethodName());
        String source = "Rats live on no evil star";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation_solution_1(source);
        assertTrue(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_solution_2_false() {
        printTestHeader(name.getMethodName());
        String source = "A ball in summer";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation_solution_2(source);
        assertFalse(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_solution_2_true() {
        printTestHeader(name.getMethodName());
        String source = "Rats live on no evil star";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation_solution_2(source);
        assertTrue(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_solution_3_false() {
        printTestHeader(name.getMethodName());
        String source = "A ball in winter";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation_solution_3(source);
        assertFalse(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_solution_3_true() {
        printTestHeader(name.getMethodName());
        String source = "Zeus was deified, saw Suez";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation_solution_3(source);
        assertTrue(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }

    @Test
    public void palindromePermutation_true() {
        printTestHeader(name.getMethodName());
        String source = "Tact Coa";
        boolean result = Q1_04_Palindrome_Permutation.palindromePermutation(source);
        assertTrue(result);
        System.out.format("\t%s has a palindrome permutation: %b\n", source, result);
    }
}
