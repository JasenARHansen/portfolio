package Test.unsorted;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import unsorted.classesStatic.KataStatic;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataTest {
    @Test
    public void test_Multiple3_5_1() {
        assertEquals(23, KataStatic.multiple3_5_2(10));
    }

    @Test
    public void test_Multiple3_5_2() {
        assertEquals(23, KataStatic.multiple3_5(10));
    }

    @Test
    public void test_rowSumOddNumbers_1() {
        assertEquals("rowSumOddNumbers 3", 27, KataStatic.rowSumOddNumbers(3));
    }

    @Test
    public void test_rowSumOddNumbers_2() {
        assertEquals("rowSumOddNumbers 3", 27, KataStatic.rowSumOddNumbers2(3));
    }

    @Test
    public void test_isSquare_1() {
        assertFalse("negative numbers aren't square numbers", KataStatic.isSquare(-1));
    }

    @Test
    public void test_isSquare_2() {
        assertFalse("3 isn't a square number", KataStatic.isSquare(3));
    }

    @Test
    public void test_isSquare_3() {
        assertTrue("4 is a square number", KataStatic.isSquare(4));
    }

    @Test
    public void test_isSquare_4() {
        assertTrue("25 is a square number", KataStatic.isSquare(25));
    }

    @Test
    public void test_isSquare_5() {
        assertFalse("26 isn't a square number", KataStatic.isSquare(26));
    }

    @Test
    public void test_HighAndLow_1() {
        assertEquals("42 -9", KataStatic.HighAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    public void test_HighAndLow_2() {
        assertEquals("42 -9", KataStatic.HighAndLow2("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    @Test
    public void test_reverseString_1() {
        assertEquals("dlrow", KataStatic.reverseString("world"));
    }

    @Test
    public void test_reverseString_2() {
        assertEquals("dlrow", KataStatic.reverseString2("world"));
    }

    @Test
    public void test_sortDesc_1() {
        assertEquals(321, KataStatic.sortDesc(123));
    }

    @Test
    public void test_findNb_1() {
        assertEquals(2022, KataStatic.findNb(2083488966853272226L));
    }

    @Test
    public void test_findNb_2() {
        assertEquals(2022, KataStatic.findNb(4183059834009L));
    }

    @Test
    public void test_findNb_3() {
        assertEquals(2022, KataStatic.findNb(4183059834009L));
    }

    @Test
    public void test_findNb_4() {
        assertEquals("findNb -1", -1, KataStatic.findNb(24723578342962L));
    }

    @Test
    public void test_findNb_5() {
        assertEquals("findNb 4824", 4824, KataStatic.findNb(135440716410000L));
    }

    @Test
    public void test_compArray_1() {
        assertTrue(KataStatic.compArray(new int[]{121, 144, 19, 161, 19, 144, 19, 11},
                new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));
    }

    @Test
    public void test_findNextSquare_1() {
        assertEquals(-1, KataStatic.findNextSquare(3));
    }

    @Test
    public void test_findNextSquare_2() {
        assertEquals(9, KataStatic.findNextSquare(4));
    }

    @Test
    public void test_digital_root_1() {
        assertEquals(4, KataStatic.digital_root(31));
    }

    @Test
    public void test_digital_root_2() {
        assertEquals(9, KataStatic.digital_root(99));
    }

    @Test
    public void test_orderWeight_1() {
        assertEquals("2000 103 123 4444 99", KataStatic.orderWeight("103 123 4444 99 2000"));
    }

    @Test
    public void test_orderWeight_2() {
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",
                KataStatic.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void test_orderWeight2_1() {
        assertEquals("2000 103 123 4444 99", KataStatic.orderWeight2("103 123 4444 99 2000"));
    }

    @Test
    public void test_orderWeight2_2() {
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",
                KataStatic.orderWeight2("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void test_inArray_1() {
        assertArrayEquals(new String[]{"arp", "live", "strong"},
                KataStatic.inArray(new String[]{"arp", "live", "strong"},
                        new String[]{"lively", "alive", "harp", "sharp", "armstrong"}));
    }

    @Test
    public void test_inArray_2() {
        assertArrayEquals(new String[]{}, KataStatic.inArray(new String[]{"tarp", "mice", "bull"},
                new String[]{"lively", "alive", "harp", "sharp", "armstrong"}));
    }

    @Test
    public void test_inArray2_1() {
        assertArrayEquals(new String[]{"arp", "live", "strong"},
                KataStatic.inArray2(new String[]{"arp", "live", "strong"},
                        new String[]{"lively", "alive", "harp", "sharp", "armstrong"}));
    }

    @Test
    public void test_inArray2_2() {
        assertArrayEquals(new String[]{}, KataStatic.inArray2(new String[]{"tarp", "mice", "bull"},
                new String[]{"lively", "alive", "harp", "sharp", "armstrong"}));
    }

    @Test
    public void test_count_find_num_1() {
        assertArrayEquals(new int[]{5, 490}, KataStatic.count_find_num(new int[]{2, 5, 7}, 500));
    }

    @Test
    public void test_count_find_num_2() {
        assertArrayEquals(new int[]{}, KataStatic.count_find_num(new int[]{2, 3, 47}, 200));
    }

    @Test
    public void test_count_find_num_3() {
        assertArrayEquals(new int[]{1, 282}, KataStatic.count_find_num(new int[]{2, 3, 47}, 282));
    }

}