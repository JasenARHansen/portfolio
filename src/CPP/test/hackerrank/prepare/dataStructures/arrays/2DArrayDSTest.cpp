#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_ARRAYS_2_DDS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_ARRAYS_2_DDS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/arrays/2DArrayDS.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_Arrays2DDSTest, description) {
    testing::internal::CaptureStdout();
    Arrays2DDS::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_Arrays2DDSTest, hourglassSum_1) {
    int expected = 7;
    vector<vector<int>> arr{
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
    };
    auto result = Arrays2DDS::hourglassSum(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_Arrays2DDSTest, hourglassSum_2) {
    int expected = 28;
    vector<vector<int>> arr{
            {-9, -9, -9, 1,  1, 1},
            {0,  -9, 0,  4,  3, 2},
            {-9, -9, -9, 1,  2, 3},
            {0,  0,  8,  6,  6, 0},
            {0,  0,  0,  -2, 0, 0},
            {0,  0,  1,  2,  4, 0}
    };
    auto result = Arrays2DDS::hourglassSum(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_Arrays2DDSTest, hourglassSum_3) {
    int expected = 19;
    vector<vector<int>> arr{
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
    };
    auto result = Arrays2DDS::hourglassSum(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_Arrays2DDSTest, hourglassSum_4) {
    int expected = 13;
    vector<vector<int>> arr{
            {1, 1, 1,  0,  0,  0},
            {0, 1, 0,  0,  0,  0},
            {1, 1, 1,  0,  0,  0},
            {0, 9, 2,  -4, -4, 0},
            {0, 0, 0,  -2, 0,  0},
            {0, 0, -1, -2, -4, 0}
    };
    auto result = Arrays2DDS::hourglassSum(arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_Arrays2DDSTest, hourglassSum_5) {
    int expected = -6;
    vector<vector<int>> arr{
            {-1, -1, 0,  -9, -2, -2},
            {-2, -1, -6, -8, -2, -5},
            {-1, -1, -1, -2, -3, -4},
            {-1, -9, -2, -4, -4, -5},
            {-7, -3, -3, -2, -9, -9},
            {-1, -3, -1, -2, -4, -5}
    };
    auto result = Arrays2DDS::hourglassSum(arr);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop