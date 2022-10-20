package Test.Java.Interview.Facebook.Practice;

import Code.Java.Interview.Facebook.Practice.BillionUsers;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillionUsersTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void BillionUsers() {
        System.out.format("%s: ", name.getMethodName());
        BillionUsers.getDescription();
    }

    @Test
    public void getBillionUsersDay_1() {
        int expected = 52;
        float[] values = {1.5f};
        int result = BillionUsers.getBillionUsersDay(values);
        System.out.format("%s: With a app growth rate of '%s' it will take %d days to reach 1 billion users.\n", name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void getBillionUsersDay_2() {
        int expected = 79;
        float[] values = {1.1f, 1.2f, 1.3f};
        int result = BillionUsers.getBillionUsersDay(values);
        System.out.format("%s: With a app growth rate of '%s' it will take %d days to reach 1 billion users.\n", name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void getBillionUsersDay_3() {
        int expected = 1047;
        float[] values = {1.01f, 1.02f};
        int result = BillionUsers.getBillionUsersDay(values);
        System.out.format("%s: With a app growth rate of '%s' it will take %d days to reach 1 billion users.\n", name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
