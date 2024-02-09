#ifndef CTCI_CH_4_TREES_AND_GRAPHS_VALIDATE_BST_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_VALIDATE_BST_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/ValidateBST.h"

TEST(ValidateBSTTest, description) {
    testing::internal::CaptureStdout();
    ValidateBST::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidateBSTTest, validateBST_1) {
    auto expected = true;
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = ValidateBST::generateBSTree(data);
    auto result = ValidateBST::validateBST(tree);
    EXPECT_EQ(expected, result);
    ValidateBST::deleteTree(&tree);
}

TEST(ValidateBSTTest, validateBST_2) {
    auto expected = false;
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = ValidateBST::generateMinimalTree(data);
    auto result = ValidateBST::validateBST(tree);
    EXPECT_EQ(expected, result);
    ValidateBST::deleteTree(&tree);
}

#endif