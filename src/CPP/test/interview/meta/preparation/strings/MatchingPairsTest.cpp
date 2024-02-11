#ifndef INTERVIEW_META_PREPARATION_MATCHING_PAIRS_TEST
#define INTERVIEW_META_PREPARATION_MATCHING_PAIRS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/strings/MatchingPairs.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_MatchingPairsTest, description) {
    testing::internal::CaptureStdout();
    MatchingPairs::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_MatchingPairsTest, matchingPairs_1) {
    auto expected = 4;
    auto s = "abcd";
    auto t = "adcb";
    auto result = MatchingPairs::matchingPairs(s, t);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MatchingPairsTest, matchingPairs_2) {
    auto expected = 3;
    auto s = "mno";
    auto t = "mno";
    auto result = MatchingPairs::matchingPairs(s, t);
    EXPECT_EQ(expected, result);
}

TEST(Interview_MatchingPairsTest, matchingPairs_fail_1) {
    // 2 ≤ s.length
    auto size = 0;
    string s(size, ' ');
    string t(size, ' ');
    EXPECT_EXIT(MatchingPairs::matchingPairs(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_MatchingPairsTest, matchingPairs_fail_2) {
    // s.length ≤ 1,000,000
    auto size = (int) pow(10, 6) + 1;
    string s(size, ' ');
    string t(size, ' ');
    EXPECT_EXIT(MatchingPairs::matchingPairs(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_MatchingPairsTest, matchingPairs_fail_3) {
    // 2 ≤ s.length
    auto size = 0;
    string s(size, ' ');
    string t(size, ' ');
    EXPECT_EXIT(MatchingPairs::matchingPairs(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_MatchingPairsTest, matchingPairs_fail_4) {
    // s.length ≤ 1,000,000
    auto size = (int) pow(10, 6) + 1;
    string s(size, ' ');
    string t(size, ' ');
    EXPECT_EXIT(MatchingPairs::matchingPairs(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_MatchingPairsTest, matchingPairs_fail_5) {
    // s.length ≤ 1,000,000
    auto size = 5;
    string s(size, ' ');
    string t(size + 1, ' ');
    EXPECT_EXIT(MatchingPairs::matchingPairs(s, t), ::testing::ExitedWithCode(3), "");
}

#endif