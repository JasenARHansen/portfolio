package Java.test.ctci.old.unsorted;

import Java.code.ctci.old.unsorted.SubstringPermutationOfLargerString;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubstringPermutationOfLargerStringTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        SubstringPermutationOfLargerString.getDescription();
    }
}
