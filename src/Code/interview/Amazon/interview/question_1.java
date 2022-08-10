package Code.interview.Amazon.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class process_records {
  /*
  For a user there is essential data: Userid, Name, ...
  For a user there is non essential data: login time, search history,
  The first design question was to implement a delete button that removes non essential data and than return success or
   failure.
  What log points would be used?
  */

    Table data = new Table();

    public void printTable() {
        this.data.printTable();
    }

    public String removeRowByUserID(int userID) {
        List<Integer> data = this.getRowByUserID(userID);
        if (data.isEmpty()) {
            return "No Record";
        }
        Collections.sort(data, Collections.reverseOrder());
        for (int rowID : data) {
            this.delete(rowID);
        }
        // Validation
        data = this.getRowByUserID(userID);
        if (data.isEmpty()) {
            return "Success";
        } else {
            return "Failure";
        }
    }

    private void delete(int rowId) {
        this.data.removeRow(rowId);
    }

    private List<Integer> getRowByUserID(int userID) {
        return this.data.getRowsByData(1, userID);
    }

    public List<Integer> getRowByUser(String user) {
        return this.data.getRowsByData(2, user);
    }

    public void insert(Object... data) {
        ArrayList<Object> row = new ArrayList<>(Arrays.asList(data));
        this.data.addRow(row);
    }
}

class Table {
    List<ArrayList<Object>> data = new ArrayList<>();
    int index = 0;

    public Object getValueAt(int row, int col) {
        return this.data.get(row).get(col);
    }

    public Object getRow(int row) {
        return this.data.get(row);
    }

    public void removeRow(int row) {
        this.data.remove(row);
    }

    public Object addRow(ArrayList<Object> row) {
        row.add(0, this.index++);
        return this.data.add(row);
    }

    public List<Integer> getRowsByData(int column, Object data) {
        List<Integer> returnList = new ArrayList<>();
        for (int index = 0; index < this.data.size(); index++) {
            if (data instanceof Integer) {
                if ((int) this.data.get(index).get(column) == (int) data) {
                    returnList.add(index);
                }
            } else if (data instanceof String) {
                if (this.data.get(index).get(column).equals(data)) {
                    returnList.add(index);
                }
            }
        }
        return returnList;
    }

    public void printTable() {
        for (ArrayList<Object> row : this.data) {
            System.out.println(row);
        }
    }
}
