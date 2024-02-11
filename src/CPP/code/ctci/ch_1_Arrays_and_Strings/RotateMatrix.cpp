#include "RotateMatrix.h"
#include <iostream>

using namespace ctci;

void RotateMatrix::description() {
    std::cout << R"(Arrays and Strings: Rotate Matrix
    Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write
     a method to rotate the image by 90 degrees.
    Can you do this in place?
    Example:
        If the array is
            [[1, 2],
             [3, 4]]
        Then the rotated array becomes:
            [[3, 1],
             [4, 2]])" << std::endl;
}

std::vector<std::vector<int>> RotateMatrix::rotateMatrix(std::vector<std::vector<int>> matrix) {
    std::vector<std::vector<int>> result;
    for (auto column = 0; column < (int) matrix.at(0).size(); column++) {
        result.emplace_back();
        for (auto row = (int) matrix.size() - 1; row >= 0; row--) {
            result.at(column).push_back(matrix.at(row).at(column));
        }
    }
    return result;
}

void RotateMatrix::rotateMatrixInPlace(std::vector<std::vector<int>> *matrix) {
    int storage;
    for (int shell = 0; shell < (matrix->size() + 1) / 2; shell++) {
        // Top
        for (int space = 0; space < matrix->size() - 2 * shell - 1; space++) {
            // Top -> Storage : 1 -> S
            storage = matrix->operator[](shell)[space + shell];
            // Left -> Top : 4 -> 1
            matrix->operator[](shell)[space + shell] = matrix->operator[](matrix->size() - 1 - shell - space)[shell];
            // Bottom -> Left : 3 -> 4
            matrix->operator[](matrix->size() - 1 - shell - space)[shell] = matrix->operator[](
                    matrix->size() - 1 - shell)[matrix->size() - 1 - shell - space];
            // Right --> Bottom : 2 -> 3
            matrix->operator[](matrix->size() - 1 - shell)[matrix->size() - 1 - shell - space] =
                    matrix->operator[](shell + space)[matrix->size() - 1 - shell];
            // Storage -> Right : S -> 2
            matrix->operator[](shell + space)[matrix->size() - 1 - shell] = storage;
        }
    }
}