package Java.code.ctci.source.ch_16_Moderate.q16_12_XML_Encoding;

@SuppressWarnings("DuplicatedCode")
public class Attribute {
    public final String tag;
    public final String value;

    public Attribute(String t, String v) {
        tag = t;
        value = v;
    }

    public String getTagCode() {
        return switch (tag) {
            case "family" -> "1";
            case "person" -> "2";
            case "firstName" -> "3";
            case "lastName" -> "4";
            case "state" -> "5";
            default -> "--";
        };
    }
}
