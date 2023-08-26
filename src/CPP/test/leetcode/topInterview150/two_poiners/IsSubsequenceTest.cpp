#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_IS_SUBSEQUENCE_TEST
#define LEETCODE_TOP_INTERVIEW_150_IS_SUBSEQUENCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/two_poiners/IsSubsequence.cpp"

TEST(IsSubsequenceTest, description) {
    testing::internal::CaptureStdout();
    IsSubsequence::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IsSubsequenceTest, isSubsequence_1) {
    bool expected = true;
    string s = "abc";
    string t = "ahbgdc";
    bool result = IsSubsequence::isSubsequence(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsSubsequenceTest, isSubsequence_2) {
    bool expected = false;
    string s = "axc";
    string t = "ahbgdc";
    bool result = IsSubsequence::isSubsequence(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsSubsequenceTest, isSubsequence_fail_1) {
    // s.length <= 100
    int size = 100 + 1;
    string s(size, ' ');
    string t = "ahbgdc";
    EXPECT_EXIT(IsSubsequence::isSubsequence(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsSubsequenceTest, isSubsequence_fail_2) {
    // t.length <= 10^4
    int size = pow(10, 4) + 1;
    string s = "ahbgdc";
    string t(size, ' ');
    EXPECT_EXIT(IsSubsequence::isSubsequence(s, t), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop