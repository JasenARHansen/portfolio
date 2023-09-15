#ifndef LEETCODE_TOP_INTERVIEW_150_SPIRAL_ORDER_TEST
#define LEETCODE_TOP_INTERVIEW_150_SPIRAL_ORDER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/matrix/SpiralMatrix.cpp"  // NOLINT : Ignore .cpp import

TEST(SpiralMatrixTest, description) {
    testing::internal::CaptureStdout();
    SpiralMatrix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SpiralMatrixTest, spiralOrder_1) {
    vector<int> expected{1, 2, 3, 6, 9, 8, 7, 4, 5};
    vector<vector<int>> matrix{{1, 2, 3},
                               {4, 5, 6},
                               {7, 8, 9}};
    auto result = SpiralMatrix::spiralOrder(matrix);
    EXPECT_EQ(expected, result);
}

TEST(SpiralMatrixTest, spiralOrder_2) {
    vector<int> expected{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
    vector<vector<int>> matrix{{1, 2,  3,  4},
                               {5, 6,  7,  8},
                               {9, 10, 11, 12}};
    auto result = SpiralMatrix::spiralOrder(matrix);
    EXPECT_EQ(expected, result);
}

TEST(SpiralMatrixTest, spiralOrder_3) {
    vector<int> expected{1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};
    vector<vector<int>> matrix{{1,  2,  3,  4},
                               {5,  6,  7,  8},
                               {9,  10, 11, 12},
                               {13, 14, 15, 16}};
    auto result = SpiralMatrix::spiralOrder(matrix);
    EXPECT_EQ(expected, result);
}

TEST(SpiralMatrixTest, spiralOrder_4) {
    vector<int> expected{1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8};
    vector<vector<int>> matrix{{1,  2,  3},
                               {4,  5,  6},
                               {7,  8,  9},
                               {10, 11, 12}};
    auto result = SpiralMatrix::spiralOrder(matrix);
    EXPECT_EQ(expected, result);
}

TEST(SpiralMatrixTest, spiralOrder_5) {
    vector<int> expected{1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13};
    vector<vector<int>> matrix{{1,  2,  3,  4,  5},
                               {6,  7,  8,  9,  10},
                               {11, 12, 13, 14, 15},
                               {16, 17, 18, 19, 20},
                               {21, 22, 23, 24, 25}};
    auto result = SpiralMatrix::spiralOrder(matrix);
    EXPECT_EQ(expected, result);
}

TEST(SpiralMatrixTest, spiralOrder_fail_1) {
    // 1 ≤ matrix.length
    auto size = 1 - 1;
    vector<vector<int>> matrix(size);
    EXPECT_EXIT(SpiralMatrix::spiralOrder(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(SpiralMatrixTest, spiralOrder_fail_2) {
    // matrix.length ≤ 10
    auto size = 10 + 1;
    vector<vector<int>> matrix(size);
    EXPECT_EXIT(SpiralMatrix::spiralOrder(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(SpiralMatrixTest, spiralOrder_fail_3) {
    // 1 ≤ matrix[i].length
    auto size = 1 - 1;
    vector<vector<int>> matrix{vector<int>(size)};
    EXPECT_EXIT(SpiralMatrix::spiralOrder(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(SpiralMatrixTest, spiralOrder_fail_4) {
    // matrix[i].length ≤ 10
    auto size = 10 + 1;
    vector<vector<int>> matrix{vector<int>(size)};
    EXPECT_EXIT(SpiralMatrix::spiralOrder(matrix), ::testing::ExitedWithCode(3), "");
}

#endif