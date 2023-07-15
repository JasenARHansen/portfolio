package Java.test.hackerrank.sorting;

import Java.code.hackerrank.sorting.FraudulentActivityNotifications;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FraudulentActivityNotificationsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void activityNotifications_1() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int days = 3;
        int[] expenditure = {10, 20, 30, 40, 50};
        int result = FraudulentActivityNotifications.activityNotifications(expenditure, days);
        System.out.format(
                "\tGiven the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }

    @Test
    public void activityNotifications_2() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int days = 5;
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int result = FraudulentActivityNotifications.activityNotifications(expenditure, days);
        System.out.format(
                "\tGiven the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }

    @Test
    public void activityNotifications_3() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int days = 4;
        int[] expenditure = {1, 2, 3, 4, 4};
        int result = FraudulentActivityNotifications.activityNotifications(expenditure, days);
        System.out.format(
                "\tGiven the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }

    @Test
    public void activityNotifications_4() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int days = 4;
        int[] expenditure = {1, 2, 3, 4, 4};
        int result = FraudulentActivityNotifications.activityNotifications2(expenditure, days);
        System.out.format(
                "\tGiven the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }
}
