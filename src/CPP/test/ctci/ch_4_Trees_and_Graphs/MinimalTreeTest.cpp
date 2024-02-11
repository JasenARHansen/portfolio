#ifndef CTCI_CH_4_TREES_AND_GRAPHS_MINIMAL_TREE_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_MINIMAL_TREE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/MinimalTree.h"

using namespace ctci;
TEST(CtCI_MinimalTreeTest, description) {
    testing::internal::CaptureStdout();
    MinimalTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_MinimalTreeTest, generateMinimalTree_1) {
    std::vector<int> expected{3, 1, 5, 0, 2, 4, 6};
    std::vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto tree = MinimalTree::generateMinimalTree(data);
    auto result = MinimalTree::getLevelOrder(tree);
    EXPECT_EQ(expected, result);
    MinimalTree::deleteTree(&tree);
}

#endif