#ifndef CTCI_CH_4_TREES_AND_GRAPHS_ROUTE_BETWEEN_NODES_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_ROUTE_BETWEEN_NODES_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/RouteBetweenNodes.h"

TEST(RouteBetweenNodesTest, description) {
    testing::internal::CaptureStdout();
    RouteBetweenNodes::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RouteBetweenNodesTest, routeBetweenNodes_1) {
    auto expected = true;
    vector<int> data{0, 1, 2, 3, 4, 5, 6};
    vector<pair<int, int>> edges{{0, 1},
                                 {1, 2},
                                 {2, 0},
                                 {2, 3},
                                 {3, 2},
                                 {4, 6},
                                 {5, 4},
                                 {6, 5}};
    auto value1 = 0;
    auto value2 = 3;
    auto graph = RouteBetweenNodes::generateGraph(data, edges);
    auto result = RouteBetweenNodes::routeBetweenNodes(graph, value1, value2);
    EXPECT_EQ(expected, result);
    RouteBetweenNodes::deleteGraph(&graph);
}

TEST(RouteBetweenNodesTest, routeBetweenNodes_2) {
    auto expected = false;
    vector<int> data{0, 1, 2, 3};
    vector<pair<int, int>> edges{{0, 1},
                                 {1, 2},
                                 {2, 0},
                                 {3, 2}};
    auto value1 = 0;
    auto value2 = 3;
    auto graph = RouteBetweenNodes::generateGraph(data, edges);
    auto result = RouteBetweenNodes::routeBetweenNodes(graph, value1, value2);
    EXPECT_EQ(expected, result);
    RouteBetweenNodes::deleteGraph(&graph);
}

TEST(RouteBetweenNodesTest, routeBetweenNodes_3) {
    auto expected = false;
    vector<int> data{0, 1, 2, 3, 4, 5};
    vector<pair<int, int>> edges{{0, 1},
                                 {0, 4},
                                 {0, 5},
                                 {1, 3},
                                 {1, 4},
                                 {2, 1},
                                 {3, 2},
                                 {3, 4}};
    auto value1 = 4;
    auto value2 = 3;
    auto graph = RouteBetweenNodes::generateGraph(data, edges);
    auto result = RouteBetweenNodes::routeBetweenNodes(graph, value1, value2);
    EXPECT_EQ(expected, result);
    RouteBetweenNodes::deleteGraph(&graph);
}

TEST(RouteBetweenNodesTest, routeBetweenNodes_4) {
    auto expected = true;
    vector<int> data{0, 1, 2, 3, 4, 5, 6};
    vector<pair<int, int>> edges{{0, 1},
                                 {1, 2},
                                 {2, 0},
                                 {2, 3},
                                 {3, 2},
                                 {4, 6},
                                 {5, 4},
                                 {6, 5}};
    auto graph = RouteBetweenNodes::generateGraph(data, edges);
    auto node1 = graph->nodes.at(0);
    auto node2 = graph->nodes.at(3);
    auto result = RouteBetweenNodes::routeBetweenNodes(graph, node1, node2);
    EXPECT_EQ(expected, result);
    RouteBetweenNodes::deleteGraph(&graph);
}

TEST(RouteBetweenNodesTest, routeBetweenNodes_5) {
    auto expected = false;
    vector<int> data{0, 1, 2, 3};
    vector<pair<int, int>> edges{{0, 1},
                                 {1, 2},
                                 {2, 0},
                                 {3, 2}};
    auto graph = RouteBetweenNodes::generateGraph(data, edges);
    auto node1 = graph->nodes.at(0);
    auto node2 = graph->nodes.at(3);
    auto result = RouteBetweenNodes::routeBetweenNodes(graph, node1, node2);
    EXPECT_EQ(expected, result);
    RouteBetweenNodes::deleteGraph(&graph);
}

TEST(RouteBetweenNodesTest, routeBetweenNodes_6) {
    auto expected = false;
    vector<int> data{0, 1, 2, 3, 4, 5};
    vector<pair<int, int>> edges{{0, 1},
                                 {0, 4},
                                 {0, 5},
                                 {1, 3},
                                 {1, 4},
                                 {2, 1},
                                 {3, 2},
                                 {3, 4}};
    auto graph = RouteBetweenNodes::generateGraph(data, edges);
    auto node1 = graph->nodes.at(4);
    auto node2 = graph->nodes.at(3);
    auto result = RouteBetweenNodes::routeBetweenNodes(graph, node1, node2);
    EXPECT_EQ(expected, result);
    RouteBetweenNodes::deleteGraph(&graph);
}

#endif