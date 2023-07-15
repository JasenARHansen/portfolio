package Java.code.challenge;

import java.util.*;

@SuppressWarnings("DuplicatedCode")
public class Primes {

    public static void getDescription() {
        System.out.println(
                """
                        A natural number (1, 2, 3, 4, 5, 6, etc.) is called a prime number (or a prime)
                         if it is greater than 1 and cannot be written as the product of two smaller
                         natural numbers.
                        The first 25 prime numbers (all the prime numbers less than 100) are:
                         2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97"""
                        .indent(2));
    }

    public static List<Integer> getNPrimes(int primes) {
        List<Integer> primeList = new ArrayList<>();
        if (primes == 0) {
            return primeList;
        }
        int currentNumber = 2;
        boolean prime;
        while (primeList.size() < primes) {
            prime = true;
            for (int number : primeList) {
                if (currentNumber % number == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeList.add(currentNumber);
            }
            currentNumber++;
        }
        return primeList;
    }

    public static int getNextPrime(int value) {
        List<Integer> primeList = getPrimesLessThanN(value + 1);
        int currentPrimes = primeList.size();
        int currentNumber = primeList.get(currentPrimes - 1) + 1;
        boolean prime;
        while (primeList.size() < currentPrimes + 1) {
            prime = true;
            for (int number : primeList) {
                if (currentNumber % number == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeList.add(currentNumber);
            }
            currentNumber++;
        }
        return currentNumber - 1;
    }

    public static List<Integer> getPrimesLessThanN(int value) {
        List<Integer> primeList = new ArrayList<>();
        if (value < 2) {
            return primeList;
        }
        int currentNumber = 2;
        boolean prime;
        while (currentNumber < value) {
            prime = true;
            for (int number : primeList) {
                if (currentNumber % number == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeList.add(currentNumber);
            }
            currentNumber++;
        }
        return primeList;
    }

    public static int greatestCommonFactor(int left, int right) {
        int returnValue = 1;
        List<Integer> factorsLeft = primeFactors(left);
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (Integer factor : factorsLeft) {
            if (leftMap.containsKey(factor)) {
                leftMap.put(factor, leftMap.get(factor) + 1);
            } else {
                leftMap.put(factor, 1);
            }
        }
        List<Integer> factorsRight = primeFactors(right);
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (Integer factor : factorsRight) {
            if (rightMap.containsKey(factor)) {
                rightMap.put(factor, rightMap.get(factor) + 1);
            } else {
                rightMap.put(factor, 1);
            }
        }
        Set<Integer> keys = new HashSet<>();
        keys.addAll(leftMap.keySet());
        keys.addAll(rightMap.keySet());
        for (Integer key : keys) {
            int leftCount = leftMap.getOrDefault(key, 0);
            int rightCount = rightMap.getOrDefault(key, 0);
            returnValue = (int) (returnValue * Math.pow(key, Math.min(leftCount, rightCount)));
        }
        return returnValue;
    }

    public static boolean isPrime(int value) {
        List<Integer> factors = primeFactors(value);
        return factors.size() == 1;
    }

    public static int leastCommonMultiple(int left, int right) {
        int returnValue = 1;
        List<Integer> factorsLeft = primeFactors(left);
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (Integer factor : factorsLeft) {
            if (leftMap.containsKey(factor)) {
                leftMap.put(factor, leftMap.get(factor) + 1);
            } else {
                leftMap.put(factor, 1);
            }
        }
        List<Integer> factorsRight = primeFactors(right);
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (Integer factor : factorsRight) {
            if (rightMap.containsKey(factor)) {
                rightMap.put(factor, rightMap.get(factor) + 1);
            } else {
                rightMap.put(factor, 1);
            }
        }
        Set<Integer> keys = new HashSet<>();
        keys.addAll(leftMap.keySet());
        keys.addAll(rightMap.keySet());
        for (Integer key : keys) {
            int leftCount = leftMap.getOrDefault(key, 0);
            int rightCount = rightMap.getOrDefault(key, 0);
            returnValue = (int) (returnValue * Math.pow(key, Math.max(leftCount, rightCount)));
        }
        return returnValue;
    }

    public static String primeFactorization(int value) {
        StringBuilder returnString = new StringBuilder();
        List<Integer> factors = primeFactors(value);
        int factorCurrent = -2;
        int factorCount = 0;
        for (Integer factor : factors) {
            if (factorCurrent == factor) {
                factorCount++;
            } else {
                if (factorCount > 0) {
                    if (returnString.length() != 0) {
                        returnString.append("*");
                    }
                    returnString.append(factorCurrent).append("^").append(factorCount);
                }
                factorCurrent = factor;
                factorCount = 1;
            }
        }
        if ((factorCount > 0)) {
            if (returnString.length() != 0) {
                returnString.append("*");
            }
            returnString.append(factorCurrent).append("^").append(factorCount);
        }
        return returnString.toString();
    }

    public static List<Integer> primeFactors(int value) {
        List<Integer> factorList = new ArrayList<>();
        if (value < 0) {
            factorList.add(-1);
            value *= -1;
        }
        int currentIndex = 2;
        int maxIndex = (int) Math.sqrt(value);
        while ((currentIndex <= maxIndex) && (value != 1)) {
            if (value % currentIndex == 0) {
                factorList.add(currentIndex);
                value /= currentIndex;
                maxIndex = (int) Math.sqrt(value);
            } else {
                currentIndex++;
            }
        }
        if (value > 1) {
            factorList.add(value);
        }
        return factorList;
    }
}
