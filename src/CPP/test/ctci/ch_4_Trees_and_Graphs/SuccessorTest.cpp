#ifndef CTCI_CH_4_TREES_AND_GRAPHS_SUCCESSOR_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_SUCCESSOR_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/Successor.h"

TEST(SuccessorTest, description) {
    testing::internal::CaptureStdout();
    Successor::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SuccessorTest, inorderSuccessor_1) {
    auto expected = 2;
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = Successor::generateBSTree(data);
    auto successor = Successor::inorderSuccessor(tree, 1);
    auto result = successor->data;
    EXPECT_EQ(expected, result);
    Successor::deleteTree(&tree);
}

TEST(SuccessorTest, inorderSuccessor_2) {
    auto expected = 2;
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = Successor::generateBSTree(data);
    auto successor = Successor::inorderSuccessor(tree->leftChild);
    auto result = successor->data;
    EXPECT_EQ(expected, result);
    Successor::deleteTree(&tree);
}

#endif