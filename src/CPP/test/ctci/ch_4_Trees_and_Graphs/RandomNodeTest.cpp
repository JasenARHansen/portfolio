#ifndef CTCI_CH_4_TREES_AND_GRAPHS_RANDOM_NODE_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_RANDOM_NODE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/RandomNode.h"

TEST(RandomNodeTest, description) {
    testing::internal::CaptureStdout();
    RandomNode::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RandomNodeTest, RandomNode_1) {
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = RandomNode();
    tree.generateBSTree(data);
    auto result = tree.getRandomNode();
    ASSERT_NE(nullptr, result);
    tree.deleteTree();
}

TEST(RandomNodeTest, RandomNode_2) {
    vector<int> data{3};
    auto tree = RandomNode();
    tree.generateBSTree(data);
    auto result = tree.getRandomNode();
    ASSERT_NE(nullptr, result);
    tree.deleteTree();
}

#endif