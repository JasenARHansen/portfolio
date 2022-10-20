package Test.Java.Challenge;

import Code.Java.Challenge.Primes;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrimeTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void Primes() {
        System.out.format("%s: ", name.getMethodName());
        Primes.getDescription();
    }

    @Test
    public void getNPrimes_0() {
        int count = 0;
        List<Integer> result = Primes.getNPrimes(count);
        System.out.format("%s: The first %d prime numbers are %s\n", name.getMethodName(), count, result);
        assertEquals(count, result.size());
    }

    @Test
    public void getNPrimes_1() {
        int count = 1;
        int lastExpected = 2;
        List<Integer> result = Primes.getNPrimes(count);
        System.out.format("%s: The first %d prime numbers are %s\n", name.getMethodName(), count, result);
        assertEquals(count, result.size());
        int lastExpectedFound = result.get(count - 1);
        assertEquals(lastExpected, lastExpectedFound);
    }

    @Test
    public void getNPrimes_2() {
        int count = 2;
        int lastExpected = 3;
        List<Integer> result = Primes.getNPrimes(count);
        System.out.format("%s: The first %d prime numbers are %s\n", name.getMethodName(), count, result);
        assertEquals(count, result.size());
        int lastExpectedFound = result.get(count - 1);
        assertEquals(lastExpected, lastExpectedFound);
    }

    @Test
    public void getNPrimes_3() {
        int count = 3;
        int lastExpected = 5;
        List<Integer> result = Primes.getNPrimes(count);
        System.out.format("%s: The first %d prime numbers are %s\n", name.getMethodName(), count, result);
        assertEquals(count, result.size());
        int lastExpectedFound = result.get(count - 1);
        assertEquals(lastExpected, lastExpectedFound);
    }

    @Test
    public void getNPrimes_4() {
        int count = 4;
        int lastExpected = 7;
        List<Integer> result = Primes.getNPrimes(count);
        System.out.format("%s: The first %d prime numbers are %s\n", name.getMethodName(), count, result);
        assertEquals(count, result.size());
        int lastExpectedFound = result.get(count - 1);
        assertEquals(lastExpected, lastExpectedFound);
    }

    @Test
    public void getNPrimes_18() {
        int count = 18;
        int lastExpected = 61;
        List<Integer> result = Primes.getNPrimes(count);
        System.out.format("%s: The first %d prime numbers are %s\n", name.getMethodName(), count, result);
        assertEquals(count, result.size());
        int lastExpectedFound = result.get(count - 1);
        assertEquals(lastExpected, lastExpectedFound);
    }

    @Test
    public void getPrimesLessThanN_100() {
        int count = 100;
        int expected = 25;
        List<Integer> result = Primes.getPrimesLessThanN(count);
        System.out.format("%s: The prime numbers less than %d are %s\n", name.getMethodName(), count, result);
        assertEquals(expected, result.size());
    }

    @Test
    public void getPrimesLessThanN_97() {
        int count = 97;
        int expected = 24;
        List<Integer> result = Primes.getPrimesLessThanN(count);
        System.out.format("%s: The prime numbers less than %d are %s\n", name.getMethodName(), count, result);
        assertEquals(expected, result.size());
    }

    @Test
    public void getNextPrime_89() {
        int count = 89;
        int expected = 97;
        int result = Primes.getNextPrime(count);
        System.out.format("%s: The next prime after %d is %d\n", name.getMethodName(), count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getNextPrime_96() {
        int count = 96;
        int expected = 97;
        int result = Primes.getNextPrime(count);
        System.out.format("%s: The next prime after %d is %d\n", name.getMethodName(), count, result);
        assertEquals(expected, result);
    }

    @Test
    public void getNextPrime_97() {
        int count = 97;
        int expected = 101;
        int result = Primes.getNextPrime(count);
        System.out.format("%s: The next prime after %d is %d\n", name.getMethodName(), count, result);
        assertEquals(expected, result);
    }

    @Test
    public void primeFactors_0() {
        int value = 0;
        int countExpected = 0;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactors_1() {
        int value = 1;
        int countExpected = 0;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactors_18() {
        int value = 18;
        int countExpected = 3;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactors_negative_18() {
        int value = -18;
        int countExpected = 4;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactors_55() {
        int value = 55;
        int countExpected = 2;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactors_97() {
        int value = 97;
        int countExpected = 1;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactors_533() {
        int value = 533;
        int countExpected = 2;
        List<Integer> result = Primes.primeFactors(value);
        System.out.format("%s: The prime factors of %d are %s\n", name.getMethodName(), value, result);
        assertEquals(countExpected, result.size());
    }

    @Test
    public void primeFactorization_0() {
        int value = 0;
        String expected = "";
        String result = Primes.primeFactorization(value);
        System.out.format("%s: The prime factorization of %d is %s\n", name.getMethodName(), value, result);
        assertEquals(expected, result);
    }

    @Test
    public void primeFactorization_1() {
        int value = 1;
        String expected = "";
        String result = Primes.primeFactorization(value);
        System.out.format("%s: The prime factorization of %d is %s\n", name.getMethodName(), value, result);
        assertEquals(expected, result);
    }

    @Test
    public void primeFactorization_123200() {
        int value = 123200;
        String expected = "2^6*5^2*7^1*11^1";
        String result = Primes.primeFactorization(value);
        System.out.format("%s: The prime factorization of %d is %s\n", name.getMethodName(), value, result);
        assertEquals(expected, result);
    }

    @Test
    public void primeFactorization_18() {
        int value = 18;
        String expected = "2^1*3^2";
        String result = Primes.primeFactorization(value);
        System.out.format("%s: The prime factorization of %d is %s\n", name.getMethodName(), value, result);
        assertEquals(expected, result);
    }

    @Test
    public void primeFactorization_negative_18() {
        int value = -18;
        String expected = "-1^1*2^1*3^2";
        String result = Primes.primeFactorization(value);
        System.out.format("%s: The prime factorization of %d is %s\n", name.getMethodName(), value, result);
        assertEquals(expected, result);
    }

    @Test
    public void isPrime_0() {
        int value = 0;
        boolean result = Primes.isPrime(value);
        System.out.format("%s: The number %d is prime: %b\n", name.getMethodName(), value, result);
        assertFalse(result);
    }

    @Test
    public void isPrime_1() {
        int value = 1;
        boolean result = Primes.isPrime(value);
        System.out.format("%s: The number %d is prime: %b\n", name.getMethodName(), value, result);
        assertFalse(result);
    }

    @Test
    public void isPrime_2() {
        int value = 2;
        boolean result = Primes.isPrime(value);
        System.out.format("%s: The number %d is prime: %b\n", name.getMethodName(), value, result);
        assertTrue(result);
    }

    @Test
    public void isPrime_4() {
        int value = 4;
        boolean result = Primes.isPrime(value);
        System.out.format("%s: The number %d is prime: %b\n", name.getMethodName(), value, result);
        assertFalse(result);
    }

    @Test
    public void greatestCommonFactor_1() {
        int left = 4;
        int right = 6;
        int expected = 2;
        int result = Primes.greatestCommonFactor(left, right);
        System.out.format("%s: The greatest common factor of %d and %d is %d\n", name.getMethodName(), left, right, result);
        assertEquals(expected, result);
    }

    @Test
    public void greatestCommonFactor_2() {
        int left = 123200;
        int right = 7260;
        int expected = 220;
        // 2^6*5^2*7^1*11^1";
        // 2*2*5*11
        int result = Primes.greatestCommonFactor(left, right);
        System.out.format("%s: The greatest common factor of %d and %d is %d\n", name.getMethodName(), left, right, result);
        assertEquals(expected, result);
    }

    @Test
    public void greatestCommonFactor_3() {
        int left = 5;
        int right = 7;
        int expected = 1;
        int result = Primes.greatestCommonFactor(left, right);
        System.out.format("%s: The greatest common factor of %d and %d is %d\n", name.getMethodName(), left, right, result);
        assertEquals(expected, result);
    }

    @Test
    public void leastCommonMultiple_1() {
        int left = 5;
        int right = 7;
        int expected = 35;
        int result = Primes.leastCommonMultiple(left, right);
        System.out.format("%s: The least common multiple of %d and %d is %d\n", name.getMethodName(), left, right, result);
        assertEquals(expected, result);
    }

    @Test
    public void leastCommonMultiple_2() {
        int left = 9;
        int right = 12;
        int expected = 36;
        // 2^6*5^2*7^1*11^1";
        // 2*2*5*11
        int result = Primes.leastCommonMultiple(left, right);
        System.out.format("%s: The least common multiple of %d and %d is %d\n", name.getMethodName(), left, right, result);
        assertEquals(expected, result);
    }
}
