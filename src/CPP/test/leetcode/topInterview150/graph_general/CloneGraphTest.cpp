#ifndef LEETCODE_TOP_INTERVIEW_150_CLONE_GRAPH_TEST
#define LEETCODE_TOP_INTERVIEW_150_CLONE_GRAPH_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/graph_general/CloneGraph.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_CloneGraphTest, description) {
    testing::internal::CaptureStdout();
    CloneGraph::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_CloneGraphTest, cloneGraph_1) {
    vector<vector<int>> expected{{2, 4},
                                 {1, 3},
                                 {2, 4},
                                 {1, 3}};
    vector<vector<int>> input{{2, 4},
                              {1, 3},
                              {2, 4},
                              {1, 3}};
    auto head = CloneGraph::deserializeGraph(input);
    auto clone = CloneGraph::cloneGraph(head);
    auto result = CloneGraph::serializeGraph(clone);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(result[index].begin(), result[index].end()));
    }
    CloneGraph::deleteGraph(&head);
    CloneGraph::deleteGraph(&clone);
}

TEST(LeetCode_CloneGraphTest, cloneGraph_2) {
    vector<vector<int>> expected{{}};
    vector<vector<int>> input{{}};
    auto head = CloneGraph::deserializeGraph(input);
    auto clone = CloneGraph::cloneGraph(head);
    auto result = CloneGraph::serializeGraph(clone);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(result[index].begin(), result[index].end()));
    }
    CloneGraph::deleteGraph(&head);
    CloneGraph::deleteGraph(&clone);
}

TEST(LeetCode_CloneGraphTest, cloneGraph_3) {
    vector<vector<int>> expected{};
    vector<vector<int>> input{};
    auto head = CloneGraph::deserializeGraph(input);
    auto clone = CloneGraph::cloneGraph(head);
    auto result = CloneGraph::serializeGraph(clone);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(result[index].begin(), result[index].end()));
    }
    CloneGraph::deleteGraph(&head);
    CloneGraph::deleteGraph(&clone);
}

#endif