package Java.code.ctci.source.ch_01_Arrays_and_Strings.q1_06_String_Compression;

@SuppressWarnings("DuplicatedCode")
public class QuestionA {
    public static void main(String[] args) {
        String str = "aa";
        System.out.println(str);
        System.out.println(compressBad(str));
    }

    public static String compressBad(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different then current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }
}
