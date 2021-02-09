package Code.CTCI.CTCI_SOURCE.other.Ch_16_Moderate.Q16_15_Master_Mind;

public class Question {
    public static int MAX_COLORS = 4;

    public static char letterFromCode(int k) {
        return switch (k) {
            case 0 -> 'B';
            case 1 -> 'G';
            case 2 -> 'R';
            case 3 -> 'Y';
            default -> '0';
        };
    }

    public static void main(String[] args) {
        Result res = estimate("GGRR", "RGBY");
        assert res != null;
        System.out.println(res.toString());
    }

    public static Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) return null;
        Result res = new Result(0, 0);
        int[] frequencies = new int[MAX_COLORS];

        /* Compute hits and built frequency table */
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
                /* Only increment the frequency table (which will be used for pseudo-hits) if
                 * it's not a hit. If it's a hit, the slot has already been "used." */
                int code = code(solution.charAt(i));
                if (code >= 0) {
                    frequencies[code]++;
                }
            }
        }

        /* Compute pseudo-hits */
        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHits++;
                frequencies[code]--;
            }
        }

        return res;
    }

    public static int code(char c) {
        return switch (c) {
            case 'B' -> 0;
            case 'G' -> 1;
            case 'R' -> 2;
            case 'Y' -> 3;
            default -> -1;
        };
    }
}