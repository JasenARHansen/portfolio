package Java.test.ctci.old.ch_15_Threads_and_Locks.q15_06_Synchronized_Methods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import Java.code.ctci.source.ch_15_Threads_and_Locks.q15_06_Synchronized_Methods.Foo;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FooTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Foo() {
    String input = "name";
    Foo foo = new Foo(input);
    assertNotNull(foo);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void column() {
    String input = "name";
    Foo foo = new Foo(input);
    assertEquals(input, foo.getName());
    System.out.format("%s: Foo name - %s\n", name.getMethodName(), foo.getName());
  }
}
