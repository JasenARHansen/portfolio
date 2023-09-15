#ifndef LEETCODE_TOP_INTERVIEW_150_AVERAGE_OF_LEVELS_IN_BINARY_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_AVERAGE_OF_LEVELS_IN_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_bfs/AverageOfLevelsInBinaryTree.cpp"  // NOLINT : Ignore .cpp import

TEST(AverageOfLevelsInBinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    AverageOfLevelsInBinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AverageOfLevelsInBinaryTreeTest, averageOfLevels_1) {
    vector<double> expected{3.00000, 14.50000, 11.00000};
    vector<string> values{"3", "9", "20", "null", "null", "15", "7"};
    auto root = AverageOfLevelsInBinaryTree::deserializeTree(values);
    auto result = AverageOfLevelsInBinaryTree::averageOfLevels(root);
    EXPECT_EQ(expected, result);
    AverageOfLevelsInBinaryTree::deleteTree(&root);
}

TEST(AverageOfLevelsInBinaryTreeTest, averageOfLevels_2) {
    vector<double> expected{3.00000, 14.50000, 11.00000};
    vector<string> values{"3", "9", "20", "15", "7"};
    auto root = AverageOfLevelsInBinaryTree::deserializeTree(values);
    auto result = AverageOfLevelsInBinaryTree::averageOfLevels(root);
    EXPECT_EQ(expected, result);
    AverageOfLevelsInBinaryTree::deleteTree(&root);
}

TEST(AverageOfLevelsInBinaryTreeTest, averageOfLevels_3) {
    vector<double> expected{5.00000, -73.00000, -56.50000};
    vector<string> values{"5", "-73", "null", "-22", "-91"};
    auto root = AverageOfLevelsInBinaryTree::deserializeTree(values);
    auto result = AverageOfLevelsInBinaryTree::averageOfLevels(root);
    EXPECT_EQ(expected, result);
    AverageOfLevelsInBinaryTree::deleteTree(&root);
}

TEST(AverageOfLevelsInBinaryTreeTest, averageOfLevels_4) {
    vector<double> expected{2147483647, 2147483647};
    vector<string> values{"2147483647", "2147483647", "2147483647"};
    auto root = AverageOfLevelsInBinaryTree::deserializeTree(values);
    auto result = AverageOfLevelsInBinaryTree::averageOfLevels(root);
    EXPECT_EQ(expected, result);
    AverageOfLevelsInBinaryTree::deleteTree(&root);
}

#endif