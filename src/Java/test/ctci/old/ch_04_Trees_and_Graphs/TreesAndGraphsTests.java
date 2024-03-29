package Java.test.ctci.old.ch_04_Trees_and_Graphs;

import Java.code.ctci.old.ch_04_Trees_and_Graphs.TreesAndGraphs;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TreesAndGraphsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        TreesAndGraphs.getDescription();
    }
}
