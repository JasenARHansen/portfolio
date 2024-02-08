#ifndef CTCI_CH_3_STACKS_AND_QUEUES_QUEUE_VIA_STACKS_TEST
#define CTCI_CH_3_STACKS_AND_QUEUES_QUEUE_VIA_STACKS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_3_Stacks_and_Queues/QueueViaStacks.h"

TEST(MyQueueTest, description) {
    testing::internal::CaptureStdout();
    MyQueue::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MyQueueTest, MyQueue_1) {
    auto queue = MyQueue();
    EXPECT_TRUE(queue.empty());
    queue.push(2);
    EXPECT_EQ(2, queue.front());
    EXPECT_EQ(1, queue.size());
    queue.push(9);
    EXPECT_EQ(2, queue.front());
    EXPECT_EQ(2, queue.size());
    queue.pop();
    EXPECT_EQ(9, queue.front());
    EXPECT_EQ(1, queue.size());
}

#endif