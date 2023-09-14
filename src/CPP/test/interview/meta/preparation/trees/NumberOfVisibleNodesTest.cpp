#ifndef LEETCODE_TOP_INTERVIEW_150_NUMBER_OF_VISIBLE_NODES_TEST
#define LEETCODE_TOP_INTERVIEW_150_NUMBER_OF_VISIBLE_NODES_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/trees/NumberOfVisibleNodes.cpp"

TEST(NumberOfVisibleNodesTest, description) {
    testing::internal::CaptureStdout();
    NumberOfVisibleNodes::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(NumberOfVisibleNodesTest, visibleNodes_1) {
    auto expected = 4;
    vector<string> values{"8", "3", "10", "1", "6", "null", "14", "null", "null", "4", "7", "13"};
    auto root = NumberOfVisibleNodes::deserializeTree(values);
    auto result = NumberOfVisibleNodes::visibleNodes(root);
    EXPECT_EQ(expected, result);
    NumberOfVisibleNodes::deleteTree(&root);
}

TEST(NumberOfVisibleNodesTest, visibleNodes_2) {
    auto expected = 5;
    vector<string> values{"10", "8", "15", "4", "null", "14", "16", "null", "5", "null", "null", "null", "null", "null",
                          "6"};
    auto root = NumberOfVisibleNodes::deserializeTree(values);
    auto result = NumberOfVisibleNodes::visibleNodes(root);
    EXPECT_EQ(expected, result);
    NumberOfVisibleNodes::deleteTree(&root);
}

#endif