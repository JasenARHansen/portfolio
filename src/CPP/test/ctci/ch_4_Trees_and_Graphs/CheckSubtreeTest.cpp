#ifndef CTCI_CH_4_TREES_AND_GRAPHS_CHECK_SUBTREE_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_CHECK_SUBTREE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/CheckSubtree.h"

using namespace ctci;
TEST(CtCI_CheckSubtreeTest, description) {
    testing::internal::CaptureStdout();
    CheckSubtree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByNode_1) {
    auto expected = true;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto result = CheckSubtree::isSubtreeByNode(tree, tree->rightChild);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByNode_2) {
    auto expected = true;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto isolated = nullptr;
    auto result = CheckSubtree::isSubtreeByNode(tree, isolated);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByNode_3) {
    auto expected = false;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    std::vector<int> dataIsolated{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto isolated = CheckSubtree::generateBSTree(dataIsolated);
    auto result = CheckSubtree::isSubtreeByNode(tree, isolated);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByData_1) {
    auto expected = true;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto result = CheckSubtree::isSubtreeByData(tree, tree->rightChild);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByData_2) {
    auto expected = true;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto isolated = nullptr;
    auto result = CheckSubtree::isSubtreeByData(tree, isolated);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByData_3) {
    auto expected = true;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    std::vector<int> data2{3, 1, 5, 0, 2, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto tree2 = CheckSubtree::generateBSTree(data2);
    auto result = CheckSubtree::isSubtreeByData(tree, tree2);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
    CheckSubtree::deleteTree(&tree2);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByData_4) {
    auto expected = false;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    std::vector<int> data2{3, 1, 5, 0, 3, 4, 6};
    auto tree = CheckSubtree::generateBSTree(data);
    auto tree2 = CheckSubtree::generateBSTree(data2);
    auto result = CheckSubtree::isSubtreeByData(tree, tree2);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
    CheckSubtree::deleteTree(&tree2);
}

TEST(CtCI_CheckSubtreeTest, isSubtreeByData_5) {
    auto expected = true;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    std::vector<int> data2{3, 1, 5, 0, 2, 4, 6};;
    auto tree = CheckSubtree::generateBSTree(data);
    auto tree2 = CheckSubtree::generateBSTree(data2);
    auto result = CheckSubtree::isSubtreeByData(tree, tree2);
    EXPECT_EQ(expected, result);
    CheckSubtree::deleteTree(&tree);
    CheckSubtree::deleteTree(&tree2);
}

#endif