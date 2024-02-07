#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ZERO_MATRIX_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ZERO_MATRIX_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/ZeroMatrix.h"

TEST(ZeroMatrixTest, description) {
    testing::internal::CaptureStdout();
    ZeroMatrix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ZeroMatrixTest, zeroMatrix_1) {
    vector<vector<int>> expected{{1, 0, 3},
                                 {0, 0, 0},
                                 {7, 0, 9}};
    vector<vector<int>> matrix = {{1, 2, 3},
                                  {4, 0, 6},
                                  {7, 8, 9}};
    auto result = ZeroMatrix::zeroMatrix(matrix);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected.at(index), result.at(index));
    }
}

TEST(ZeroMatrixTest, zeroMatrixInPlace_1) {
    vector<vector<int>> expected{{1, 0, 3},
                                 {0, 0, 0},
                                 {7, 0, 9}};
    vector<vector<int>> matrix = {{1, 2, 3},
                                  {4, 0, 6},
                                  {7, 8, 9}};
    ZeroMatrix::zeroMatrixInPlace(&matrix);
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected.at(index), matrix.at(index));
    }
}

#endif