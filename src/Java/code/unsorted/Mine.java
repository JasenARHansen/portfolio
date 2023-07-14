package Java.code.unsorted;

import java.util.*;

@SuppressWarnings({"DuplicatedCode", "DataFlowIssue"})
public class Mine {

  public static int[] mergeAndSort(int[]... sourceArrays) {
    List<Integer> merged = new ArrayList<>();
    for (int[] array : sourceArrays) {
      merged.addAll(Arrays.stream(array).boxed().toList());
    }
    int[] returnArray = new int[merged.size()];
    Iterator<Integer> iterator = merged.iterator();
    for (int i = 0; i < returnArray.length; i++) {
      returnArray[i] = iterator.next();
    }
    Arrays.sort(returnArray);
    return returnArray;
  }

  public static int search(int element, int[] array1, int[] array2) {
    if ((element < 1) || (element > (array1.length + array2.length))) {
      return -1;
    }
    Arrays.sort(array1); /* To pre-sort the contents of the Array. */
    Arrays.sort(array2); /* To pre-sort the contents of the Array. */
    int value = -1;
    int counter = 0;
    int index1 = 0;
    int index2 = 0;
    while (counter++ < element) {
      if (index1 == array1.length && index2 < array2.length) {
        value = array2[index2];
        index2++;
      } else if (index2 == array2.length && index1 < array1.length) {
        value = array1[index1];
        index1++;
      } else if (array1[index1] <= array2[index2]) {
        value = array1[index1];
        index1++;
      } else {
        value = array2[index2];
        index2++;
      }
    }
    return value;
  }

  public static int searchComplex(int element, int[]... sourceArrays) {
    int totalCount = 0;
    for (int[] array : sourceArrays) {
      Arrays.sort(array); /* To pre-sort the contents of the Array. */
      totalCount += array.length; /* Ignoring the NPE for simplicity. */
    }
    if ((element < 1) || (element > totalCount)) {
      return Integer.MIN_VALUE;
    }
    int[] indexes = new int[sourceArrays.length];
    int value = Integer.MIN_VALUE;
    int counter = 0;
    while (counter++ < element) {
      int indexToAdjust = 0;
      Integer currentValue = null;
      for (int i = 0; i < sourceArrays.length; i++) {
        if (indexes[i] < sourceArrays[i].length) {
          if ((currentValue == null) || (currentValue > sourceArrays[i][indexes[i]])) {
            indexToAdjust = i;
            currentValue = sourceArrays[i][indexes[i]];
          }
        }
      }
      value = currentValue;
      indexes[indexToAdjust]++;
    }
    return value;
  }

  public static String highestAssociativity() {
    Scanner scan = new Scanner(System.in);
    float AssociativityThreshold = scan.nextFloat();
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
          if (itemAssociativity > AssociativityThreshold) {
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
        if (itemAssociativity > AssociativityThreshold) {
          associativityNode.addAssociation(secondItem);
        }
        /* Add to associativityNodeList. */
        associativityNodeList.add(associativityNode);
      }
    }
    scan.close();
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
    return associativityHeadList.get(0);
  }

  public static void loopTest() {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      int n = scan.nextInt();
      List<Integer> loopOut = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        int sum = a;
        for (int k = 0; k <= j; k++) {
          sum += b * Math.pow(2, k);
        }
        loopOut.add(sum);
      }
      StringBuilder output = new StringBuilder();
      for (int value : loopOut) {
        output.append(value).append(" ");
      }
      System.out.format("\t%s\n", output.toString().trim());
    }
    scan.close();
  }

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

    public String getName() {
      return this.name;
    }

    public List<String> getAssociativity() {
      List<String> returnList = new ArrayList<>();
      return getAssociationList(returnList);
    }

    public String toString() {
      return getAssociativity().toString();
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

    private void replaceAssociation(AssociativityNode associationNode) {
      for (int i = 0; i < associations.size(); i++) {
        if (associations.get(i).getName().equals(associationNode.getName())) {
          associations.set(i, associationNode);
          break;
        }
      }
    }
  }
}
