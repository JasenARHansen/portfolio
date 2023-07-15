package Java.test.interview.Amazon.interview.question3;

import Java.code.interview.Amazon.interview.question3.ConvertXML;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConvertXMLTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void convert_1() {
        String expected = "h<b>e<i>ll</i>o</b>";
        printTestHeader(name.getMethodName());
        String[][] rules = {{"b", "1", "4"}, {"i", "2", "3"}};
        String input = "hello";
        String result = ConvertXML.convert(input, rules);
        System.out.format("\t%s converts to %s\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void convert_2() {
        String expected = "h<b>e<i>l</i></b><i>l</i>o";
        printTestHeader(name.getMethodName());
        String[][] rules = {{"b", "1", "2"}, {"i", "2", "3"}};
        String input = "hello";
        String result = ConvertXML.convert(input, rules);
        System.out.format("\t%s converts to %s\n", input, result);
        assertEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ConvertXML.getDescription();
    }
}
