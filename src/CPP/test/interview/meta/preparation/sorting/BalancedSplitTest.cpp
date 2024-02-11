#ifndef INTERVIEW_META_PREPARATION_BALANCED_SPLIT_TEST
#define INTERVIEW_META_PREPARATION_BALANCED_SPLIT_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/sorting/BalancedSplit.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_BalancedSplitTest, description) {
    testing::internal::CaptureStdout();
    BalancedSplit::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_BalancedSplitTest, balancedSplitExists_1) {
    auto expected = true;
    vector<int> arr{1, 5, 7, 1};
    auto result = BalancedSplit::balancedSplitExists(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_BalancedSplitTest, balancedSplitExists_2) {
    auto expected = false;
    vector<int> arr{12, 7, 6, 7, 6};
    auto result = BalancedSplit::balancedSplitExists(arr);
    EXPECT_EQ(expected, result);
}

#endif