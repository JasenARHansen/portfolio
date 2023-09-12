#ifndef INTERVIEW_META_PREPARATION_SLOW_SUMS_TEST
#define INTERVIEW_META_PREPARATION_SLOW_SUMS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/greedy_algorithm/SlowSums.cpp"

TEST(SlowSumsTest, description) {
    testing::internal::CaptureStdout();
    SlowSums::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SlowSumsTest, getTotalTime_1) {
    int expected = 26;
    vector<int> arr{4, 2, 1, 3};
    auto result = SlowSums::getTotalTime(arr);
    EXPECT_EQ(expected, result);
}

TEST(SlowSumsTest, getTotalTime_2) {
    int expected = 88;
    vector<int> arr{2, 3, 9, 8, 4};
    auto result = SlowSums::getTotalTime(arr);
    EXPECT_EQ(expected, result);
}

TEST(SlowSumsTest, SlowSums_fail_1) {
    // 1 ≤ arr.length
    auto size = 1 - 1;
    vector<int> arr(size);
    EXPECT_EXIT(SlowSums::getTotalTime(arr), ::testing::ExitedWithCode(3), "");
}

TEST(SlowSumsTest, SlowSums_fail_2) {
    // 1 ≤ Ai
    auto size = (int) pow(10, 6) + 1;
    vector<int> arr(size);
    EXPECT_EXIT(SlowSums::getTotalTime(arr), ::testing::ExitedWithCode(3), "");
}

TEST(SlowSumsTest, SlowSums_fail_3) {
    // 1 ≤ Ai
    auto size = 1 - 1;
    vector<int> arr{size};
    EXPECT_EXIT(SlowSums::getTotalTime(arr), ::testing::ExitedWithCode(3), "");
}

TEST(SlowSumsTest, SlowSums_fail_4) {
    // Ai ≤ 10^7
    auto size = (int) pow(10, 7) + 1;
    vector<int> arr{size};
    EXPECT_EXIT(SlowSums::getTotalTime(arr), ::testing::ExitedWithCode(3), "");
}

#endif