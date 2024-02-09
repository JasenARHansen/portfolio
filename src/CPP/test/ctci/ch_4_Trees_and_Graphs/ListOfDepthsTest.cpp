#ifndef CTCI_CH_4_TREES_AND_GRAPHS_LIST_OF_DEPTHS_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_LIST_OF_DEPTHS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/ListOfDepths.h"

TEST(ListOfDepthsTest, description) {
    testing::internal::CaptureStdout();
    ListOfDepths::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ListOfDepthsTest, getListOfDepths_1) {
    vector<vector<int>> expected{{3},
                                 {1, 5},
                                 {0, 2, 4, 6}};
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = ListOfDepths::generateBSTree(data);
    auto result = ListOfDepths::getListOfDepths(tree);
    EXPECT_EQ(expected, result);
    ListOfDepths::deleteTree(&tree);
}

TEST(ListOfDepthsTest, getListOfDepths_2) {
    vector<vector<int>> expected{{0},
                                 {1},
                                 {2},
                                 {3},
                                 {4},
                                 {5},
                                 {6}};
    vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto tree = ListOfDepths::generateBSTree(data);
    auto result = ListOfDepths::getListOfDepths(tree);
    EXPECT_EQ(expected, result);
    ListOfDepths::deleteTree(&tree);
}

#endif