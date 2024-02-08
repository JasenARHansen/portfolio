#ifndef CTCI_CH_3_STACKS_AND_QUEUES_SORT_STACK_TEST
#define CTCI_CH_3_STACKS_AND_QUEUES_SORT_STACK_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_3_Stacks_and_Queues/SortStack.h"

TEST(SortStackTest, description) {
    testing::internal::CaptureStdout();
    SortStack::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SortStackTest, SortStack_1) {
    auto stack = SortStack();
    EXPECT_TRUE(stack.empty());
    stack.push(2);
    EXPECT_EQ(2, stack.peek());
    EXPECT_EQ(1, stack.size());
    stack.push(9);
    EXPECT_EQ(2, stack.peek());
    EXPECT_EQ(2, stack.size());
    stack.pop();
    EXPECT_EQ(9, stack.peek());
    EXPECT_EQ(1, stack.size());
}

#endif