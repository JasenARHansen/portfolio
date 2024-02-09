#ifndef CTCI_CH_4_TREES_AND_GRAPHS_BUILD_ORDER_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_BUILD_ORDER_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/BuildOrder.h"

TEST(BuildOrderTest, description) {
    testing::internal::CaptureStdout();
    BuildOrder::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BuildOrderTest, buildOrder_1) {
    vector<char> expected{'e', 'f', 'a', 'b', 'd', 'c'};
    vector<char> data{'a', 'b', 'c', 'd', 'e', 'f'};
    vector<pair<char, char>> dependencies{{'a', 'd'},
                                          {'f', 'b'},
                                          {'b', 'd'},
                                          {'f', 'a'},
                                          {'d', 'c'}};
    auto graph = BuildOrder::generateGraph(data, dependencies);
    auto result = BuildOrder::buildOrder(graph);
    EXPECT_EQ(expected, result);
    BuildOrder::deleteGraph(&graph);
}
TEST(BuildOrderTest, buildOrder_2) {
    vector<char> expected{'e','r','r','o','r'};
    vector<char> data{'a', 'b', 'c', 'd', 'e', 'f'};
    vector<pair<char, char>> dependencies{{'a', 'd'},
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