#ifndef LEETCODE_TOP_INTERVIEW_150_SUMMARY_RANGES_TEST
#define LEETCODE_TOP_INTERVIEW_150_SUMMARY_RANGES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/intervals/SummaryRanges.cpp"

TEST(SummaryRangesTest, description) {
    testing::internal::CaptureStdout();
    SummaryRanges::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SummaryRangesTest, summaryRanges_1) {
    vector<string> expected{"0->2", "4->5", "7"};
    vector<int> nums{0, 1, 2, 4, 5, 7};
    auto result = SummaryRanges::summaryRanges(nums);
    EXPECT_EQ(expected, result);
}

TEST(SummaryRangesTest, summaryRanges_2) {
    vector<string> expected{"0", "2->4", "6", "8->9"};
    vector<int> nums{0, 2, 3, 4, 6, 8, 9};
    auto result = SummaryRanges::summaryRanges(nums);
    EXPECT_EQ(expected, result);
}

TEST(SummaryRangesTest, summaryRanges_3) {
    vector<string> expected{};
    vector<int> nums{};
    auto result = SummaryRanges::summaryRanges(nums);
    EXPECT_EQ(expected, result);
}

TEST(SummaryRangesTest, summaryRanges_fail_1) {
    // nums.length ≤ 20
    auto size = 20 + 1;
    vector<int> nums(size);
    EXPECT_EXIT(SummaryRanges::summaryRanges(nums), ::testing::ExitedWithCode(3), "");
}

#endif