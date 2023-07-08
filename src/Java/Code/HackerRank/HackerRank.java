package Java.Code.HackerRank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@SuppressWarnings({"SpellCheckingInspection", "unused", "deprecation"})
public class HackerRank {

  private static final String querryTemplate =
          "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s";
  private static final String pageTemplate =
          "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d";

  public static List<String> http(String substr) throws IOException, JSONException {
    // http://chillyfacts.com/java-send-http-getpost-request-and-read-json-response/
    String initialString = String.format(querryTemplate, substr);

    URL url = new URL(initialString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    connection.disconnect();

    // Read JSON response and print
    JSONObject myResponse = new JSONObject(response.toString());

    List<String> movies = new ArrayList<>();
    int pages = myResponse.getInt("total_pages");
    for (int page = 1; page <= pages; page++) {
      String pageString = String.format(pageTemplate, substr, page);
      url = new URL(pageString);
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");

      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      response = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      connection.disconnect();

      JSONArray data = myResponse.getJSONArray("data");
      for (int i = 0; i < data.length(); i++) {
        JSONObject movie = data.getJSONObject(i);
        String name = movie.getString("Title");
        movies.add(name);
      }
    }
    Collections.sort(movies);
    return movies;
  }

  public static String stringMerge(String a, String b) {
    StringBuilder returnString = new StringBuilder();
    int minLength = Math.min(a.length(), b.length());
    for (int i = 0; i < minLength; i++) {
      returnString.append(a.charAt(i));
      returnString.append(b.charAt(i));
    }
    if (a.length() > b.length()) {
      returnString.append(a.substring(b.length()));
    } else {
      returnString.append(b.substring(a.length()));
    }
    return returnString.toString();
  }

  public static String isSubset(String[] master, String[] secondary) {

    Map<String, Integer> masterMap = new HashMap<>();
    for (String element : master) {
      if (masterMap.containsKey(element)) {
        masterMap.put(element, masterMap.get(element) + 1);
      } else {
        masterMap.put(element, 1);
      }
    }
    for (String element : secondary) {
      if (masterMap.containsKey(element)) {
        int count = masterMap.get(element);
        if (count == 0) {
          return "No";
        } else {
          masterMap.put(element, count - 1);
        }
      } else {
        return "No";
      }
    }
    return "Yes";
  }

  public static String isBalanced(String input) {
    // Complete the function isBalanced in the editor below. It must return
    // a string: YES if the sequence is balanced or NO if it is not.
    // isBalanced has the following parameter(s): s: a string of brackets
    // All chracters in the sequences ∈ { {, }, (, ), [, ] }.

    Stack<String> stackOfBrackets = new Stack<>();
    for (int index = 0; index < input.length(); index++) {
      String testString = Character.toString(input.charAt(index));
      switch (testString) {
        case "{", "(", "[" -> stackOfBrackets.push(testString);
        case "}" -> {
          if (stackOfBrackets.isEmpty()) {
            return "NO";
          } else {
            String evalString = stackOfBrackets.pop();
            if (!evalString.equals("{")) {
              return "NO";
            }
          }
        }
        case ")" -> {
          if (stackOfBrackets.isEmpty()) {
            return "NO";
          } else {
            String evalString = stackOfBrackets.pop();
            if (!evalString.equals("(")) {
              return "NO";
            }
          }
        }
        case "]" -> {
          if (stackOfBrackets.isEmpty()) {
            return "NO";
          } else {
            String evalString = stackOfBrackets.pop();
            if (!evalString.equals("[")) {
              return "NO";
            }
          }
        }
      }
    }
    if (stackOfBrackets.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }
  }
}
