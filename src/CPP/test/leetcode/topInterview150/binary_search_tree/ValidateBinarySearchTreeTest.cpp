#ifndef LEETCODE_TOP_INTERVIEW_150_VALIDATE_BINARY_SEARCH_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALIDATE_BINARY_SEARCH_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_search_tree/ValidateBinarySearchTree.cpp"

TEST(ValidateBinarySearchTreeTest, description) {
    testing::internal::CaptureStdout();
    ValidateBinarySearchTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidateBinarySearchTreeTest, isValidBST_1) {
    bool expected = true;
    vector<string> values{"2", "1", "3"};
    auto root = ValidateBinarySearchTree::deserializeTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

TEST(ValidateBinarySearchTreeTest, isValidBST_2) {
    auto expected = false;
    vector<string> values{"5", "1", "4", "null", "null", "3", "6"};
    auto root = ValidateBinarySearchTree::deserializeTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

TEST(ValidateBinarySearchTreeTest, isValidBST_3) {
    auto expected = false;
    vector<string> values{"2", "2", "2"};
    auto root = ValidateBinarySearchTree::deserializeTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

TEST(ValidateBinarySearchTreeTest, isValidBST_4) {
    auto expected = true;
    vector<string> values{"2147483647"};
    auto root = ValidateBinarySearchTree::deserializeTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

#endif