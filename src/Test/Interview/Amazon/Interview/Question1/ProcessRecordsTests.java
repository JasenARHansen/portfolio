package Test.Interview.Amazon.Interview.Question1;

import Code.Interview.Amazon.Interview.Question1.ProcessRecords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessRecordsTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void ProcessRecords() {
        System.out.format("%s: ", name.getMethodName());
        ProcessRecords.getDescription();
    }

    @Test
    public void deleteNonEssential() {
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteNonEssential();
        data.printTable();

    }

}
