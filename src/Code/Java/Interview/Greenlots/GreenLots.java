package Code.Java.Interview.Greenlots;

import Code.Java.unsorted.classes.classesInstance.Tank;

import java.util.ArrayList;
import java.util.List;

public class GreenLots {

    /*
     * Imagine that you have a water tank of unknown size input: Sensor ratings
     *
     * Sample an array of input[] {1, 2, -1 }
     *
     */

    public static void main(String[] args) throws Exception {

        int startSize = 0;

        System.out.println("Minimum size static 1: ");
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(2);
        inputs.add(-1);

        int size = getMinimumSize(inputs);
        System.out.println("Minimum size: " + size);

        System.out.println("Minimum size dynamic 1: ");

        Tank current = new Tank(startSize);
        for (Integer input : inputs) {
            current.addValue(input);
            System.out.println("Minimum size: " + current.getSize());
        }

        System.out.println("Minimum size static 2: ");
        inputs.clear();
        inputs.add(-1);
        inputs.add(-2);
        inputs.add(1);
        size = getMinimumSize2(inputs);
        System.out.println("Minimum size: " + size);

        System.out.println("Minimum size dynamic 2: ");

        current = new Tank(startSize);
        for (Integer input : inputs) {
            current.addValue(input);
            System.out.println("Minimum size: " + current.getSize());
        }

        System.out.println("Minimum size static 3: ");
        inputs.clear();
        inputs.add(-1);
        inputs.add(1);
        inputs.add(-2);
        size = getMinimumSize2(inputs);
        System.out.println("Minimum size: " + size);

        System.out.println("Minimum size dynamic 3: ");

        current = new Tank(startSize);
        for (Integer input : inputs) {
            current.addValue(input);
            System.out.println("Minimum size: " + current.getSize());
        }

        System.out.println("Minimum size static 4: ");
        inputs.clear();
        inputs.add(-1);
        inputs.add(-2);
        inputs.add(-3);
        inputs.add(1);
        inputs.add(2);
        inputs.add(3);
        inputs.add(1);
        size = getMinimumSize2(inputs);
        System.out.println("Minimum size: " + size);

        System.out.println("Minimum size dynamic 4: ");

        current = new Tank(startSize);

        for (Integer input : inputs) {
            current.addValue(input);
            System.out.println("Minimum size: " + current.getSize());
        }

    }

    private static int getMinimumSize(List<Integer> inputs) {
        int minimumSize = 0;
        int accumulator = 0;

        for (Integer value : inputs) {
            accumulator += value;
            if (minimumSize < accumulator) {
                minimumSize = accumulator;
            }
        }
        return minimumSize;
    }

    private static int getMinimumSize2(List<Integer> inputs) {
        int minimumSize = 0;
        int accumulator = 0;

        for (Integer value : inputs) {
            accumulator += value;
            if (minimumSize < Math.abs(accumulator)) {
                minimumSize = Math.abs(accumulator);
            }
        }
        return minimumSize;
    }

}
