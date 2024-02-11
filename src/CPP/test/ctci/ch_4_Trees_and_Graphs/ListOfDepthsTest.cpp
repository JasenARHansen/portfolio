#ifndef CTCI_CH_4_TREES_AND_GRAPHS_LIST_OF_DEPTHS_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_LIST_OF_DEPTHS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/ListOfDepths.h"

using namespace ctci;
TEST(CtCI_ListOfDepthsTest, description) {
    testing::internal::CaptureStdout();
    ListOfDepths::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_ListOfDepthsTest, getListOfDepths_1) {
    std::vector<std::vector<int>> expected{{3},
                                           {1, 5},
                                           {0, 2, 4, 6}};
    std::vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto tree = ListOfDepths::generateBSTree(data);
    auto result = ListOfDepths::getListOfDepths(tree);
    EXPECT_EQ(expected, result);
    ListOfDepths::deleteTree(&tree);
}

TEST(CtCI_ListOfDepthsTest, getListOfDepths_2) {
    std::vector<std::vector<int>> expected{{0},
                                           {1},
                                           {2},
                                           {3},
                                           {4},
                                           {5},
                                           {6}};
    std::vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto tree = ListOfDepths::generateBSTree(data);
    auto result = ListOfDepths::getListOfDepths(tree);
    EXPECT_EQ(expected, result);
    ListOfDepths::deleteTree(&tree);
}

#endif