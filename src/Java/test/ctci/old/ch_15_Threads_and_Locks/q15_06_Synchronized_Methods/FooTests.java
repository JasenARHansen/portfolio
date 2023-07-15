package Java.test.ctci.old.ch_15_Threads_and_Locks.q15_06_Synchronized_Methods;

import Java.code.ctci.source.ch_15_Threads_and_Locks.q15_06_Synchronized_Methods.Foo;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FooTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Foo() {
        printTestHeader(name.getMethodName());
        String input = "name";
        Foo foo = new Foo(input);
        assertNotNull(foo);
    }

    @Test
    public void column() {
        String input = "name";
        Foo foo = new Foo(input);
        assertEquals(input, foo.getName());
        System.out.format("\tFoo name - %s\n", foo.getName());
    }
}
