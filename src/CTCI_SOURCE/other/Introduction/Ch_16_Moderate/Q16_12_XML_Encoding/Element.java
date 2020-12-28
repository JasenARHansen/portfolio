package CTCI_SOURCE.other.Introduction.Ch_16_Moderate.Q16_12_XML_Encoding;

import java.util.ArrayList;

public class Element {
    public ArrayList<Attribute> attributes;
    public ArrayList<Element> children;
    public String name;
    public String value;

    public Element(String n) {
        name = n;
        attributes = new ArrayList<>();
        children = new ArrayList<>();
    }

    public Element(String n, String v) {
        name = n;
        value = v;
        attributes = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getNameCode() {
        return switch (name) {
            case "family" -> "1";
            case "person" -> "2";
            case "firstName" -> "3";
            case "lastName" -> "4";
            case "state" -> "5";
            default -> "--";
        };
    }

    public void insert(Attribute attribute) {
        attributes.add(attribute);
    }

    public void insert(Element child) {
        children.add(child);
    }
}
