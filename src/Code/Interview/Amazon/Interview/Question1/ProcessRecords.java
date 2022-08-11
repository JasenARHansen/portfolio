package Code.Interview.Amazon.Interview.Question1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessRecords {
  /*
  For a user there is essential data: Userid, Name, ...
  For a user there is non-essential data: login time, search history,
  The first design question was to implement a delete button that removes non-essential data and then return success or
   failure.
  What log points would be used?
  */

    List<String> essential = new ArrayList<>(Arrays.asList("Userid", "Name"));

    Table data = new Table();

    // Create a class constructor for the Main class
    public ProcessRecords() {
        this.setEssential();
    }

    public static void getDescription() {
        System.out.println("""
                For a user there is essential data: Userid, Name, ...
                For a user there is non-essential data: login time, search history,
                The first design question was to implement a delete button that removes non-essential data and then return success or
                 failure.
                What log points would be used?""".indent(2));
    }

    public void setEssential() {
        this.data.setEssential(essential);
    }

    public void printTable() {
        this.data.printTable();
    }

    public void delete(int rowId) {
        this.data.removeRow(rowId);
    }

    public void deleteNonEssential() {
        boolean success = this.data.deleteNonEssential();
        if (success) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }

    public void insert(Object @NotNull ... row) {
        this.data.addRow(row);

    }
}
