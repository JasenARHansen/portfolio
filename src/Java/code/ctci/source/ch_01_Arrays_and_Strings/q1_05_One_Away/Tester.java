package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_05_One_Away;

@SuppressWarnings("SpellCheckingInspection")
public class Tester {
    public static void main(String[] args) {
        String[][] tests = {
                {"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}
        };
        for (String[] test : tests) {
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");
            test(a, b, expected);
            test(b, a, expected);
        }
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = QuestionA.oneEditAway(a, b);
        boolean resultB = QuestionB.oneEditAway(a, b);
        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }
}
