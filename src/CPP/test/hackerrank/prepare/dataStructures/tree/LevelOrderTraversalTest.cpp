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
    auto expected = "1 2 5 3 6 4\n";
    vector<string> values{"1", "null", "2", "null", "5", "3", "6", "null", "4"};
    auto root = LevelOrderTraversal::deserializeTree(values);
    testing::internal::CaptureStdout();
    LevelOrderTraversal::levelOrder(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    LevelOrderTraversal::deleteTree(&root);
}

#endif