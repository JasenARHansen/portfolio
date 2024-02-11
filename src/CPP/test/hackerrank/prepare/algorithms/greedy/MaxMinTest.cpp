#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_ALGORITHMS_GREEDY_MAX_MIN_TEST
#define HACKERRANK_PREPARE_ALGORITHMS_GREEDY_MAX_MIN_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/algorithms/greedy/MaxMin.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_MaxMinTest, description) {
    testing::internal::CaptureStdout();
    MaxMin::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_MaxMinTest, maxMin_1) {
    auto expected = 1;
    auto k = 2;
    vector<int> arr{1, 4, 7, 2};
    auto result = MaxMin::maxMin(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MaxMinTest, maxMin_2) {
    auto expected = 20;
    auto k = 3;
    vector<int> arr{10, 100, 300, 200, 1000, 20, 30};
    auto result = MaxMin::maxMin(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MaxMinTest, maxMin_3) {
    auto expected = 3;
    auto k = 4;
    vector<int> arr{1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
    auto result = MaxMin::maxMin(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MaxMinTest, maxMin_4) {
    auto expected = 0;
    auto k = 2;
    vector<int> arr{1, 2, 1, 2, 1};
    auto result = MaxMin::maxMin(k, arr);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_MaxMinTest, maxMin_5) {
    auto expected = 2;
    auto k = 3;
    vector<int> arr{100, 200, 300, 350, 400, 401, 402};
    auto result = MaxMin::maxMin(k, arr);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop