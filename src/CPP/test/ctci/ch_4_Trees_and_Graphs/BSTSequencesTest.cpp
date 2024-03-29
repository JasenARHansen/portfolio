#ifndef CTCI_CH_4_TREES_AND_GRAPHS_BST_SEQUENCES_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_BST_SEQUENCES_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/BSTSequences.h"

TEST(CtCI_BSTSequencesTest, description) {
    testing::internal::CaptureStdout();
    BSTSequences::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_BSTSequencesTest, findAllSequences_1) {
    std::vector<std::vector<int>> expected = {{2, 1, 3},
                                              {2, 3, 1}};
    std::vector<int> data{2, 1, 3};
    auto tree = BSTSequences::generateBSTree(data);
    auto result = BSTSequences::findAllSequences(tree);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < (int) result.size(); index++) {
        EXPECT_EQ(expected.at(index), result.at(index));
    }
    BSTSequences::deleteTree(&tree);
}

TEST(CtCI_BSTSequencesTest, findAllSequences_2) {
    auto expected = 80;
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = BSTSequences::generateBSTree(data);
    auto sequences = BSTSequences::findAllSequences(tree);
    auto result = (int) sequences.size();
    EXPECT_EQ(expected, result);
    BSTSequences::deleteTree(&tree);
}

#endif