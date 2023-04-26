package Java.Code.Challenge;

import Java.Code.unsorted.classes.classesInstance.Circle;
import Java.Code.unsorted.classes.classesInstance.Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThiefAndSensors {

    private static List<Circle> circles;
    private static Rectangle room;
    private static boolean evaluated = false;
    private static boolean blockedBottomTop = false;
    private static boolean blockedLeftRight = false;

    public static void getDescription() {
        System.out.println("Given a room with thief on one side of the room with finite number of sensors. He has to reach on other side missing the sensors. Each sensor is placed at any random point in the room and has its coverage in the radius r. Find out if the thief can reach to the other side without touching the range of any sensor.");
    }

    public static void add_circle(int x_coordinate, int y_coordinate, int radius) {
        if (room == null) {
            System.out.println("The room must be defined before you can add sensors.");
            return;
        }
        // Circle must be in the room
        if ((room.getXMinimum() <= x_coordinate) && (x_coordinate <= room.getXMaximum()) && (room.getYMinimum() <= y_coordinate) && (y_coordinate <= room.getYMaximum())) {
            if (circles == null) {
                circles = new ArrayList<>();
            }
            circles.add(new Circle(x_coordinate, y_coordinate, radius));
        } else {
            System.out.println("The sensor must be in the room.");
        }
    }

    public static void constructRoom(int lowerRightX, int lowerRightY, int width, int height) {
        reset();
        room = new Rectangle(lowerRightX, lowerRightY, lowerRightX + width, lowerRightY + height);
    }

    public static void pathBottomTop() {
        if (!evaluated) {
            processPaths();
        }
        if (blockedBottomTop) {
            System.out.println("There is no path from Left to Right");
        } else {
            System.out.println("There is a path from Left to Right");
        }
    }

    public static void pathExists() {
        if (!evaluated) {
            processPaths();
        }
        if (blockedLeftRight && blockedBottomTop) {
            System.out.println("There is no path available");
        } else {
            System.out.println("There is a path available");
        }
    }

    private static void processPaths() {
        List<ArrayList<Integer>> intersections = new ArrayList<>();
        for (int circle = 0; circle < circles.size(); circle++) {
            ArrayList<Integer> intersectsWith = new ArrayList<>();
            for (int compare_circle = circle + 1; compare_circle < circles.size(); compare_circle++) {
                if (circles.get(circle).intersects(circles.get(compare_circle))) {
                    intersectsWith.add(compare_circle);
                }
            }
            intersections.add(intersectsWith);
        }

        boolean[] processed = new boolean[circles.size()];

        List<ArrayList<Integer>> intersectionClusters = new ArrayList<>();
        for (int circle = 0; circle < circles.size(); circle++) {
            if (!processed[circle]) {
                processed[circle] = true;
                ArrayList<Integer> cluster = new ArrayList<>();
                cluster.add(circle);
                if (!intersections.get(circle).isEmpty()) {
                    Queue<Integer> myQueue = new LinkedList<>(intersections.get(circle));
                    while (!myQueue.isEmpty()) {
                        int process = myQueue.remove();
                        processed[process] = true;
                        myQueue.addAll(intersections.get(process));
                        if (!cluster.contains(process)) {
                            cluster.add(process);
                        }
                    }
                }
                intersectionClusters.add(cluster);
            }
        }

        for (ArrayList<Integer> cluster : intersectionClusters) {
            int xMinimum = circles.get(cluster.get(0)).getXMinimum();
            int xMaximum = circles.get(cluster.get(0)).getXMaximum();
            int yMinimum = circles.get(cluster.get(0)).getYMinimum();
            int yMaximum = circles.get(cluster.get(0)).getYMaximum();
            for (int circle = 1; circle < cluster.size(); circle++) {
                if (circles.get(cluster.get(circle)).getXMinimum() < xMinimum) {
                    xMinimum = circles.get(cluster.get(circle)).getXMinimum();
                }
                if (circles.get(cluster.get(circle)).getXMaximum() > xMaximum) {
                    xMaximum = circles.get(cluster.get(circle)).getXMaximum();
                }
                if (circles.get(cluster.get(circle)).getYMinimum() < yMinimum) {
                    yMinimum = circles.get(cluster.get(circle)).getYMinimum();
                }
                if (circles.get(cluster.get(circle)).getYMaximum() > yMaximum) {
                    yMaximum = circles.get(cluster.get(circle)).getYMaximum();
                }
            }
            if ((xMinimum <= room.getXMinimum()) && (room.getXMaximum() <= xMaximum)) {
                blockedLeftRight = true;
            }
            if ((yMinimum <= room.getYMinimum()) && (room.getYMaximum() <= yMaximum)) {
                blockedBottomTop = true;
            }
        }
        evaluated = true;
    }

    public static void pathLeftRight() {
        if (!evaluated) {
            processPaths();
        }
        if (blockedLeftRight) {
            System.out.println("There is no path from Bottom to Top");
        } else {
            System.out.println("There is a path from Bottom to Top");
        }
    }

    private static void reset() {
        circles = null;
        room = null;
        evaluated = false;
        blockedBottomTop = false;
        blockedLeftRight = false;
    }

    public static void main(String[] argv) {
        getDescription();
        constructRoom(0, 0, 10, 10);
        add_circle(1, 1, 1);
        add_circle(3, 3, 3);
        add_circle(5, 8, 4);
        add_circle(8, 8, 2);
        pathExists();
        pathBottomTop();
        pathLeftRight();

        reset();
        constructRoom(0, 0, 10, 10);
        add_circle(1, 1, 1);
        add_circle(3, 3, 1);
        add_circle(5, 5, 1);
        add_circle(8, 8, 1);
        pathExists();
        pathBottomTop();
        pathLeftRight();
    }
}
