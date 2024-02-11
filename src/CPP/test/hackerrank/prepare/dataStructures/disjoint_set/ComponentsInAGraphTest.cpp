#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_DISJOINT_SET_COMPONENTS_IN_A_GRAPH_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_DISJOINT_SET_COMPONENTS_IN_A_GRAPH_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/disjoint_set/ComponentsInAGraph.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_ComponentsInAGraphTest, description) {
    testing::internal::CaptureStdout();
    ComponentsInAGraph::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_ComponentsInAGraphTest, componentsInGraph_1) {
    vector<int> expected{2, 3};
    vector<vector<int>> gb{{1, 5},
                           {1, 6},
                           {2, 4}};
    auto result = ComponentsInAGraph::componentsInGraph(gb);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_ComponentsInAGraphTest, componentsInGraph_2) {
    vector<int> expected{11, 11};
    vector<vector<int>> gb{{1, 17},
                           {5, 13},
                           {7, 12},
                           {5, 17},
                           {5, 12},
                           {2, 17},
                           {1, 18},
                           {8, 13},
                           {2, 15},
                           {5, 20}};
    auto result = ComponentsInAGraph::componentsInGraph(gb);
    EXPECT_EQ(expected, result);
}

#endif