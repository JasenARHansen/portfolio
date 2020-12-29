package unsorted.classesMain;

import unsorted.classesInstance.Tuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class PeopleOnBench {

    // Comparator to sort by value
    static Comparator<Tuple<Integer, Integer>> compareGaps = (o1, o2) -> {
        Integer v1 = o1.getLeftData() - o1.getRightData();
        Integer v2 = o2.getLeftData() - o2.getRightData();
        return v1.compareTo(v2);
    };

    private static int benchSeats = 0;
    private static boolean benchLeftEdge = true;
    private static boolean benchRightEdge = true;
    private static List<Tuple<Integer, Integer>> gaps;
    private static List<Integer> people;

    private static void buildBench(int seats) {
        benchSeats = seats;
    }

    private static void getDescription() {
        System.out.println(
                "Given a bench with n seats and few people sitting, tell the seat number each time when a new person goes to sit on the bench such that his distance from others is maximum..");
    }

    public static void main(String[] argv) {
        getDescription();
        buildBench(10);
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
        personSits();
    }

    private static void personSits() {
        if (people == null) {
            people = new ArrayList<>();
            int seat = new Random().nextInt(benchSeats) + 1;
            people.add(seat);
            // Edge case checks
            if (seat == 1) {
                benchLeftEdge = false;
                System.out.format("The first person sits at seat '%d' (the far left edge)\n", seat);
            } else if (seat == (benchSeats)) {
                benchRightEdge = false;
                System.out.format("The first person sits at seat '%d' (the far right edge)\n", seat);
            } else {
                System.out.format("The first person sits at seat '%d'\n", seat);
            }
        } else if (people.size() == benchSeats) {
            System.out.println("Sorry, the bench is full");
            return;
        } else if (gaps == null) {
            gaps = new ArrayList<>();
            int firstSeat = people.get(0);
            if ((firstSeat) > (benchSeats - firstSeat)) {
                benchLeftEdge = false;
                gaps.add(new Tuple<>(1, firstSeat));
                people.add(1);
                System.out.format(
                        "The 2nd person sits at seat '%d' (the far left edge), '%d' spaces from the person to his right\n",
                        1, firstSeat - 1);
            } else {
                benchRightEdge = false;
                gaps.add(new Tuple<>(firstSeat, benchSeats));
                people.add(benchSeats);
                System.out.format(
                        "The 2nd person sits at seat '%d' (the far right edge), '%d' spaces from the person to his left\n",
                        benchSeats, benchSeats - firstSeat);
            }
        } else {
            gaps.sort(compareGaps);
            int gap = gaps.get(0).getRightData() - gaps.get(0).getLeftData() - 1;
            // Edge case. a edge is still open.
            if (benchLeftEdge) {
                int gap2 = gaps.get(0).getLeftData() - 1;
                if (gap2 >= gap) {
                    benchLeftEdge = false;
                    gaps.add(new Tuple<>(1, gaps.get(0).getLeftData()));
                    people.add(1);
                    System.out.format(
                            "Person '%d' sits at seat '%d' (the far left edge), '%d' spaces from the person to his right n",
                            people.size(), 1, gap2);
                    return;
                }
            } else if (benchRightEdge) {
                int gap2 = benchSeats - gaps.get(0).getRightData();
                if (gap2 >= gap) {
                    benchRightEdge = false;
                    gaps.add(new Tuple<>(gaps.get(0).getRightData(), benchSeats));
                    people.add(benchSeats);
                    System.out.format(
                            "Person '%d' sits at seat '%d' (the far right edge), '%d' spaces from the person to his left\n",
                            people.size(), benchSeats, gap2);
                    return;
                }
            }
            // normal operation
            Tuple<Integer, Integer> origianalGap = gaps.remove(0);
            int newSeat = (origianalGap.getLeftData() + origianalGap.getRightData()) / 2;
            gaps.add(new Tuple<>(origianalGap.getLeftData(), newSeat));
            gaps.add(new Tuple<>(newSeat, origianalGap.getRightData()));
            people.add(newSeat);

            System.out.format(
                    "Person '%d' sits at seat '%d', '%d' spaces from the person to his left and '%d' spaces from the person to his right\n",
                    people.size(), newSeat, newSeat - origianalGap.getLeftData(),
                    origianalGap.getRightData() - newSeat);
        }
    }
}
