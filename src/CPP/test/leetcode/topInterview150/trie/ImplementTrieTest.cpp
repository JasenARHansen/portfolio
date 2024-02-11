#ifndef LEETCODE_TOP_INTERVIEW_150_IMPLEMENT_TRIE_PREFIX_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_IMPLEMENT_TRIE_PREFIX_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/trie/ImplementTrie.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_ImplementTrieTest, description) {
    testing::internal::CaptureStdout();
    Trie::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_ImplementTrieTest, climbStairs_1) {
    Trie *trie = new Trie();
    trie->insert("apple");
    auto result = trie->search("apple");
    EXPECT_TRUE(result);
    result = trie->startsWith("app");
    EXPECT_TRUE(result);
    result = trie->search("app");
    EXPECT_FALSE(result);
    trie->insert("app");
    result = trie->search("app");
    EXPECT_TRUE(result);
}

#endif