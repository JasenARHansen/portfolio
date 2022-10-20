package Test.Java.Interview.Facebook.Practice;

import Code.Java.Interview.Facebook.Practice.EditDistance;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EditDistanceTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void EditDistance() {
        System.out.format("%s: ", name.getMethodName());
        EditDistance.getDescription();
    }

    @Test
    public void oneEditApart_1() {
        String left = "cat";
        String right = "dog";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_2() {
        String left = "cat";
        String right = "cats";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_3() {
        String left = "cat";
        String right = "cut";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_4() {
        String left = "cat";
        String right = "cast";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_5() {
        String left = "at";
        String right = "cat";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertTrue(result);
    }

    @Test
    public void oneEditApart_6() {
        String left = "cat";
        String right = "act";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_7() {
        String left = "at";
        String right = "acts";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_8() {
        String left = null;
        String right = "acts";
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_9() {
        String left = "cat";
        String right = null;
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertFalse(result);
    }

    @Test
    public void oneEditApart_10() {
        String left = null;
        String right = null;
        boolean result = EditDistance.oneEditApart(left, right);
        System.out.format("%s: The string '%s' is 1 edit away from '%s': %b\n", name.getMethodName(), left, right, result);
        assertTrue(result);
    }
}
