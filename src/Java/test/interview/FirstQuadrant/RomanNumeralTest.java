package Java.test.interview.FirstQuadrant;

import Java.code.interview.FirstQuadrant.RomanNumeral;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({
        "SpellCheckingInspection",
        "unchecked",
        "InstantiationOfUtilityClass",
        "DuplicatedCode"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RomanNumeralTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void conversion_To_Int_Array() {
        int[] expected = {1964, -1};
        printTestHeader(name.getMethodName());
        String[] data = {"MCMLXIV", "MIM"};
        int[] result = RomanNumeral.conversion_To_Int(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_CMXCIX() {
        int expected = 999;
        printTestHeader(name.getMethodName());
        String data = "CMXCIX";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_Complex_1() {
        String expected = "(20+999)/5";
        printTestHeader(name.getMethodName());
        String data = "(XX+CMXCIX)/V";
        String result = RomanNumeral.conversion_To_Int_Complex(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int_Complex of '%s' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Int_Complex_2() {
        String expected = "(1+5+10+900+90+9)/5";
        printTestHeader(name.getMethodName());
        String data = "(I+v+X+CM+XC+IX)/V";
        String result = RomanNumeral.conversion_To_Int_Complex(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int_Complex of '%s' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Int_Complex_3() {
        String expected = "(20+(#ERROR#))/5";
        printTestHeader(name.getMethodName());
        String data = "(XX+CIMXCIX)/V";
        String result = RomanNumeral.conversion_To_Int_Complex(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int_Complex of '%s' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Int_Complex_Array() {
        String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
        printTestHeader(name.getMethodName());
        String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
        String[] result = RomanNumeral.conversion_To_Int_Complex(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Complex_List() {
        String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
        printTestHeader(name.getMethodName());
        List<String> data = List.of("(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V");
        String[] result = RomanNumeral.conversion_To_Int_Complex(data);
        for (int i = 0; i < data.size(); i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Complex_Multiple_Input() {
        String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
        printTestHeader(name.getMethodName());
        String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
        String[] result = RomanNumeral.conversion_To_Int_Complex(data[0], data[1], data[2]);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Complex_Output_Array() {
        String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
        printTestHeader(name.getMethodName());
        String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
        String[] result = RomanNumeral.conversion_To_Int_Complex_Output(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Complex_Output_List() {
        String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
        printTestHeader(name.getMethodName());
        List<String> data = List.of("(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V");
        String[] result = RomanNumeral.conversion_To_Int_Complex_Output(data);
        for (int i = 0; i < data.size(); i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Complex_Output_Multiple_Input() {
        String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
        printTestHeader(name.getMethodName());
        String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
        String[] result = RomanNumeral.conversion_To_Int_Complex_Output(data[0], data[1], data[2]);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_III() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        String data = "iii";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_IIII() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "iiii";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_IIX() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "IIX";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_IM() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "IM";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_K() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "K";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_List() {
        int[] expected = {1964, -1};
        printTestHeader(name.getMethodName());
        List<String> data = List.of("MCMLXIV", "MIM");
        int[] result = RomanNumeral.conversion_To_Int(data);
        for (int i = 0; i < data.size(); i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Log() {
        printTestHeader(name.getMethodName());
        String[] data = {"iiii", "IIX", "IM", "Cat", "i", "I", "Ix"};
        List<String> result = RomanNumeral.conversion_To_Int_Log(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(7, result.size());
            System.out.format("\t%s", result.get(i));
        }
    }

    @Test
    public void conversion_To_Int_MCMLXIV() {
        int expected = 1964;
        printTestHeader(name.getMethodName());
        String data = "MCMLXIV";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_MMMCMXCIX() {
        int expected = 3999;
        printTestHeader(name.getMethodName());
        String data = "MMMCMXCIX";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_McMlXIv() {
        int expected = 1964;
        printTestHeader(name.getMethodName());
        String data = "McMlXIv";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_Multiple_Input() {
        int[] expected = {1964, -1};
        printTestHeader(name.getMethodName());
        String[] data = {"MCMLXIV", "MIM"};
        int[] result = RomanNumeral.conversion_To_Int(data[0], data[1]);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Output_1() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "iiii";
        int result = RomanNumeral.conversion_To_Int_Output(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_Output_2() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        String data = "iv";
        int result = RomanNumeral.conversion_To_Int_Output(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_Output_Array() {
        int[] expected = {1964, -1};
        printTestHeader(name.getMethodName());
        String[] data = {"MCMLXIV", "MIM"};
        int[] result = RomanNumeral.conversion_To_Int_Output(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Output_List() {
        int[] expected = {1964, -1};
        printTestHeader(name.getMethodName());
        List<String> data = List.of("MCMLXIV", "MIM");
        int[] result = RomanNumeral.conversion_To_Int_Output(data);
        for (int i = 0; i < data.size(); i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Output_MCMLXIV() {
        int expected = 1964;
        printTestHeader(name.getMethodName());
        String data = "MCMLXIV";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_Output_MIM() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "MIM";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_Output_Multiple_Input() {
        int[] expected = {1964, -1};
        printTestHeader(name.getMethodName());
        String[] data = {"MCMLXIV", "MIM"};
        int[] result = RomanNumeral.conversion_To_Int_Output(data[0], data[1]);
        for (int i = 0; i < data.length; i++) {
            assertEquals(expected[i], result[i]);
            System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
        }
    }

    @Test
    public void conversion_To_Int_Output_XLIX() {
        int expected = 49;
        printTestHeader(name.getMethodName());
        String data = "XLIX";
        int result = RomanNumeral.conversion_To_Int_Output(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_XLIX() {
        int expected = 49;
        printTestHeader(name.getMethodName());
        String data = "XLIX";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_i() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        String data = "i";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Int_mim() {
        int expected = -1;
        printTestHeader(name.getMethodName());
        String data = "mim";
        int result = RomanNumeral.conversion_To_Int(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Int of '%s' is %d\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_0() {
        String expected = RomanNumeral.errorString;
        printTestHeader(name.getMethodName());
        int data = 0;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_1964() {
        String expected = "MCMLXIV";
        printTestHeader(name.getMethodName());
        int data = 1964;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_20() {
        String expected = "XX";
        printTestHeader(name.getMethodName());
        int data = 20;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_3() {
        String expected = "III";
        printTestHeader(name.getMethodName());
        int data = 3;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_3999() {
        String expected = "MMMCMXCIX";
        printTestHeader(name.getMethodName());
        int data = 3999;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_4() {
        String expected = "IV";
        printTestHeader(name.getMethodName());
        int data = 4;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_4000() {
        String expected = RomanNumeral.errorString;
        printTestHeader(name.getMethodName());
        int data = 4000;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_5() {
        String expected = "V";
        printTestHeader(name.getMethodName());
        int data = 5;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void conversion_To_Numeral_999() {
        String expected = "CMXCIX";
        printTestHeader(name.getMethodName());
        int data = 999;
        String result = RomanNumeral.conversion_To_Numeral(data);
        assertEquals(expected, result);
        System.out.format("\tconversion_To_Numeral of '%d' is %s\n", data, result);
    }

    @Test
    public void supported_Characters_C() throws NoSuchFieldException, IllegalAccessException {
        int expected = 100;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "C";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }

    @Test
    public void supported_Characters_D() throws NoSuchFieldException, IllegalAccessException {
        int expected = 500;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "D";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }

    @Test
    public void supported_Characters_I() throws NoSuchFieldException, IllegalAccessException {
        int expected = 1;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "I";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }

    @Test
    public void supported_Characters_L() throws NoSuchFieldException, IllegalAccessException {
        int expected = 50;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "L";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }

    @Test
    public void supported_Characters_M() throws NoSuchFieldException, IllegalAccessException {
        int expected = 1000;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "M";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }

    @Test
    public void supported_Characters_V() throws NoSuchFieldException, IllegalAccessException {
        int expected = 5;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "V";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }

    @Test
    public void supported_Characters_X() throws NoSuchFieldException, IllegalAccessException {
        int expected = 10;
        printTestHeader(name.getMethodName());
        RomanNumeral e = new RomanNumeral();
        Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
        privateField.setAccessible(true);
        HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
        String data = "X";
        int result = supportedCharacters.get(data);
        assertEquals(expected, result);
        System.out.format("\tCharacter Value of '%s' is %d\n", data, result);
    }
}
