package Java.Code.unsorted.classes;

import Java.Code.unsorted.classes.classesInstance.Rectangle;
import Java.Code.unsorted.classes.classesInstance.Tuple;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodeChallenge {
    // Comparator to sort by value
    static Comparator<Tuple<String, Integer>> compareLeft = (e1, e2) -> {
        String v1 = e1.getLeftData();
        String v2 = e2.getLeftData();
        return v1.compareTo(v2);
    };

    // Comparator to sort by value
    static Comparator<Tuple<String, Integer>> compareRight = (e1, e2) -> {
        Integer v1 = e1.getRightData();
        Integer v2 = e2.getRightData();
        return v1.compareTo(v2);
    };

    public static void sortTupelLeft(List<Tuple<String, Integer>> values) {
        values.sort(compareLeft);
    }

    public static void sortTupelRight(List<Tuple<String, Integer>> values) {
        values.sort(compareRight);
    }

    public static void description() {

        System.out.println(
                "Challenge 1: Given an ordered list of numbers find if a pair of numbers exist equal to a target number");
        System.out.println(
                "Challenge 2: Given an ordered list of numbers find a pair of numbers equal to a target number");
        // System.out.println("Challenge 3: Given an ordered list of numbers find
        // all pairs of numbers equal to a target number");
        System.out.println("Challenge 4: Given an array of numbers find all subsets of thoes numbers");
        System.out.println(
                "Challenge 5: Given an array of numbers representing a single number, increment by 1 and return array");
        System.out.println("Challenge 6: Given 2 rectangles return the total area of overlap");
        System.out.println("Challenge 7: Place N Queens on a NxN chessboard");
        System.out.println(
                "Challenge 8: Given an aray if integers where the content of the array at an index, is the next index it navigates to.  Detect cycles.");
        System.out.println("Challenge 9: Given 1 or more array, without merging, find the Nth item in the sequence");
        System.out.println("Challenge 10: Given 1 or more array, find all values that exist in all arrays");
        System.out.println("Challenge 11: Given a list of Tuples, sort by the leftData and sort by .getRightData()");
    }

    public static int[] mergeAndSort(int[]... sourceArrays) {
        List<Integer> merged = new ArrayList<>();
        for (int[] array : sourceArrays) {
            merged.addAll(Arrays.stream(array).boxed().collect(Collectors.toList()));
        }
        int[] returnArray = new int[merged.size()];
        Iterator<Integer> iterator = merged.iterator();
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = iterator.next();
        }
        Arrays.sort(returnArray);
        return returnArray;
    }

    public static int searchComplex(int element, int[]... sourceArrays) {
        int totalCount = 0;
        for (int[] array : sourceArrays) {
            Arrays.sort(array); /* To pre-sort the contents of the Array */
            totalCount += array.length; /* Ignoring the NPE for simplicity */
        }
        if ((element < 1) || (element > totalCount)) {
            return Integer.MIN_VALUE;
        }
        int[] indexes = new int[sourceArrays.length];
        int value = Integer.MIN_VALUE;
        int counter = 0;
        while (counter++ < element) {
            int indexToAdjust = 0;
            Integer currentValue = null;
            for (int i = 0; i < sourceArrays.length; i++) {
                if (indexes[i] < sourceArrays[i].length) {
                    if ((currentValue == null) || (currentValue > sourceArrays[i][indexes[i]])) {
                        indexToAdjust = i;
                        currentValue = sourceArrays[i][indexes[i]];
                    }
                }
            }
            value = currentValue;
            indexes[indexToAdjust]++;
        }
        return value;
    }

    public static List<Integer> findCommonComplex(int[]... sourceArrays) {
        List<Integer> returnValues = new ArrayList<>();
        for (int[] array : sourceArrays) {
            Arrays.sort(array); /* To pre-sort the contents of the Array */
        }
        if (sourceArrays.length == 1) {
            return IntStream.of(sourceArrays[0]).boxed().collect(Collectors.toCollection(ArrayList::new));
        }

        int[] indexes = new int[sourceArrays.length];

        for (int index = 0; index < sourceArrays[0].length; index++) {
            for (int relatedArray = 1; relatedArray < sourceArrays.length; relatedArray++) {
                while (sourceArrays[relatedArray][indexes[relatedArray]] < sourceArrays[0][index]) {
                    indexes[relatedArray]++;
                    if (indexes[relatedArray] >= sourceArrays[relatedArray].length) {
                        return returnValues;
                    }
                }
            }

            boolean addValue = true;
            for (int relatedArray = 1; relatedArray < sourceArrays.length; relatedArray++) {
                if (sourceArrays[relatedArray][indexes[relatedArray]] != sourceArrays[0][index]) {
                    addValue = false;
                    break;
                }
            }

            if (addValue) {
                returnValues.add(sourceArrays[0][index]);
            }

            // Eliminate duplicates
            while (((index + 1) < sourceArrays[0].length) && (sourceArrays[0][index] == sourceArrays[0][index + 1])) {
                index++;
            }
        }
        return returnValues;
    }

    public static boolean detectCycle(int... values) {
        if ((values[0] >= values.length) || (values[0] < 0)) {
            // Points out of range so no cycle
            return false;
        }

        int fastCursor = 0;
        int slowCursor = 0;
        int detect = 0;
        int failsafe = 0;

        while (true) {
            for (int index = 0; index < 3; index++) {
                // First fastCursor step
                // Second fastCursor step monthString = "January";
                // First slowCursor step monthString = "February";
                switch (index) {
                    case 0 -> {
                        fastCursor = values[fastCursor];
                        detect = detectCycle(true, fastCursor, slowCursor, values);
                    }
                    case 1 -> {
                        fastCursor = values[fastCursor];
                        detect = detectCycle(true, fastCursor, slowCursor, values);
                    }
                    case 2 -> {
                        slowCursor = values[slowCursor];
                        detect = detectCycle(false, fastCursor, slowCursor, values);
                    }
                }

                switch (detect) {
                    case -1:
                        // Escaped the inputs, no cycle
                        return false;
                    case 0:
                        // Bound by the inputs, continue looking for cycle
                        failsafe++;
                        if (failsafe == values.length) {
                            // Breaking infinite loop. If every item in the array
                            // has been hit without escaping it will repeat so a
                            // cycle exists.
                            return true;
                        }
                        break;
                    case 1:
                        // cursors are equal, cycle
                        return true;
                }
            }

        }
    }

    private static int detectCycle(boolean selector, int fastCursor, int slowCursor, int[] values) {
        // 3 cases
        if (selector) {
            if ((values[fastCursor] >= values.length) || (values[fastCursor] < 0)) {
                // Points out of range so no cycle
                return -1;
            }
        } else {
            if ((values[slowCursor] >= values.length) || (values[slowCursor] < 0)) {
                // Points out of range so no cycle
                return -1;
            }

        }

        if (fastCursor == slowCursor) {
            // Cursors are equal so a cycle has been detected
            return 1;
        }

        return 0;
    }

    public static ArrayList<ArrayList<Integer>> findSubsets(int... numbers) {
        ArrayList<ArrayList<Integer>> returnValue = new ArrayList<>();
        ArrayList<Integer> working = new ArrayList<>();
        returnValue.add(working);
        return findSubsets(0, numbers, returnValue);
    }

    public static List<Integer> firstPairSortedList(int sum, int... numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int startValue, endValue, localSum;

        List<Integer> returnValue = null;

        while (startIndex < endIndex) {
            startValue = numbers[startIndex];
            endValue = numbers[endIndex];
            localSum = startValue + endValue;
            if (localSum == sum) {
                returnValue = new ArrayList<>();
                returnValue.add(startValue);
                returnValue.add(endValue);
                return returnValue;
            } else if (localSum > sum) {
                endIndex--;
            } else if (localSum < sum) {
                startValue++;
            }
        }
        return returnValue;
    }

    public static Tuple<Integer, Integer> firstPairSortedTuple(int sum, int... numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int startValue, endValue, localSum;

        while (startIndex < endIndex) {
            startValue = numbers[startIndex];
            endValue = numbers[endIndex];
            localSum = startValue + endValue;
            if (localSum == sum) {
                return new Tuple<>(startValue, endValue);
            } else if (localSum > sum) {
                endIndex--;
            } else {
                startValue++;
            }
        }
        return null;
    }

    public static List<Integer> firstPairUnortedList(int sum, int... numbers) {
        List<Integer> pairValue = new LinkedList<>();
        for (int value : numbers) {
            if (pairValue.contains(sum - value)) {
                List<Integer> returnValue = new ArrayList<>();
                returnValue.add(sum - value);
                returnValue.add(value);
                return returnValue;
            } else {
                pairValue.add(value);
            }
        }
        return null;
    }

    public static Tuple<Integer, Integer> firstPairUnortedTuple(int sum, int... numbers) {
        List<Integer> pairValue = new LinkedList<>();
        for (int value : numbers) {
            if (pairValue.contains(sum - value)) {
                return new Tuple<>(sum - value, value);
            } else {
                pairValue.add(value);
            }
        }
        return null;
    }

    public static int[] incrementArrayValue(int... numbers) {
        return incrementArrayIndex(numbers.length, numbers);
    }

    public static Boolean pairExistsSorted(int sum, int... numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int startValue, endValue, localSum;
        while (startIndex < endIndex) {
            startValue = numbers[startIndex];
            endValue = numbers[endIndex];
            localSum = startValue + endValue;
            if (localSum == sum) {
                return true;
            } else if (localSum > sum) {
                endIndex--;
            } else {
                startValue++;
            }
        }
        return false;
    }

    public static Boolean pairExistsUnorted(int sum, int... numbers) {
        List<Integer> pairValue = new LinkedList<>();
        for (int value : numbers) {
            if (pairValue.contains(sum - value)) {
                return true;
            } else {
                pairValue.add(value);
            }
        }
        return false;
    }

    public static List<Tuple<Integer, Integer>> placeNQueens(int Queens) {
        List<Tuple<Integer, Integer>> queenList = new ArrayList<>();
        int[][] board = new int[Queens][Queens];
        addQueen(0, queenList, board);
        return queenList;
    }

    public static void printQueens(List<Tuple<Integer, Integer>> queenList) {
        if (queenList.isEmpty()) {
            System.out.println("\tNo Queens placed.");
            return;
        }
        StringBuilder topBoarder = new StringBuilder("\t");
        for (int index = 0; index < queenList.size(); index++) {
            topBoarder.append(index).append("\t");

        }
        System.out.println(topBoarder);

        String[] board = new String[queenList.size()];
        for (Tuple<Integer, Integer> queen : queenList) {
            String line = queen.getRightData() + ":\t" + "\t".repeat(Math.max(0, queen.getLeftData())) + "X";
            board[queen.getRightData()] = line;
        }

        for (int index = 0; index < queenList.size(); index++) {
            System.out.println(board[index]);
        }
    }

    public static void printSubsets(ArrayList<ArrayList<Integer>> subsets) {
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static void printSubsets(int... numbers) {
        printSubsets(findSubsets(numbers));
    }

    public static int rectangleOverlap(Rectangle firstRectangle, Rectangle secondRectangle) {
        // For overlap area there must be X axis overlap
        int firstX1 = firstRectangle.point1.getLeftData();
        int firstX2 = firstRectangle.point2.getLeftData();
        int secondX1 = secondRectangle.point1.getLeftData();
        int secondX2 = secondRectangle.point2.getLeftData();

        int overlapXStart = Math.max(firstX1, secondX1);
        int overlapXEnd = Math.min(firstX2, secondX2);

        // Validity check
        if ((overlapXEnd - overlapXStart) <= 0) {
            // No overlap
            return 0;
        }

        // For overlap area there must be y-axis overlap
        int firstY1 = firstRectangle.point1.getRightData();
        int firstY2 = firstRectangle.point2.getRightData();
        int secondY1 = secondRectangle.point1.getRightData();
        int secondY2 = secondRectangle.point2.getRightData();

        int overlapYStart = Math.max(firstY1, secondY1);
        int overlapYEnd = Math.min(firstY2, secondY2);
        // Validity check
        if ((overlapYEnd - overlapYStart) <= 0) {
            // No overlap
            return 0;
        }

        return new Rectangle(overlapXStart, overlapYStart, overlapXEnd, overlapYEnd).getArea();

        // Integer overlapXStart = null;
        // Integer overlapXEnd = null;
        //
        // // The starting X coordinate must be between the X bounds of the 2nd
        // Rectangle
        // if (( firstX1 <= secondX1 ) && (secondX1 <= firstX2)){
        // overlapXStart = secondX1;
        // }
        // else if (( secondX1 <= firstX1 ) && (firstX1 <= firstX2)){
        // overlapXEnd = secondX1;
        // }
        // else
        // {
        // //No overlap
        // return 0;
        // }
        //
        // // The ending X coordinate must be between the X bounds of the 2nd
        // Rectangle
        // if (( firstX1 <= secondX2 ) && (secondX2 <= firstX2)){
        // overlapXEnd = secondX2;
        // }
        // else if (( secondX1 <= firstX2 ) && (firstX2 <= firstX2)){
        // overlapXEnd = firstX2;
        // }
        // else
        // {
        // //No overlap
        // return 0;
        // }
        //
        // Integer overlapYStart = null;
        // Integer overlapYEnd = null;
        //
        // // The starting Y coordinate must be between the Y bounds of the 2nd
        // Rectangle
        // if (( firstY1 <= secondY1 ) && (secondY1 <= firstY2)){
        // overlapYStart = secondY1;
        // }
        // else if (( secondY1 <= firstY1 ) && (firstY1 <= firstY2)){
        // overlapYEnd = secondY1;
        // }
        // else
        // {
        // //No overlap
        // return 0;
        // }
        //
        // // The ending Y coordinate must be between the Y bounds of the 2nd
        // Rectangle
        // if (( firstY1 <= secondY2 ) && (secondY2 <= firstY2)){
        // overlapYEnd = secondY2;
        // }
        // else if (( secondY1 <= firstY2 ) && (firstY2 <= firstY2)){
        // overlapYEnd = firstY2;
        // }
        // else
        // {
        // //No overlap
        // return 0;
        // }
        //
        // // If double overlap found
        // int width = overlapXEnd - overlapXStart;
        // int height = overlapYEnd - overlapYStart;
        // return width * height;
    }

    private static void addQueen(int collumn, List<Tuple<Integer, Integer>> queenList, int[][] board) {
        if (collumn == board.length) {
            return;
        }
        int row = 0;
        while ((row < board.length) && (queenList.size() < board.length)) {
            if (!testThreatened(collumn, row, board)) {
                Tuple<Integer, Integer> queen = new Tuple<>(collumn, row);
                queenList.add(queen);
                board[collumn][row] = 1;
                addQueen(collumn + 1, queenList, board);
                if (queenList.size() != board.length) {
                    board[collumn][row] = 0;
                    queenList.remove(collumn);
                }
            }
            row++;
        }
    }

    private static ArrayList<ArrayList<Integer>> findSubsets(int index, int[] numbers,
                                                             ArrayList<ArrayList<Integer>> returnValue) {

        if (index >= numbers.length) {
            return returnValue;
        }
        int counMax = returnValue.size();
        for (int loop = 0; loop < counMax; loop++) {
            @SuppressWarnings("unchecked")
            ArrayList<Integer> working = (ArrayList<Integer>) returnValue.get(loop).clone();
            working.add(numbers[index]);
            returnValue.add(working);
        }

        return findSubsets(index + 1, numbers, returnValue);
    }

    private static int[] incrementArrayIndex(int index, int... numbers) {
        if (numbers.length == 0) {
            return new int[]{1};
        }
        if (index == 0) {
            int[] newReturn = Arrays.copyOf(numbers, numbers.length + 1);
            newReturn[0] = 1;
            System.arraycopy(numbers, 0, newReturn, 1, numbers.length);
            return newReturn;
        }
        numbers[index - 1]++;
        if (numbers[index - 1] > 9) {
            numbers[index - 1] = 0;
            return incrementArrayIndex(index - 1, numbers);
        }
        return numbers;
    }

    private static Boolean testThreatened(int collumn, int row, int[][] board) {
        // 3 cases of threat only.
        // left and up
        int counter = 0;
        while (true) {
            if (((collumn - counter) >= 0) && ((row - counter) >= 0)) {
                if (board[collumn - counter][row - counter] == 1) {
                    return true;
                }
                counter++;
            } else {
                break;
            }
        }

        // left only
        for (int index = collumn - 1; index >= 0; index--) {
            if (board[index][row] == 1) {
                return true;
            }
        }
        // left and down
        counter = 0;
        while (true) {
            if (((collumn - counter) >= 0) && ((row + counter) < board.length)) {
                if (board[collumn - counter][row + counter] == 1) {
                    return true;
                }
                counter++;
            } else {
                break;
            }
        }
        return false;
    }

}
