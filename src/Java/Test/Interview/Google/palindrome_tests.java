package Test.Java.Interview.Google;


import Java.Code.Interview.Google.palindrome;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class palindrome_tests {

	@Rule
	public TestName name = new TestName();

	public void print_palindrome(String name, String value, boolean result) {
		System.out.printf("%s: %s is a palindrome: %b\n", name, value, result);
	}

	public void print_palindrome(String name, String value, String result) {
		System.out.printf("%s: %s became the palindrome: %s\n", name, value, result);
	}

	public void print_transform(String name, String value, String transform) {
		System.out.printf("%s: %s applied the transform: %s\n", name, value, transform);
	}

	@Test
	public void detect_false() {
		String source = "cat";
		boolean result = palindrome.detect(source);
		print_palindrome(name.getMethodName(), source, result);
		Assert.assertFalse(result);
	}

	@Test
	public void detect_true() {
		String source = "Anna";
		boolean result = palindrome.detect(source);
		print_palindrome(name.getMethodName(), source, result);
		Assert.assertTrue(result);
	}

	@Test
	public void convert_palindrome_even() {
		String source = "Ann";
		Map.Entry<String, String> transformed = palindrome.transform(source);
		String value = palindrome.convert(transformed);
		String transform = palindrome.report(transformed);
		print_palindrome(name.getMethodName(), source, value);
		print_transform(name.getMethodName(), source, transform);
	}

	@Test
	public void convert_palindrome_odd() {
		String source = "Lvel";
		Map.Entry<String, String> transformed = palindrome.transform(source);
		String value = palindrome.convert(transformed);
		String transform = palindrome.report(transformed);
		print_palindrome(name.getMethodName(), source, value);
		print_transform(name.getMethodName(), source, transform);
	}

	@Test
	public void convert_non_palindrome() {
		String source = "Racear";
		Map.Entry<String, String> transformed = palindrome.transform(source);
		String value = palindrome.convert(transformed);
		String transform = palindrome.report(transformed);
		print_palindrome(name.getMethodName(), source, value);
		print_transform(name.getMethodName(), source, transform);
	}

}
