package Java.Test.HackerRank.Sorting;

import static org.junit.Assert.assertEquals;

import Java.Code.HackerRank.Sorting.FraudulentActivityNotifications;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FraudulentActivityNotificationsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void activityNotifications_1() {
        int expected = 1;
        int days = 3;
        int[] expenditure = {10, 20, 30, 40, 50};
        int result = FraudulentActivityNotifications.activityNotifications(expenditure, days);
        System.out.format(
                "%s: Given the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                name.getMethodName(), Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }

    @Test
    public void activityNotifications_2() {
        int expected = 2;
        int days = 5;
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int result = FraudulentActivityNotifications.activityNotifications(expenditure, days);
        System.out.format(
                "%s: Given the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                name.getMethodName(), Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }

    @Test
    public void activityNotifications_3() {
        int expected = 0;
        int days = 4;
        int[] expenditure = {1, 2, 3, 4, 4};
        int result = FraudulentActivityNotifications.activityNotifications(expenditure, days);
        System.out.format(
                "%s: Given the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                name.getMethodName(), Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }

    @Test
    public void activityNotifications_4() {
        int expected = 0;
        int days = 4;
        int[] expenditure = {1, 2, 3, 4, 4};
        int result = FraudulentActivityNotifications.activityNotifications2(expenditure, days);
        System.out.format(
                "%s: Given the expenditures of '%s' and a period of %d processing days, there will be %d warnings sent.\n",
                name.getMethodName(), Arrays.toString(expenditure), days, result);
        assertEquals(expected, result);
    }
}
