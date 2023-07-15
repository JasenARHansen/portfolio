package Java.test.ctci.old.ch_01_Arrays_and_Strings;

import Java.code.ctci.old.ch_01_Arrays_and_Strings.Q1_09_String_Rotation;
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
public class Q1_09_String_Rotation_Test {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void isRotation_false() {
        printTestHeader(name.getMethodName());
        String left = "water";
        String right = "waterbottle";
        boolean result = Q1_09_String_Rotation.isRotation(left, right);
        assertFalse(result);
        System.out.format("\tstring '%s' is  rotation of '%s': %b\n", left, right, result);
    }

    @Test
    public void isRotation_solution_1() {
        printTestHeader(name.getMethodName());
        String left = "waterbottle";
        String right = "erbottlewat";
        boolean result = Q1_09_String_Rotation.isRotation_solution_1(left, right);
        assertTrue(result);
        System.out.format("\tstring '%s' is  rotation of '%s': %b\n", left, right, result);
    }

    @Test
    public void isRotation_true() {
        printTestHeader(name.getMethodName());
        String left = "waterbottle";
        String right = "erbottlewat";
        boolean result = Q1_09_String_Rotation.isRotation(left, right);
        assertTrue(result);
        System.out.format("\tstring '%s' is  rotation of '%s': %b\n", left, right, result);
    }
}
