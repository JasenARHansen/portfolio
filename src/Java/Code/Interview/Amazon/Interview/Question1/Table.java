package Java.Code.Interview.Amazon.Interview.Question1;

import java.util.*;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"SuspiciousMethodCalls", "DuplicatedCode"})
public class Table {
  List<String> essential = new ArrayList<>();
  List<String> keys = new ArrayList<>();
  Map<String, Integer> keys_count = new HashMap<>();
  List<Integer> rows = new ArrayList<>();
  Map<Integer, Map<String, Object>> data = new HashMap<>();

  public static void getDescription() {
    System.out.println(
        """
                A table that implements the data structure for ProcessRecords."""
            .indent(2));
  }

  public void setEssential(List<String> essential) {
    this.essential = essential;
  }

  private List<Integer> selectRowByData(Object @NotNull ... data) {
    List<Integer> rowIndex = new ArrayList<>();
    int index = 0;
    while (data.length >= index + 1) {
      String key = (String) data[index];
      Object value = data[index + 1];
      for (Map<String, Object> values : this.data.values()) {
        if (values.containsKey(key) && values.get(key) == value) {
          rowIndex.add(this.rows.indexOf(values.get("Userid")));
        }
      }
      index += 2;
    }
    Collections.sort(rowIndex);
    return rowIndex;
  }

  public void insert(Object @NotNull ... row) {
    String key = "Userid";
    int Userid = (int) row[0];
    if (!this.rows.contains(Userid)) {
      this.rows.add(Userid);
      this.data.put(Userid, new HashMap<>());
      this.data.get(Userid).put(key, Userid);
      if (!this.keys.contains(key)) {
        this.keys.add(key);
      }
      if (this.keys_count.containsKey(key)) {
        this.keys_count.put(key, (this.keys_count.get(key) + 1));
      } else {
        this.keys_count.put(key, 1);
      }
    }
    int index = 1;
    while (row.length >= index + 1) {
      key = (String) row[index];
      if (!this.essential.contains(key)) {
        if (this.keys.contains(key)) {
          if (!this.data.get(Userid).containsKey(key)) {
            this.keys_count.put(key, (this.keys_count.get(key) + 1));
          }
        } else {
          this.keys.add(key);
          this.keys_count.put(key, 1);
        }
      }
      Object value = row[index + 1];
      this.data.get(Userid).put(key, value);
      index += 2;
    }
  }

  public boolean deleteNonEssential() {
    try {
      List<String> remove = new ArrayList<>();
      for (String key : this.keys) {
        if (!this.essential.contains(key)) {
          remove.add(key);
        }
      }
      for (String key : remove) {
        this.keys.remove(key);
      }
      remove.clear();
      for (String key : this.keys_count.keySet()) {
        if (!this.essential.contains(key)) {
          remove.add(key);
        }
      }
      for (String key : remove) {
        this.keys.remove(key);
      }
      for (Map<String, Object> values : data.values()) {
        remove.clear();
        for (String key : values.keySet()) {
          if (!this.essential.contains(key)) {
            remove.add(key);
          }
        }
        for (String key : remove) {
          values.remove(key);
        }
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void deleteRow(Integer... rows) {
    List<Integer> rowIndex = Arrays.asList(rows);
    rowIndex.sort(Collections.reverseOrder());
    for (int index : rowIndex) {
      int Userid = this.rows.get(index);
      this.rows.remove(index);
      for (String key : this.data.get(Userid).keySet()) {
        if (!this.essential.contains(key)) {
          int count = this.keys_count.get(key) - 1;
          if (count > 0) {
            this.keys_count.put(key, count);
          } else {
            this.keys_count.remove(key);
            this.keys.remove(key);
          }
        }
      }
      this.data.remove(Userid);
    }
  }

  public void deleteRowByUserID(int UserID) {
    int index = this.rows.indexOf(UserID);
    this.deleteRow(index);
  }

  public void deleteRowByData(Object @NotNull ... data) {
    List<Integer> result = this.selectRowByData(data);
    this.deleteRow(result.toArray(Integer[]::new));
  }

  public void printTable() {
    // Print header
    StringBuilder header = new StringBuilder(String.format("%5s", "Row"));
    for (String key : this.essential) {
      header.append(String.format("%10s", key));
    }
    for (String key : this.keys) {
      if (!this.essential.contains(key)) {
        header.append(String.format("%10s", key));
      }
    }
    System.out.printf("%s\n", header);
    // Print rows
    for (int Userid : this.rows) {
      StringBuilder line = new StringBuilder(String.format("%5s", this.rows.indexOf(Userid)));
      for (String key : this.essential) {
        line.append(String.format("%10s", this.data.get(Userid).getOrDefault(key, "")));
      }
      for (String key : this.keys) {
        if (!this.essential.contains(key)) {
          line.append(String.format("%10s", this.data.get(Userid).getOrDefault(key, "")));
        }
      }
      System.out.printf("%s\n", line);
    }
  }

  public void printRow(Integer... rows) {
    List<Integer> rowIndex = Arrays.asList(rows);
    Collections.sort(rowIndex);
    // Print header
    StringBuilder header = new StringBuilder(String.format("%5s", "Row"));
    for (String key : this.essential) {
      header.append(String.format("%10s", key));
    }
    for (String key : this.keys) {
      if (!this.essential.contains(key)) {
        header.append(String.format("%10s", key));
      }
    }
    System.out.printf("%s\n", header);
    for (int row : rows) {
      // Print row
      int Userid = this.rows.get(row);
      StringBuilder line = new StringBuilder(String.format("%5s", row));
      for (String key : this.essential) {
        line.append(String.format("%10s", this.data.get(Userid).getOrDefault(key, "")));
      }
      for (String key : this.keys) {
        if (!this.essential.contains(key)) {
          line.append(String.format("%10s", this.data.get(Userid).getOrDefault(key, "")));
        }
      }
      System.out.printf("%s\n", line);
    }
  }

  public void printRowByUserID(int UserID) {
    // Print header
    StringBuilder header = new StringBuilder(String.format("%5s", "Row"));
    for (String key : this.essential) {
      header.append(String.format("%10s", key));
    }
    for (String key : this.keys) {
      if (!this.essential.contains(key)) {
        header.append(String.format("%10s", key));
      }
    }
    System.out.printf("%s\n", header);
    // Print row
    StringBuilder line = new StringBuilder(String.format("%5s", this.rows.indexOf(UserID)));
    for (String key : this.essential) {
      line.append(String.format("%10s", this.data.get(UserID).getOrDefault(key, "")));
    }
    for (String key : this.keys) {
      if (!this.essential.contains(key)) {
        line.append(String.format("%10s", this.data.get(UserID).getOrDefault(key, "")));
      }
    }
    System.out.printf("%s\n", line);
  }

  public void printRowByData(Object @NotNull ... data) {
    List<Integer> result = this.selectRowByData(data);
    this.printRow(result.toArray(Integer[]::new));
  }
}
