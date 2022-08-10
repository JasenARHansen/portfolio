package Code.interview.Amazon.interview;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_1_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void removeRowByUserID_1() {
        String expected = "Success";
        process_records data = new process_records();
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
        process_records data = new process_records();
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
}
