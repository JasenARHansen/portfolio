package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_07_Chat_Server;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_07_Chat_Server.UserStatusType;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserStatusTypeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Available() {
        String expected = "Available";
        printTestHeader(name.getMethodName());
        UserStatusType result = UserStatusType.Available;
        assertEquals(expected, result.toString());
        System.out.format("\t%s\n", result);
    }

    @Test
    public void Away() {
        String expected = "Away";
        printTestHeader(name.getMethodName());
        UserStatusType result = UserStatusType.Away;
        assertEquals(expected, result.toString());
        System.out.format("\t%s\n", result);
    }

    @Test
    public void Busy() {
        String expected = "Busy";
        printTestHeader(name.getMethodName());
        UserStatusType result = UserStatusType.Busy;
        assertEquals(expected, result.toString());
        System.out.format("\t%s\n", result);
    }

    @Test
    public void Idle() {
        String expected = "Idle";
        printTestHeader(name.getMethodName());
        UserStatusType result = UserStatusType.Idle;
        assertEquals(expected, result.toString());
        System.out.format("\t%s\n", result);
    }

    @Test
    public void Offline() {
        String expected = "Offline";
        printTestHeader(name.getMethodName());
        UserStatusType result = UserStatusType.Offline;
        assertEquals(expected, result.toString());
        System.out.format("\t%s\n", result);
    }

}
