#ifndef LEETCODE_TOP_INTERVIEW_150_VALID_ANAGRAM_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALID_ANAGRAM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/ValidAnagram.cpp"

TEST(ValidAnagramTest, description) {
    testing::internal::CaptureStdout();
    ValidAnagram::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidAnagramTest, isAnagram_1) {
    auto expected = true;
    auto s = "anagram";
    auto t = "nagaram";
    auto result = ValidAnagram::isAnagram(s, t);
    EXPECT_EQ(expected, result);
}

TEST(ValidAnagramTest, isAnagram_2) {
    auto expected = false;
    auto s = "rat";
    auto t = "car";
    auto result = ValidAnagram::isAnagram(s, t);
    EXPECT_EQ(expected, result);
}

TEST(ValidAnagramTest, isAnagram_3) {
    auto expected = false;
    auto s = "cart";
    auto t = "car";
    auto result = ValidAnagram::isAnagram(s, t);
    EXPECT_EQ(expected, result);
}

TEST(ValidAnagramTest, isAnagram_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, ' ');
    auto t = "nagaram";
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(ValidAnagramTest, isAnagram_fail_2) {
    // s.length ≤ 5 * 10^4
    auto size = 5 * (int) pow(10, 4) + 1;
    string s(size, ' ');
    auto t = "nagaram";
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(ValidAnagramTest, isAnagram_fail_3) {
    // 1 ≤ t.length
    auto size = 1 - 1;
    auto s = "anagram";
    string t(size, ' ');
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(ValidAnagramTest, isAnagram_fail_4) {
    // t.length ≤ 5 * 10^4
    auto size = 5 * (int) pow(10, 4) + 1;
    auto s = "anagram";
    string t(size, ' ');
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

#endif