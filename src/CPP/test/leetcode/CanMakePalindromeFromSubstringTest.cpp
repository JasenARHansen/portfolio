#ifndef LEETCODE_CAN_MAKE_PALINDROME_FROM_SUBSTRING_TEST
#define LEETCODE_CAN_MAKE_PALINDROME_FROM_SUBSTRING_TEST

#include "gtest/gtest.h"
#include "../../code/leetcode/CanMakePalindromeFromSubstring.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_CanMakePalindromeFromSubstring_Test, description) {
    testing::internal::CaptureStdout();
    CanMakePalindromeFromSubstring::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_CanMakePalindromeFromSubstring_Test, canMakePaliQueries_1) {
    vector<bool> expected{true, false, false, true, true};
    string s = "abcda";
    vector<vector<int>> queries{{3, 3, 0},
                                {1, 2, 0},
                                {0, 3, 1},
                                {0, 3, 2},
                                {0, 4, 1}};
    auto result = CanMakePalindromeFromSubstring::canMakePaliQueries(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LeetCode_CanMakePalindromeFromSubstring_Test, canMakePaliQueries_2) {
    vector<bool> expected{false, true};
    string s = "lyb";
    vector<vector<int>> queries{{0, 1, 0},
                                {2, 2, 1}};
    auto result = CanMakePalindromeFromSubstring::canMakePaliQueries(s, queries);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

#endif