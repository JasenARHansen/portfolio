#ifndef LEETCODE_TOP_INTERVIEW_150_INVERT_BINARY_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_INVERT_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/InvertBinaryTree.cpp"  // NOLINT : Ignore .cpp import

TEST(InvertBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    InvertBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InvertBinaryTreeTest, invertTree_1) {
    vector<string> valuesExpected{"4", "7", "2", "9", "6", "3", "1"};
    vector<string> values{"4", "2", "7", "1", "3", "6", "9"};
    auto root = InvertBinaryTree::deserializeTree(values);
    auto result = InvertBinaryTree::invertTree(root);
    auto resultValues = InvertBinaryTree::serializeTree(result);
    EXPECT_EQ(valuesExpected, resultValues);
    InvertBinaryTree::deleteTree(&root);
}

TEST(InvertBinaryTreeTest, invertTree_2) {
    vector<string> valuesExpected{"2", "3", "1"};
    vector<string> values{"2", "1", "3"};
    auto root = InvertBinaryTree::deserializeTree(values);
    auto result = InvertBinaryTree::invertTree(root);
    auto resultValues = InvertBinaryTree::serializeTree(result);
    EXPECT_EQ(valuesExpected, resultValues);
    InvertBinaryTree::deleteTree(&root);
}

TEST(InvertBinaryTreeTest, invertTree_3) {
    vector<string> valuesExpected{};
    vector<string> values{};
    auto root = InvertBinaryTree::deserializeTree(values);
    auto result = InvertBinaryTree::invertTree(root);
    auto resultValues = InvertBinaryTree::serializeTree(result);
    EXPECT_EQ(valuesExpected, resultValues);
    InvertBinaryTree::deleteTree(&root);
}

#endif