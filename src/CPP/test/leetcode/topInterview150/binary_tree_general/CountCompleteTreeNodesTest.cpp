#ifndef LEETCODE_TOP_INTERVIEW_150_COUNT_COMPLETE_TREE_NODES_TEST
#define LEETCODE_TOP_INTERVIEW_150_COUNT_COMPLETE_TREE_NODES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/CountCompleteTreeNodes.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_CountCompleteTreeNodesTest, description) {
    testing::internal::CaptureStdout();
    CountCompleteTreeNodes::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_CountCompleteTreeNodesTest, countNodes_1) {
    auto expected = 6;
    vector<string> values{"1", "2", "3", "4", "5", "6"};
    auto root = CountCompleteTreeNodes::deserializeTree(values);
    auto result = CountCompleteTreeNodes::countNodes(root);
    EXPECT_EQ(expected, result);
    CountCompleteTreeNodes::deleteTree(&root);
}

TEST(LeetCode_CountCompleteTreeNodesTest, countNodes_2) {
    auto expected = 0;
    vector<string> values{};
    auto root = CountCompleteTreeNodes::deserializeTree(values);
    auto result = CountCompleteTreeNodes::countNodes(root);
    EXPECT_EQ(expected, result);
    CountCompleteTreeNodes::deleteTree(&root);
}

#endif