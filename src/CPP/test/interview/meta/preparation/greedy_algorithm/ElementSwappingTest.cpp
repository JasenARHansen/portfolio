#ifndef INTERVIEW_META_PREPARATION_ELEMENT_SWAPPING_TEST
#define INTERVIEW_META_PREPARATION_ELEMENT_SWAPPING_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/greedy_algorithm/ElementSwapping.cpp"

TEST(ElementSwappingTest, description) {
    testing::internal::CaptureStdout();
    ElementSwapping::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ElementSwappingTest, findMinArray_1) {
    vector<int> expected{1, 5, 3};
    vector<int> arr{5, 3, 1};
    auto k = 2;
    auto result = ElementSwapping::findMinArray(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(ElementSwappingTest, findMinArray_2) {
    vector<int> expected{2, 8, 9, 11, 1};
    vector<int> arr{8, 9, 11, 2, 1};
    auto k = 3;
    auto result = ElementSwapping::findMinArray(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(ElementSwappingTest, findMinArray_3) {
    vector<int> expected{2, 2, 2, 1, 2, 2, 2};
    vector<int> arr{2, 2, 2, 2, 2, 2, 1};
    auto k = 3;
    auto result = ElementSwapping::findMinArray(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(ElementSwappingTest, findMinArray_4) {
    vector<int> expected{1, 2, 2, 2, 1, 2, 2};
    vector<int> arr{2, 1, 2, 2, 2, 2, 1};
    auto k = 3;
    auto result = ElementSwapping::findMinArray(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(ElementSwappingTest, findMinArray_fail_1) {
    // 1 ≤ arr.length
    auto size = 1 - 1;
    vector<int> arr(size);
    auto k = 3;
    EXPECT_EXIT(ElementSwapping::findMinArray(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(ElementSwappingTest, findMinArray_fail_2) {
    // arr.length ≤ 10^3
    auto size = (int) pow(10, 6) + 1;
    vector<int> arr(size);
    auto k = 3;
    EXPECT_EXIT(ElementSwapping::findMinArray(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(ElementSwappingTest, findMinArray_fail_3) {
    // 1 ≤ k
    vector<int> arr{8, 9, 11, 2, 1};
    auto k = 1 - 1;
    EXPECT_EXIT(ElementSwapping::findMinArray(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(ElementSwappingTest, findMinArray_fail_4) {
    // k ≤ 10^3
    vector<int> arr{8, 9, 11, 2, 1};
    auto k = (int) pow(10, 6) + 1;
    EXPECT_EXIT(ElementSwapping::findMinArray(arr, k), ::testing::ExitedWithCode(3), "");
}

#endif