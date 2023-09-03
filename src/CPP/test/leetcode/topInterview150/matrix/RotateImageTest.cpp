#ifndef LEETCODE_TOP_INTERVIEW_150_ROTATE_IMAGE_TEST
#define LEETCODE_TOP_INTERVIEW_150_ROTATE_IMAGE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/matrix/RotateImage.cpp"

TEST(RotateImageTest, description) {
    testing::internal::CaptureStdout();
    RotateImage::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotateImageTest, rotate_1) {
    vector<vector<int>> expected{{7, 4, 1},
                                 {8, 5, 2},
                                 {9, 6, 3}};
    vector<vector<int>> matrix{{1, 2, 3},
                               {4, 5, 6},
                               {7, 8, 9}};
    RotateImage::rotate(matrix);
    EXPECT_EQ(expected, matrix);
}

TEST(RotateImageTest, rotate_2) {
    vector<vector<int>> expected{{15, 13, 2,  5},
                                 {14, 3,  4,  1},
                                 {12, 6,  8,  9},
                                 {16, 7,  10, 11}};
    vector<vector<int>> matrix{{5,  1,  9,  11},
                               {2,  4,  8,  10},
                               {13, 3,  6,  7},
                               {15, 14, 12, 16}};
    RotateImage::rotate(matrix);
    EXPECT_EQ(expected, matrix);
}

TEST(RotateImageTest, rotate_fail_1) {
    // 1 <= matrix.length
    auto size = 1 - 1;
    vector<vector<int>> matrix(size);
    EXPECT_EXIT(RotateImage::rotate(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(RotateImageTest, rotate_fail_2) {
    // matrix.length <= 20
    auto size = 10 + 1;
    vector<vector<int>> matrix(size);
    EXPECT_EXIT(RotateImage::rotate(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(RotateImageTest, rotate_fail_3) {
    // matrix.length ==  matrix[i].length
    auto size = 1;
    vector<vector<int>> matrix{vector<int>(size), vector<int>(size)};
    EXPECT_EXIT(RotateImage::rotate(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(RotateImageTest, rotate_fail_4) {
    // 0 <= matrix[i].length
    auto size = 1 - 1;
    vector<vector<int>> matrix{vector<int>(size)};
    EXPECT_EXIT(RotateImage::rotate(matrix), ::testing::ExitedWithCode(3), "");
}

TEST(RotateImageTest, rotate_fail_5) {
    // matrix[i].length <= 20
    auto size = 20;
    vector<vector<int>> matrix(size);
    size++;
    matrix[0] = vector<int>(size);
    EXPECT_EXIT(RotateImage::rotate(matrix), ::testing::ExitedWithCode(3), "");
}

#endif