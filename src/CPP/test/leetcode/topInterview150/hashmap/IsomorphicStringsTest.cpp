#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_ISOMORPHIC_STRINGS_TEST
#define LEETCODE_TOP_INTERVIEW_150_ISOMORPHIC_STRINGS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/IsomorphicStrings.cpp"

TEST(IsomorphicStringsTest, description) {
    testing::internal::CaptureStdout();
    IsomorphicStrings::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IsomorphicStringsTest, isIsomorphic_1) {
    bool expected = true;
    string s = "egg";
    string t = "add";
    bool result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_2) {
    bool expected = false;
    string s = "foo";
    string t = "bar";
    bool result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_3) {
    bool expected = true;
    string s = "paper";
    string t = "title";
    bool result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_4) {
    bool expected = true;
    string s = "a";
    string t = "a";
    bool result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_5) {
    bool expected = false;
    string s = "bbbaaaba";
    string t = "aaabbbba";
    bool result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_1) {
    // 1 <= IsomorphicStrings.length
    int size = 1 - 1;
    string s(size, ' ');
    string t = "aab";
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_2) {
    // t.length <= 5 * 10^4
    int size = 5 * pow(10, 4) + 1;
    string s(size, ' ');
    string t = "aab";
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_3) {
    // 1 <= t.length
    int size = 1 - 1;
    string s = "aa";
    string t(size, ' ');
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_4) {
    // t.length <= 5 * 10^4
    int size = 5 * pow(10, 4) + 1;
    string s = "aa";
    string t(size, ' ');
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop