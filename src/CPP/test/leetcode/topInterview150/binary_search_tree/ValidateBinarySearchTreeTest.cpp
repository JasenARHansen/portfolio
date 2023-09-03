#ifndef LEETCODE_TOP_INTERVIEW_150_VALIDATE_BINARY_SEARCH_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALIDATE_BINARY_SEARCH_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_search_tree/ValidateBinarySearchTree.cpp"

TEST(ValidateBinarySearchTreeTest, description) {
    testing::internal::CaptureStdout();
    ValidateBinarySearchTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidateBinarySearchTreeTest, kthSmallest_1) {
    auto expected = true;
    vector<string> values{"2", "1", "3", "null", "null", "null", "null"};
    auto root = ValidateBinarySearchTree::generateTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

TEST(ValidateBinarySearchTreeTest, kthSmallest_2) {
    auto expected = false;
    vector<string> values{"5", "1", "4", "null", "null", "3", "6", "null", "null", "null", "null"};
    auto root = ValidateBinarySearchTree::generateTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
    }

TEST(ValidateBinarySearchTreeTest, kthSmallest_3) {
    auto expected = false;
    vector<string> values{"2", "2", "2", "null", "null", "null", "null"};
    auto root = ValidateBinarySearchTree::generateTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

TEST(ValidateBinarySearchTreeTest, kthSmallest_4) {
    auto expected = true;
    vector<string> values{"2147483647", "null", "null"};
    auto root = ValidateBinarySearchTree::generateTree(values);
    auto result = ValidateBinarySearchTree::isValidBST(root);
    EXPECT_EQ(expected, result);
    ValidateBinarySearchTree::deleteTree(&root);
}

#endif