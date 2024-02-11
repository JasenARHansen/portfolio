#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_IN_ORDER_TRAVERSAL_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_IN_ORDER_TRAVERSAL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/InOrderTraversal.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_InOrderTraversalTest, description) {
    testing::internal::CaptureStdout();
    InOrderTraversal::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_InOrderTraversalTest, inOrder_1) {
    auto expected = "1 2 3 4 5 6\n";
    vector<string> values{"1", "null", "2", "null", "5", "3", "6", "null", "4"};
    auto root = InOrderTraversal::deserializeTree(values);
    testing::internal::CaptureStdout();
    InOrderTraversal::inOrder(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    InOrderTraversal::deleteTree(&root);
}

#endif