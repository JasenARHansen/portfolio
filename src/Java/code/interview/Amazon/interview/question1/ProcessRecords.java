package Java.code.interview.Amazon.interview.question1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessRecords {
    final Table data = new Table();
    final List<String> essential = new ArrayList<>(Arrays.asList("Userid", "Name"));

    public ProcessRecords() {
        // Create a class constructor for the Main class
        this.setEssential();
    }

    private void setEssential() {
        this.data.setEssential(essential);
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

    public void deleteNonEssential() {
        boolean success = this.data.deleteNonEssential();
        if (success) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }

    public void deleteRow(int rowId) {
        this.data.deleteRow(rowId);
    }

    public void deleteRowByData(Object @NotNull ... data) {
        this.data.deleteRowByData(data);
    }

    public void deleteRowByUserID(int UserID) {
        this.data.deleteRowByUserID(UserID);
    }

    public void insert(Object @NotNull ... row) {
        this.data.insert(row);
    }

    public void printRow(int row) {
        this.data.printRow(row);
    }

    public void printRowByData(Object @NotNull ... data) {
        this.data.printRowByData(data);
    }

    public void printRowByUserID(int UserID) {
        this.data.printRowByUserID(UserID);
    }

    public void printTable() {
        this.data.printTable();
    }
}
