#ifndef CTCI_CH_4_TREES_AND_GRAPHS_BUILD_ORDER_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_BUILD_ORDER_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/BuildOrder.h"

TEST(CtCI_BuildOrderTest, description) {
    testing::internal::CaptureStdout();
    BuildOrder::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_BuildOrderTest, buildOrder_1) {
    std::vector<char> expected{'e', 'f', 'a', 'b', 'd', 'c'};
    std::vector<char> data{'a', 'b', 'c', 'd', 'e', 'f'};
    std::vector<std::pair<char, char>> dependencies{{'a', 'd'},
                                                    {'f', 'b'},
                                                    {'b', 'd'},
                                                    {'f', 'a'},
                                                    {'d', 'c'}};
    auto graph = BuildOrder::generateGraph(data, dependencies);
    auto result = BuildOrder::buildOrder(graph);
    EXPECT_EQ(expected, result);
    BuildOrder::deleteGraph(&graph);
}

TEST(CtCI_BuildOrderTest, buildOrder_2) {
    std::vector<char> expected{'e', 'r', 'r', 'o', 'r'};
    std::vector<char> data{'a', 'b', 'c', 'd', 'e', 'f'};
    std::vector<std::pair<char, char>> dependencies{{'a', 'd'},
                                                    {'f', 'b'},
                                                    {'b', 'd'},
                                                    {'f', 'a'},
                                                    {'d', 'c'},
                                                    {'c', 'd'}};
    auto graph = BuildOrder::generateGraph(data, dependencies);
    auto result = BuildOrder::buildOrder(graph);
    EXPECT_EQ(expected, result);
    BuildOrder::deleteGraph(&graph);
}

#endif