#ifndef LEETCODE_TOP_INTERVIEW_150_GROUP_ANAGRAMS_TEST
#define LEETCODE_TOP_INTERVIEW_150_GROUP_ANAGRAMS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/GroupAnagrams.cpp"

TEST(GroupAnagramsTest, description) {
    testing::internal::CaptureStdout();
    GroupAnagrams::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(GroupAnagramsTest, groupAnagrams_1) {
    vector<vector<string>> expected{{"bat"},
                                       {"nat", "tan"},
                                       {"ate", "eat", "tea"}};
    vector<string> strs{"eat", "tea", "tan", "ate", "nat", "bat"};
    auto result = GroupAnagrams::groupAnagrams(strs);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }

}

TEST(GroupAnagramsTest, groupAnagrams_2) {
    vector<vector<string>> expected{{""}};
    vector<string> strs{""};
    auto result = GroupAnagrams::groupAnagrams(strs);
    EXPECT_EQ(expected, result);
}

TEST(GroupAnagramsTest, groupAnagrams_3) {
    vector<vector<string>> expected{{"a"}};
    vector<string> strs{"a"};
    auto result = GroupAnagrams::groupAnagrams(strs);
    EXPECT_EQ(expected, result);
}

TEST(GroupAnagramsTest, groupAnagrams_fail_1) {
    // 1 <= strs.length
    auto size = 1 - 1;
    vector<string> strs(size);
    EXPECT_EXIT(GroupAnagrams::groupAnagrams(strs), ::testing::ExitedWithCode(3), "");
}

TEST(GroupAnagramsTest, groupAnagrams_fail_2) {
    // strs.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<string> strs(size);
    EXPECT_EXIT(GroupAnagrams::groupAnagrams(strs), ::testing::ExitedWithCode(3), "");
}

TEST(GroupAnagramsTest, groupAnagrams_fail_3) {
    // strs[i].length <= 100
    auto size = 100 + 1;
    string s(size, ' ');
    vector<string> strs{s};
    EXPECT_EXIT(GroupAnagrams::groupAnagrams(strs), ::testing::ExitedWithCode(3), "");
}

#endif