#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <vector>

using namespace std;

class SparseMatrix {
public:
    static void description() {
        cout << R"(SparseMatrix
    Design and implement a Class called "SparseMatrix", which is defined as a VERY big matrix of
     floats with mostly ZEROs
    NOTE: The matrix is too big to fit in to the memory if you store every single entry value.
          You are not expected to introduce a non-sparse matrix representation in transpose(),
     multiply() or as class variables
    Implement the constructor which takes in the dimension of the matrix, but not any values
    Implement the following methods
    * put - override an entry given a coordinate and a value
    * transpose - return a new instance of SparseMatrix that is a "diagonal flip" of itself.
    Here is an example of matrix transpose:
        1 0 0  => 1 3
        3 0 6     0 0
                  0 6
    * multiply - input is another SparseMatrix instance (called "other"), return a new SparseMatrix instance
     as a multiplication between "this" and "other".
     Here is an example of matrix multiplication:
        2by3 x 3by3 => 2by3 matrix
        1 2 3  x a b c  ->   [1a+2d+3g  1b+2e+3h 1c+2f+3i]
        4 5 6    d e f       [4a+5d+6g  ...      ...     ]
                 g h i
    For each method you implement, comment on their runtime complexities.
    Assuming the dimension of the matrix you represent is A by B, and that of the "other" matrix in
     multiplication is "B by C".)" << endl;
    }

    SparseMatrix(int row, int column) : row_internal(row), column_internal(column) {}

    SparseMatrix(int row, int column, const vector<vector<int>> &cells) : SparseMatrix(row, column) {
        for (auto cell: cells) {
            put(cell[0], cell[1], cell[2]);
        }
    }

    void put(int row, int column, int value) {
        if ((row < 0) || (row > this->row_internal)) {
            throw runtime_error("Error: Row value out of bounds");
        }
        if ((column < 0) || (column > this->column_internal)) {
            throw runtime_error("Error: Column value out of bounds");
        }
        if (!this->map_internal.count(row)) {
            this->map_internal[row] = map<int, int>();
        }
        if (value != 0) {
            this->map_internal[row][column] = value;
        } else {
            // 0's are not stored, so this is actually a remove operation
            this->map_internal[row].erase(column);
            if (this->map_internal[row].empty()) {
                this->map_internal.erase(row);
            }
        }
    }

    SparseMatrix transpose() {
        SparseMatrix result = SparseMatrix(this->column_internal, this->row_internal);
        for (const auto &row: this->map_internal) {
            for (auto column: row.second) {
                result.put(column.first, row.first, column.second);
            }
        }
        return result;
    }

    SparseMatrix multiply(SparseMatrix input) {
        if (this->getColumn() != input.getRow()) {
            throw runtime_error("Error: column count not equal to target row count");
        }
        SparseMatrix result = SparseMatrix(this->column_internal, this->row_internal);
        for (int row = 0; row < this->row_internal; row++) {
            if (this->map_internal.count(row)) {
                auto targetRow = getRowValues(row);
                for (int column = 0; column < this->column_internal; column++) {
                    auto targetColumn = input.getColumnValues(column);
                    auto multiplied = multiply(targetRow, targetColumn, this->column_internal);
                    if (multiplied != 0) {
                        result.put(row, column, multiplied);
                    }
                }
            }
        }
        return result;
    }

    [[nodiscard]] int getRow() const {
        return this->row_internal;
    }

    [[nodiscard]] int getColumn() const {
        return this->column_internal;
    }

    vector<vector<int>> getCells() {
        vector<vector<int>> result;
        for (const auto &row: this->map_internal) {
            for (const auto &column: row.second) {
                serializeCell(result, row.first, column.first, column.second);
            }
        }
        return result;
    }

    string toString() {
        string result = "(";
        result.append(to_string(this->row_internal));
        result.append(", ");
        result.append(to_string(this->column_internal));
        result.append(", {");
        auto cells = getCells();
        if (!cells.empty()) {
            result.append(toStringCell(cells[0]));
        }
        if (cells.size() > 1) {
            for (int cell = 1; cell < cells.size(); cell++) {
                result.append(", ");
                result.append(toStringCell(cells[cell]));
            }
        }
        result.append("})");
        return result;
    }

private:
    int row_internal;
    int column_internal;
    map<int, map<int, int>> map_internal;

    map<int, int> getColumnValues(int column) {
        map<int, int> result;
        for (int row = 0; row < this->row_internal; row++) {
            if (this->map_internal.count(row)) {
                if (this->map_internal[row].count(column)) {
                    result[row] = this->map_internal[row][column];
                }
            }
        }
        return result;
    }

    map<int, int> getRowValues(int row) {
        map<int, int> result;
        if (this->map_internal.count(row)) {
            for (int column = 0; column < this->column_internal; column++)
                if (this->map_internal[row].count(column)) {
                    result[column] = this->map_internal[row][column];
                }
        }
        return result;
    }

    static int multiply(map<int, int> multiplicand, map<int, int> multiplier, int length) {
        auto product = 0;
        for (int index = 0; index < length; index++) {
            if (multiplicand.count(index) && multiplier.count(index)) {
                product = multiplicand.at(index) * multiplier.at(index);
            }
        }
        return product;
    }

    static string toStringCell(vector<int> cell) {
        string result = "{";
        result.append(to_string(cell[0]));
        result.append(", ");
        result.append(to_string(cell[1]));
        result.append(", ");
        result.append(to_string(cell[2]));
        result.append("}");
        return result;
    }

    static void serializeCell(vector<vector<int>> &result, int row, int column, int data) {
        vector<int> cell{row, column, data};
        result.push_back(cell);
    }
};

#pragma clang diagnostic pop
