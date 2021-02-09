package Code.interview.Facebook.practice;

import java.util.List;
import java.util.PriorityQueue;

public class YearWithMostPeopleAlive {
  /*
  Year With Most People Alive
  given a list of People with a birth year and a death year, fine what year, or rear range has the most people
  Special object Person(int birth,  int death)
  bool isBalanced(int s)
  */

    public static int[] mostPeople(List<Person> people) {
        PriorityQueue<Integer> birth = new PriorityQueue<>();
        PriorityQueue<Integer> death = new PriorityQueue<>();
        for (Person person : people) {
            birth.add(person.born);
            death.add(person.died);
        }
        int currentYear;
        int currentPeople = 0;
        int maxYear = 0;
        int maxPeople = 0;
        while ((!birth.isEmpty())) {
            if (birth.isEmpty()) {
                death.clear();
            } else if (death.isEmpty()) {
                while (!birth.isEmpty()) {
                    currentYear = birth.poll();
                    currentPeople++;
                    if (currentPeople > maxPeople) {
                        maxPeople = currentPeople;
                        maxYear = currentYear;
                    }
                }
            } else if (death.peek() < birth.peek()) {
                death.poll();
                currentPeople--;
            } else if (birth.peek() <= death.peek()) {
                currentYear = birth.poll();
                currentPeople++;
                if (currentPeople > maxPeople) {
                    maxPeople = currentPeople;
                    maxYear = currentYear;
                }
            }
        }
        return new int[]{maxYear, maxPeople};
    }

    public static class Person {
        public int born;
        public int died;

        public Person(int born, int died) {
            this.born = born;
            this.died = died;
        }
    }
}
