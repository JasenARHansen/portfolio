#include "ZeroMatrix.h"
#include <iostream>

using namespace ctci;

void ZeroMatrix::description() {
    std::cout << R"(Arrays and Strings: Zero Matrix
    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column
     are set to 0.)" << std::endl;
}

std::vector<std::vector<int>> ZeroMatrix::zeroMatrix(std::vector<std::vector<int>> matrix) {
    std::vector<std::vector<int>> result;
    std::vector<int> zeroRow;
    std::vector<int> zeroColumn;
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

void ZeroMatrix::zeroMatrixInPlace(std::vector<std::vector<int>> *matrix) {
    std::vector<int> zeroRow;
    std::vector<int> zeroColumn;
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