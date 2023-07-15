package Java.code.unsorted.classes;

import Java.code.unsorted.classes.classesInstance.Car;
import Java.code.unsorted.interfaces.GreetingService;
import Java.code.unsorted.interfaces.MathOperation;
import Java.code.unsorted.interfaces.Vehicle;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings({
        "SameParameterValue",
        "DataFlowIssue",
        "SpellCheckingInspection",
        "ConstantValue",
        "DuplicatedCode",
        "OptionalGetWithoutIsPresent",
        "OptionalUsedAsFieldOrParameterType"
})
public class Java8Tester {
    public static void main(String[] args) {
        // https://www.tutorialspoint.com/java8/index.htm
        section1();
        section2();
        section3();
        section4();
        section5();
        section6();
        section7();
        section8();
        section9();
        section10();
        section11();
    }

    private static void section1() {
        System.out.println("Section 1:");
        List<String> names1 = new ArrayList<>();
        names1.add("Mahesh ");
        names1.add("Suresh ");
        names1.add("Ramesh ");
        names1.add("Naresh ");
        names1.add("Kalpesh ");
        List<String> names2 = new ArrayList<>();
        names2.add("Mahesh ");
        names2.add("Suresh ");
        names2.add("Ramesh ");
        names2.add("Naresh ");
        names2.add("Kalpesh ");
        Java8Tester tester = new Java8Tester();
        System.out.println("Sort using Java 7 syntax: ");
        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("Sort using Java 8 syntax: ");
        tester.sortUsingJava8(names2);
        System.out.println(names2);
    }

    private static void section2() {
        System.out.println("\nSection 2:");
        // with type declaration
        MathOperation addition = Integer::sum;
        // without type declaration
        MathOperation subtraction = (a, b) -> a - b;
        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> a * b;
        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("10 + 5 = " + MathOperation.operate(10, 5, addition));
        System.out.println("10 - 5 = " + MathOperation.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + MathOperation.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + MathOperation.operate(10, 5, division));
    }

    private static void section3() {
        System.out.println("\nSection 3:");
        // without parenthesis
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        // with parenthesis
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
        GreetingService greetService3 =
                message -> System.out.println(GreetingService.salutation + message);
        greetService3.sayMessage("Mahesh");
    }

    private static void section4() {
        System.out.println("\nSection 4:");
        List<String> names = new ArrayList<>();
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");
        names.forEach(System.out::println);
        System.out.println("\nSection 4:");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interfacef
        // test method will always return true no matter what value n has.
        System.out.println("Print all numbers:");
        // pass n as parameter
        eval(list, n -> true);
        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero
        System.out.println("Print even numbers:");
        eval(list, n -> n % 2 == 0);
        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.
        System.out.println("Print numbers greater than 3:");
        eval(list, n -> n > 3);
    }

    private static void section5() {
        System.out.println("\nSection 5:");
        Vehicle vehicle = new Car();
        vehicle.print();
    }

    private static void section6() {
        System.out.println("\nSection 6:");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered =
                strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("strings:" + strings);
        System.out.println("filtered:" + filtered);
        Random random = new Random();
        System.out.println("random:");
        random.ints().limit(10).forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // get list of unique squares
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().toList();
        System.out.println("squaresList:" + squaresList);
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // get count of empty string
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println("count:" + count);
        System.out.println("random:");
        random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        System.out.println("random:");
        random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // get count of empty string
        count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("count:" + count);
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        String mergedString =
                strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
        numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

    private static void section7() {
        System.out.println("\nSection 7:");
        List<String> strings;
        List<String> filtered;
        Random random;
        List<Integer> numbers;
        List<Integer> squaresList;
        long count;
        String mergedString;
        IntSummaryStatistics stats;
        System.out.println("Using Java 7: ");
        // Count empty strings
        strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("List: " + strings);
        count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty Strings: " + count);
        count = getCountLengthUsingJava7(strings);
        System.out.println("Strings of length 3: " + count);
        // Eliminate empty string
        filtered = deleteEmptyStringsUsingJava7(strings);
        System.out.println("Filtered List: " + filtered);
        // Eliminate empty string and join using comma.
        mergedString = getMergedStringUsingJava7(strings, ", ");
        System.out.println("Merged String: " + mergedString);
        numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // get list of square of distinct numbers
        squaresList = getSquares(numbers);
        System.out.println("Squares List: " + squaresList);
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        System.out.println("List: " + integers);
        System.out.println("Highest number in List : " + getMax(integers));
        System.out.println("Lowest number in List : " + getMin(integers));
        System.out.println("Sum of all numbers : " + getSum(integers));
        System.out.println("Average of all numbers : " + getAverage(integers));
        System.out.println("Random Numbers: ");
        // print ten random numbers
        random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }
        System.out.println("Using Java 8: ");
        System.out.println("List: " + strings);
        count = strings.stream().filter(String::isEmpty).count();
        System.out.println("Empty Strings: " + count);
        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("Strings of length 3: " + count);
        filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        mergedString =
                strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
        squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
        System.out.println("List: " + integers);
        stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
        System.out.println("Random Numbers: ");
        random.ints().limit(10).sorted().forEach(System.out::println);
        // parallel processing
        count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("Empty Strings: " + count);
    }

    private static void section8() {
        System.out.println("\nSection 8:");
        Java8Tester java8Tester = new Java8Tester();
        Integer value1 = null;
        Integer value2 = 10;
        // Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);
        // Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(java8Tester.sum(a, b));
    }

    private static void section9() {
        System.out.println("\nSection 9:");
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Mahesh";
        Integer result = null;
        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e.getMessage());
        }
        assert result != null;
        System.out.println(result);
    }

    private static void section10() {
        System.out.println("\nSection 10:");
        Java8Tester java8tester = new Java8Tester();
        java8tester.testLocalDateTime();
        java8tester.testZonedDateTime();
        java8tester.testChromoUnits();
        java8tester.testPeriod();
        java8tester.testDuration();
        java8tester.testAdjusters();
        java8tester.testBackwardCompatability();
    }

    private static void section11() {
        System.out.println("\nSection 11:");
        // Encode using basic encoder
        String base64encodedString =
                Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
        // Decode
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println(
                "Original String: " + new String(base64decodedBytes, StandardCharsets.UTF_8));
        base64encodedString =
                Base64.getUrlEncoder()
                        .encodeToString("TutorialsPoint?java8".getBytes(StandardCharsets.UTF_8));
        System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID());
        }
        byte[] mimeBytes = stringBuilder.toString().getBytes(StandardCharsets.UTF_8);
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);
    }

    private void sortUsingJava7(List<String> names) {
        // sort using java 7
        names.sort(String::compareTo);
    }

    private void sortUsingJava8(List<String> names) {
        // sort using java 8
        names.sort(String::compareTo);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    private static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static int getCountLengthUsingJava7(List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.length() == 3) {
                count++;
            }
        }
        return count;
    }

    private static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
        List<String> filteredList = new ArrayList<>();
        for (String string : strings) {
            if (!string.isEmpty()) {
                filteredList.add(string);
            }
        }
        return filteredList;
    }

    private static String getMergedStringUsingJava7(List<String> strings, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (!string.isEmpty()) {
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length() - 2);
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squaresList = new ArrayList<>();
        for (Integer number : numbers) {
            Integer square = number * number;
            if (!squaresList.contains(square)) {
                squaresList.add(square);
            }
        }
        return squaresList;
    }

    private static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static int getSum(List<Integer> numbers) {
        int sum = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private static int getAverage(List<Integer> numbers) {
        return getSum(numbers) / numbers.size();
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());
        // Optional.orElse - returns the value if present otherwise returns
        // the default value passed.
        Integer value1 = a.orElse(0);
        // Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }

    private void testLocalDateTime() {
        System.out.println("Test LocalDateTime:");
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("Month: " + month + " day: " + day + " seconds: " + seconds);
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);
        // 22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
        // parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }

    private void testZonedDateTime() {
        System.out.println("Test ZonedDateTime:");
        // Get the current date and time
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date1);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("CurrentZone: " + currentZone);
    }

    private void testChromoUnits() {
        System.out.println("Test ChronoUnit:");
        // Get the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);
        // add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);
        // add 1 month to the current date
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + nextMonth);
        // add 1 year to the current date
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: " + nextYear);
        // add 10 years to the current date
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: " + nextDecade);
    }

    private void testPeriod() {
        System.out.println("Test Period:");
        // Get the current date
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);
        // add 1 month to the current date
        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("Next month: " + date2);
        Period period = Period.between(date2, date1);
        System.out.println("Period: " + period);
    }

    private void testDuration() {
        System.out.println("Test Duration:");
        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(2);
        LocalTime time2 = time1.plus(twoHours);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);
    }

    private void testAdjusters() {
        System.out.println("Test TemporalAdjusters:");
        // Get the current date
        LocalDate date1 = LocalDate.now();
        System.out.println("Current date: " + date1);
        // get the next Tuesday
        LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on : " + nextTuesday);
        // get the second Saturday of next month
        LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
        LocalDate secondSaturday =
                firstInYear
                        .with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                        .with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("Second Saturday on : " + secondSaturday);
    }

    private void testBackwardCompatability() {
        System.out.println("Test Date:");
        // Get the current date
        Date currentDate = new Date();
        System.out.println("Current date: " + currentDate);
        // Get the instant of current date in terms of milliseconds
        Instant now = currentDate.toInstant();
        ZoneId currentZone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
        System.out.println("Local date: " + localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
        System.out.println("Zoned date: " + zonedDateTime);
    }
}
