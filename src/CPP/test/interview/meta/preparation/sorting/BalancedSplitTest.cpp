#ifndef INTERVIEW_META_PREPARATION_BALANCED_SPLIT_TEST
#define INTERVIEW_META_PREPARATION_BALANCED_SPLIT_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/sorting/BalancedSplit.cpp"  // NOLINT : Ignore .cpp import

TEST(BalancedSplitTest, description) {
    testing::internal::CaptureStdout();
    BalancedSplit::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BalancedSplitTest, balancedSplitExists_1) {
    bool expected = true;
    vector<int> arr{1, 5, 7, 1};
    auto result = BalancedSplit::balancedSplitExists(arr);
    EXPECT_EQ(expected, result);
}

TEST(BalancedSplitTest, balancedSplitExists_2) {
    bool expected = false;
    vector<int> arr{12, 7, 6, 7, 6};
    auto result = BalancedSplit::balancedSplitExists(arr);
    EXPECT_EQ(expected, result);
}

#endif