package Java.Code.Interview.Amazon.Interview.Question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ProcessRecords {
  List<String> essential = new ArrayList<>(Arrays.asList("Userid", "Name"));
  Table data = new Table();
  public ProcessRecords() {
    // Create a class constructor for the Main class
    this.setEssential();
  }

  public static void getDescription() {
    System.out.println(
        """
                For a user there is essential data: Userid, Name, ...
                For a user there is non-essential data: login time, search history,
                The first design question was to implement a delete button that removes non-essential data and then return success or
                 failure.
                What log points would be used?"""
            .indent(2));
  }

  private void setEssential() {
    this.data.setEssential(essential);
  }

  public void deleteNonEssential() {
    boolean success = this.data.deleteNonEssential();
    if (success) {
      System.out.println("Success");
    } else {
      System.out.println("Failure");
    }
  }

  public void printTable() {
    this.data.printTable();
  }

  public void printRow(int row) {
    this.data.printRow(row);
  }

  public void printRowByUserID(int UserID) {
    this.data.printRowByUserID(UserID);
  }

  public void printRowByData(Object @NotNull ... data) {
    this.data.printRowByData(data);
  }

  public void deleteRow(int rowId) {
    this.data.deleteRow(rowId);
  }

  public void deleteRowByUserID(int UserID) {
    this.data.deleteRowByUserID(UserID);
  }

  public void deleteRowByData(Object @NotNull ... data) {
    this.data.deleteRowByData(data);
  }

  public void insert(Object @NotNull ... row) {
    this.data.insert(row);
  }
}
