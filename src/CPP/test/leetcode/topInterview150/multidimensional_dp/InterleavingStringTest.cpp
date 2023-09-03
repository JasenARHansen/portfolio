#ifndef LEETCODE_TOP_INTERVIEW_150_INTERLEAVING_STRING_TEST
#define LEETCODE_TOP_INTERVIEW_150_INTERLEAVING_STRING_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/InterleavingString.cpp"

TEST(InterleavingStringTest, description) {
    testing::internal::CaptureStdout();
    InterleavingString::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InterleavingStringTest, isInterleave_1) {
    auto expected = true;
    auto s1 = "aabcc";
    auto s2 = "dbbca";
    auto s3 = "aadbbcbcac";
    auto result = InterleavingString::isInterleave(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_2) {
    auto expected = false;
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3 = "aadbbbaccc";
    auto result = InterleavingString::isInterleave(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_3) {
    auto expected = false;
    string s1;
    string s2;
    string s3 = "a";
    auto result = InterleavingString::isInterleave(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_4) {
    auto expected = true;
    string s1;
    string s2;
    string s3;
    auto result = InterleavingString::isInterleave(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_5) {
    auto expected = true;
    string s1 = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
    string s2 = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
    string s3 = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";
    auto result = InterleavingString::isInterleave(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_fail_1) {
    // s1.length <= 100
    auto size = 100 + 1;
    string s1(size, ' ');
    string s2 = "dbbca";
    string s3 = "aadbbbaccc";
    EXPECT_EXIT(InterleavingString::isInterleave(s1, s2, s3), ::testing::ExitedWithCode(3), "");
}

TEST(InterleavingStringTest, isInterleave_fail_2) {
    // s2.length <= 100
    auto size = 100 + 1;
    string s1 = "aabcc";
    string s2(size, ' ');
    string s3 = "aadbbbaccc";
    EXPECT_EXIT(InterleavingString::isInterleave(s1, s2, s3), ::testing::ExitedWithCode(3), "");
}

TEST(InterleavingStringTest, isInterleave_fail_3) {
    // s3.length <= 200
    auto size = 200 + 1;
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3(size, ' ');
    EXPECT_EXIT(InterleavingString::isInterleave(s1, s2, s3), ::testing::ExitedWithCode(3), "");
}

TEST(InterleavingStringTest, isInterleave_2_1) {
    auto expected = true;
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3 = "aadbbcbcac";
    auto result = InterleavingString::isInterleave_2(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_2_2) {
    auto expected = false;
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3 = "aadbbbaccc";
    auto result = InterleavingString::isInterleave_2(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_2_3) {
    auto expected = false;
    string s1;
    string s2;
    string s3 = "a";
    auto result = InterleavingString::isInterleave_2(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_2_4) {
    auto expected = true;
    string s1;
    string s2;
    string s3;
    auto result = InterleavingString::isInterleave_2(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_2_5) {
    auto expected = true;
    string s1 = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
    string s2 = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
    string s3 = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";
    auto result = InterleavingString::isInterleave_2(s1, s2, s3);
    EXPECT_EQ(expected, result);
}

TEST(InterleavingStringTest, isInterleave_2_fail_1) {
    // s1.length <= 100
    auto size = 100 + 1;
    string s1(size, ' ');
    string s2 = "dbbca";
    string s3 = "aadbbbaccc";
    EXPECT_EXIT(InterleavingString::isInterleave_2(s1, s2, s3), ::testing::ExitedWithCode(3), "");
}

TEST(InterleavingStringTest, isInterleave_2_fail_2) {
    // s2.length <= 100
    auto size = 100 + 1;
    string s1 = "aabcc";
    string s2(size, ' ');
    string s3 = "aadbbbaccc";
    EXPECT_EXIT(InterleavingString::isInterleave_2(s1, s2, s3), ::testing::ExitedWithCode(3), "");
}

TEST(InterleavingStringTest, isInterleave_2_fail_3) {
    // s3.length <= 200
    auto size = 200 + 1;
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3(size, ' ');
    EXPECT_EXIT(InterleavingString::isInterleave_2(s1, s2, s3), ::testing::ExitedWithCode(3), "");
}

#endif