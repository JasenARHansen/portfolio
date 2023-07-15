package Java.test.ctci.old.ch_17_Hard.q17_13_ReSpace;

import Java.code.ctci.source.ch_17_Hard.q17_13_ReSpace.ParseResult;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParseResultTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void ParseResult() {
        printTestHeader(name.getMethodName());
        int first = 5;
        String second = "second";
        ParseResult parseResult = new ParseResult(first, second);
        assertNotNull(parseResult);
    }

    @Test
    public void min() {
        printTestHeader(name.getMethodName());
        int first = 5;
        String second = "second";
        int third = 5;
        ParseResult parseResult_1 = new ParseResult(first, second);
        ParseResult parseResult_2 = new ParseResult(third, second);
        ParseResult result_1 = ParseResult.min(parseResult_1, parseResult_2);
        ParseResult result_2 = ParseResult.min(parseResult_2, parseResult_1);
        assertEquals(result_1, result_2);
        System.out.format("\tmin of %s and %s - %s\n", parseResult_1, parseResult_2, result_1);
    }
}
