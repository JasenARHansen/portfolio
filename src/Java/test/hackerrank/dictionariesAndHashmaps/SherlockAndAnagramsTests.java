package Java.test.hackerrank.dictionariesAndHashmaps;

import Java.code.hackerrank.dictionariesAndHashmaps.SherlockAndAnagrams;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SherlockAndAnagramsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void sherlockAndAnagrams_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        String source = "mom";
        int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
        System.out.format(
                "\tThe string '%s' has %d unordered anagrams.\n", source, result);
        assertEquals(expected, result);
    }

    @Test
    public void sherlockAndAnagrams_2() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        String source = "abba";
        int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
        System.out.format(
                "\tThe string '%s' has %d unordered anagrams.\n", source, result);
        assertEquals(expected, result);
    }

    @Test
    public void sherlockAndAnagrams_3() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        String source = "abcd";
        int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
        System.out.format(
                "\tThe string '%s' has %d unordered anagrams.\n", source, result);
        assertEquals(expected, result);
    }

    @Test
    public void sherlockAndAnagrams_4() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        String source = "ifailuhkqq";
        int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
        System.out.format(
                "\tThe string '%s' has %d unordered anagrams.\n", source, result);
        assertEquals(expected, result);
    }

    @Test
    public void sherlockAndAnagrams_5() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        String source = "kkkk";
        int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
        System.out.format(
                "\tThe string '%s' has %d unordered anagrams.\n", source, result);
        assertEquals(expected, result);
    }

    @Test
    public void sherlockAndAnagrams_6() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        String source = "cdcd";
        int result = SherlockAndAnagrams.sherlockAndAnagrams(source);
        System.out.format(
                "\tThe string '%s' has %d unordered anagrams.\n", source, result);
        assertEquals(expected, result);
    }
}
