package Java.code.interview.Amazon.assessment.question2;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static void getDescription() {
        System.out.println(
                """
                        Amazon would like to know how much inventory exists in their closed inventory compartments.  Given a string with the
                        character "*" representing an item and the character "|" representing a boundary of a container, find out how many
                        items are in the closed containers determined b a start and stop index.
                        A closed container is one that is bound on both sides with a boundary character "|*|" would be a closed container
                        with 1 item.
                        Write a method that takes:
                         1. A string representing the inventory
                         2. A list of starting indexes for examination ranges
                         3. A list of stopping indexes for examination ranges
                        For each pair os starting and stopping indexes dine the items in the closed containers.
                        Note: The indexes are not array based!
                        I am going to assume that if the start and stop index are the same the range actually includes the character at
                         that index
                        """
                        .indent(2));
    }

    public static List<Integer> numberOfItems(
            String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        char item = '*';
        char compartment = '|';
        List<Integer> return_list = new ArrayList<>();
        // Process each pair of indices
        while ((!startIndices.isEmpty()) && (!endIndices.isEmpty())) {
            int start = startIndices.remove(0) - 1;
            int stop = endIndices.remove(0);
            int count = 0;
            if ((0 <= start) && (stop <= s.length())) {
                String section = s.substring(start, stop);
                int section_Start = 0;
                // Find first boundary
                while ((section_Start < section.length())
                        && (section.charAt(section_Start) != compartment)) {
                    section_Start++;
                }
                // Increment past boundary
                section_Start++;
                // Loop for each section
                int sub_count;
                while (section_Start < section.length()) {
                    sub_count = 0;
                    while ((section_Start < section.length()) && (section.charAt(section_Start) == item)) {
                        section_Start++;
                        sub_count++;
                    }
                    // After finding the last item, check if the next character is a boundary
                    if ((section_Start < section.length())
                            && (section.charAt(section_Start) == compartment)) {
                        section_Start++;
                        count += sub_count;
                    }
                }
            }
            return_list.add(count);
        }
        return return_list;
    }
}
