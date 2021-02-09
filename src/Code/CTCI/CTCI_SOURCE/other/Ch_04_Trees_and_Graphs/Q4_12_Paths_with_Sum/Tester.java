package Code.CTCI.CTCI_SOURCE.other.Ch_04_Trees_and_Graphs.Q4_12_Paths_with_Sum;

import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;
import Code.CTCI.CTCI_SOURCE.other.CtCILibrary.TreeNode;

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
