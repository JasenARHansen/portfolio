#ifndef LEETCODE_TOP_INTERVIEW_150_SYMMETRIC_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_SYMMETRIC_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/SymmetricTree.cpp"

TEST(SymmetricTreeTest, description) {
    testing::internal::CaptureStdout();
    SymmetricTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SymmetricTreeTest, isSymmetric_1) {
    auto expected = true;
    vector<string> values{"1", "2", "2", "3", "4", "4", "3"};
    auto root = SymmetricTree::deserializeTree(values);
    auto result = SymmetricTree::isSymmetric(root);
    EXPECT_EQ(expected, result);
    SymmetricTree::deleteTree(&root);
}

TEST(SymmetricTreeTest, isSymmetric_2) {
    auto expected = false;
    vector<string> values{"1", "2", "2", "null", "3", "null", "3"};
    auto root = SymmetricTree::deserializeTree(values);
    auto result = SymmetricTree::isSymmetric(root);
    EXPECT_EQ(expected, result);
    SymmetricTree::deleteTree(&root);
}

#endif