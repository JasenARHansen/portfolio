package Java.code.ctci.source.ch_04_Trees_and_Graphs.q4_12_Paths_with_Sum;

import Java.code.ctci.source.ctciLibrary.AssortedMethods;
import Java.code.ctci.source.ctciLibrary.TreeNode;

public class Tester {
    public static void main(String[] args) {
        boolean isWorking = true;
        while (isWorking) {
            int min = -20;
            int max = 20;
            int size = 20;
            TreeNode root = AssortedMethods.randomBST(size, min, max);
            for (int targetSum = min * size - 10; targetSum <= max * size + 10; targetSum++) {
                int answerA = QuestionA.countPathsWithSum(root, targetSum);
                int answerB = QuestionB.countPathsWithSum(root, targetSum);
                if (answerA > 0 || answerB > 0) {
                    System.out.println(
                            targetSum + ": " + answerA + ", " + answerB + " | " + (answerA == answerB));
                }
                if (answerA != answerB) {
                    isWorking = false;
                    break;
                }
            }
        }
    }
}
