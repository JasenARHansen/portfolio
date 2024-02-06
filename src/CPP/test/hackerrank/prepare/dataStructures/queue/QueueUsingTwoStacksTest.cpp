#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_QUEUE_QUEUE_USING_TWO_STACKS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_QUEUE_QUEUE_USING_TWO_STACKS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/queue/QueueUsingTwoStacks.cpp"  // NOLINT : Ignore .cpp import

TEST(QueueUsingTwoStacksTest, description) {
    testing::internal::CaptureStdout();
    QueueUsingTwoStacks::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(QueueUsingTwoStacksTest, QueueUsingTwoStacks_1) {
    vector<int> expected{35, 15};
    vector<string> operations{"1 35", "1 15", "3", "2", "3"};
    auto result = QueueUsingTwoStacks::queueOperations(operations);
    EXPECT_EQ(expected, result);
}

TEST(QueueUsingTwoStacksTest, QueueUsingTwoStacks_2) {
    vector<int> expected{14, 14};
    vector<string> operations{"1 42", "2", "1 14", "3", "1 28", "3", "1 60", "1 78", "2", "2"};
    auto result = QueueUsingTwoStacks::queueOperations(operations);
    EXPECT_EQ(expected, result);
}

#endif