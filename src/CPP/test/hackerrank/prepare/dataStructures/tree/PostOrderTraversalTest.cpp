#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_POST_ORDER_TRAVERSAL_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_POST_ORDER_TRAVERSAL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/PostOrderTraversal.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_PostOrderTraversalTest, description) {
    testing::internal::CaptureStdout();
    PostOrderTraversal::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_PostOrderTraversalTest, postOrder_1) {
    auto expected = "4 3 6 5 2 1\n";
    vector<string> values{"1", "null", "2", "null", "5", "3", "6", "null", "4"};
    auto root = PostOrderTraversal::deserializeTree(values);
    testing::internal::CaptureStdout();
    PostOrderTraversal::postOrder(root);
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
    PostOrderTraversal::deleteTree(&root);
}

#endif