#ifndef LEETCODE_TOP_INTERVIEW_150_INVERT_BINARY_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_INVERT_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/InvertBinaryTree.cpp"

TEST(InvertBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    InvertBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InvertBinaryTreeTest, invertTree_1) {
    vector<string> valuesExpected{"4", "7", "2", "9", "6", "3", "1", "null", "null", "null", "null", "null", "null",
                                  "null", "null"};
    vector<string> values{"4", "2", "7", "1", "3", "6", "9", "null", "null", "null", "null", "null", "null", "null",
                          "null"};
    auto root = InvertBinaryTree::generateTree(values);
    auto result = InvertBinaryTree::invertTree(root);
    auto resultValues = InvertBinaryTree::serialize(result);
    EXPECT_EQ(valuesExpected, resultValues);
    InvertBinaryTree::deleteTree(&root);
}

TEST(InvertBinaryTreeTest, invertTree_2) {
    vector<string> valuesExpected{"2", "3", "1", "null", "null", "null", "null"};
    vector<string> values{"2", "1", "3", "null", "null", "null", "null"};
    auto root = InvertBinaryTree::generateTree(values);
    auto  result = InvertBinaryTree::invertTree(root);
    auto resultValues = InvertBinaryTree::serialize(result);
    EXPECT_EQ(valuesExpected, resultValues);
    InvertBinaryTree::deleteTree(&root);
}

TEST(InvertBinaryTreeTest, invertTree_3) {
    vector<string> valuesExpected{};
    vector<string> values{};
    auto root = InvertBinaryTree::generateTree(values);
    auto  result = InvertBinaryTree::invertTree(root);
    auto resultValues = InvertBinaryTree::serialize(result);
    EXPECT_EQ(valuesExpected, resultValues);
    InvertBinaryTree::deleteTree(&root);
}

#endif