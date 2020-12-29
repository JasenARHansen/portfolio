package unsorted.classesStatic;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class KataStatic {
    public static int multiple3_5(int number) {
        // If we list all the natural numbers below 10 that are multiples of 3
        // or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
        // Finish the solution so that it returns the sum of all the multiples
        // of 3 or 5 below the number passed in.
        // Note: If the number is a multiple of both 3 and 5, only count it
        // once.
        int returnValue = 0;
        for (int i = 1; i < number; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                returnValue += i;
            }
        }
        return returnValue;
    }

    public static int multiple3_5_2(int number) {
        return IntStream.range(0, number).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
    }

    public static int rowSumOddNumbers(int n) {
        //
        // Given the triangle of consecutive odd numbers:
        // 1
        // 3 5
        // 7 9 11
        // 13 15 17 19
        // 21 23 25 27 29
        // ...
        // Calculate the row sums of this triangle from the row index (starting
        // at index 1) e.g.:
        // rowSumOddNumbers(1); // 1
        // rowSumOddNumbers(2); // 3 + 5 = 8
        // The nth odd number: Xn = 2n - 1
        // To find the leftmost number in a triangle of consecutive standard
        // numbers:
        // n(n-1)/2 +1
        // To find the starting point of the nth row = (n)(n-1) + 1
        // Triangle count = n(n+1)/2
        // (n(n+1)/2)^2 - ((n-1)(n)/2)^2
        // int larger = Math.pow((n*(n+1)/2), 2);
        // int smaller = Math.pow(((n-1)*n/2), 2);
        return (int) (Math.pow((n * (n + 1) / 2), 2) - Math.pow(((n - 1) * n / 2), 2));
        // Optimal
        // return (int) (Math.pow(n, 3);
    }

    public static int rowSumOddNumbers2(int n) {
        return (int) Math.pow(n, 3);
    }

    public static boolean isSquare(int n) {
        return Math.pow((int) Math.sqrt(n), 2) == n;
    }

    public static boolean isSquare2(int n) {
        return Math.sqrt(n) % 1 == 0;
    }

    public static String HighAndLow(String numbers) {
        String[] numbersString = numbers.split(" ");
        int[] numbersInt = new int[numbersString.length];
        for (int i = 0; i < numbersInt.length; i++) {
            numbersInt[i] = Integer.parseInt(numbersString[i]);
        }
        Arrays.sort(numbersInt);
        return numbersInt[numbersInt.length - 1] + " " + numbersInt[0];
    }

    public static String HighAndLow2(String numbers) {
        IntSummaryStatistics numbersInt = Arrays.stream(numbers.split("\\s")).mapToInt(Integer::parseInt)
                .summaryStatistics();
        return String.format("%d %d", numbersInt.getMax(), numbersInt.getMin());
    }

    public static String reverseString(String str) {
        StringBuilder returnString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            returnString.append(str.charAt(i));
        }
        return returnString.toString();
    }

    public static String reverseString2(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int sortDesc(final int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(new StringBuilder(String.valueOf(digits)).reverse().toString());
    }

    public static long findNb(long m) {
        // https://brilliant.org/wiki/sum-of-n-n2-or-n3/
        // (n^2(n+1)^2)/4
        BigInteger source = BigInteger.valueOf(m);
        int n = 1;
        while (true) {
            BigInteger value = BigInteger.valueOf((n * n) * ((n + 1) * (n + 1)) / 4);
            switch (value.compareTo(source)) {
                case -1: // Less than
                    n++;
                    break;
                case 0: // Equal to
                    return n;
                case 1: // Greater than
                    return -1;
            }
        }
    }

    public static boolean compArray(int[] a, int[] b) {
        if ((a == null) || (b == null)) {
            return false;
        }
        int[] aWithOutDuplicates = Arrays.stream(a).distinct().toArray();
        int[] bWithOutDuplicates = Arrays.stream(b).distinct().toArray();
        for (int i = 0; i < aWithOutDuplicates.length; i++) {
            final int test = i;
            if (IntStream.of(bWithOutDuplicates).noneMatch(x -> x == Math.pow(aWithOutDuplicates[test], 2))) {
                return false;
            }
        }
        return true;
    }

    public static long findNextSquare(long sq) {
        double local = Math.sqrt(sq);
        if (local % 1 != 0) {
            return -1;
        } else {
            return (long) Math.pow((local + 1), 2);
        }
    }

    public static int digital_root(int n) {
        // A digital root is the recursive sum of all the digits in a number.
        // Given n, take the sum of the digits of n. If that value has two
        // digits, continue reducing in this way until a single-digit number is
        // produced. This is only applicable to the natural numbers.
        int[] digits = Integer.toString(n).chars().map(c -> c -= '0').toArray();
        int sum = IntStream.of(digits).sum();
        if (sum > 10) {
            return digital_root(sum);
        } else {
            return sum;
        }
    }

    public static String orderWeight(String strng) {
        // Comparator to sort by path depth
        Comparator<Entry<String, Integer>> weightComparator = (e1, e2) -> {
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            if (v1.equals(v2)) {
                String k1 = e1.getKey();
                String k2 = e2.getKey();
                return k1.compareTo(k2);
            } else {
                return v1.compareTo(v2);
            }
        };
        // Object to hold weights to values
        Map<String, Integer> weightMap = new LinkedHashMap<>();
        List<String> numbersString = new ArrayList<>(Arrays.asList(strng.split(" ")));
        for (String val : numbersString) {
            int[] digits = val.chars().map(Character::getNumericValue).toArray();
            int sum = IntStream.of(digits).sum();
            weightMap.put(val, sum);
        }
        Set<Entry<String, Integer>> keySet = weightMap.entrySet();
        List<Entry<String, Integer>> weightList = new ArrayList<>(keySet);
        weightList.sort(weightComparator);
        StringBuilder returnString = new StringBuilder();
        for (Entry<String, Integer> key : weightList) {
            String t1 = key.getKey();
            for (int i = 0; i < Collections.frequency(numbersString, t1); i++) {
                returnString.append(t1).append(" ");
            }
        }
        return returnString.toString().trim();
    }

    public static String orderWeight2(String strng) {
        String[] split = strng.split(" ");
        Arrays.sort(split, (a, b) -> {
            int aWeight = a.chars().map(Character::getNumericValue).sum();
            int bWeight = b.chars().map(Character::getNumericValue).sum();
            return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
        });
        return String.join(" ", split);
    }

    public static String[] inArray(String[] array1, String[] array2) {
        // Given two arrays of strings a1 and a2 return a sorted array r in
        // lexicographical order of the strings of a1 which are substrings of
        // strings of a2.
        List<String> returnArray = new ArrayList<>();
        for (String entry1 : array1) {
            for (String entry2 : array2) {
                if (entry2.contains(entry1)) {
                    returnArray.add(entry1);
                    break;
                }
            }
        }
        Collections.sort(returnArray);
        return returnArray.toArray(new String[0]);
    }

    public static String[] inArray2(String[] array1, String[] array2) {
        return Arrays.stream(array1).filter(str -> Arrays.stream(array2).anyMatch(s -> s.contains(str))).distinct().sorted().toArray(String[]::new);
    }


    public static int[] count_find_num(int[] primesL, int limit) {
        // Result Sets
        List<ArrayList<Integer>> resultSets = new ArrayList<>();
        // Setup stacks
        Stack<Integer> factors = new Stack<>();
        Stack<Integer> values = new Stack<>();
        for (int value : primesL) {
            factors.push(value);
            if (values.isEmpty()) {
                values.push(value);
            } else {
                values.push(value * values.peek());
            }
        }
        List<Integer> returnArray = new ArrayList<>();
        int max;
        if (values.peek() <= limit) {
            // Initial result set
            resultSets.add(new ArrayList<>(factors));
            max = values.peek();

            // Determine all permutations

            // Set up return list
            returnArray.add(resultSets.size());
            returnArray.add(max);

        }

        //list = new ArrayList(stack);

        return returnArray.stream().mapToInt(i -> i).toArray();
    }

}
