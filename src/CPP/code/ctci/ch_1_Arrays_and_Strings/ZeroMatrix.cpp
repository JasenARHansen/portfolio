#include "ZeroMatrix.h"
#include <iostream>

void ZeroMatrix::description() {
    cout << R"(Arrays and Strings: Zero Matrix
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column
     are set to 0.)" << endl;
}

vector<vector<int>> ZeroMatrix::zeroMatrix(vector<vector<int>> matrix) {
    vector<vector<int>> result;
    vector<int> zeroRow;
    vector<int> zeroColumn;
    for (auto row = 0; row < (int) matrix.size(); row++) {
        result.emplace_back();
        for (auto column = 0; column < matrix.at(0).size(); column++) {
            result.at(row).push_back(matrix[row][column]);
            if (matrix[row][column] == 0) {
                zeroRow.push_back(row);
                zeroColumn.push_back(column);
            }
        }
    }
    // Zero out row
    for (auto row: zeroRow) {
        for (auto column = 0; column < (int) matrix.at(0).size(); column++) {
            result[row][column] = 0;
        }
    }
    // Zero out column
    for (auto column: zeroColumn) {
        for (auto row = 0; row < (int) matrix.size(); row++) {
            result[row][column] = 0;
        }
    }
    return result;
}

void ZeroMatrix::zeroMatrixInPlace(vector<vector<int>> *matrix) {
    vector<int> zeroRow;
    vector<int> zeroColumn;
    for (auto row = 0; row < (int) matrix->size(); row++) {
        for (auto column = 0; column < matrix->at(0).size(); column++) {
            if (matrix->operator[](row)[column] == 0) {
                zeroRow.push_back(row);
                zeroColumn.push_back(column);
            }
        }
    }
    // Zero out row
    for (auto row: zeroRow) {
        for (auto column = 0; column < (int) matrix->at(0).size(); column++) {
            matrix->operator[](row)[column] = 0;
        }
    }
    // Zero out column
    for (auto column: zeroColumn) {
        for (auto row = 0; row < (int) matrix->size(); row++) {
            matrix->operator[](row)[column] = 0;
        }
    }
}