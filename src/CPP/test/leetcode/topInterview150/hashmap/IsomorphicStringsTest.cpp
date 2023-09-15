#ifndef LEETCODE_TOP_INTERVIEW_150_ISOMORPHIC_STRINGS_TEST
#define LEETCODE_TOP_INTERVIEW_150_ISOMORPHIC_STRINGS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/IsomorphicStrings.cpp"  // NOLINT : Ignore .cpp import

TEST(IsomorphicStringsTest, description) {
    testing::internal::CaptureStdout();
    IsomorphicStrings::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IsomorphicStringsTest, isIsomorphic_1) {
    auto expected = true;
    auto s = "egg";
    auto t = "add";
    auto result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_2) {
    auto expected = false;
    auto s = "foo";
    auto t = "bar";
    auto result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_3) {
    auto expected = true;
    auto s = "paper";
    auto t = "title";
    auto result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_4) {
    auto expected = true;
    auto s = "a";
    auto t = "a";
    auto result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_5) {
    auto expected = false;
    auto s = "bbbaaaba";
    auto t = "aaabbbba";
    auto result = IsomorphicStrings::isIsomorphic(s, t);
    EXPECT_EQ(expected, result);
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_1) {
    // 1 ≤ IsomorphicStrings.length
    auto size = 1 - 1;
    string s(size, ' ');
    auto t = "aab";
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_2) {
    // t.length ≤ 5 * 10^4
    auto size = 5 * (int) pow(10, 4) + 1;
    string s(size, ' ');
    auto t = "aab";
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_3) {
    // 1 ≤ t.length
    auto size = 1 - 1;
    auto s = "aa";
    string t(size, ' ');
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(IsomorphicStringsTest, isIsomorphic_fail_4) {
    // t.length ≤ 5 * 10^4
    auto size = 5 * (int) pow(10, 4) + 1;
    auto s = "aa";
    string t(size, ' ');
    EXPECT_EXIT(IsomorphicStrings::isIsomorphic(s, t), ::testing::ExitedWithCode(3), "");
}

#endif