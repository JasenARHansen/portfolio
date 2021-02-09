package Code.CTCI.unsorted;

import Code.unsorted.classes.classesInstance.Tuple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SumOfCubes {

    public static void getDescription() {
        System.out.println("Find all values from 1 to n where a^3 + b^3 = c^3 + d^3");
    }

    public static void findValues(int range) {
        Map<Double, List<Tuple<Integer, Integer>>> pairs = new HashMap<>();

        for (int a = 1; a <= range; a++) {
            for (int b = 1; b <= range; b++) {
                double value = Math.pow(a, 3) + Math.pow(b, 3);
                if (!pairs.containsKey(value)) {
                    pairs.put(value, new LinkedList<>());
                }
                pairs.get(value).add(new Tuple<>(a, b));
            }
        }

        for (Entry<Double, List<Tuple<Integer, Integer>>> set : pairs.entrySet()) {
            System.out.format(
                    "For where a^3 + b^3 = c^3 + d^3 = %d, The (a,b) and (c,d) sets are: %s\n",
                    set.getKey().intValue(), set.getValue());
        }
    }
}
