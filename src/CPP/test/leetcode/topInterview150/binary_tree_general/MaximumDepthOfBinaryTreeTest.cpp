#ifndef LEETCODE_TOP_INTERVIEW_150_MAXIMUM_DEPTH_OF_BINARY_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_MAXIMUM_DEPTH_OF_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/MaximumDepthOfBinaryTree.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_MaximumDepthOfBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    MaximumDepthOfBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_MaximumDepthOfBinaryTreeTest, maxDepth_1) {
    auto expected = 3;
    vector<string> values{"3", "9", "20", "null", "null", "15", "7"};
    auto root = MaximumDepthOfBinaryTree::deserializeTree(values);
    auto result = MaximumDepthOfBinaryTree::maxDepth(root);
    EXPECT_EQ(expected, result);
    MaximumDepthOfBinaryTree::deleteTree(&root);
}

TEST(LeetCode_MaximumDepthOfBinaryTreeTest, maxDepth_2) {
    auto expected = 2;
    vector<string> values{"1", "null", "2"};
    auto root = MaximumDepthOfBinaryTree::deserializeTree(values);
    auto result = MaximumDepthOfBinaryTree::maxDepth(root);
    EXPECT_EQ(expected, result);
    MaximumDepthOfBinaryTree::deleteTree(&root);
}

#endif