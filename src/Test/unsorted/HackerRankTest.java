package Test.unsorted;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import unsorted.classesStatic.HackerRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HackerRankTest {

    @Test
    public void http() throws Exception {
        List<String> test = HackerRank.http("Spiderman");
        System.out.println(test.toString());
    }

    @Test
    public void stringMerge() {
        String test = HackerRank.stringMerge("abcd", "1234567");
        System.out.println(test);
    }

    @Test
    public void isSubset() {


        Map<String, String> myMap1 = new HashMap<>();
        myMap1.put("John", "New York");
        myMap1.put("Rajeev", "Bengaluru");
        myMap1.put("Steve", "London");
        Map<String, String> myMap2 = new HashMap<>();
        myMap2.put("John", "New York");
        myMap2.put("Steve", "London");


//		String test = HackerRank.isSubset(  myMap1, myMap2);
//		System.out.println(test);
    }


}