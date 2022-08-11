package Test.Interview.Amazon.Interview.Question1;

import Code.Interview.Amazon.Interview.Question1.Table;
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
    public void constructor() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.printTable();
    }

    @Test
    public void addRow() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.addRow(12345, "Name", "Jasen", "Age", 25);
        data.printTable();
    }

    @Test
    public void addRow_update() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.addRow(12345, "Name", "Jasen", "Age", 25);
        data.addRow(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.addRow(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.addRow(1234, "Name", "Ted", "Pet", "Cat");
        data.removeRow(1);
        data.printTable();
    }

    @Test
    public void addRow_extra() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.addRow(12345, "Name", "Jasen", "Age", 25);
        data.addRow(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.addRow(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.addRow(1234, "Name", "Ted", "Pet", "Cat");
        data.printTable();
    }

    @Test
    public void removeRow() {
        System.out.format("%s: Table\n", name.getMethodName());
        Table data = new Table();
        data.addRow(12345, "Name", "Jasen", "Age", 25);
        data.addRow(12345, "Name", "Jasen", "Age", 25, "Pet", "Cat");
        data.addRow(12346, "Name", "Bob", "Age", 25, "Pet", "Cat", "Bird", 0);
        data.addRow(1234, "Name", "Ted", "Pet", "Cat");
        data.removeRow(1);
        data.printTable();
    }


}
