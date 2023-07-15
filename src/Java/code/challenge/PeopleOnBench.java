package Java.code.challenge;

import Java.code.unsorted.classes.classesInstance.Tuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PeopleOnBench {
    static final Comparator<Tuple<Integer, Integer>> compareGaps =
            (o1, o2) -> {
                /* Comparator to sort by value. */
                Integer v1 = o1.leftData() - o1.rightData();
                Integer v2 = o2.leftData() - o2.rightData();
                return v1.compareTo(v2);
            };
    private static boolean benchLeftEdge = true;
    private static boolean benchRightEdge = true;
    private static int benchSeats = 0;
    private static List<Tuple<Integer, Integer>> gaps;
    private static List<Integer> people;

    public static void buildBench(int seats) {
        reset();
        benchSeats = seats;
    }

    private static void reset() {
        benchSeats = 0;
        benchLeftEdge = true;
        benchRightEdge = true;
        gaps = null;
        people = null;
    }

    public static String getBench() {
        return String.format("Seats:%d, People:%s", benchSeats, people);
    }

    public static void getDescription() {
        System.out.println(
                """
                        Given a bench with n seats and few people sitting, tell the
                         seat number each time when a new person goes to sit on the
                         bench such that his distance from others is maximum."""
                        .indent(2));
    }

    public static String personSits() {
        if (people == null) {
            people = new ArrayList<>();
            int seat = new Random().nextInt(benchSeats) + 1;
            people.add(seat);
            // Edge case checks
            if (seat == 1) {
                benchLeftEdge = false;
                return String.format("The first person sits at seat '%d' (the far left edge)\n", seat);
            } else if (seat == (benchSeats)) {
                benchRightEdge = false;
                return String.format("The first person sits at seat '%d' (the far right edge)\n", seat);
            } else {
                return String.format("The first person sits at seat '%d'\n", seat);
            }
        } else if (people.size() == benchSeats) {
            return "Sorry, the bench is full\n";
        } else if (gaps == null) {
            gaps = new ArrayList<>();
            int firstSeat = people.get(0);
            if ((firstSeat) > (benchSeats - firstSeat)) {
                benchLeftEdge = false;
                gaps.add(new Tuple<>(1, firstSeat));
                people.add(1);
                return String.format(
                        "The 2nd person sits at seat '%d' (the far left edge), '%d' spaces from the"
                                + " person to his right\n",
                        1, firstSeat - 1);
            } else {
                benchRightEdge = false;
                gaps.add(new Tuple<>(firstSeat, benchSeats));
                people.add(benchSeats);
                return String.format(
                        "The 2nd person sits at seat '%d' (the far right edge), '%d' spaces from the"
                                + " person to his left\n",
                        benchSeats, benchSeats - firstSeat);
            }
        } else {
            gaps.sort(compareGaps);
            int gap = gaps.get(0).rightData() - gaps.get(0).leftData() - 1;
            // Edge case. An edge is still open.
            if (benchLeftEdge) {
                int gap2 = gaps.get(0).leftData() - 1;
                if (gap2 >= gap) {
                    benchLeftEdge = false;
                    gaps.add(new Tuple<>(1, gaps.get(0).leftData()));
                    people.add(1);
                    return String.format(
                            "Person '%d' sits at seat '%d' (the far left edge), '%d' spaces from the"
                                    + " person to his right n",
                            people.size(), 1, gap2);
                }
            } else if (benchRightEdge) {
                int gap2 = benchSeats - gaps.get(0).rightData();
                if (gap2 >= gap) {
                    benchRightEdge = false;
                    gaps.add(new Tuple<>(gaps.get(0).rightData(), benchSeats));
                    people.add(benchSeats);
                    return String.format(
                            "Person '%d' sits at seat '%d' (the far right edge), '%d' spaces from the"
                                    + " person to his left\n",
                            people.size(), benchSeats, gap2);
                }
            }
            // normal operation
            Tuple<Integer, Integer> originalGap = gaps.remove(0);
            int newSeat = (originalGap.leftData() + originalGap.rightData()) / 2;
            gaps.add(new Tuple<>(originalGap.leftData(), newSeat));
            gaps.add(new Tuple<>(newSeat, originalGap.rightData()));
            people.add(newSeat);
            return String.format(
                    "Person '%d' sits at seat '%d', '%d' spaces from the person to his left and '%d'"
                            + " spaces from the person to his right\n",
                    people.size(),
                    newSeat,
                    newSeat - originalGap.leftData(),
                    originalGap.rightData() - newSeat);
        }
    }
}
