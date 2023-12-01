#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_LEVEL_ORDER_TRAVERSAL_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_LEVEL_ORDER_TRAVERSAL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/LevelOrderTraversal.cpp"  // NOLINT : Ignore .cpp import

TEST(LevelOrderTraversalTest, description) {
    testing::internal::CaptureStdout();
    LevelOrderTraversal::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LevelOrderTraversalTest, levelOrder_1) {
    auto *n1 = new LevelOrderTraversal::Node(1);
    auto *n2 = new LevelOrderTraversal::Node(2);
    auto *n3 = new LevelOrderTraversal::Node(3);
    auto *n4 = new LevelOrderTraversal::Node(4);
    auto *n5 = new LevelOrderTraversal::Node(5);
    auto *n6 = new LevelOrderTraversal::Node(6);
    n1->right = n2;
    n2->right = n5;
    n5->left = n3;
    n5->right = n6;
    n3->right = n4;
    testing::internal::CaptureStdout();
    LevelOrderTraversal::levelOrder(n1);
    EXPECT_EQ("1 2 5 3 6 4\n", testing::internal::GetCapturedStdout());
}

#endif