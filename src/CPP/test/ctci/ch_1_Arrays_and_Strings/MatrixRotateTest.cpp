#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ROTATE_MATRIX_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ROTATE_MATRIX_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/RotateMatrix.h"

using namespace ctci;
TEST(CtCI_RotateMatrixTest, description) {
    testing::internal::CaptureStdout();
    RotateMatrix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_RotateMatrixTest, rotateMatrix_1) {
    std::vector<std::vector<int>> expected{{7, 4, 1},
                                           {8, 5, 2},
                                           {9, 6, 3}};
    std::vector<std::vector<int>> matrix = {{1, 2, 3},
                                            {4, 5, 6},
                                            {7, 8, 9}};
    auto result = RotateMatrix::rotateMatrix(matrix);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected.at(index), result.at(index));
    }
}

TEST(CtCI_RotateMatrixTest, rotateMatrix_2) {
    std::vector<std::vector<int>> expected{{9,  5, 1},
                                           {10, 6, 2},
                                           {11, 7, 3},
                                           {12, 8, 4}};
    std::vector<std::vector<int>> matrix = {{1, 2,  3,  4},
                                            {5, 6,  7,  8},
                                            {9, 10, 11, 12}};
    auto result = RotateMatrix::rotateMatrix(matrix);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected.at(index), result.at(index));
    }
}

TEST(CtCI_RotateMatrixTest, rotateMatrixInPlace_1) {
    std::vector<std::vector<int>> expected{{7, 4, 1},
                                           {8, 5, 2},
                                           {9, 6, 3}};
    std::vector<std::vector<int>> matrix = {{1, 2, 3},
                                            {4, 5, 6},
                                            {7, 8, 9}};
    RotateMatrix::rotateMatrixInPlace(&matrix);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected.at(index), matrix.at(index));
    }
}

#endif