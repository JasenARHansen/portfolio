package Test.CTCI.Ch_03_Stacks_and_Queues;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3_01_Three_in_One_Test {

    @Rule
    public TestName name = new TestName();

    @Test
    public void temp() {
        System.out.format("%s: \n", name.getMethodName());
        assertTrue(true);
    }

}
