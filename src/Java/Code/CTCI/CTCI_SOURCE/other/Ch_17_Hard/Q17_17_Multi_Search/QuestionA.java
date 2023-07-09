package Java.Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_17_Multi_Search;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.HashMapList;
import java.util.ArrayList;

public class QuestionA {
  public static void main(String[] args) {
    String big = "mississippi";
    String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
    HashMapList<String, Integer> locations = searchAll(big, smalls);
    System.out.println(locations);
  }

  public static HashMapList<String, Integer> searchAll(String big, String[] smalls) {
    HashMapList<String, Integer> lookup = new HashMapList<>();
    for (String small : smalls) {
      ArrayList<Integer> locations = search(big, small);
      lookup.put(small, locations);
    }
    return lookup;
  }

  public static ArrayList<Integer> search(String big, String small) {
    ArrayList<Integer> locations = new ArrayList<>();
    for (int i = 0; i < big.length() - small.length() + 1; i++) {
      if (isSubstringAtLocation(big, small, i)) {
        locations.add(i);
      }
    }
    return locations;
  }

  public static boolean isSubstringAtLocation(String big, String small, int offset) {
    for (int i = 0; i < small.length(); i++) {
      if (big.charAt(offset + i) != small.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
