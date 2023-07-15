package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.EditDistance;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditDistanceTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        EditDistance.getDescription();
    }

    @Test
    public void oneEditApart_1() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = "dog";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_10() {
        printTestHeader(name.getMethodName());
        String left = null;
        String right = null;
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_2() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = "cats";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_3() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = "cut";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_4() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = "cast";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_5() {
        printTestHeader(name.getMethodName());
        String left = "at";
        String right = "cat";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_6() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = "act";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_7() {
        printTestHeader(name.getMethodName());
        String left = "at";
        String right = "acts";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_8() {
        printTestHeader(name.getMethodName());
        String left = null;
        String right = "acts";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_9() {
        printTestHeader(name.getMethodName());
        String left = "cat";
        String right = null;
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format(
                "\tThe string '%s' is 1 edit away from '%s': %b\n",
                left, right, result);
        assertFalse(result);
    }
}
