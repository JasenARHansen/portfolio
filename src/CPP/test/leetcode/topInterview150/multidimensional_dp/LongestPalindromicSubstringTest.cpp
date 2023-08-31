#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_LONGEST_PALINDROMIC_SUBSTRING_TEST
#define LEETCODE_TOP_INTERVIEW_150_LONGEST_PALINDROMIC_SUBSTRING_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/LongestPalindromicSubstring.cpp"

TEST(LongestPalindromicSubstringTest, description) {
    testing::internal::CaptureStdout();
    LongestPalindromicSubstring::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_1) {
    string expected = "bab";
    string s = "babad";
    string result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_2) {
    string expected = "bb";
    string s = "cbbd";
    string result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_3) {
    string expected = "abcdcba";
    string s = "1234abcdcba1234";
    string result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_4) {
    string expected = "ranynar";
    string s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
    string result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, ' ');
    EXPECT_EXIT(LongestPalindromicSubstring::longestPalindrome(s), ::testing::ExitedWithCode(3), "");
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_fail_2) {
    // s.length <= 1000
    int size = 1000 + 1;
    string s(size, ' ');
    EXPECT_EXIT(LongestPalindromicSubstring::longestPalindrome(s), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop