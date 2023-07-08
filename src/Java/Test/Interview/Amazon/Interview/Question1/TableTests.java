package Java.Test.Interview.Amazon.Interview.Question1;

import Java.Code.Interview.Amazon.Interview.Question1.Table;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableTests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void Table() {
        System.out.format("%s: ", name.getMethodName());
        Table.getDescription();
    }

    @Test
    public void constructor() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.printTable();
    }

    @Test
    public void addRow() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.printTable();
    }

    @Test
    public void addRow_update() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.printTable();
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.printTable();
    }

    @Test
    public void addRow_extra() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.printTable();
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.printTable();
    }

    @Test
    public void removeRow() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
        data.deleteRow(1);
        data.printTable();
    }

    @Test
    public void printRow() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printRow(0);
    }

    @Test
    public void printRowByUserID() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Cat");
        data.printRowByUserID(12346);
    }

    @Test
    public void removeRowByUserID() {
        System.out.format("%s: Table\n", name.getMethodName());
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
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.insert(12345, "Name", "Jasen", "Age", 25);
        data.insert(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.insert(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.insert(1234, "Name", "Ted", "Pet", "Dog");
        data.insert(33356, "Name", "Alan", "Pet", "Dog");
        data.printTable();
        data.printRowByData("Name", "Alan", "Pet", "Cat");
    }

    @Test
    public void removeRowByData() {
        System.out.format("%s: Table\n", name.getMethodName());
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
}
