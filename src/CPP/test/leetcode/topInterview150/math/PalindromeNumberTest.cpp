#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_PALINDROME_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_PALINDROME_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/PalindromeNumber.cpp"

TEST(PalindromeNumberTest, description) {
    testing::internal::CaptureStdout();
    PalindromeNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PalindromeNumberTest, isPalindrome_1) {
    bool expected = true;
    int x = 121;
    bool result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

TEST(PalindromeNumberTest, isPalindrome_2) {
    bool expected = false;
    int x = -121;
    bool result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

TEST(PalindromeNumberTest, isPalindrome_3) {
    bool expected = false;
    int x = 10;
    vector<int> nums{1, 1, 1, 1, 1, 1, 1, 1};
    bool result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

TEST(PalindromeNumberTest, isPalindrome_4) {
    bool expected = true;
    int x = 1221;
    bool result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}


#endif
#pragma clang diagnostic pop