package Code.Java.CTCI.CTCI_SOURCE.other.Ch_16_Moderate.Q16_17_Contiguous_Sequence;

public class Question {

    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSum(a));
    }

    public static int getMaxSum(int[] a) {
        int maxSum = 0;
        int runningSum = 0;
        for (int j : a) {
            runningSum += j;
            if (maxSum < runningSum) {
                maxSum = runningSum;
            } else if (runningSum < 0) {
                runningSum = 0;
            }
        }
        return maxSum;
    }
}
