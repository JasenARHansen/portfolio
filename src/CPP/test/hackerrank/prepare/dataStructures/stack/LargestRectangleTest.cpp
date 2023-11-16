#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACK_BALANCED_BRACKETS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACK_BALANCED_BRACKETS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/LargestRectangle.cpp"  // NOLINT : Ignore .cpp import

TEST(LargestRectangleTest, description) {
    testing::internal::CaptureStdout();
    LargestRectangle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LargestRectangleTest, isBalanced_1) {
    auto expected = 6;
    vector<int> input{3, 2, 3};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(LargestRectangleTest, isBalanced_2) {
    auto expected = 9;
    vector<int> input{1, 2, 3, 4, 5};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

#endif