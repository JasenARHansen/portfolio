package Java.test.interview.Amazon.interview.question1;

import Java.code.interview.Amazon.interview.question1.ProcessRecords;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessRecordsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void constructor() {
        System.out.format("\tTable\n");
        ProcessRecords data = new ProcessRecords();
        data.printTable();
    }

    @Test
    public void deleteNonEssential() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteNonEssential();
        data.printTable();
    }

    @Test
    public void deleteRow() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteRow(1);
        data.printTable();
    }

    @Test
    public void deleteRowByData() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Dog");
        data.insert(33356, "Name", "Alan", "Pet", "Dog");
        data.printTable();
        data.deleteRowByData("Name", "Alan", "Pet", "Cat");
        data.printTable();
    }

    @Test
    public void deleteRowByUserID() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteRowByUserID(12345);
        data.printTable();
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ProcessRecords.getDescription();
    }

    @Test
    public void printRow() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.printRow(1);
    }

    @Test
    public void printRowByData() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Dog");
        data.insert(33356, "Name", "Alan", "Pet", "Dog");
        data.printTable();
        data.printRowByData("Name", "Alan", "Pet", "Cat");
    }

    @Test
    public void printRowByUserID() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.printRowByUserID(12345);
    }

    @Test
    public void printTable() {
        printTestHeader(name.getMethodName());
        ProcessRecords data = new ProcessRecords();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
    }
}
