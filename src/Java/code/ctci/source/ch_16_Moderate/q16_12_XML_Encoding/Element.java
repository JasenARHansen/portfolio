package Java.code.ctci.source.ch_16_Moderate.q16_12_XML_Encoding;

import java.util.ArrayList;

@SuppressWarnings("DuplicatedCode")
public class Element {
  public final ArrayList<Attribute> attributes;
  public final ArrayList<Element> children;
  public final String name;
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
