package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_05_Cache;

public class Question {

  public static String[] generateResults(int i) {
    return new String[] {"resultA" + i, "resultB" + i, "resultC" + i};
  }

  public static void main(String[] args) {
    Cache cache = new Cache();
    for (int i = 0; i < 20; i++) {
      String query = "query" + i;
      cache.insertResults(query, generateResults(i));
      if (i == 9 || i == 16 || i == 19) {
        cache.getResults("query" + 2);
        cache.getResults("query" + 6);
        cache.getResults("query" + 9);
      }
    }
    for (int i = 0; i < 30; i++) {
      String query = "query" + i;
      String[] results = cache.getResults(query);
      System.out.print(query + ": ");
      if (results == null) {
        System.out.print("null");
      } else {
        for (String s : results) {
          System.out.print(s + ", ");
        }
      }
      System.out.println();
    }
  }
}
