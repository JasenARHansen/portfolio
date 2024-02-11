#ifndef CTCI_CH_3_STACKS_AND_QUEUES_STACK_MIN_TEST
#define CTCI_CH_3_STACKS_AND_QUEUES_STACK_MIN_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_3_Stacks_and_Queues/StackMin.h"

using namespace ctci;
TEST(CtCI_StackMinTest, description) {
    testing::internal::CaptureStdout();
    StackMin::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_StackMinTest, minimum_1) {
    auto stacks = StackMin();
    EXPECT_TRUE(stacks.empty());
    stacks.push(2);
    EXPECT_EQ(2, stacks.top());
    EXPECT_EQ(2, stacks.minimum());
    stacks.push(9);
    EXPECT_EQ(9, stacks.top());
    EXPECT_EQ(2, stacks.minimum());
    stacks.pop();
    EXPECT_EQ(2, stacks.top());
    EXPECT_EQ(2, stacks.minimum());
}

#endif