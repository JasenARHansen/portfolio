#ifndef INTERVIEW_META_INTERVIEW_2023_9_14_SPARSE_MATRIX_TEST
#define INTERVIEW_META_INTERVIEW_2023_9_14_SPARSE_MATRIX_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_2023_9_14/SparseMatrix.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_SparseMatrixTest, description) {
    testing::internal::CaptureStdout();
    SparseMatrix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_SparseMatrixTest, constructor_1) {
    auto expected = "(2, 3, {})";
    auto row = 2;
    auto column = 3;
    auto sparseMatrix = SparseMatrix(row, column);
    auto result = sparseMatrix.toString();
    EXPECT_EQ(expected, result);
    auto bar = sparseMatrix.getCells();
}

TEST(Interview_SparseMatrixTest, constructor_2) {
    auto expected = "(2, 3, {{0, 0, 1}, {1, 0, 3}, {1, 2, 6}})";
    auto row = 2;
    auto column = 3;
    vector<vector<int>> cells{{0, 0, 1},
                              {1, 0, 3},
                              {1, 2, 6}};
    auto sparseMatrix = SparseMatrix(row, column, cells);
    auto result = sparseMatrix.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, put) {
    auto expected = "(2, 3, {{0, 0, 1}, {1, 0, 3}, {1, 2, 6}})";
    auto row = 2;
    auto column = 3;
    auto sparseMatrix = SparseMatrix(row, column);
    sparseMatrix.put(0, 0, 1);
    sparseMatrix.put(1, 0, 3);
    sparseMatrix.put(1, 2, 6);
    auto result = sparseMatrix.toString();
    EXPECT_EQ(expected, result);
    auto bar = sparseMatrix.getCells();
}

TEST(Interview_SparseMatrixTest, put_erase) {
    auto expected = "(2, 3, {{1, 0, 3}, {1, 2, 6}})";
    auto row = 2;
    auto column = 3;
    vector<vector<int>> cells{{0, 0, 1},
                              {1, 0, 3},
                              {1, 2, 6},
                              {0, 1, 0}};
    auto sparseMatrix = SparseMatrix(row, column, cells);
    sparseMatrix.put(0, 0, 0);
    auto result = sparseMatrix.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, put_zero) {
    auto expected = "(2, 3, {{0, 0, 1}, {1, 0, 3}, {1, 2, 6}})";
    auto row = 2;
    auto column = 3;
    vector<vector<int>> cells{{0, 0, 1},
                              {1, 0, 3},
                              {1, 2, 6}};
    auto sparseMatrix = SparseMatrix(row, column, cells);
    sparseMatrix.put(0, 1, 0);
    auto result = sparseMatrix.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, transpose) {
    auto expected = "(3, 2, {{0, 0, 1}, {0, 1, 3}, {2, 1, 6}})";
    auto row = 2;
    auto column = 3;
    vector<vector<int>> cells{{0, 0, 1},
                              {1, 0, 3},
                              {1, 2, 6}};
    auto sparseMatrix = SparseMatrix(row, column, cells);
    auto transpose = sparseMatrix.transpose();
    auto result = transpose.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, multiply) {
    auto expected = "(3, 2, {{0, 0, 1}, {0, 1, 2}, {0, 2, 3}, {1, 0, 3}, {1, 1, 6}, {1, 2, 9}})";
    auto row = 2;
    auto column = 3;
    vector<vector<int>> cells{{0, 0, 1},
                              {1, 0, 3},
                              {1, 2, 6}};
    auto sparseMatrix = SparseMatrix(row, column, cells);
    row = 3;
    column = 3;
    vector<vector<int>> cells2{
            {0, 0, 1},
            {0, 1, 2},
            {0, 2, 3},
            {1, 0, 4},
            {1, 1, 5},
            {1, 2, 6}};
    auto sparseMatrix2 = SparseMatrix(row, column, cells2);
    auto multiply = sparseMatrix.multiply(sparseMatrix2);
    auto result = multiply.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, getRow) {
    auto expected = 2;
    auto row = 2;
    auto column = 3;
    auto sparseMatrix = SparseMatrix(row, column);
    auto result = sparseMatrix.getRow();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, getColumn) {
    auto expected = 3;
    auto row = 2;
    auto column = 3;
    auto sparseMatrix = SparseMatrix(row, column);
    auto result = sparseMatrix.getColumn();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, getCells) {
    vector<vector<int>> expected{{0, 0, 1},
                                 {1, 0, 3},
                                 {1, 2, 6}};
    auto row = 2;
    auto column = 3;
    vector<vector<int>> cells{{0, 0, 1},
                              {1, 0, 3},
                              {1, 2, 6}};
    auto sparseMatrix = SparseMatrix(row, column, cells);
    auto result = sparseMatrix.getCells();
    EXPECT_EQ(expected, result);
}

TEST(Interview_SparseMatrixTest, put_fail_1) {
    // 0 < row
    auto row = 2;
    auto column = 3;
    int size = 0 - 1;
    auto sparseMatrix = SparseMatrix(row, column);
    EXPECT_THROW(sparseMatrix.put(size, 0, 1), runtime_error);
}

TEST(Interview_SparseMatrixTest, put_fail_2) {
    // row < Max Row
    auto row = 2;
    auto column = 3;
    int size = row + 1;
    auto sparseMatrix = SparseMatrix(row, column);
    EXPECT_THROW(sparseMatrix.put(size, 0, 1), runtime_error);
}

TEST(Interview_SparseMatrixTest, put_fail_3) {
    // 0 < row
    auto row = 2;
    auto column = 3;
    int size = 0 - 1;
    auto sparseMatrix = SparseMatrix(row, column);
    EXPECT_THROW(sparseMatrix.put(0, size, 1), runtime_error);
}

TEST(Interview_SparseMatrixTest, put_fail_4) {
    // row < Max Row
    auto row = 2;
    auto column = 3;
    int size = column + 1;
    auto sparseMatrix = SparseMatrix(row, column);
    EXPECT_THROW(sparseMatrix.put(0, size, 1), runtime_error);
}

TEST(Interview_SparseMatrixTest, multiply_fail_1) {
    // row < Max Row
    auto row = 1;
    auto column = 1;
    auto sparseMatrix = SparseMatrix(row, column);
    row = 3;
    column = 3;
    auto sparseMatrix2 = SparseMatrix(row, column);
    EXPECT_THROW(sparseMatrix.multiply(sparseMatrix2), runtime_error);
}

#endif