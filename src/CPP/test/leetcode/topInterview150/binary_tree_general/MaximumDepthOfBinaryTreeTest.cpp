#ifndef LEETCODE_TOP_INTERVIEW_150_MAXIMUM_DEPTH_OF_BINARY_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_MAXIMUM_DEPTH_OF_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/MaximumDepthOfBinaryTree.cpp"

TEST(MaximumDepthOfBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    MaximumDepthOfBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MaximumDepthOfBinaryTreeTest, maxDepth_1) {
    auto expected = 3;
    vector<string> values{"3", "9", "20", "null", "null", "15", "7", "null", "null", "null", "null"};
    auto root = MaximumDepthOfBinaryTree::generateTree(values);
    auto result = MaximumDepthOfBinaryTree::maxDepth(root);
    EXPECT_EQ(expected, result);
    MaximumDepthOfBinaryTree::deleteTree(&root);
}

TEST(MaximumDepthOfBinaryTreeTest, maxDepth_2) {
    auto expected = 2;
    vector<string> values{"1", "null", "2", "null", "null"};
    auto root = MaximumDepthOfBinaryTree::generateTree(values);
    auto result = MaximumDepthOfBinaryTree::maxDepth(root);
    EXPECT_EQ(expected, result);
    MaximumDepthOfBinaryTree::deleteTree(&root);
}

#endif