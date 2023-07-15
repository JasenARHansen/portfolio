package Java.test.interview.Amazon.interview.question1;

import Java.code.interview.Amazon.interview.question1.Table;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void addRow() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.printTable();
    }

    @Test
    public void addRow_extra() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.printTable();
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.printTable();
    }

    @Test
    public void addRow_update() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.printTable();
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.printTable();
    }

    @Test
    public void constructor() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.printTable();
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Table.getDescription();
    }

    @Test
    public void printRow() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printRow(0);
    }

    @Test
    public void printRowByUserID() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printRowByUserID(12346);
    }

    @Test
    public void removeRow() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteRow(1);
        data.printTable();
    }

    @Test
    public void removeRowByData() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
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
    public void removeRowByUserID() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteRowByUserID(12346);
        data.printTable();
    }

    @Test
    public void selectRowByData() {
        printTestHeader(name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Dog");
        data.insert(33356, "Name", "Alan", "Pet", "Dog");
        data.printTable();
        data.printRowByData("Name", "Alan", "Pet", "Cat");
    }
}
