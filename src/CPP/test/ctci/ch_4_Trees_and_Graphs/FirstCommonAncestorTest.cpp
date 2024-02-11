#ifndef CTCI_CH_4_TREES_AND_GRAPHS_FIRST_COMMON_ANCESTOR_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_FIRST_COMMON_ANCESTOR_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/FirstCommonAncestor.h"

using namespace ctci;
TEST(CtCI_FirstCommonAncestorTest, description) {
    testing::internal::CaptureStdout();
    FirstCommonAncestor::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_FirstCommonAncestorTest, firstCommonAncestor_1) {
    auto expected = 3;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = FirstCommonAncestor::generateBSTree(data);
    auto node1 = tree->leftChild;
    auto node2 = tree->rightChild;
    auto node = FirstCommonAncestor::firstCommonAncestor(tree, node1, node2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    FirstCommonAncestor::deleteTree(&tree);
}

TEST(CtCI_FirstCommonAncestorTest, firstCommonAncestor_2) {
    auto expected = 1;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = FirstCommonAncestor::generateBSTree(data);
    auto node1 = tree->leftChild->leftChild;
    auto node2 = tree->leftChild->rightChild;
    auto node = FirstCommonAncestor::firstCommonAncestor(tree, node1, node2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    FirstCommonAncestor::deleteTree(&tree);
}

TEST(CtCI_FirstCommonAncestorTest, firstCommonAncestor_3) {
    auto expected = 5;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = FirstCommonAncestor::generateBSTree(data);
    auto node1 = tree->rightChild->leftChild;
    auto node2 = tree->rightChild->rightChild;
    auto node = FirstCommonAncestor::firstCommonAncestor(tree, node1, node2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    FirstCommonAncestor::deleteTree(&tree);
}

TEST(CtCI_FirstCommonAncestorTest, firstCommonAncestor_4) {
    auto expected = 1;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = FirstCommonAncestor::generateBSTree(data);
    auto node1 = tree->leftChild;
    auto node2 = tree->leftChild->leftChild;
    auto node = FirstCommonAncestor::firstCommonAncestor(tree, node1, node2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    FirstCommonAncestor::deleteTree(&tree);
}

TEST(CtCI_FirstCommonAncestorTest, firstCommonAncestor_5) {
    auto expected = 5;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = FirstCommonAncestor::generateBSTree(data);
    auto node1 = tree->rightChild->rightChild;
    auto node2 = tree->rightChild;
    auto node = FirstCommonAncestor::firstCommonAncestor(tree, node1, node2);
    auto result = node->data;
    EXPECT_EQ(expected, result);
    FirstCommonAncestor::deleteTree(&tree);
}

TEST(CtCI_FirstCommonAncestorTest, firstCommonAncestor_6) {
    std::vector<int> data1{3, 1, 5, 0, 2, 4, 6};
    std::vector<int> data2{0};
    auto tree = FirstCommonAncestor::generateBSTree(data1);
    auto isolated = FirstCommonAncestor::generateBSTree(data2);
    auto child = tree->leftChild;
    auto result = FirstCommonAncestor::firstCommonAncestor(tree, child, isolated);
    EXPECT_EQ(nullptr, result);
    FirstCommonAncestor::deleteTree(&tree);
}

#endif