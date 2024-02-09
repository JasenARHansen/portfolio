#ifndef CTCI_CH_4_TREES_AND_GRAPHS_CHECK_BALANCED_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_CHECK_BALANCED_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/CheckBalanced.h"

TEST(CheckBalancedTest, description) {
    testing::internal::CaptureStdout();
    CheckBalanced::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CheckBalancedTest, checkBalanced_1) {
    auto expected = true;
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckBalanced::generateBSTree(data);
    auto result = CheckBalanced::checkBalanced(tree);
    EXPECT_EQ(expected, result);
    CheckBalanced::deleteTree(&tree);
}

TEST(CheckBalancedTest, checkBalanced_2) {
    auto expected = false;
    vector<int> data{0, 1, 2};
    auto tree = CheckBalanced::generateBSTree(data);
    auto result = CheckBalanced::checkBalanced(tree);
    EXPECT_EQ(expected, result);
    CheckBalanced::deleteTree(&tree);
}

#endif