#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_AND_QUEUE_TWO_STACKS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_AND_QUEUE_TWO_STACKS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stacksAndQueue/TwoStacks.cpp"  // NOLINT : Ignore .cpp import

TEST(TwoStacksTest, description) {
    testing::internal::CaptureStdout();
    TwoStacks::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(TwoStacksTest, has_cycle_1) {
    vector<int> expected{35, 15};
    vector<int> source{35, 15};
    auto queue = TwoStacks::MyQueue();
    for (auto value: source) {
        queue.push(value);
    }
    auto result = queue.front();
    EXPECT_EQ(expected.at(0), result);
    queue.pop();
    result = queue.front();
    EXPECT_EQ(expected.at(1), result);
}

TEST(TwoStacksTest, has_cycle_2) {
    vector<int> expected{14, 60};
    vector<int> source{42, 14, 28, 60, 78};
    auto queue = TwoStacks::MyQueue();
    queue.push(source.at(0));
    queue.pop();
    queue.push(source.at(1));
    auto result = queue.front();
    EXPECT_EQ(expected.at(0), result);
    queue.push(source.at(2));
    result = queue.front();
    EXPECT_EQ(expected.at(0), result);
    queue.push(source.at(3));
    queue.push(source.at(4));
    queue.pop();
    queue.pop();
    result = queue.front();
    EXPECT_EQ(expected.at(1), result);
}

#endif