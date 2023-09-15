#ifndef INTERVIEW_META_PREPARATION_BUBBLE_SORT_TEST
#define INTERVIEW_META_PREPARATION_BUBBLE_SORT_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/BubbleSort.cpp"  // NOLINT : Ignore .cpp import

TEST(BubbleSortTest, description) {
    testing::internal::CaptureStdout();
    BubbleSort::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BubbleSortTest, initial) {
    string expected = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9";
    vector<int> values{9, 7, 5, 3, 1, 0, 8, 6, 4, 2};
    auto sorted = BubbleSort::sort(values);
    auto result = BubbleSort::toString(sorted);
    EXPECT_EQ(expected, result);
}

#endif