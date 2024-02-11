#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_GRAPH_SHORTEST_REACH_IN_A_GRAPH_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_GRAPH_SHORTEST_REACH_IN_A_GRAPH_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/graph/ShortestReachInAGraph.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_ShortestReachInAGraphUnidirectionalEdgesTest, description) {
    testing::internal::CaptureStdout();
    ShortestReachInAGraphUnidirectionalEdges::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_ShortestReachInAGraphUnidirectionalEdgesTest, shortest_reach_1) {
    vector<int> expected{6, 12, 18, 6, -1};
    auto n = 6;
    auto weight = 6;
    auto s = 1;
    auto graph = ShortestReachInAGraphUnidirectionalEdges::Graph(n);
    graph.setWeight(weight);
    graph.add_edge(1, 2);
    graph.add_edge(2, 3);
    graph.add_edge(3, 4);
    graph.add_edge(1, 5);
    auto result = graph.shortest_reach(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_ShortestReachInAGraphUnidirectionalEdgesTest, shortest_reach_2) {
    vector<int> expected{6, 6, -1};
    auto n = 4;
    auto weight = 6;
    auto s = 1;
    auto graph = ShortestReachInAGraphUnidirectionalEdges::Graph(n);
    graph.setWeight(weight);
    graph.add_edge(4, 2);
    graph.add_edge(1, 2);
    graph.add_edge(1, 3);
    auto result = graph.shortest_reach(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_ShortestReachInAGraphUnidirectionalEdgesTest, shortest_reach_3) {
    vector<int> expected{12, 6};
    auto n = 3;
    auto weight = 6;
    auto s = 2;
    auto graph = ShortestReachInAGraphUnidirectionalEdges::Graph(n);
    graph.setWeight(weight);
    graph.add_edge(3, 1);
    graph.add_edge(2, 3);
    auto result = graph.shortest_reach(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_ShortestReachInAGraphBidirectionalEdgesTest, shortest_reach_4) {
    vector<int> expected{6, 12, 18, 6, -1, 24};
    auto n = 7;
    auto weight = 6;
    auto s = 2;
    auto graph = ShortestReachInAGraphBidirectionalEdges::Graph(n);
    graph.setWeight(weight);
    graph.add_edge(7, 4);
    graph.add_edge(1, 2);
    graph.add_edge(1, 3);
    graph.add_edge(3, 4);
    graph.add_edge(2, 5);
    auto result = graph.shortest_reach(s);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_ShortestReachInAGraphTest, shortest_reach_raw) {
    auto expected = "6 6 -1 ";
    int n = 4;
    // Create a graph of size n where each edge weight is 6:
    GraphRequiresOffsets::Graph graph(n);
    // read and set edges
    int u, v;
    u = 4;
    v = 2;
    u--, v--;
    // add each edge to the graph
    graph.add_edge(u, v);
    u = 1;
    v = 2;
    u--, v--;
    // add each edge to the graph
    graph.add_edge(u, v);
    u = 1;
    v = 3;
    u--, v--;
    // add each edge to the graph
    graph.add_edge(u, v);
    int startId = 1;
    startId--;
    // Find the shortest reach from node s
    vector<int> distances = graph.shortest_reach(startId);
    string result;
    for (int i = 0; i < distances.size(); i++) {
        if (i != startId) {
            result += to_string(distances[i]);
            result += " ";
        }
    }
    EXPECT_EQ(expected, result);
}

#endif