#ifndef LEETCODE_TOP_INTERVIEW_150_BINARY_TREE_LEVEL_ORDER_TRAVERSAL_TEST
#define LEETCODE_TOP_INTERVIEW_150_BINARY_TREE_LEVEL_ORDER_TRAVERSAL_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_bfs/BinaryTreeLevelOrderTraversal.cpp"

TEST(BinaryTreeLevelOrderTraversalTest, description) {
    testing::internal::CaptureStdout();
    BinaryTreeLevelOrderTraversal::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BinaryTreeLevelOrderTraversalTest, levelOrder_1) {
    vector<vector<int>> expected{{3},
                                 {9,  20},
                                 {15, 7}};
    vector<string> values{"3", "9", "20", "null", "null", "15", "7"};
    auto root = BinaryTreeLevelOrderTraversal::deserializeTree(values);
    auto result = BinaryTreeLevelOrderTraversal::levelOrder(root);
    EXPECT_EQ(expected, result);
    BinaryTreeLevelOrderTraversal::deleteTree(&root);
}

TEST(BinaryTreeLevelOrderTraversalTest, levelOrder_2) {
    vector<vector<int>> expected{{1}};
    vector<string> values{"1"};
    auto root = BinaryTreeLevelOrderTraversal::deserializeTree(values);
    auto result = BinaryTreeLevelOrderTraversal::levelOrder(root);
    EXPECT_EQ(expected, result);
    BinaryTreeLevelOrderTraversal::deleteTree(&root);
}

TEST(BinaryTreeLevelOrderTraversalTest, levelOrder_3) {
    vector<vector<int>> expected{};
    vector<string> values{};
    auto root = BinaryTreeLevelOrderTraversal::deserializeTree(values);
    auto result = BinaryTreeLevelOrderTraversal::levelOrder(root);
    EXPECT_EQ(expected, result);
    BinaryTreeLevelOrderTraversal::deleteTree(&root);
}

#endif