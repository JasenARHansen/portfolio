#ifndef LEETCODE_TOP_INTERVIEW_150_IS_SUBSEQUENCE_TEST
#define LEETCODE_TOP_INTERVIEW_150_IS_SUBSEQUENCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/two_poiners/IsSubsequence.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_IsSubsequenceTest, description) {
    testing::internal::CaptureStdout();
    IsSubsequence::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_IsSubsequenceTest, isSubsequence_1) {
    auto expected = true;
    auto s = "abc";
    auto t = "ahbgdc";
    auto result = IsSubsequence::isSubsequence(s, t);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_IsSubsequenceTest, isSubsequence_2) {
    auto expected = false;
    auto s = "axc";
    auto t = "ahbgdc";
    auto result = IsSubsequence::isSubsequence(s, t);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_IsSubsequenceTest, isSubsequence_fail_1) {
    // s.length ≤ 100
    auto size = 100 + 1;
    string s(size, ' ');
    auto t = "ahbgdc";
    EXPECT_EXIT(IsSubsequence::isSubsequence(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_IsSubsequenceTest, isSubsequence_fail_2) {
    // t.length ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    auto s = "ahbgdc";
    string t(size, ' ');
    EXPECT_EXIT(IsSubsequence::isSubsequence(s, t), ::testing::ExitedWithCode(3), "");
}

#endif