package Code.CTCI.CTCI_SOURCE.other.Ch_16_Moderate.Q16_12_XML_Encoding;

public class Attribute {
    public String tag;
    public String value;

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
