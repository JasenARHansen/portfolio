package Java.test.challenge;

import Java.code.challenge.Primes;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings("ConstantValue")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PrimeTest {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Primes.getDescription();
    }

    @Test
    public void getNPrimes_0() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        List<Integer> result = Primes.getNPrimes(expected);
        assertEquals(expected, result.size());
        System.out.format("\tThe first %d prime numbers are %s\n", expected, result);
    }

    @Test
    public void getNPrimes_1() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        List<Integer> result = Primes.getNPrimes(expected);
        assertEquals(expected, result.size());
        System.out.format("\tThe first %d prime numbers are %s\n", expected, result);
    }

    @Test
    public void getNPrimes_18() {
        int expected = 18;
        printTestHeader(name.getMethodName());
        List<Integer> result = Primes.getNPrimes(expected);
        assertEquals(expected, result.size());
        System.out.format("\tThe first %d prime numbers are %s\n", expected, result);
    }

    @Test
    public void getNPrimes_2() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        List<Integer> result = Primes.getNPrimes(expected);
        assertEquals(expected, result.size());
        System.out.format("\tThe first %d prime numbers are %s\n", expected, result);
    }

    @Test
    public void getNPrimes_3() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        List<Integer> result = Primes.getNPrimes(expected);
        assertEquals(expected, result.size());
        System.out.format("\tThe first %d prime numbers are %s\n", expected, result);
    }

    @Test
    public void getNPrimes_4() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        List<Integer> result = Primes.getNPrimes(expected);
        assertEquals(expected, result.size());
        System.out.format("\tThe first %d prime numbers are %s\n", expected, result);
    }

    @Test
    public void getNextPrime_89() {
        int expected = 97;
        printTestHeader(name.getMethodName());
        int count = 89;
        int result = Primes.getNextPrime(count);
        assertEquals(expected, result);
        System.out.format("\tThe next prime after %d is %d\n", count, result);
    }

    @Test
    public void getNextPrime_96() {
        int expected = 97;
        printTestHeader(name.getMethodName());
        int count = 96;
        int result = Primes.getNextPrime(count);
        assertEquals(expected, result);
        System.out.format("\tThe next prime after %d is %d\n", count, result);
    }

    @Test
    public void getNextPrime_97() {
        int expected = 101;
        printTestHeader(name.getMethodName());
        int count = 97;
        int result = Primes.getNextPrime(count);
        assertEquals(expected, result);
        System.out.format("\tThe next prime after %d is %d\n", count, result);
    }

    @Test
    public void getPrimesLessThanN_100() {
        printTestHeader(name.getMethodName());
        int expected = 25;
        int count = 100;
        List<Integer> result = Primes.getPrimesLessThanN(count);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime numbers less than %d are %s\n", count, result);
    }

    @Test
    public void getPrimesLessThanN_97() {
        int expected = 24;
        printTestHeader(name.getMethodName());
        int count = 97;
        List<Integer> result = Primes.getPrimesLessThanN(count);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime numbers less than %d are %s\n", count, result);
    }

    @Test
    public void greatestCommonFactor_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int left = 4;
        int right = 6;
        int result = Primes.greatestCommonFactor(left, right);
        assertEquals(expected, result);
        System.out.format("\tThe greatest common factor of %d and %d is %d\n", left, right, result);
    }

    @Test
    public void greatestCommonFactor_2() {
        int expected = 220;
        printTestHeader(name.getMethodName());
        int left = 123200;
        int right = 7260;
        int result = Primes.greatestCommonFactor(left, right);
        assertEquals(expected, result);
        System.out.format("\tThe greatest common factor of %d and %d is %d\n", left, right, result);
    }

    @Test
    public void greatestCommonFactor_3() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int left = 5;
        int right = 7;
        int result = Primes.greatestCommonFactor(left, right);
        assertEquals(expected, result);
        System.out.format("\tThe greatest common factor of %d and %d is %d\n", left, right, result);
    }

    @Test
    public void isPrime_0() {
        printTestHeader(name.getMethodName());
        int value = 0;
        boolean result = Primes.isPrime(value);
        assertFalse(result);
        System.out.format("\tThe number %d is prime: %b\n", value, result);
    }

    @Test
    public void isPrime_1() {
        printTestHeader(name.getMethodName());
        int value = 1;
        boolean result = Primes.isPrime(value);
        assertFalse(result);
        System.out.format("\tThe number %d is prime: %b\n", value, result);
    }

    @Test
    public void isPrime_2() {
        printTestHeader(name.getMethodName());
        int value = 2;
        boolean result = Primes.isPrime(value);
        assertTrue(result);
        System.out.format("\tThe number %d is prime: %b\n", value, result);
    }

    @Test
    public void isPrime_4() {
        printTestHeader(name.getMethodName());
        int value = 4;
        boolean result = Primes.isPrime(value);
        assertFalse(result);
        System.out.format("\tThe number %d is prime: %b\n", value, result);
    }

    @Test
    public void leastCommonMultiple_1() {
        int expected = 35;
        printTestHeader(name.getMethodName());
        int left = 5;
        int right = 7;
        int result = Primes.leastCommonMultiple(left, right);
        assertEquals(expected, result);
        System.out.format("\tThe least common multiple of %d and %d is %d\n", left, right, result);
    }

    @Test
    public void leastCommonMultiple_2() {
        int expected = 36;
        printTestHeader(name.getMethodName());
        int left = 9;
        int right = 12;
        int result = Primes.leastCommonMultiple(left, right);
        assertEquals(expected, result);
        System.out.format("\tThe least common multiple of %d and %d is %d\n", left, right, result);
    }

    @Test
    public void primeFactorization_0() {
        String expected = "";
        printTestHeader(name.getMethodName());
        int value = 0;
        String result = Primes.primeFactorization(value);
        assertEquals(expected, result);
        System.out.format("\tThe prime factorization of %d is %s\n", value, result);
    }

    @Test
    public void primeFactorization_1() {
        String expected = "";
        printTestHeader(name.getMethodName());
        int value = 1;
        String result = Primes.primeFactorization(value);
        assertEquals(expected, result);
        System.out.format("\tThe prime factorization of %d is %s\n", value, result);
    }

    @Test
    public void primeFactorization_123200() {
        String expected = "2^6*5^2*7^1*11^1";
        printTestHeader(name.getMethodName());
        int value = 123200;
        String result = Primes.primeFactorization(value);
        assertEquals(expected, result);
        System.out.format("\tThe prime factorization of %d is %s\n", value, result);
    }

    @Test
    public void primeFactorization_18() {
        String expected = "2^1*3^2";
        printTestHeader(name.getMethodName());
        int value = 18;
        String result = Primes.primeFactorization(value);
        assertEquals(expected, result);
        System.out.format("\tThe prime factorization of %d is %s\n", value, result);
    }

    @Test
    public void primeFactorization_negative_18() {
        String expected = "-1^1*2^1*3^2";
        printTestHeader(name.getMethodName());
        int value = -18;
        String result = Primes.primeFactorization(value);
        assertEquals(expected, result);
        System.out.format("\tThe prime factorization of %d is %s\n", value, result);
    }

    @Test
    public void primeFactors_0() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int value = 0;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }

    @Test
    public void primeFactors_1() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int value = 1;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }

    @Test
    public void primeFactors_18() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int value = 18;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }

    @Test
    public void primeFactors_533() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int value = 533;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }

    @Test
    public void primeFactors_55() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int value = 55;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }

    @Test
    public void primeFactors_97() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int value = 97;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }

    @Test
    public void primeFactors_negative_18() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int value = -18;
        List<Integer> result = Primes.primeFactors(value);
        assertEquals(expected, result.size());
        System.out.format("\tThe prime factors of %d are %s\n", value, result);
    }
}
