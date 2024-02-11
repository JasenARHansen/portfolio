#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_LARGEST_RECTANGLE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_LARGEST_RECTANGLE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/LargestRectangle.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_LargestRectangleTest, description) {
    testing::internal::CaptureStdout();
    LargestRectangle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_1) {
    auto expected = 6;
    vector<int> input{3, 2, 3};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_2) {
    auto expected = 9;
    vector<int> input{1, 2, 3, 4, 5};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_3) {
    auto expected = 50;
    vector<int> input{11, 11, 10, 10, 10};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_4) {
    auto expected = 11;
    vector<int> input{11, 0, 5, 4, 3, 2, 1};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_5) {
    auto expected = 18;
    vector<int> input{1, 3, 5, 9, 11};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_6) {
    auto expected = 6;
    vector<int> input{0, 0, 0, 6, 0, 0};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_7) {
    auto expected = 9;
    vector<int> input{1, 2, 3, 4, 5, 1};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_LargestRectangleTest, largestRectangle_8) {
    auto expected = 9;
    vector<int> input{3, 3, 3};
    auto result = LargestRectangle::largestRectangle(input);
    EXPECT_EQ(expected, result);
}

#endif