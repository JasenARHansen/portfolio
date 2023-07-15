package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_13_Stack_of_Boxes;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
    public static int createStack(ArrayList<Box> boxes) {
        boxes.sort(new BoxComparator());
        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    public static int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.height;
        return maxHeight;
    }

    public static void main(String[] args) {
        Box[] boxList = {
                new Box(6, 4, 4),
                new Box(8, 6, 2),
                new Box(5, 3, 3),
                new Box(7, 8, 3),
                new Box(4, 2, 2),
                new Box(9, 7, 3)
        };
        ArrayList<Box> boxes = new ArrayList<>(List.of(boxList));
        int height = createStack(boxes);
        System.out.println(height);
    }
}
