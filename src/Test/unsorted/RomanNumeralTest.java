package Test.unsorted;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import unsorted.CodeChalenge.FirstQuadrant;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RomanNumeralTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Complex_1() {
        String testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+999)/5");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Complex_2() {
        String testConversion = FirstQuadrant.conversion_To_Int_Complex("(I+v+X+CM+XC+IX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(1+5+10+900+90+9)/5");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Complex_3() {
        String testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CIMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+(#ERROR#))/5");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Complex_Output_Array() {
        System.out.format("Test: %s\n", name.getMethodName());
        String[] numerals = new String[]{"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
        FirstQuadrant.conversion_To_Int_Output_Complex(numerals);
        System.out.format("\n");
        String testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+999)/5");
        testConversion = FirstQuadrant.conversion_To_Int_Complex("(I+v+X+CM+XC+IX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(1+5+10+900+90+9)/5");
        testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CIMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+(#ERROR#))/5");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Complex_Output_List() {
        System.out.format("Test: %s\n", name.getMethodName());
        List<String> numerals = new ArrayList<>();
        numerals.add("(XX+CMXCIX)/V");
        numerals.add("(I+v+X+CM+XC+IX)/V");
        numerals.add("(XX+CIMXCIX)/V");
        FirstQuadrant.conversion_To_Int_Output_Complex(numerals);
        System.out.format("\n");
        String testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+999)/5");
        testConversion = FirstQuadrant.conversion_To_Int_Complex("(I+v+X+CM+XC+IX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(1+5+10+900+90+9)/5");
        testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CIMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+(#ERROR#))/5");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Complex_Output_Multiple_Input() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output_Complex("(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V");
        System.out.format("\n");
        String testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+999)/5");
        testConversion = FirstQuadrant.conversion_To_Int_Complex("(I+v+X+CM+XC+IX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(1+5+10+900+90+9)/5");
        testConversion = FirstQuadrant.conversion_To_Int_Complex("(XX+CIMXCIX)/V");
        assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V", testConversion, "(20+(#ERROR#))/5");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Complex_1() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output_Complex("(XX+CMXCIX)/V");
        System.out.format("\n");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Complex_2() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output_Complex("(I+v+X+CM+XC+IX)/V");
        System.out.format("\n");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Complex_3() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output_Complex("(XX+CIMXCIX)/V");
        System.out.format("\n");
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_Array() {
        System.out.format("Test: %s\n", name.getMethodName());
        String[] numerals = new String[]{"MCMLXIV", "MIM"};
        FirstQuadrant.conversion_To_Int_Output(numerals);
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
        testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_List() {
        System.out.format("Test: %s\n", name.getMethodName());
        List<String> numerals = new ArrayList<>();
        numerals.add("MCMLXIV");
        numerals.add("MIM");
        FirstQuadrant.conversion_To_Int_Output(numerals);
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
        testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
    }

    // @Test
    // public void
    // test_RomanNumeral_Conversion_To_Int_Complex_Output_With_Log_Array() {
    // System.out.format("Test: %s\n", name.getMethodName());
    // String[] numerals = new String[] { "(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V",
    // "(XX+CIMXCIX)/V" };
    // RomanNumeral.conversion_Output_Complex_With_Log(numerals);
    // System.out.format("\n");
    // String testConversion = RomanNumeral.conversion_Complex("(XX+CMXCIX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(20+999)/5");
    // testConversion = RomanNumeral.conversion_Complex("(I+v+X+CM+XC+IX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(1+5+10+900+90+9)/5");
    // testConversion = RomanNumeral.conversion_Complex("(XX+CIMXCIX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(20+(#ERROR#))/5");
    // }

    // @Test
    // public void
    // test_RomanNumeral_Conversion_To_Int_Complex_Output_With_Log_List() {
    // System.out.format("Test: %s\n", name.getMethodName());
    // List<String> numerals = new ArrayList<>();
    // numerals.add("(XX+CMXCIX)/V");
    // numerals.add("(I+v+X+CM+XC+IX)/V");
    // numerals.add("(XX+CIMXCIX)/V");
    // RomanNumeral.conversion_Output_Complex_With_Log(numerals);
    // System.out.format("\n");
    // String testConversion = RomanNumeral.conversion_Complex("(XX+CMXCIX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(20+999)/5");
    // testConversion = RomanNumeral.conversion_Complex("(I+v+X+CM+XC+IX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(1+5+10+900+90+9)/5");
    // testConversion = RomanNumeral.conversion_Complex("(XX+CIMXCIX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(20+(#ERROR#))/5");
    // }

    // @Test
    // public void
    // test_RomanNumeral_Conversion_To_Int_Complex_Output_With_Log_Multiple_Input()
    // {
    // System.out.format("Test: %s\n", name.getMethodName());
    // RomanNumeral.conversion_Output_Complex_With_Log( "(XX+CMXCIX)/V",
    // "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V");
    // System.out.format("\n");
    // String testConversion = RomanNumeral.conversion_Complex("(XX+CMXCIX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(20+999)/5");
    // testConversion = RomanNumeral.conversion_Complex("(I+v+X+CM+XC+IX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(1+5+10+900+90+9)/5");
    // testConversion = RomanNumeral.conversion_Complex("(XX+CIMXCIX)/V");
    // assertEquals("Test RomanNumeral Conversion Complex: (XX+CMXCIX)/V",
    // testConversion, "(20+(#ERROR#))/5");
    // }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_MCMLXIV() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output("MCMLXIV");
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_MIM() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output("MIM");
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_Multiple_Input() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output("MCMLXIV", "MIM");
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
        testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_With_Logs_Array() {
        System.out.format("Test: %s\n", name.getMethodName());
        String[] numerals = new String[]{"MCMLXIV", "MIM", "K", "IIII"};
        FirstQuadrant.conversion_To_Int_Output_With_Log(numerals);
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
        testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
        testValue = FirstQuadrant.conversion_To_Int("K");
        assertEquals("Test RomanNumeral Conversion (Invalid): K", -1, testValue);
        testValue = FirstQuadrant.conversion_To_Int("IIII");
        assertEquals("Test RomanNumeral Conversion (Invalid): IIII", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_With_Logs_List() {
        System.out.format("Test: %s\n", name.getMethodName());
        List<String> numerals = new ArrayList<>();
        numerals.add("MCMLXIV");
        numerals.add("MIM");
        numerals.add("k");
        numerals.add("IIII");
        FirstQuadrant.conversion_To_Int_Output_With_Log(numerals);
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
        testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
        testValue = FirstQuadrant.conversion_To_Int("K");
        assertEquals("Test RomanNumeral Conversion (Invalid): K", -1, testValue);
        testValue = FirstQuadrant.conversion_To_Int("IIII");
        assertEquals("Test RomanNumeral Conversion (Invalid): IIII", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_With_Logs_Multiple_Input() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output_With_Log("MCMLXIV", "MIM", "K", "IIII");
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
        testValue = FirstQuadrant.conversion_To_Int("MIM");
        assertEquals("Test RomanNumeral Conversion (Invalid): MIM", -1, testValue);
        testValue = FirstQuadrant.conversion_To_Int("K");
        assertEquals("Test RomanNumeral Conversion (Invalid): K", -1, testValue);
        testValue = FirstQuadrant.conversion_To_Int("IIII");
        assertEquals("Test RomanNumeral Conversion (Invalid): IIII", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Output_Simple_XLIX() {
        System.out.format("Test: %s\n", name.getMethodName());
        FirstQuadrant.conversion_To_Int_Output("XLIX");
        System.out.format("\n");
        int testValue = FirstQuadrant.conversion_To_Int("XLIX");
        assertEquals("Test RomanNumeral Conversion: XLIX", 49, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_CMXCIX() {
        int testValue = FirstQuadrant.conversion_To_Int("CMXCIX");
        assertEquals("Test RomanNumeral Conversion: CMXCIX", 999, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_i() {
        int testValue = FirstQuadrant.conversion_To_Int("i");
        assertEquals("Test RomanNumeral Conversion: i", 1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_III() {
        int testValue = FirstQuadrant.conversion_To_Int("III");
        assertEquals("Test RomanNumeral Conversion: III", 3, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_IIII() {
        int testValue = FirstQuadrant.conversion_To_Int("IIII");
        assertEquals("Test RomanNumeral Conversion (Invalid): IIII", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_IIX() {
        int testValue = FirstQuadrant.conversion_To_Int("IIX");
        assertEquals("Test RomanNumeral Conversion (Invalid): IIX", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_IM() {
        int testValue = FirstQuadrant.conversion_To_Int("IM");
        assertEquals("Test RomanNumeral Conversion (Invalid): IM", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_K() {
        int testValue = FirstQuadrant.conversion_To_Int("K");
        assertEquals("Test RomanNumeral Conversion (Invalid): K", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_McMlXIv() {
        int testValue = FirstQuadrant.conversion_To_Int("McMlXIv");
        assertEquals("Test RomanNumeral Conversion: McMlXIv", 1964, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_MCMLXIV() {
        int testValue = FirstQuadrant.conversion_To_Int("MCMLXIV");
        assertEquals("Test RomanNumeral Conversion: MCMLXIV", 1964, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_mim() {
        int testValue = FirstQuadrant.conversion_To_Int("mim");
        assertEquals("Test RomanNumeral Conversion (Invalid): mim", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_MMMCMXCIX() {
        int testValue = FirstQuadrant.conversion_To_Int("MMMCMXCIX");
        assertEquals("Test RomanNumeral Conversion: MMMCMXCIX", 3999, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Int_Value_XLIX() {
        int testValue = FirstQuadrant.conversion_To_Int("XLIX");
        assertEquals("Test RomanNumeral Conversion: XLIX", 49, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_0() {
        String testValue = FirstQuadrant.conversion_To_Numeral(0);
        assertEquals("Test RomanNumeral Conversion (Invalid): 0", FirstQuadrant.errorString, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_4000() {
        String testValue = FirstQuadrant.conversion_To_Numeral(4000);
        assertEquals("Test RomanNumeral Conversion (Invalid): 4000", FirstQuadrant.errorString, testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_1964() {
        String testValue = FirstQuadrant.conversion_To_Numeral(1964);
        assertEquals("Test RomanNumeral Conversion: 1964", "MCMLXIV", testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_20() {
        String testValue = FirstQuadrant.conversion_To_Numeral(20);
        assertEquals("Test RomanNumeral Conversion: 20", "XX", testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_3() {
        String testValue = FirstQuadrant.conversion_To_Numeral(3);
        assertEquals("Test RomanNumeral Conversion: 3", "III", testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_3999() {
        String testValue = FirstQuadrant.conversion_To_Numeral(3999);
        assertEquals("Test RomanNumeral Conversion: 3999", "MMMCMXCIX", testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_4() {
        String testValue = FirstQuadrant.conversion_To_Numeral(4);
        assertEquals("Test RomanNumeral Conversion: 4", "IV", testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_5() {
        String testValue = FirstQuadrant.conversion_To_Numeral(5);
        assertEquals("Test RomanNumeral Conversion: 5", "V", testValue);
    }

    @Test
    public void test_RomanNumeral_Conversion_To_Numeral_999() {
        String testValue = FirstQuadrant.conversion_To_Numeral(999);
        assertEquals("Test RomanNumeral Conversion: 999", "CMXCIX", testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_c() {
        int testValue = FirstQuadrant.get_Character_Value('c');
        assertEquals("Test RomanNumeral Value: c", 100, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_C() {
        int testValue = FirstQuadrant.get_Character_Value('C');
        assertEquals("Test RomanNumeral Value: C", 100, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_d() {
        int testValue = FirstQuadrant.get_Character_Value('d');
        assertEquals("Test RomanNumeral Value: d", 500, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_D() {
        int testValue = FirstQuadrant.get_Character_Value('D');
        assertEquals("Test RomanNumeral Value: D", 500, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_i() {
        int testValue = FirstQuadrant.get_Character_Value('i');
        assertEquals("Test RomanNumeral Value: i", 1, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_I() {
        int testValue = FirstQuadrant.get_Character_Value('I');
        assertEquals("Test RomanNumeral Value: I", 1, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_k() {
        int testValue = FirstQuadrant.get_Character_Value('k');
        assertEquals("Test RomanNumeral Value: k", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_l() {
        int testValue = FirstQuadrant.get_Character_Value('l');
        assertEquals("Test RomanNumeral Value: l", 50, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_L() {
        int testValue = FirstQuadrant.get_Character_Value('L');
        assertEquals("Test RomanNumeral Value: L", 50, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_m() {
        int testValue = FirstQuadrant.get_Character_Value('m');
        assertEquals("Test RomanNumeral Value: m", 1000, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_M() {
        int testValue = FirstQuadrant.get_Character_Value('M');
        assertEquals("Test RomanNumeral Value: M", 1000, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_v() {
        int testValue = FirstQuadrant.get_Character_Value('v');
        assertEquals("Test RomanNumeral Value: v", 5, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_V() {
        int testValue = FirstQuadrant.get_Character_Value('V');
        assertEquals("Test RomanNumeral Value: V", 5, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_x() {
        int testValue = FirstQuadrant.get_Character_Value('x');
        assertEquals("Test RomanNumeral Value: x", 10, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_Character_X() {
        int testValue = FirstQuadrant.get_Character_Value('X');
        assertEquals("Test RomanNumeral Value: X", 10, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_c() {
        int testValue = FirstQuadrant.get_Character_Value("c");
        assertEquals("Test RomanNumeral Value: c", 100, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_C() {
        int testValue = FirstQuadrant.get_Character_Value("C");
        assertEquals("Test RomanNumeral Value: C", 100, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_d() {
        int testValue = FirstQuadrant.get_Character_Value("d");
        assertEquals("Test RomanNumeral Value: d", 500, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_D() {
        int testValue = FirstQuadrant.get_Character_Value("D");
        assertEquals("Test RomanNumeral Value: D", 500, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_i() {
        int testValue = FirstQuadrant.get_Character_Value("i");
        assertEquals("Test RomanNumeral Value: i", 1, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_I() {
        int testValue = FirstQuadrant.get_Character_Value("I");
        assertEquals("Test RomanNumeral Value: I", 1, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_k() {
        int testValue = FirstQuadrant.get_Character_Value("k");
        assertEquals("Test RomanNumeral Value: X", -1, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_l() {
        int testValue = FirstQuadrant.get_Character_Value("l");
        assertEquals("Test RomanNumeral Value: l", 50, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_L() {
        int testValue = FirstQuadrant.get_Character_Value("L");
        assertEquals("Test RomanNumeral Value: L", 50, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_m() {
        int testValue = FirstQuadrant.get_Character_Value("m");
        assertEquals("Test RomanNumeral Value: m", 1000, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_M() {
        int testValue = FirstQuadrant.get_Character_Value("M");
        assertEquals("Test RomanNumeral Value: M", 1000, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_v() {
        int testValue = FirstQuadrant.get_Character_Value("v");
        assertEquals("Test RomanNumeral Value: v", 5, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_V() {
        int testValue = FirstQuadrant.get_Character_Value("V");
        assertEquals("Test RomanNumeral Value: V", 5, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_x() {
        int testValue = FirstQuadrant.get_Character_Value("x");
        assertEquals("Test RomanNumeral Value: x", 10, testValue);
    }

    @Test
    public void test_RomanNumeral_Get_Character_Value_As_String_X() {
        int testValue = FirstQuadrant.get_Character_Value("X");
        assertEquals("Test RomanNumeral Value: X", 10, testValue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_cd() {
        int testvalue = FirstQuadrant.subtractive_Notation("cd", 1);
        assertEquals("Test RomanNumeral Subtractive value: cd", 100, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_CD() {
        int testvalue = FirstQuadrant.subtractive_Notation("CD", 1);
        assertEquals("Test RomanNumeral Subtractive Value: CD", 100, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_cm() {
        int testvalue = FirstQuadrant.subtractive_Notation("cm", 1);
        assertEquals("Test RomanNumeral Subtractive value: cm", 100, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_CM() {
        int testvalue = FirstQuadrant.subtractive_Notation("CM", 1);
        assertEquals("Test RomanNumeral Subtractive Value: CM", 100, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_iv() {
        int testvalue = FirstQuadrant.subtractive_Notation("iv", 1);
        assertEquals("Test RomanNumeral Subtractive value: iv", 1, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_IV() {
        int testvalue = FirstQuadrant.subtractive_Notation("IV", 1);
        assertEquals("Test RomanNumeral Subtractive Value: IV", 1, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_ix() {
        int testvalue = FirstQuadrant.subtractive_Notation("ix", 1);
        assertEquals("Test RomanNumeral Subtractive value: ix", 1, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_IX() {
        int testvalue = FirstQuadrant.subtractive_Notation("IX", 1);
        assertEquals("Test RomanNumeral Subtractive Value: IX", 1, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_xc() {
        int testvalue = FirstQuadrant.subtractive_Notation("xc", 1);
        assertEquals("Test RomanNumeral Subtractive value: xc", 10, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_XC() {
        int testvalue = FirstQuadrant.subtractive_Notation("XC", 1);
        assertEquals("Test RomanNumeral Subtractive Value: XC", 10, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_xL() {
        int testvalue = FirstQuadrant.subtractive_Notation("xL", 1);
        assertEquals("Test RomanNumeral Subtractive value: xL", 10, testvalue);
    }

    @Test
    public void test_RomanNumeral_Subtractive_Value_XL() {
        int testvalue = FirstQuadrant.subtractive_Notation("XL", 1);
        assertEquals("Test RomanNumeral Subtractive Value: XL", 10, testvalue);
    }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_C() {
    // int testValue = RomanNumeral.supportedCharacters.get("C");
    // assertEquals("Test RomanNumeral Value: C", 100, testValue);
    // }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_D() {
    // int testValue = RomanNumeral.supportedCharacters.get("D");
    // assertEquals("Test RomanNumeral Value: D", 500, testValue);
    // }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_I() {
    // int testValue = RomanNumeral.supportedCharacters.get("I");
    // assertEquals("Test RomanNumeral Value: I", 1, testValue);
    // }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_L() {
    // int testValue = RomanNumeral.supportedCharacters.get("L");
    // assertEquals("Test RomanNumeral Value: L", 50, testValue);
    // }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_M() {
    // int testValue = RomanNumeral.supportedCharacters.get("M");
    // assertEquals("Test RomanNumeral Value: M", 1000, testValue);
    // }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_V() {
    // int testValue = RomanNumeral.supportedCharacters.get("V");
    // assertEquals("Test RomanNumeral Value: V", 5, testValue);
    // }

    // @Test
    // public void test_RomanNumeral_Supported_Characters_Value_X() {
    // int testValue = RomanNumeral.supportedCharacters.get("X");
    // assertEquals("Test RomanNumeral Value: X", 10, testValue);
    // }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_c() {
        Boolean testvalue = FirstQuadrant.validity_Character('c');
        assertEquals("Test RomanNumeral character validity: c", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_C() {
        Boolean testValue = FirstQuadrant.validity_Character('C');
        assertEquals("Test RomanNumeral Character Validity: C", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_d() {
        Boolean testvalue = FirstQuadrant.validity_Character('d');
        assertEquals("Test RomanNumeral character validity: d", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_D() {
        Boolean testValue = FirstQuadrant.validity_Character('D');
        assertEquals("Test RomanNumeral Character Validity: D", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_i() {
        Boolean testvalue = FirstQuadrant.validity_Character('i');
        assertEquals("Test RomanNumeral character validity: i", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_I() {
        Boolean testValue = FirstQuadrant.validity_Character('I');
        assertEquals("Test RomanNumeral Character Validity: I", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_k() {
        Boolean testvalue = FirstQuadrant.validity_Character('k');
        assertEquals("Test RomanNumeral character validity (invalid): k", false, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_K() {
        Boolean testValue = FirstQuadrant.validity_Character('K');
        assertEquals("Test RomanNumeral Character Validity (Invalid): K", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_l() {
        Boolean testvalue = FirstQuadrant.validity_Character('l');
        assertEquals("Test RomanNumeral character validity: l", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_L() {
        Boolean testValue = FirstQuadrant.validity_Character('L');
        assertEquals("Test RomanNumeral Character Validity: L", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_m() {
        Boolean testvalue = FirstQuadrant.validity_Character('m');
        assertEquals("Test RomanNumeral character validity: m", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_M() {
        Boolean testValue = FirstQuadrant.validity_Character('M');
        assertEquals("Test RomanNumeral Character Validity: M", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_v() {
        Boolean testvalue = FirstQuadrant.validity_Character('v');
        assertEquals("Test RomanNumeral character validity: v", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_V() {
        Boolean testValue = FirstQuadrant.validity_Character('V');
        assertEquals("Test RomanNumeral Character Validity: V", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_x() {
        Boolean testvalue = FirstQuadrant.validity_Character('x');
        assertEquals("Test RomanNumeral character validity: x", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_Character_X() {
        Boolean testValue = FirstQuadrant.validity_Character('X');
        assertEquals("Test RomanNumeral Character Validity: X", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_c() {
        Boolean testvalue = FirstQuadrant.validity_Character("c");
        assertEquals("Test RomanNumeral character validity: c", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_C() {
        Boolean testValue = FirstQuadrant.validity_Character("C");
        assertEquals("Test RomanNumeral Character Validity: C", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_d() {
        Boolean testvalue = FirstQuadrant.validity_Character("d");
        assertEquals("Test RomanNumeral character validity: d", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_D() {
        Boolean testValue = FirstQuadrant.validity_Character("D");
        assertEquals("Test RomanNumeral Character Validity: D", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_i() {
        Boolean testvalue = FirstQuadrant.validity_Character("i");
        assertEquals("Test RomanNumeral character validity: i", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_I() {
        Boolean testValue = FirstQuadrant.validity_Character("I");
        assertEquals("Test RomanNumeral Character Validity: I", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_k() {
        Boolean testvalue = FirstQuadrant.validity_Character("k");
        assertEquals("Test RomanNumeral character validity (invalid): k", false, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_K() {
        Boolean testValue = FirstQuadrant.validity_Character("K");
        assertEquals("Test RomanNumeral Character Validity (Invalid): K", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_l() {
        Boolean testvalue = FirstQuadrant.validity_Character("l");
        assertEquals("Test RomanNumeral character validity: l", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_L() {
        Boolean testValue = FirstQuadrant.validity_Character("L");
        assertEquals("Test RomanNumeral Character Validity: L", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_m() {
        Boolean testvalue = FirstQuadrant.validity_Character("m");
        assertEquals("Test RomanNumeral character validity: m", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_M() {
        Boolean testValue = FirstQuadrant.validity_Character("M");
        assertEquals("Test RomanNumeral Character Validity: M", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_v() {
        Boolean testvalue = FirstQuadrant.validity_Character("v");
        assertEquals("Test RomanNumeral character validity: v", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_V() {
        Boolean testValue = FirstQuadrant.validity_Character("V");
        assertEquals("Test RomanNumeral Character Validity: V", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_x() {
        Boolean testvalue = FirstQuadrant.validity_Character("x");
        assertEquals("Test RomanNumeral character validity: x", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Character_As_String_X() {
        Boolean testValue = FirstQuadrant.validity_Character("X");
        assertEquals("Test RomanNumeral Character Validity: X", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_I() {
        Boolean testValue = FirstQuadrant.validity_Order("I");
        assertEquals("Test RomanNumeral Order Validity: I", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_II() {
        Boolean testValue = FirstQuadrant.validity_Order("II");
        assertEquals("Test RomanNumeral Order Validity: II", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_IIV() {
        Boolean testValue = FirstQuadrant.validity_Order("IIV");
        assertEquals("Test RomanNumeral Order Validity (Invalid): IIV", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_IIX() {
        Boolean testValue = FirstQuadrant.validity_Order("IIX");
        assertEquals("Test RomanNumeral Order Validity (Invalid): IIX", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_IMCMLXIV() {
        Boolean testValue = FirstQuadrant.validity_Order("IMCMLXIV");
        assertEquals("Test RomanNumeral Order Validity (Invalid): IMCMLXIV", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_IV() {
        Boolean testValue = FirstQuadrant.validity_Order("IV");
        assertEquals("Test RomanNumeral Order Validity: IV", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_IX() {
        Boolean testValue = FirstQuadrant.validity_Order("IX");
        assertEquals("Test RomanNumeral Order Validity: IX", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_IXL() {
        Boolean testValue = FirstQuadrant.validity_Order("IXL");
        assertEquals("Test RomanNumeral Order Validity (Invalid): IXL", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_MCMLXIV() {
        Boolean testValue = FirstQuadrant.validity_Order("MCMLXIV");
        assertEquals("Test RomanNumeral Order Validity: MCMLXIV", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_V() {
        Boolean testValue = FirstQuadrant.validity_Order("V");
        assertEquals("Test RomanNumeral Order Validity: V", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_VI() {
        Boolean testValue = FirstQuadrant.validity_Order("VI");
        assertEquals("Test RomanNumeral Order Validity: ", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_X() {
        Boolean testValue = FirstQuadrant.validity_Order("X");
        assertEquals("Test RomanNumeral Order Validity: X", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_XI() {
        Boolean testValue = FirstQuadrant.validity_Order("XI");
        assertEquals("Test RomanNumeral Order Validity: ", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Order_XL() {
        Boolean testValue = FirstQuadrant.validity_Order("XL");
        assertEquals("Test RomanNumeral Order Validity: XL", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_Repetition_XXX() {
        Boolean testvalue = FirstQuadrant.validity_Repetition("XXX");
        assertEquals("Test RomanNumeral Repetition Validity: XXX", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Repetition_XXXX() {
        Boolean testvalue = FirstQuadrant.validity_Repetition("XXXX");
        assertEquals("Test RomanNumeral Repetition Validity: XXXX", false, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_Repetition_XXXXX() {
        Boolean testvalue = FirstQuadrant.validity_Repetition("XXXXX");
        assertEquals("Test RomanNumeral Repetition Validity: XXXXX", false, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_c() {
        Boolean testvalue = FirstQuadrant.validity_String("c");
        assertEquals("Test RomanNumeral String validity: c", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_C() {
        Boolean testValue = FirstQuadrant.validity_String("C");
        assertEquals("Test RomanNumeral String Validity: C", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_cd() {
        Boolean testvalue = FirstQuadrant.validity_String("cd");
        assertEquals("Test RomanNumeral String validity: cd", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_CD() {
        Boolean testValue = FirstQuadrant.validity_String("CD");
        assertEquals("Test RomanNumeral String Validity: CD", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_cm() {
        Boolean testvalue = FirstQuadrant.validity_String("cm");
        assertEquals("Test RomanNumeral String validity: cm", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_CM() {
        Boolean testValue = FirstQuadrant.validity_String("CM");
        assertEquals("Test RomanNumeral String Validity: CM", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_d() {
        Boolean testvalue = FirstQuadrant.validity_String("d");
        assertEquals("Test RomanNumeral String validity: d", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_D() {
        Boolean testValue = FirstQuadrant.validity_String("D");
        assertEquals("Test RomanNumeral String Validity: D", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_i() {
        Boolean testvalue = FirstQuadrant.validity_String("i");
        assertEquals("Test RomanNumeral String validity: i", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_I() {
        Boolean testValue = FirstQuadrant.validity_String("I");
        assertEquals("Test RomanNumeral String Validity: I", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_iv() {
        Boolean testvalue = FirstQuadrant.validity_String("iv");
        assertEquals("Test RomanNumeral String validity: iv", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_IV() {
        Boolean testValue = FirstQuadrant.validity_String("IV");
        assertEquals("Test RomanNumeral String Validity: IV", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_ix() {
        Boolean testvalue = FirstQuadrant.validity_String("ix");
        assertEquals("Test RomanNumeral String validity: x", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_IX() {
        Boolean testValue = FirstQuadrant.validity_String("IX");
        assertEquals("Test RomanNumeral String Validity: X", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_k() {
        Boolean testvalue = FirstQuadrant.validity_String("k");
        assertEquals("Test RomanNumeral String validity (invalid): k", false, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_K() {
        Boolean testValue = FirstQuadrant.validity_String("K");
        assertEquals("Test RomanNumeral String Validity (Invalid): K", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_l() {
        Boolean testvalue = FirstQuadrant.validity_String("l");
        assertEquals("Test RomanNumeral String validity: l", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_L() {
        Boolean testValue = FirstQuadrant.validity_String("L");
        assertEquals("Test RomanNumeral String Validity: L", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_m() {
        Boolean testvalue = FirstQuadrant.validity_String("m");
        assertEquals("Test RomanNumeral String validity: m", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_M() {
        Boolean testValue = FirstQuadrant.validity_String("M");
        assertEquals("Test RomanNumeral String Validity: M", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_v() {
        Boolean testvalue = FirstQuadrant.validity_String("v");
        assertEquals("Test RomanNumeral String validity: v", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_V() {
        Boolean testValue = FirstQuadrant.validity_String("V");
        assertEquals("Test RomanNumeral String Validity: V", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_x() {
        Boolean testvalue = FirstQuadrant.validity_String("x");
        assertEquals("Test RomanNumeral String validity: x", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_X() {
        Boolean testValue = FirstQuadrant.validity_String("X");
        assertEquals("Test RomanNumeral String Validity: X", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_xc() {
        Boolean testvalue = FirstQuadrant.validity_String("xc");
        assertEquals("Test RomanNumeral String validity: xc", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_XC() {
        Boolean testValue = FirstQuadrant.validity_String("XC");
        assertEquals("Test RomanNumeral String Validity: XC", true, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_xki() {
        Boolean testvalue = FirstQuadrant.validity_String("xki");
        assertEquals("Test RomanNumeral String validity (invalid): xki", false, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_XKI() {
        Boolean testValue = FirstQuadrant.validity_String("XKI");
        assertEquals("Test RomanNumeral String Validity (Invalid): XKI", false, testValue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_xl() {
        Boolean testvalue = FirstQuadrant.validity_String("xl");
        assertEquals("Test RomanNumeral String validity: xl", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_xL() {
        Boolean testvalue = FirstQuadrant.validity_String("xL");
        assertEquals("Test RomanNumeral String validity: xL", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_Xl() {
        Boolean testvalue = FirstQuadrant.validity_String("Xl");
        assertEquals("Test RomanNumeral String validity: Xl", true, testvalue);
    }

    @Test
    public void test_RomanNumeral_Validity_String_XL() {
        Boolean testValue = FirstQuadrant.validity_String("XL");
        assertEquals("Test RomanNumeral String Validity: XL", true, testValue);
    }
}