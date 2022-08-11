package Test.Interview.Amazon.Interview;

import Code.Interview.Amazon.Interview.Question1.ProcessRecords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Question1Tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void ProcessRecords() {
        System.out.format("%s: ", name.getMethodName());
        ProcessRecords.getDescription();
    }

    /*
    @Test
    public void removeRowByUserID_1() {
        String expected = "Success";
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "User", "Data");
        data.insert(12346, "User1", "Data");
        data.insert(12345, "User", "Data");
        data.insert(12348, "User3", "Data");
        int userID = 12345;
        System.out.format("%s: Initial data.\n", name.getMethodName());
        data.printTable();
        String result = data.removeRowByUserID(userID);
        System.out.format(
                "%s: Attempting to delete records for userID %d: %s.\n",
                name.getMethodName(), userID, result);
        System.out.format("%s: Modified data.\n", name.getMethodName());
        data.printTable();
        assertEquals(expected, result);
    }

    @Test
    public void removeRowByUserID_2() {
        String expected = "No Record";
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "User", "Data");
        data.insert(12346, "User1", "Data");
        data.insert(12345, "User", "Data");
        data.insert(12348, "User3", "Data");
        int userID = 9999;
        System.out.format("%s: Initial data.\n", name.getMethodName());
        data.printTable();
        String result = data.removeRowByUserID(userID);
        System.out.format(
                "%s: Attempting to delete records for userID %d: %s.\n",
                name.getMethodName(), userID, result);
        System.out.format("%s: Modified data.\n", name.getMethodName());
        data.printTable();
        assertEquals(expected, result);
    }
     */
}
