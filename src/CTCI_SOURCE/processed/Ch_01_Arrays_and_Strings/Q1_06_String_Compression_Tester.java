package CTCI_SOURCE.processed.Ch_01_Arrays_and_Strings;

public class Q1_06_String_Compression_Tester {

    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddc";
        System.out.println(str);
        System.out.println(Q1_06_String_Compression_QuestionA.compressBad(str));
        System.out.println(Q1_06_String_Compression_QuestionB.compress(str));
        System.out.println(Q1_06_String_Compression_QuestionC.compress(str));
    }
}
