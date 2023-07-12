package Java.test.interview.FirstQuadrant;

import static org.junit.Assert.assertEquals;

import Java.code.interview.FirstQuadrant.RomanNumeral;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({
  "SpellCheckingInspection",
  "DuplicatedCode",
  "unchecked",
  "InstantiationOfUtilityClass"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RomanNumeralTest {
  @Rule public final TestName name = new TestName();

  @Test
  public void conversion_To_Int_Complex_1() {
    String data = "(XX+CMXCIX)/V";
    String expected = "(20+999)/5";
    String result = RomanNumeral.conversion_To_Int_Complex(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Int_Complex of '%s' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Complex_2() {
    String data = "(I+v+X+CM+XC+IX)/V";
    String expected = "(1+5+10+900+90+9)/5";
    String result = RomanNumeral.conversion_To_Int_Complex(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Int_Complex of '%s' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Complex_3() {
    String data = "(XX+CIMXCIX)/V";
    String expected = "(20+(#ERROR#))/5";
    String result = RomanNumeral.conversion_To_Int_Complex(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Int_Complex of '%s' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Complex_Array() {
    System.out.format("%s: conversion_To_Int_Complex\n", name.getMethodName());
    String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
    String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
    String[] result = RomanNumeral.conversion_To_Int_Complex(data);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Complex_List() {
    System.out.format("%s: conversion_To_Int_Complex\n", name.getMethodName());
    List<String> data = List.of("(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V");
    String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
    String[] result = RomanNumeral.conversion_To_Int_Complex(data);
    for (int i = 0; i < data.size(); i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Complex_Multiple_Input() {
    System.out.format("%s: conversion_To_Int_Complex\n", name.getMethodName());
    String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
    String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
    String[] result = RomanNumeral.conversion_To_Int_Complex(data[0], data[1], data[2]);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Complex_Output_Array() {
    System.out.format("%s: conversion_To_Int_Complex_Output\n", name.getMethodName());
    String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
    String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
    String[] result = RomanNumeral.conversion_To_Int_Complex_Output(data);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Complex_Output_List() {
    System.out.format("%s: conversion_To_Int_Complex_Output\n", name.getMethodName());
    List<String> data = List.of("(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V");
    String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
    String[] result = RomanNumeral.conversion_To_Int_Complex_Output(data);
    for (int i = 0; i < data.size(); i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Complex_Output_Multiple_Input() {
    System.out.format("%s: conversion_To_Int_Complex_Output\n", name.getMethodName());
    String[] data = {"(XX+CMXCIX)/V", "(I+v+X+CM+XC+IX)/V", "(XX+CIMXCIX)/V"};
    String[] expected = {"(20+999)/5", "(1+5+10+900+90+9)/5", "(20+(#ERROR#))/5"};
    String[] result = RomanNumeral.conversion_To_Int_Complex_Output(data[0], data[1], data[2]);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Complex_Output_1() {
    System.out.format("Test: %s\n", name.getMethodName());
    RomanNumeral.conversion_To_Int_Complex("(XX+CMXCIX)/V");
    System.out.format("\n");
  }

  @Test
  public void conversion_To_Int_Complex_Output_2() {
    System.out.format("Test: %s\n", name.getMethodName());
    RomanNumeral.conversion_To_Int_Complex("(I+v+X+CM+XC+IX)/V");
    System.out.format("\n");
  }

  @Test
  public void conversion_To_Int_Complex_Output_3() {
    System.out.format("Test: %s\n", name.getMethodName());
    RomanNumeral.conversion_To_Int_Complex("(XX+CIMXCIX)/V");
    System.out.format("\n");
  }

  @Test
  public void conversion_To_Int_CMXCIX() {
    String data = "CMXCIX";
    int expected = 999;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_i() {
    String data = "i";
    int expected = 1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_III() {
    String data = "iii";
    int expected = 3;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_IIII() {
    String data = "iiii";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_IIX() {
    String data = "IIX";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_IM() {
    String data = "IM";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_K() {
    String data = "K";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_McMlXIv() {
    String data = "McMlXIv";
    int expected = 1964;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_MCMLXIV() {
    String data = "MCMLXIV";
    int expected = 1964;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_mim() {
    String data = "mim";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_MMMCMXCIX() {
    String data = "MMMCMXCIX";
    int expected = 3999;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_XLIX() {
    String data = "XLIX";
    int expected = 49;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Output_MCMLXIV() {
    String data = "MCMLXIV";
    int expected = 1964;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Output_MIM() {
    String data = "MIM";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Array() {
    System.out.format("%s: conversion_To_Int\n", name.getMethodName());
    String[] data = {"MCMLXIV", "MIM"};
    int[] expected = {1964, -1};
    int[] result = RomanNumeral.conversion_To_Int(data);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_List() {
    System.out.format("%s: conversion_To_Int\n", name.getMethodName());
    List<String> data = List.of("MCMLXIV", "MIM");
    int[] expected = {1964, -1};
    int[] result = RomanNumeral.conversion_To_Int(data);
    for (int i = 0; i < data.size(); i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Multiple_Input() {
    System.out.format("%s: conversion_To_Int_Complex_Output\n", name.getMethodName());
    String[] data = {"MCMLXIV", "MIM"};
    int[] expected = {1964, -1};
    int[] result = RomanNumeral.conversion_To_Int(data[0], data[1]);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Output_1() {
    String data = "iiii";
    int expected = -1;
    int result = RomanNumeral.conversion_To_Int_Output(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Output_2() {
    String data = "iv";
    int expected = 4;
    int result = RomanNumeral.conversion_To_Int_Output(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Output_XLIX() {
    String data = "XLIX";
    int expected = 49;
    int result = RomanNumeral.conversion_To_Int_Output(data);
    assertEquals(expected, result);
    System.out.format("%s: conversion_To_Int of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Int_Output_Array() {
    System.out.format("%s: conversion_To_Int_Output\n", name.getMethodName());
    String[] data = {"MCMLXIV", "MIM"};
    int[] expected = {1964, -1};
    int[] result = RomanNumeral.conversion_To_Int_Output(data);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Output_List() {
    System.out.format("%s: conversion_To_Int_Output\n", name.getMethodName());
    List<String> data = List.of("MCMLXIV", "MIM");
    int[] expected = {1964, -1};
    int[] result = RomanNumeral.conversion_To_Int_Output(data);
    for (int i = 0; i < data.size(); i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data.get(i), result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Output_Multiple_Input() {
    System.out.format("%s: conversion_To_Int_Output_Complex_Output\n", name.getMethodName());
    String[] data = {"MCMLXIV", "MIM"};
    int[] expected = {1964, -1};
    int[] result = RomanNumeral.conversion_To_Int_Output(data[0], data[1]);
    for (int i = 0; i < data.length; i++) {
      assertEquals(expected[i], result[i]);
      System.out.format("\t'%s' converts to '%s'\n", data[i], result[i]);
    }
  }

  @Test
  public void conversion_To_Int_Log() {
    System.out.format("%s: conversion_To_Int_Log\n", name.getMethodName());
    String[] data = {"iiii", "IIX", "IM", "Cat", "i", "I", "Ix"};
    List<String> result = RomanNumeral.conversion_To_Int_Log(data);
    for (int i = 0; i < data.length; i++) {
      assertEquals(7, result.size());
      System.out.format("\t%s", result.get(i));
    }
  }

  @Test
  public void conversion_To_Numeral_0() {
    int data = 0;
    String expected = RomanNumeral.errorString;
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_4000() {
    int data = 4000;
    String expected = RomanNumeral.errorString;
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_1964() {
    int data = 1964;
    String expected = "MCMLXIV";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_20() {
    int data = 20;
    String expected = "XX";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_3() {
    int data = 3;
    String expected = "III";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_3999() {
    int data = 3999;
    String expected = "MMMCMXCIX";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_4() {
    int data = 4;
    String expected = "IV";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_5() {
    int data = 5;
    String expected = "V";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void conversion_To_Numeral_999() {
    int data = 999;
    String expected = "CMXCIX";
    String result = RomanNumeral.conversion_To_Numeral(data);
    assertEquals(expected, result);
    System.out.format(
        "%s: conversion_To_Numeral of '%d' is %s\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_I() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "I";
    int expected = 1;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_V() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "V";
    int expected = 5;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_X() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "X";
    int expected = 10;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_L() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "L";
    int expected = 50;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_C() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "C";
    int expected = 100;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_D() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "D";
    int expected = 500;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }

  @Test
  public void supported_Characters_M() throws NoSuchFieldException, IllegalAccessException {
    RomanNumeral e = new RomanNumeral();
    Field privateField = RomanNumeral.class.getDeclaredField("supportedCharacters");
    privateField.setAccessible(true);
    HashMap<String, Integer> supportedCharacters = (HashMap<String, Integer>) privateField.get(e);
    String data = "M";
    int expected = 1000;
    int result = supportedCharacters.get(data);
    assertEquals(expected, result);
    System.out.format("%s: Character Value of '%s' is %d\n", name.getMethodName(), data, result);
  }
}
