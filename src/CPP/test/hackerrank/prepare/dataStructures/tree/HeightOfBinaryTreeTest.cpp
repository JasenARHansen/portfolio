#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_HEIGHT_OF_BINARY_TREE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_HEIGHT_OF_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/HeightOfBinaryTree.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_HeightOfBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    HeightOfBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_HeightOfBinaryTreeTest, height_1) {
    auto expected = 2;
    vector<string> values{"4", "2", "6", "1", "3", "5", "7"};
    auto root = HeightOfBinaryTree::deserializeTree(values);
    auto result = HeightOfBinaryTree::height(root);
    EXPECT_EQ(expected, result);
    HeightOfBinaryTree::deleteTree(&root);
}

TEST(HackerRank_HeightOfBinaryTreeTest, height_2) {
    auto expected = 3;
    vector<string> values{"3", "2", "5", "1", "null", "4", "6", "null", "null", "null", "null", "null", "7"};
    auto root = HeightOfBinaryTree::deserializeTree(values);
    auto result = HeightOfBinaryTree::height(root);
    EXPECT_EQ(expected, result);
    HeightOfBinaryTree::deleteTree(&root);
}

#endif