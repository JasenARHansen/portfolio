#ifndef INTERVIEW_META_PREPARATION_BINARY_SEARCH_TEST
#define INTERVIEW_META_PREPARATION_BINARY_SEARCH_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/BinarySearch.cpp"  // NOLINT : Ignore .cpp import

TEST(BinarySearchTest, description) {
    testing::internal::CaptureStdout();
    BinarySearch::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BinarySearchTest, binarySearchRecursive_1) {
    auto expected = -1;
    vector<int> values{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    auto value = 11;
    auto result = BinarySearch::binarySearchRecursive(values, value);
    EXPECT_EQ(expected, result);
}

TEST(BinarySearchTest, binarySearchRecursive_2) {
    auto expected = 3;
    vector<int> values{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    auto value = 3;
    auto result = BinarySearch::binarySearchRecursive(values, value);
    EXPECT_EQ(expected, result);
}

TEST(BinarySearchTest, binarySearch_1) {
    auto expected = -1;
    vector<int> values{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    auto value = 11;
    auto result = BinarySearch::binarySearch(values, value);
    EXPECT_EQ(expected, result);
}

TEST(BinarySearchTest, binarySearch_2) {
    auto expected = 3;
    vector<int> values{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    auto value = 3;
    auto result = BinarySearch::binarySearch(values, value);
    EXPECT_EQ(expected, result);
}

#endif