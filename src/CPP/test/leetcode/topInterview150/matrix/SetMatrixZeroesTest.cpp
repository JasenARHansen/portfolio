#ifndef LEETCODE_TOP_INTERVIEW_150_SET_MATRIX_ZEROES_TEST
#define LEETCODE_TOP_INTERVIEW_150_SET_MATRIX_ZEROES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/matrix/SetMatrixZeroes.cpp"

TEST(SetMatrixZeroesTest, description) {
    testing::internal::CaptureStdout();
    SetMatrixZeroes::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SetMatrixZeroesTest, setZeroes_1) {
    vector<vector<int>> expected{{1, 0, 1},
                                 {0, 0, 0},
                                 {1, 0, 1}};
    vector<vector<int>> matrix{{1, 1, 1},
                               {1, 0, 1},
                               {1, 1, 1}};
    SetMatrixZeroes::setZeroes(matrix);
    EXPECT_EQ(expected, matrix);
}

TEST(SetMatrixZeroesTest, setZeroes_2) {
    vector<vector<int>> expected{{0, 0, 0, 0},
                                 {0, 4, 5, 0},
                                 {0, 3, 1, 0}};
    vector<vector<int>> matrix{{0, 1, 2, 0},
                               {3, 4, 5, 2},
                               {1, 3, 1, 5}};
    SetMatrixZeroes::setZeroes(matrix);
    EXPECT_EQ(expected, matrix);
}

TEST(SetMatrixZeroesTest, setZeroes_fail_1) {
    // 1 ≤ matrix.length
    auto size = 1 - 1;
    vector<vector<int>> matrix(size);
    EXPECT_EXIT(SetMatrixZeroes::setZeroes(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(SetMatrixZeroesTest, setZeroes_fail_2) {
    // matrix.length ≤ 200
    auto size = 200 + 1;
    vector<vector<int>> matrix(size);
    EXPECT_EXIT(SetMatrixZeroes::setZeroes(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(SetMatrixZeroesTest, setZeroes_fail_3) {
    // 1 ≤ matrix[i].length
    auto size = 1 - 1;
    vector<vector<int>> matrix{vector<int>(size)};
    EXPECT_EXIT(SetMatrixZeroes::setZeroes(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(SetMatrixZeroesTest, setZeroes_fail_4) {
    // matrix[i].length ≤ 200
    auto size = 200 + 1;
    vector<vector<int>> matrix{vector<int>(size)};
    EXPECT_EXIT(SetMatrixZeroes::setZeroes(matrix), ::testing::ExitedWithCode(3), "");
}

#endif