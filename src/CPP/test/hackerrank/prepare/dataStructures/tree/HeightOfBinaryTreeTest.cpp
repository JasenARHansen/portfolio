#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_HEIGHT_OF_BINARY_TREE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_HEIGHT_OF_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/HeightOfBinaryTree.cpp"  // NOLINT : Ignore .cpp import

TEST(HeightOfBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    HeightOfBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HeightOfBinaryTreeTest, height_1) {
    auto expected = 2;
    auto *n1 = new HeightOfBinaryTree::Node(4);
    auto *n2 = new HeightOfBinaryTree::Node(2);
    auto *n3 = new HeightOfBinaryTree::Node(6);
    auto *n4 = new HeightOfBinaryTree::Node(1);
    auto *n5 = new HeightOfBinaryTree::Node(3);
    auto *n6 = new HeightOfBinaryTree::Node(5);
    auto *n7 = new HeightOfBinaryTree::Node(7);
    n1->left = n2;
    n1->right = n3;
    n2->left = n4;
    n2->right = n5;
    n3->left = n6;
    n3->right = n7;
    auto result = HeightOfBinaryTree::height(n1);
    EXPECT_EQ(expected, result);
}

TEST(HeightOfBinaryTreeTest, height_2) {
    auto expected = 3;
    auto *n1 = new HeightOfBinaryTree::Node(3);
    auto *n2 = new HeightOfBinaryTree::Node(2);
    auto *n3 = new HeightOfBinaryTree::Node(5);
    auto *n4 = new HeightOfBinaryTree::Node(1);
    auto *n5 = new HeightOfBinaryTree::Node(4);
    auto *n6 = new HeightOfBinaryTree::Node(5);
    auto *n7 = new HeightOfBinaryTree::Node(7);
    n1->left = n2;
    n1->right = n3;
    n2->left = n4;
    n3->left = n5;
    n3->right = n6;
    n6->right = n7;
    auto result = HeightOfBinaryTree::height(n1);
    EXPECT_EQ(expected, result);
}

#endif