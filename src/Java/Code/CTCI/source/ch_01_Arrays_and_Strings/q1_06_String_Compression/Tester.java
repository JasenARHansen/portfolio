package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_06_String_Compression;

@SuppressWarnings("SpellCheckingInspection")
public class Tester {
  public static void main(String[] args) {
    String str = "aaaaabbbbaaaabbddc";
    System.out.println(str);
    System.out.println(QuestionA.compressBad(str));
    System.out.println(QuestionB.compress(str));
    System.out.println(QuestionC.compress(str));
  }
}
