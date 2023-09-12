#ifndef LEETCODE_TOP_INTERVIEW_150_LOWEST_COMMON_ANCESTOR_OF_A_BINARY_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_LOWEST_COMMON_ANCESTOR_OF_A_BINARY_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/LowestCommonAncestorOfABinaryTree.cpp"

TEST(LowestCommonAncestorOfABinaryTreeTest, description) {
    testing::internal::CaptureStdout();
    LowestCommonAncestorOfABinaryTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LowestCommonAncestorOfABinaryTreeTest, sumNumbers_1) {
    vector<string> values{"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
    auto expectedVal = 3;
    auto pVal = 5;
    auto qVal = 1;
    auto root = LowestCommonAncestorOfABinaryTree::deserializeTree(values);
    auto expected = LowestCommonAncestorOfABinaryTree::findNode(root, expectedVal);
    auto p = LowestCommonAncestorOfABinaryTree::findNode(root, pVal);
    auto q = LowestCommonAncestorOfABinaryTree::findNode(root, qVal);
    auto result = LowestCommonAncestorOfABinaryTree::lowestCommonAncestor(root, p, q);
    EXPECT_EQ(expected->val, result->val);
    LowestCommonAncestorOfABinaryTree::deleteTree(&root);
}

TEST(LowestCommonAncestorOfABinaryTreeTest, sumNumbers_2) {
    vector<string> values{"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
    auto expectedVal = 5;
    auto pVal = 5;
    auto qVal = 4;
    auto root = LowestCommonAncestorOfABinaryTree::deserializeTree(values);
    auto expected = LowestCommonAncestorOfABinaryTree::findNode(root, expectedVal);
    auto p = LowestCommonAncestorOfABinaryTree::findNode(root, pVal);
    auto q = LowestCommonAncestorOfABinaryTree::findNode(root, qVal);
    auto result = LowestCommonAncestorOfABinaryTree::lowestCommonAncestor(root, p, q);
    EXPECT_EQ(expected->val, result->val);
    LowestCommonAncestorOfABinaryTree::deleteTree(&root);
}

TEST(LowestCommonAncestorOfABinaryTreeTest, sumNumbers_3) {
    vector<string> values{"1", "2"};
    auto expectedVal = 1;
    auto pVal = 1;
    auto qVal = 2;
    auto root = LowestCommonAncestorOfABinaryTree::deserializeTree(values);
    auto expected = LowestCommonAncestorOfABinaryTree::findNode(root, expectedVal);
    auto p = LowestCommonAncestorOfABinaryTree::findNode(root, pVal);
    auto q = LowestCommonAncestorOfABinaryTree::findNode(root, qVal);
    auto result = LowestCommonAncestorOfABinaryTree::lowestCommonAncestor(root, p, q);
    EXPECT_EQ(expected->val, result->val);
    LowestCommonAncestorOfABinaryTree::deleteTree(&root);
}

TEST(LowestCommonAncestorOfABinaryTreeTest, sumNumbers_4) {
    vector<string> values{"1", "2", "3"};
    auto expectedVal = 1;
    auto pVal = 2;
    auto qVal = 3;
    auto root = LowestCommonAncestorOfABinaryTree::deserializeTree(values);
    auto expected = LowestCommonAncestorOfABinaryTree::findNode(root, expectedVal);
    auto p = LowestCommonAncestorOfABinaryTree::findNode(root, pVal);
    auto q = LowestCommonAncestorOfABinaryTree::findNode(root, qVal);
    auto result = LowestCommonAncestorOfABinaryTree::lowestCommonAncestor(root, p, q);
    EXPECT_EQ(expected->val, result->val);
    LowestCommonAncestorOfABinaryTree::deleteTree(&root);
}


#endif