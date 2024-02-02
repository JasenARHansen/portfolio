#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_PRE_ORDER_TRAVERSAL_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_PRE_ORDER_TRAVERSAL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/PreOrderTraversal.cpp"  // NOLINT : Ignore .cpp import

TEST(PreOrderTraversalTest, description) {
    testing::internal::CaptureStdout();
    PreOrderTraversal::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PreOrderTraversalTest, preOrder_1) {
    auto expected = "1 2 5 3 4 6\n";
    vector<string> values{"1", "null", "2", "null", "5", "3", "6", "null", "4"};
    auto root = PreOrderTraversal::deserializeTree(values);
    testing::internal::CaptureStdout();
    PreOrderTraversal::preOrder(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PreOrderTraversal::deleteTree(&root);
}

#endif