#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef INTERVIEW_FACEBOOK_PREPARATION_SPIRAL_ARRAY_2D_TEST
#define INTERVIEW_FACEBOOK_PREPARATION_SPIRAL_ARRAY_2D_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/preparation/SpiralArray2D.cpp"

TEST(SpiralArray2dTest, description) {
    testing::internal::CaptureStdout();
    SpiralArray2D::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SpiralArray2dTest, spiral_1) {
    vector<vector<int>> expected = {{1, 2, 3},
                                    {8, 9, 4},
                                    {7, 6, 5}};
    auto n = 3;
    auto result = SpiralArray2D::spiral(n);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(SpiralArray2dTest, spiral_2) {
    vector<vector<int>> expected = {{01, 02, 03, 4},
                                    {12, 13, 14, 5},
                                    {11, 16, 15, 6},
                                    {10, 9,  8,  7}};
    auto n = 4;
    auto result = SpiralArray2D::spiral(n);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(SpiralArray2dTest, spiral_3) {
    vector<vector<int>> expected = {{1,  2,  3,  4,  5,  6,  7,  8},
                                    {28, 29, 30, 31, 32, 33, 34, 9},
                                    {27, 48, 49, 50, 51, 52, 35, 10},
                                    {26, 47, 60, 61, 62, 53, 36, 11},
                                    {25, 46, 59, 64, 63, 54, 37, 12},
                                    {24, 45, 58, 57, 56, 55, 38, 13},
                                    {23, 44, 43, 42, 41, 40, 39, 14},
                                    {22, 21, 20, 19, 18, 17, 16, 15}};
    auto n = 8;
    auto result = SpiralArray2D::spiral(n);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

#endif
#pragma clang diagnostic pop