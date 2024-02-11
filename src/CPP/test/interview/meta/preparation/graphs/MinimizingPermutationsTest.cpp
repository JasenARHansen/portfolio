#ifndef INTERVIEW_META_PREPARATION_MINIMIZING_PERMUTATIONS_TEST
#define INTERVIEW_META_PREPARATION_MINIMIZING_PERMUTATIONS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/graphs/MinimizingPermutations.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_MinimizingPermutationsTest, description) {
    testing::internal::CaptureStdout();
    MinimizingPermutations::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_MinimizingPermutationsTest, minOperations_1) {
    auto expected = 1;
    vector<int> arr{1, 2, 5, 4, 3};
    auto result = MinimizingPermutations::minOperations(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MinimizingPermutationsTest, minOperations_2) {
    auto expected = 2;
    vector<int> arr{3, 1, 2};
    auto result = MinimizingPermutations::minOperations(arr);
    EXPECT_EQ(expected, result);
}

#endif