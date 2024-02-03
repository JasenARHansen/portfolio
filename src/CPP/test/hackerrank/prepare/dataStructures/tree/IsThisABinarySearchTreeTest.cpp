#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_IS_THIS_A_BINARY_SEARCH_TREE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_IS_THIS_A_BINARY_SEARCH_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/IsThisABinarySearchTree.cpp"  // NOLINT : Ignore .cpp import

TEST(IsThisABinarySearchTreeTest, description) {
    testing::internal::CaptureStdout();
    IsThisABinarySearchTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IsThisABinarySearchTreeTest, preOrder_1) {
    auto expected = false;
    vector<string> values{"3", "5", "2", "1", "4", "6",};
    auto root = IsThisABinarySearchTree::deserializeTree(values);
    auto result = IsThisABinarySearchTree::checkBST(root);
    EXPECT_EQ(expected, result);
    IsThisABinarySearchTree::deleteTree(&root);
}

TEST(IsThisABinarySearchTreeTest, preOrder_2) {
    auto expected = true;
    vector<string> values{"4", "2", "6", "1", "3", "5", "7"};
    auto root = IsThisABinarySearchTree::deserializeTree(values);
    auto result = IsThisABinarySearchTree::checkBST(root);
    EXPECT_EQ(expected, result);
    IsThisABinarySearchTree::deleteTree(&root);
}

#endif