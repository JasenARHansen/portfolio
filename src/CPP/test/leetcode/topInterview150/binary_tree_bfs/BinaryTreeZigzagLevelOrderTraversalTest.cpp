#ifndef LEETCODE_TOP_INTERVIEW_150_BINARY_TREE_ZIGZAG_LEVEL_ORDER_TRAVERSAL_TEST
#define LEETCODE_TOP_INTERVIEW_150_BINARY_TREE_ZIGZAG_LEVEL_ORDER_TRAVERSAL_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_bfs/BinaryTreeZigzagLevelOrderTraversal.cpp"

TEST(BinaryTreeZigzagLevelOrderTraversalTest, description) {
    testing::internal::CaptureStdout();
    BinaryTreeZigzagLevelOrderTraversal::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BinaryTreeZigzagLevelOrderTraversalTest, zigzagLevelOrder_1) {
    vector<vector<int>> expected{{3},
                                 {20, 9},
                                 {15, 7}};
    vector<string> values{"3", "9", "20", "null", "null", "15", "7", "null", "null", "null", "null"};
    auto *root = BinaryTreeZigzagLevelOrderTraversal::generateTree(values);
    vector<vector<int>> result = BinaryTreeZigzagLevelOrderTraversal::zigzagLevelOrder(root);
    EXPECT_EQ(expected, result);
    BinaryTreeZigzagLevelOrderTraversal::deleteTree(&root);
}

TEST(BinaryTreeZigzagLevelOrderTraversalTest, zigzagLevelOrder_2) {
    vector<vector<int>> expected{{1}};
    vector<string> values{"1", "null", "null"};
    auto *root = BinaryTreeZigzagLevelOrderTraversal::generateTree(values);
    vector<vector<int>> result = BinaryTreeZigzagLevelOrderTraversal::zigzagLevelOrder(root);
    EXPECT_EQ(expected, result);
    BinaryTreeZigzagLevelOrderTraversal::deleteTree(&root);
}

TEST(BinaryTreeZigzagLevelOrderTraversalTest, zigzagLevelOrder_3) {
    vector<vector<int>> expected{};
    TreeNode *root = nullptr;
    vector<vector<int>> result = BinaryTreeZigzagLevelOrderTraversal::zigzagLevelOrder(root);
    EXPECT_EQ(expected, result);
    BinaryTreeZigzagLevelOrderTraversal::deleteTree(&root);
}

#endif