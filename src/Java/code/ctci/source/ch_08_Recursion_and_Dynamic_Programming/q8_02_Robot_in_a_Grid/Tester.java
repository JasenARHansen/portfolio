package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_02_Robot_in_a_Grid;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;

import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        int size = 5;
        boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
        AssortedMethods.printMatrix(maze);
        ArrayList<Point> pathA = QuestionA.getPath(maze);
        ArrayList<Point> pathB = QuestionB.getPath(maze);
        if (pathA != null) {
            System.out.println(pathA);
        } else {
            System.out.println("No path found.");
        }
        if (pathB != null) {
            System.out.println(pathB);
        } else {
            System.out.println("No path found.");
        }
    }
}
