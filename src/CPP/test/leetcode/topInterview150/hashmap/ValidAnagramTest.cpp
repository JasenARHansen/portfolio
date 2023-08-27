#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    bool expected = true;
    string s = "anagram";
    string t = "nagaram";
    bool result = ValidAnagram::isAnagram(s, t);
    EXPECT_EQ(expected, result);
}

TEST(ValidAnagramTest, isAnagram_2) {
    bool expected = false;
    string s = "rat";
    string t = "car";
    bool result = ValidAnagram::isAnagram(s, t);
    EXPECT_EQ(expected, result);
}

TEST(ValidAnagramTest, isAnagram_3) {
    bool expected = false;
    string s = "cart";
    string t = "car";
    bool result = ValidAnagram::isAnagram(s, t);
    EXPECT_EQ(expected, result);
}

TEST(ValidAnagramTest, isAnagram_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, ' ');
    string t = "nagaram";
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(ValidAnagramTest, isAnagram_fail_2) {
    // s.length <= 5 * 10^4
    int size = 5 * pow(10, 4) + 1;
    string s(size, ' ');
    string t = "nagaram";
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(ValidAnagramTest, isAnagram_fail_3) {
    // 1 <= t.length
    int size = 1 - 1;
    string s = "anagram";
    string t(size, ' ');
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

TEST(ValidAnagramTest, isAnagram_fail_4) {
    // t.length <= 5 * 10^4
    int size = 5 * pow(10, 4) + 1;
    string s = "anagram";
    string t(size, ' ');
    EXPECT_EXIT(ValidAnagram::isAnagram(s, t), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop