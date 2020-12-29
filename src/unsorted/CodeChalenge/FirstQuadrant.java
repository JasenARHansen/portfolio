package unsorted.CodeChalenge;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstQuadrant {
    private static final Map<String, Integer> supportedCharacters = new HashMap<>() {
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }
    };
    // Comparator to sort by value
    private static final Comparator<Entry<String, Integer>> valueComparator = (e1, e2) -> {
        Integer v1 = e1.getValue();
        Integer v2 = e2.getValue();
        return v2.compareTo(v1);
    };
    public static String errorString = "(#ERROR#)";

    public static int conversion_To_Int(String numeral) {
        // Convert a String representing a Roman Numeral into a Decimal
        // equivalent
        // Algorithm logic found at
        // https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
        // but this is my custom implementation.

        // If string contains invalid characters fail
        if (!validity_String(numeral)) {
            return -1;
        }

        // If string contains invalid Ordering fail
        if (!validity_Order(numeral)) {
            return -1;
        }

        // If string contains invalid repetition fail
        if (!validity_Repetition(numeral)) {
            return -1;
        }

        String localNumeral = numeral.toUpperCase();

        int currentValue = 0;

        for (int index = localNumeral.length() - 1; index >= 0; index--) {
            char testCharacter = localNumeral.charAt(index);
            int testValue = get_Character_Value(testCharacter);

            int testSubtraction = 0;
            if (index > 0) {
                testSubtraction = subtractive_Notation(localNumeral, index);
                if (testSubtraction != 0) {
                    index--;
                }
            }

            if (testSubtraction != 0) {
                currentValue += testValue - testSubtraction;
            } else {
                currentValue += testValue;
            }
        }

        return currentValue;
    }

    public static String conversion_To_Int_Complex(String complexNumeral) {
        // Convert valid Roman Numerals in string into Integer representations
        List<String> allMatches = new ArrayList<>();

        // RegEX definition
        String regex = "[CDILMVX]{1,}";

        String complexNumeralLocal = complexNumeral.toUpperCase();

        Matcher m = Pattern.compile(regex).matcher(complexNumeralLocal);
        while (m.find()) {
            allMatches.add(m.group());
        }

        for (String match : allMatches) {
            int conversion = conversion_To_Int(match);
            if (conversion == -1) {
                complexNumeralLocal = complexNumeralLocal.replaceFirst(Pattern.quote(match), errorString);
            } else {
                complexNumeralLocal = complexNumeralLocal.replaceFirst(Pattern.quote(match),
                        Integer.toString(conversion));
            }
        }
        return complexNumeralLocal;
    }

    private static void conversion_To_Int_Error_Log(String errorString) {
        if (!validity_String(errorString)) {
            System.out.format("The String '%s' contains invalid characters\n", errorString);
        }
        if (!validity_Order(errorString)) {
            System.out.format("The String '%s' contains characters in an invalid order\n", errorString);
        }
        if (!validity_Repetition(errorString)) {
            System.out.format("The String '%s' contains invalid repeating characters\n", errorString);
        }
    }

    public static void conversion_To_Int_Output(List<String> numerals) {
        conversion_To_Int_Output(numerals.toArray(new String[numerals.size()]));
    }

    public static void conversion_To_Int_Output(String... numeralStrings) {
        // Convert and display based on specification
        for (String numeralString : numeralStrings) {
            int localConversion = conversion_To_Int(numeralString);
            System.out.format("%s -> %d\n", numeralString, localConversion);
        }
    }

    public static void conversion_To_Int_Output_Complex(List<String> complexNumeralStrings) {
        conversion_To_Int_Output_Complex(complexNumeralStrings.toArray(new String[complexNumeralStrings.size()]));
    }

    public static void conversion_To_Int_Output_Complex(String... complexNumeralStrings) {
        // Convert valid Roman Numerals in string into Integer representations
        // and print output

        for (String complexNumeral : complexNumeralStrings) {
            String complexNumeralLocal = conversion_To_Int_Complex(complexNumeral);
            System.out.format("%s -> %s\n", complexNumeral, complexNumeralLocal);
        }
    }

    public static void conversion_To_Int_Output_With_Log(List<String> numerals) {
        conversion_To_Int_Output_With_Log(numerals.toArray(new String[numerals.size()]));
    }

    public static void conversion_To_Int_Output_With_Log(String... numeralStrings) {
        // Convert and display based on specification
        for (String numeralString : numeralStrings) {
            int localConversion = conversion_To_Int(numeralString);
            if (localConversion == -1) {
                conversion_To_Int_Error_Log(numeralString);
            }
            System.out.format("%s -> %d\n", numeralString, localConversion);
        }
    }

    public static String conversion_To_Numeral(int number) {
        // https://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/

        StringBuilder returnValue = new StringBuilder(errorString);
        if (validity_Value(number)) {
            returnValue = new StringBuilder();
            Set<Entry<String, Integer>> keySet = supportedCharacters.entrySet();
            List<Entry<String, Integer>> keySetList = new ArrayList<>(keySet);
            keySetList.sort(valueComparator);
            for (Entry<String, Integer> key : keySetList) {
                String numeral = key.getKey();
                Integer value = key.getValue();
                while (number >= value) {
                    returnValue.append(numeral);
                    number -= value;
                }

                String subtractiveCharacter = null;
                Integer subtractiveValue = 0;
                switch (numeral) {
                    case "M":
                        subtractiveCharacter = "C";
                        subtractiveValue = supportedCharacters.get(subtractiveCharacter);
                        break;
                    case "D":
                        subtractiveCharacter = "C";
                        subtractiveValue = supportedCharacters.get(subtractiveCharacter);
                        break;
                    case "C":
                        subtractiveCharacter = "X";
                        subtractiveValue = supportedCharacters.get(subtractiveCharacter);
                        break;
                    case "L":
                        subtractiveCharacter = "X";
                        subtractiveValue = supportedCharacters.get(subtractiveCharacter);
                        break;
                    case "X":
                        subtractiveCharacter = "I";
                        subtractiveValue = supportedCharacters.get(subtractiveCharacter);
                        break;
                    case "V":
                        subtractiveCharacter = "I";
                        subtractiveValue = supportedCharacters.get(subtractiveCharacter);
                        break;
                    default:
                }

                if (number >= (value - subtractiveValue)) {
                    returnValue.append(subtractiveCharacter).append(numeral);
                    number -= value;
                    number += subtractiveValue;
                }
            }
        }
        return returnValue.toString();
    }

    public static int get_Character_Value(char numeralCharacter) {
        // Test string to determine if all characters are in a valid order

        String localCharacter = Character.toString(numeralCharacter);
        return get_Character_Value(localCharacter);
    }

    public static int get_Character_Value(String numeralCharacter) {
        // Test string to determine if all characters are in a valid order

        String localString = numeralCharacter.toUpperCase();
        return supportedCharacters.getOrDefault(localString, -1);
    }

    public static int subtractive_Notation(String numeralString, int index) {
        // Test string to determine if subtractive notation applies

        // I placed before V or X indicates one less
        // X placed before L or C indicates ten less
        // C placed before D or M indicates a hundred less

        if ((index - 1) >= 0) {
            String localString = numeralString.toUpperCase();
            char atIndex = localString.charAt(index);
            char atPrecedingIndex = localString.charAt(index - 1);

            if (atPrecedingIndex == 'I' && atIndex == 'V') {
                return 1;
            } else if (atPrecedingIndex == 'I' && atIndex == 'X') {
                return 1;
            } else if (atPrecedingIndex == 'X' && atIndex == 'L') {
                return 10;
            } else if (atPrecedingIndex == 'X' && atIndex == 'C') {
                return 10;
            } else if (atPrecedingIndex == 'C' && atIndex == 'D') {
                return 100;
            } else if (atPrecedingIndex == 'C' && atIndex == 'M') {
                return 100;
            }

        }
        return 0;
    }

    public static Boolean validity_Character(char numeralCharacter) {
        // Test character to determine if it is supported
        String localCharacter = Character.toString(numeralCharacter);
        return validity_Character(localCharacter);

    }

    public static Boolean validity_Character(String numeralCharacter) {
        // Test character to determine if it is supported
        String localCharacter = numeralCharacter.toUpperCase();
        return supportedCharacters.containsKey(localCharacter);

    }

    public static Boolean validity_Order(String numeralString) {
        // Test string to determine if all characters are in a valid order

        String localString = numeralString.toUpperCase();
        int currentValue = 0;

        for (int index = localString.length() - 1; index >= 0; index--) {
            char testCharacter = localString.charAt(index);
            int testValue = get_Character_Value(testCharacter);
            if (testValue != -1) {
                if (index > 0) {
                    int testSubtraction = subtractive_Notation(numeralString, index);
                    if (testSubtraction != 0) {
                        index--;
                    }
                }

                if (testValue >= currentValue) {
                    currentValue = testValue;
                } else {
                    return false;
                }
            } else {
                // This is an error case that is handled elsewhere
                return true;
            }
        }

        return true;
    }

    public static Boolean validity_Repetition(String numeralString) {
        // Characters can not repeat more than 3 times

        String localString = numeralString.toUpperCase();

        Pattern pattern = Pattern.compile("^.*(.)\\1\\1\\1.*$");
        Matcher matcher = pattern.matcher(localString);
        return !matcher.find();
    }

    public static Boolean validity_String(String numeralString) {
        // Test string to determine if all characters are supported

        String localString = numeralString.toUpperCase();

        for (int i = 0; i < localString.length(); i++) {

            if (!validity_Character(localString.charAt(i)))
                return false;
        }

        return true;
    }

    public static Boolean validity_Value(int number) {
        // Test value to determine if it is supported
        return number >= 1 && number <= 3999;
    }
}
