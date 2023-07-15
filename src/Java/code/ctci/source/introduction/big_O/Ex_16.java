package Java.code.ctci.source.introduction.big_O;

public class Ex_16 {
    public static void main(String[] args) {
        permutation("abc");
    }

    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void permutation(String str) {
        permutation(str, "");
    }
}
