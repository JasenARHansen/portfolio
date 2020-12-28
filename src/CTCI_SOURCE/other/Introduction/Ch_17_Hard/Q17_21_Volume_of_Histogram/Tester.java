package CTCI_SOURCE.other.Introduction.Ch_17_Hard.Q17_21_Volume_of_Histogram;

public class Tester {

    public static void main(String[] args) {
        String[][] tests = {{"6 1 8 1 2 1 5", "16"},
                {"5 1 2 1 8", "11"},
                {"15 12 20 16 17 25", "10"},
                {"28 25 26", "1"},
                {"28 25 28", "3"},
                {"22", "0"},
                {"22 22", "0"},
                {"0 0 4 0 0 6 0 0 3 0 8 0 2 0 5 2 0 3 0 0", "46"}};
        for (String[] test : tests) {
            String input = test[0];
            String output = test[1];
            String[] inputStringArray = input.split(" ");
            int[] histogram = new int[inputStringArray.length];
            for (int j = 0; j < inputStringArray.length; j++) {
                histogram[j] = Integer.parseInt(inputStringArray[j]);
            }
            int targetVolume = Integer.parseInt(output);

            int volumeA = QuestionA.computeHistogramVolume(histogram);
            int volumeB = QuestionB.computeHistogramVolume(histogram);
            int volumeC = QuestionC.computeHistogramVolume(histogram);
            if (volumeA != targetVolume || volumeB != targetVolume || volumeC != targetVolume) {
                System.out.println("FAILURE: " + input + " -> wanted " + output + " but got (" + volumeA + ", " + volumeB + ", " + volumeC + ")");
            } else {
                System.out.println("SUCCESS: " + input + " -> " + targetVolume);
            }
        }
    }

}
