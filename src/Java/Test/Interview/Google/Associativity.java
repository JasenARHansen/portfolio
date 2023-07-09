package Java.Test.Interview.Google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class Associativity {
  public static void main(String[] args) {
    Associativity associativity = new Associativity();
    associativity.highestAssociativity();
  }

  public void highestAssociativity() {
    Scanner scan = new Scanner(System.in);
    float associativityThreshold = scan.nextFloat();
    int associationCount = scan.nextInt();
    List<AssociativityNode> associativityNodeList = new ArrayList<>();
    for (int i = 0; i < associationCount; i++) {
      String firstItem = scan.next();
      String secondItem = scan.next();
      float itemAssociativity = scan.nextFloat();
      /* Create all AssociativityNodes. */
      boolean found = false;
      for (AssociativityNode associativityNode : associativityNodeList) {
        if (associativityNode.getName().equals(firstItem)) {
          if (itemAssociativity > associativityThreshold) {
            associativityNode.addAssociation(secondItem);
            found = true;
            break;
          }
        }
      }
      if (!found) {
        boolean duplicate = false;
        for (AssociativityNode associativityNode : associativityNodeList) {
          if (associativityNode.getName().equals(firstItem)) {
            duplicate = true;
            break;
          }
        }
        if (duplicate) {
          continue;
        }
        AssociativityNode associativityNode = new AssociativityNode(firstItem);
        if (itemAssociativity > associativityThreshold) {
          associativityNode.addAssociation(secondItem);
        }
        /* Add to associativityNodeList. */
        associativityNodeList.add(associativityNode);
      }
    }
    /* Create proper links in associativityNodeList. */
    for (AssociativityNode associativityNode : associativityNodeList) {
      for (int i = 0; i < associativityNode.getAssociationCount(); i++) {
        for (AssociativityNode associativityNodeInner : associativityNodeList) {
          if (associativityNode
              .getAssociations(i)
              .getName()
              .equals(associativityNodeInner.getName())) {
            associativityNode.replaceAssociation(associativityNodeInner);
            break;
          }
        }
      }
    }
    /* Determine AssociativityNode with the greatest associativity. */
    int associativity = 0;
    List<String> associativityHeadList = new ArrayList<>();
    for (AssociativityNode associativityNode : associativityNodeList) {
      List<String> associativityList = associativityNode.getAssociativity();
      if (associativityList.size() > associativity) {
        associativity = associativityList.size();
        associativityHeadList.clear();
      }
      if (associativityList.size() >= associativity) {
        associativityHeadList.add(associativityList.get(0));
      }
    }
    Collections.sort(associativityHeadList);
    System.out.println(associativityHeadList.get(0));
  }

  @SuppressWarnings("DuplicatedCode")
  public static class AssociativityNode {
    private final List<AssociativityNode> associations;
    private final String name;

    public AssociativityNode(String name) {
      this.name = name;
      associations = new ArrayList<>();
    }

    public void addAssociation(String name) {
      if (!containsName(name)) {
        AssociativityNode association = new AssociativityNode(name);
        associations.add(association);
      }
    }

    private boolean containsName(String name) {
      for (AssociativityNode association : associations) {
        if (association.getName().equals(name)) {
          return true;
        }
      }
      return false;
    }

    private int getAssociationCount() {
      return associations.size();
    }

    private List<String> getAssociationList(List<String> returnList) {
      if (returnList.contains(this.name)) {
        return returnList;
      }
      returnList.add(this.name);
      for (AssociativityNode association : associations) {
        for (String element : association.getAssociationList(returnList)) {
          if (!returnList.contains(element)) {
            returnList.add(element);
          }
        }
      }
      return returnList;
    }

    private AssociativityNode getAssociations(int index) {
      return associations.get(index);
    }

    public List<String> getAssociativity() {
      List<String> returnList = new ArrayList<>();
      return getAssociationList(returnList);
    }

    public String getName() {
      return this.name;
    }

    private void replaceAssociation(AssociativityNode associationNode) {
      for (int i = 0; i < associations.size(); i++) {
        if (associations.get(i).getName().equals(associationNode.getName())) {
          associations.set(i, associationNode);
          break;
        }
      }
    }

    public String toString() {
      return getAssociativity().toString();
    }
  }
}
