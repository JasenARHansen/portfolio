#ifndef INTERVIEW_META_PREPARATION_SEATING_ARRANGEMENTS_TEST
#define INTERVIEW_META_PREPARATION_SEATING_ARRANGEMENTS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/greedy_algorithm/SeatingArrangements.cpp"  // NOLINT : Ignore .cpp import

TEST(SeatingArrangementsTest, description) {
    testing::internal::CaptureStdout();
    SeatingArrangements::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SeatingArrangementsTest, minOverallAwkwardness_1) {
    auto expected = 4;
    vector<int> arr{5, 10, 6, 8};
    auto result = SeatingArrangements::minOverallAwkwardness(arr);
    EXPECT_EQ(expected, result);
}

TEST(SeatingArrangementsTest, minOverallAwkwardness_2) {
    auto expected = 4;
    vector<int> arr{1, 2, 5, 3, 7};
    auto result = SeatingArrangements::minOverallAwkwardness(arr);
    EXPECT_EQ(expected, result);
}

TEST(SeatingArrangementsTest, minOverallAwkwardness_fail_1) {
    // 3 ≤ arr.length
    auto size = 3 - 1;
    vector<int> arr(size);
    EXPECT_EXIT(SeatingArrangements::minOverallAwkwardness(arr), ::testing::ExitedWithCode(3), "");
}

TEST(SeatingArrangementsTest, minOverallAwkwardness_fail_2) {
    // arr.length ≤ 10^3
    auto size = (int) pow(10, 6) + 1;
    vector<int> arr(size);
    EXPECT_EXIT(SeatingArrangements::minOverallAwkwardness(arr), ::testing::ExitedWithCode(3), "");
}

#endif