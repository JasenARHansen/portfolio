#ifndef CTCI_CH_4_TREES_AND_GRAPHS_PATHS_WITH_SUM_TEST
#define CTCI_CH_4_TREES_AND_GRAPHS_PATHS_WITH_SUM_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_4_Trees_and_Graphs/PathsWithSum.h"

TEST(PathsWithSumTest, description) {
    testing::internal::CaptureStdout();
    PathsWithSum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PathsWithSumTest, pathsWithSum_1) {
    auto expected = 2;
    vector<int> data{3, 1, 5, 0, 2, 4, 6};
    auto root = PathsWithSum::generateBSTree(data);
    auto target = 6;
    auto result = PathsWithSum::pathsWithSum(root, target);
    EXPECT_EQ(expected, result);
    PathsWithSum::deleteTree(&root);
}

#endif