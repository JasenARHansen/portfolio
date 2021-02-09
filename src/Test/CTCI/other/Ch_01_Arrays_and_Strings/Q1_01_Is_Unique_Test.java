package Test.CTCI.other.Ch_01_Arrays_and_Strings;

import Code.CTCI.other.Ch_01_Arrays_and_Strings.Q1_01_Is_Unique;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1_01_Is_Unique_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void isUniqueChars_true() {
        String word = "cat";
        boolean success = Q1_01_Is_Unique.isUnique(word);
        System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, success);
        assertTrue(success);
    }

    @Test
    public void isUniqueChars_false() {
        String word = "Jasen Hansen";
        boolean success = Q1_01_Is_Unique.isUnique(word);
        System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, success);
        assertFalse(success);
    }

    @Test
    public void isUniqueChars_solution_1_true() {
        String word = "cake";
        boolean success = Q1_01_Is_Unique.isUnique_solution_1(word);
        System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, success);
        assertTrue(success);
    }

    @Test
    public void isUniqueChars_solution_1_false() {
        String word = "teapot";
        boolean success = Q1_01_Is_Unique.isUnique_solution_1(word);
        System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, success);
        assertFalse(success);
    }

    @Test
    public void isUniqueChars_solution_2_true() {
        String word = "cake";
        boolean success = Q1_01_Is_Unique.isUnique_solution_2(word);
        System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, success);
        assertTrue(success);
    }

    @Test
    public void isUniqueChars_solution_2_false() {
        String word = "teapot";
        boolean success = Q1_01_Is_Unique.isUnique_solution_2(word);
        System.out.format("%s: %s has unique characters: %b\n", name.getMethodName(), word, success);
        assertFalse(success);
    }
}
